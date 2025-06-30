import { Injectable } from '@angular/core';
import { Projeto } from '../model/projeto';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProjetoService {
  apiURL = "http://localhost:8080/api/v1/projetos";

  constructor(private http:HttpClient) { }

  getProjetos(){
    return this.http.get<Projeto[]>(this.apiURL);
  }

  getProjetoById(id: any) {
    return this.http.get<Projeto>(this.apiURL + '/' + id);
  }

  saveProjeto(projeto:Projeto){
    if(projeto.id){
      return this.http.put(this.apiURL + '/' + projeto.id, projeto);
    }
    return this.http.post(this.apiURL,projeto);
  }

  excluirProjeto(id: any){
  return this.http.delete<Projeto>(this.apiURL + '/' + id);
  }
}
