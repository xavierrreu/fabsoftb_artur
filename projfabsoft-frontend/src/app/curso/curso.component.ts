import { Component, ElementRef, ViewChild } from '@angular/core';
import { Curso } from '../model/curso';
import { CursoService } from '../service/curso.service';
import * as bootstrap from 'bootstrap';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-curso',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './curso.component.html',
  styleUrl: './curso.component.css',
  providers: [CursoService, Router]
})
export class CursoComponent {
  listaCursos: Curso[] = [];

  @ViewChild('myModal') modalElement!: ElementRef;
  private modal!: bootstrap.Modal;

  private cursoSelecionado!: Curso;

  constructor(
    private cursoService: CursoService,
    private router: Router
  ) {}

  novo(){
    this.router.navigate(['cursos/novo'])
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


  alterar(curso:Curso){
    this.router.navigate(['cursos/alterar', curso.id]);
  }

  ngOnInit(){
    console.log("Carregando cursos...");
    this.cursoService.getCursos().subscribe(
      cursos => {
        this.listaCursos = cursos;
      }
    )
  }

  abrirConfirmacao(curso:Curso) {
    this.cursoSelecionado = curso;
    this.modal = new bootstrap.Modal(this.modalElement.nativeElement);
    this.modal.show();
  }

  fecharConfirmacao() {
    this.modal.hide();
  }

  confirmarExclusao() {
    this.cursoService.excluirCurso(this.cursoSelecionado.id).subscribe(
        () => {
            this.fecharConfirmacao();
            this.cursoService.getCursos().subscribe(
              cursos => {
                this.listaCursos = cursos;
              }
            );
        },
        error => {
            console.error('Erro ao excluir curso:', error);
        }
    );
}
}
