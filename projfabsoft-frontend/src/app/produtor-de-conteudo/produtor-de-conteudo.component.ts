import { Component, ElementRef, ViewChild } from '@angular/core';
import { ProdutorConteudoService } from '../service/produtor-conteudo.service';
import { ProdutorConteudo } from '../model/produtor-conteudo';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import * as bootstrap from 'bootstrap';

@Component({
  selector: 'app-produtor-de-conteudo',
  imports: [CommonModule, HttpClientModule],
  templateUrl: './produtor-de-conteudo.component.html',
  styleUrl: './produtor-de-conteudo.component.css',
  providers: [ProdutorConteudoService, Router]
})
export class ProdutorDeConteudoComponent {
  listaProdutores: ProdutorConteudo[] = [];

  @ViewChild('myModal') modalElement!: ElementRef;
  private modal!: bootstrap.Modal;

  private produtorSelecionado!: ProdutorConteudo;

  constructor(
    private produtorService: ProdutorConteudoService,
    private router: Router
  ) {}

  novo(){
    this.router.navigate(['produtores/novo'])
  }

  alterar(produtor:ProdutorConteudo){
    this.router.navigate(['produtores/alterar', produtor.id]);
  }

  ngOnInit(){
    console.log("Carregando produtores...");
    this.produtorService.getProdutoresConteudo().subscribe(
      produtores => {
        this.listaProdutores = produtores;
      }
    )
  }

  abrirConfirmacao(produtor:ProdutorConteudo) {
    this.produtorSelecionado = produtor;
    this.modal = new bootstrap.Modal(this.modalElement.nativeElement);
    this.modal.show();
  }

  fecharConfirmacao() {
    this.modal.hide();
  }

  confirmarExclusao() {
    this.produtorService.excluirProdutorConteudo(this.produtorSelecionado.id).subscribe(
        () => {
            this.fecharConfirmacao();
            this.produtorService.getProdutoresConteudo().subscribe(
              produtores => {
                this.listaProdutores = produtores;
              }
            );
        },
        error => {
            console.error('Erro ao excluir produtor:', error);
        }
    );
}
}
