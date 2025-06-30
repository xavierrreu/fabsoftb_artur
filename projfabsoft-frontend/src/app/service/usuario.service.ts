import { Injectable } from '@angular/core';
import { Usuario } from '../model/usuario';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  apiURL = "http://localhost:8080/api/v1/usuarios";
  apiProjectURL = "http://localhost:8080/api/v1/projetos"; // URL para listar projetos por usuario

  constructor(private http:HttpClient) { }

  getUsuarios(){
    return this.http.get<Usuario[]>(this.apiURL);
  }

  getUsuarioById(id: any) {
    return this.http.get<Usuario>(this.apiURL + '/' + id);
  }

  saveUsuario(usuario:Usuario){
    if(usuario.id){
      return this.http.put(this.apiURL + '/' + usuario.id, usuario);
    }
    return this.http.post(this.apiURL,usuario);
  }

  excluirUsuario(id: any){
  return this.http.delete<Usuario>(this.apiURL + '/' + id);
  }

  getUsuarioProjects(id: any) {
    return this.http.get<any[]>(`${this.apiProjectURL}/${id}`); // Busca os projetos do usuário
  }
}
