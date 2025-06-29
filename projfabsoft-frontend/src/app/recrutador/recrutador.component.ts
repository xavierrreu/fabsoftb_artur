import { Recrutador } from '../model/recrutador';
import { RecrutadorService } from '../service/recrutador.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { Component, ElementRef, ViewChild } from '@angular/core';
import * as bootstrap from 'bootstrap';


@Component({
  selector: 'app-recrutador',
  imports: [CommonModule, HttpClientModule],
  templateUrl: './recrutador.component.html',
  styleUrl: './recrutador.component.css',
  providers: [RecrutadorService, Router]
})
export class RecrutadorComponent {
  listaRecrutadores: Recrutador[] = [];

  @ViewChild('myModal') modalElement!: ElementRef;
  private modal!: bootstrap.Modal;

  private recrutadorSelecionado!: Recrutador;

  constructor(
    private recrutadorService: RecrutadorService,
    private router: Router
  ) {}

  novo(){
    this.router.navigate(['recrutadores/novo'])
  }

  alterar(recrutador:Recrutador){
    this.router.navigate(['recrutadores/alterar', recrutador.id]);
  }

  ngOnInit(){
    console.log("Carregando recrutadores...");
    this.recrutadorService.getRecrutadores().subscribe(
      recrutadores => {
        this.listaRecrutadores = recrutadores;
      }
    )
  }

  abrirConfirmacao(recrutador:Recrutador) {
    this.recrutadorSelecionado = recrutador;
    this.modal = new bootstrap.Modal(this.modalElement.nativeElement);
    this.modal.show();
  }

  fecharConfirmacao() {
    this.modal.hide();
  }

  confirmarExclusao() {
    this.recrutadorService.excluirRecrutador(this.recrutadorSelecionado.id).subscribe(
        () => {
            this.fecharConfirmacao();
            this.recrutadorService.getRecrutadores().subscribe(
              recrutadores => {
                this.listaRecrutadores = recrutadores;
              }
            );
        },
        error => {
            console.error('Erro ao excluir recrutador:', error);
        }
    );
}
}
