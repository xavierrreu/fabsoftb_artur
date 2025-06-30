import { Component } from '@angular/core';
import { Projeto } from '../model/projeto';
import { ProjetoService } from '../service/projeto.service';
import { UsuarioService } from '../service/usuario.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from '../model/usuario';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-form-projeto',
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './form-projeto.component.html',
  styleUrl: './form-projeto.component.css',
  providers: [ProjetoService, UsuarioService, Router]
})
export class FormProjetoComponent {
  projeto:Projeto=new Projeto(); //instanciando um objeto novo em branco para inserir infos
  public listaUsuarios:Usuario[] = [];

  constructor(
    private projetoService:ProjetoService,
    private usuarioService: UsuarioService,
    private router:Router,
    private activeRouter: ActivatedRoute
  ){
    const id = this.activeRouter.snapshot.paramMap.get('id');

    this.usuarioService.getUsuarios().subscribe(usuarios =>{
    this.listaUsuarios = usuarios;
    });

    if (id) {
      this.projetoService.getProjetoById(id).subscribe(projeto => {
        this.projeto = projeto;
      });
    }
  }

  comparaUsuarios(obj1: Usuario, obj2: Usuario): boolean {
    return obj1 && obj2 ? obj1.id === obj2.id : obj1 === obj2;
  }

  salvar(){
    this.projetoService.saveProjeto(this.projeto)
    .subscribe(resultado => {
      this.router.navigate(['projetos']);
    });
  }
}
