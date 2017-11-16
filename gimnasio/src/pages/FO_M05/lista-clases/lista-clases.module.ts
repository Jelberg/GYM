import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ListaClasesPage } from './lista-clases';

@NgModule({
  declarations: [
    ListaClasesPage,
  ],
  imports: [
    IonicPageModule.forChild(ListaClasesPage),
  ],
})
export class ListaClasesPageModule {}
