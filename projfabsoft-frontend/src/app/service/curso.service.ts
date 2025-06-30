import { Injectable } from '@angular/core';
import { Curso } from '../model/curso';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CursoService {
  apiURL = "http://localhost:8080/api/v1/cursos";

  constructor(private http:HttpClient) { }

  getCursos(){
    return this.http.get<Curso[]>(this.apiURL);
  }

  getCursoById(id: any) {
    return this.http.get<Curso>(this.apiURL + '/' + id);
  }

  saveCurso(curso:Curso){
    if(curso.id){
      return this.http.put(this.apiURL + '/' + curso.id, curso);
    }
    return this.http.post(this.apiURL,curso);
  }

  excluirCurso(id: any){
  return this.http.delete<Curso>(this.apiURL + '/' + id);
  }
}
