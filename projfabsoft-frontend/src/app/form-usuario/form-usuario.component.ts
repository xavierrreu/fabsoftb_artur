import { Component } from '@angular/core';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../service/usuario.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-form-usuario',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-usuario.component.html',
  styleUrl: './form-usuario.component.css',
  providers: [UsuarioService, Router]
})
export class FormUsuarioComponent {
  usuario:Usuario=new Usuario(); //instanciando um objeto novo em branco para inserir infos

  constructor(
    private usuarioService:UsuarioService,
    private router:Router,
    private activeRouter: ActivatedRoute
  ){
    const id = this.activeRouter.snapshot.paramMap.get('id');
        
    if (id) {
      this.usuarioService.getUsuarioById(id).subscribe(usuario => {
        this.usuario = usuario;
      });
    }
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

  salvar(){
    this.usuarioService.saveUsuario(this.usuario)
    .subscribe(resultado => {
      this.router.navigate(['usuarios']);
    });
  }
}
