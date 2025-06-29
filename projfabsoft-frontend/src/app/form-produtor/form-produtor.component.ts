import { Component } from '@angular/core';
import { ProdutorConteudo } from '../model/produtor-conteudo';
import { ProdutorConteudoService } from '../service/produtor-conteudo.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-form-produtor',
  imports: [CommonModule, HttpClientModule, FormsModule],
  templateUrl: './form-produtor.component.html',
  styleUrl: './form-produtor.component.css',
  providers: [ProdutorConteudoService, Router]
})
export class FormProdutorComponent {
  produtor:ProdutorConteudo=new ProdutorConteudo(); //instanciando um objeto novo em branco para inserir infos

  constructor(
    private produtorService:ProdutorConteudoService,
    private router:Router,
    private activeRouter: ActivatedRoute
  ){
    const id = this.activeRouter.snapshot.paramMap.get('id');
        
    if (id) {
      this.produtorService.getProdutorConteudoById(id).subscribe(produtor => {
        this.produtor = produtor;
      });
    }
  }

  salvar(){
    this.produtorService.saveProdutorConteudo(this.produtor)
    .subscribe(resultado => {
      this.router.navigate(['produtores']);
    });
  }
}
