import { Routes } from '@angular/router';
import { UsuarioComponent } from './usuario/usuario.component';
import { FormUsuarioComponent } from './form-usuario/form-usuario.component';
import { RecrutadorComponent } from './recrutador/recrutador.component';
import { FormRecrutadorComponent } from './form-recrutador/form-recrutador.component';
import { ProdutorDeConteudoComponent } from './produtor-de-conteudo/produtor-de-conteudo.component';
import { FormProdutorComponent } from './form-produtor/form-produtor.component';

export const routes: Routes = [
    { path: 'usuarios', component: UsuarioComponent},
    { path: 'usuarios/novo', component: FormUsuarioComponent},
    { path: 'usuarios/alterar/:id', component: FormUsuarioComponent},
    { path: 'recrutadores', component: RecrutadorComponent},
    { path: 'recrutadores/novo', component: FormRecrutadorComponent},
    { path: 'recrutadores/alterar/:id', component: FormRecrutadorComponent},
    { path: 'produtores', component: ProdutorDeConteudoComponent},
    { path: 'produtores/novo', component: FormProdutorComponent},
    { path: 'produtores/alterar/:id', component: FormProdutorComponent}
];
