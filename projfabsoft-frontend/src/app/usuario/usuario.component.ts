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
  currentUserProjects: any[] = []; // Store the current user's projects
  selectedUserId: any; // Store se

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

  mostrarProjetos(usuario: any): void {
    usuario.mostrarProjetos = !usuario.mostrarProjetos;  // Toggle the 'mostrarProjetos' flag
    if (usuario.mostrarProjetos) {
      this.usuarioService.getUsuarioProjects(usuario.id).subscribe((projects: any[]) => {
        // Store the fetched projects for the user
        this.currentUserProjects = projects;
      });
    }
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
