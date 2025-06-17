import { Component } from '@angular/core';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../service/usuario.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';


@Component({
  selector: 'app-usuario',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './usuario.component.html',
  styleUrl: './usuario.component.css',
  providers: [UsuarioService, Router]
})
export class UsuarioComponent {
  listaUsuarios: Usuario[] = [];

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
}
