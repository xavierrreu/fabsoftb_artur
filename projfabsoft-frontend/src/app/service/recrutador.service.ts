import { Injectable } from '@angular/core';
import { Recrutador } from '../model/recrutador';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RecrutadorService {
  apiURL = "http://localhost:8080/api/v1/recrutador";

  constructor(private http:HttpClient) { }

  getRecrutadores(){
    return this.http.get<Recrutador[]>(this.apiURL);
  }

  getRecrutadorById(id: any) {
    return this.http.get<Recrutador>(this.apiURL + '/' + id);
  }

  saveRecrutador(recrutador:Recrutador){
    if(recrutador.id){
      return this.http.put(this.apiURL + '/' + recrutador.id, recrutador);
    }
    return this.http.post(this.apiURL,recrutador);
  }

  excluirRecrutador(id: any){
  return this.http.delete<Recrutador>(this.apiURL + '/' + id);
  }
}
