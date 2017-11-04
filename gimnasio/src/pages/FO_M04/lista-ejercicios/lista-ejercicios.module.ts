import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ListaEjerciciosPage } from './lista-ejercicios';

@NgModule({
  declarations: [
    ListaEjerciciosPage,
  ],
  imports: [
    IonicPageModule.forChild(ListaEjerciciosPage),
  ],
})
export class ListaEjerciciosPageModule {}
