import { Component } from '@angular/core';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../service/usuario.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-usuario',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './usuario.component.html',
  styleUrl: './usuario.component.css',
  providers: [UsuarioService]
})
export class UsuarioComponent {
  listaUsuarios: Usuario[] = [];

  constructor(private usuarioService: UsuarioService) {}

  ngOnInit(){
    console.log("Carregando clientes...");
    this.usuarioService.getUsuarios().subscribe(
      usuarios => {
        this.listaUsuarios = usuarios;
      }
    )
  }
}
