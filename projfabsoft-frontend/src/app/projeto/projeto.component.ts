import { Component, ElementRef, ViewChild } from '@angular/core';
import { Projeto } from '../model/projeto';
import { ProjetoService } from '../service/projeto.service';
import * as bootstrap from 'bootstrap';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-projeto',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './projeto.component.html',
  styleUrl: './projeto.component.css',
  providers: [ProjetoService, Router]
})
export class ProjetoComponent {
  listaProjetos: Projeto[] = [];

  @ViewChild('myModal') modalElement!: ElementRef;
  private modal!: bootstrap.Modal;

  private projetoSelecionado!: Projeto;

  constructor(
    private projetoService: ProjetoService,
    private router: Router
  ) {}

  novo(){
    this.router.navigate(['projetos/novo'])
  }


  usuarios(){
    this.router.navigate(['usuarios']);
  }

  projetos(){
    this.router.navigate(['projetos']);
  }

  cursos(){
    this.router.navigate(['cursos']);
  }

  produtores(){
    this.router.navigate(['produtores']);
  }

  recrutadores(){
    this.router.navigate(['recrutadores']);
  }


  alterar(projeto:Projeto){
    this.router.navigate(['projetos/alterar', projeto.id]);
  }

  ngOnInit(){
    console.log("Carregando projetos...");
    this.projetoService.getProjetos().subscribe(
      projetos => {
        this.listaProjetos = projetos;
      }
    )
  }

  abrirConfirmacao(projeto:Projeto) {
    this.projetoSelecionado = projeto;
    this.modal = new bootstrap.Modal(this.modalElement.nativeElement);
    this.modal.show();
  }

  fecharConfirmacao() {
    this.modal.hide();
  }

  confirmarExclusao() {
    this.projetoService.excluirProjeto(this.projetoSelecionado.id).subscribe(
        () => {
            this.fecharConfirmacao();
            this.projetoService.getProjetos().subscribe(
              projetos => {
                this.listaProjetos = projetos;
              }
            );
        },
        error => {
            console.error('Erro ao excluir curso:', error);
        }
    );
}
}
