import { Component } from '@angular/core';
import { Curso } from '../model/curso';
import { CursoService } from '../service/curso.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { ProdutorConteudo } from '../model/produtor-conteudo';
import { ProdutorConteudoService } from '../service/produtor-conteudo.service';

@Component({
  selector: 'app-form-curso',
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './form-curso.component.html',
  styleUrl: './form-curso.component.css',
  providers: [CursoService, Router, ProdutorConteudoService]
})
export class FormCursoComponent {
  curso:Curso=new Curso(); //instanciando um objeto novo em branco para inserir infos
  public listaProdutores:ProdutorConteudo[] = [];

  constructor(
    private cursoService:CursoService,
    private produtorConteudoService: ProdutorConteudoService,
    private router:Router,
    private activeRouter: ActivatedRoute
  ){
    const id = this.activeRouter.snapshot.paramMap.get('id');

    this.produtorConteudoService.getProdutoresConteudo().subscribe(produtores =>{
    this.listaProdutores = produtores;
    });

    if (id) {
      this.cursoService.getCursoById(id).subscribe(curso => {
        this.curso = curso;
      });
    }
  }

  comparaProdutores(obj1: ProdutorConteudo, obj2: ProdutorConteudo): boolean {
    return obj1 && obj2 ? obj1.id === obj2.id : obj1 === obj2;
  }

  salvar(){
    this.cursoService.saveCurso(this.curso)
    .subscribe(resultado => {
      this.router.navigate(['cursos']);
    });
  }
}
