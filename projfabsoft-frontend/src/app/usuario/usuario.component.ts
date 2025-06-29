import { Usuario } from '../model/usuario';
import { UsuarioService } from '../service/usuario.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { Component, ElementRef, ViewChild } from '@angular/core';
import * as bootstrap from 'bootstrap';


@Component({
  selector: 'app-usuario',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './usuario.component.html',
  styleUrl: './usuario.component.css',
  providers: [UsuarioService, Router]
})
export class UsuarioComponent {
  listaUsuarios: Usuario[] = [];

  @ViewChild('myModal') modalElement!: ElementRef;
  private modal!: bootstrap.Modal;

  private usuarioSelecionado!: Usuario;

  constructor(
    private usuarioService: UsuarioService,
    private router: Router
  ) {}

  novo(){
    this.router.navigate(['usuarios/novo'])
  }

  alterar(usuario:Usuario){
    this.router.navigate(['usuarios/alterar', usuario.id]);
  }

  ngOnInit(){
    console.log("Carregando usuarios...");
    this.usuarioService.getUsuarios().subscribe(
      usuarios => {
        this.listaUsuarios = usuarios;
      }
    )
  }

  abrirConfirmacao(usuario:Usuario) {
    this.usuarioSelecionado = usuario;
    this.modal = new bootstrap.Modal(this.modalElement.nativeElement);
    this.modal.show();
  }

  fecharConfirmacao() {
    this.modal.hide();
  }

  confirmarExclusao() {
    this.usuarioService.excluirUsuario(this.usuarioSelecionado.id).subscribe(
        () => {
            this.fecharConfirmacao();
            this.usuarioService.getUsuarios().subscribe(
              usuarios => {
                this.listaUsuarios = usuarios;
              }
            );
        },
        error => {
            console.error('Erro ao excluir usuário:', error);
        }
    );
}
}
