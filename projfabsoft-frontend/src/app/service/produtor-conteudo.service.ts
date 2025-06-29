import { Injectable } from '@angular/core';
import { ProdutorConteudo } from '../model/produtor-conteudo';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProdutorConteudoService {
  apiURL = "http://localhost:8080/api/v1/produtores-conteudo";

  constructor(private http:HttpClient) { }

  getProdutoresConteudo(){
    return this.http.get<ProdutorConteudo[]>(this.apiURL);
  }

  getProdutorConteudoById(id: any) {
    return this.http.get<ProdutorConteudo>(this.apiURL + '/' + id);
  }

  saveProdutorConteudo(produtorConteudo: ProdutorConteudo){
    if(produtorConteudo.id){
      return this.http.put(this.apiURL + '/' + produtorConteudo.id, produtorConteudo);
    }
    return this.http.post(this.apiURL,produtorConteudo);
  }

  excluirProdutorConteudo(id: any){
  return this.http.delete<ProdutorConteudo>(this.apiURL + '/' + id);
  }
}
