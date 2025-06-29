import { Component } from '@angular/core';
import { RecrutadorService } from '../service/recrutador.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Recrutador } from '../model/recrutador';

@Component({
  selector: 'app-form-recrutador',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-recrutador.component.html',
  styleUrl: './form-recrutador.component.css',
  providers: [RecrutadorService, Router]
})
export class FormRecrutadorComponent {
  recrutador:Recrutador=new Recrutador(); //instanciando um objeto novo em branco para inserir infos

  constructor(
    private recrutadorService:RecrutadorService,
    private router:Router,
    private activeRouter: ActivatedRoute
  ){
    const id = this.activeRouter.snapshot.paramMap.get('id');
        
    if (id) {
      this.recrutadorService.getRecrutadorById(id).subscribe(recrutador => {
        this.recrutador = recrutador;
      });
    }
  }

  salvar(){
    this.recrutadorService.saveRecrutador(this.recrutador)
    .subscribe(resultado => {
      this.router.navigate(['recrutadores']);
    });
  }
}
