import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ListaCriticasPage } from './lista-criticas';

@NgModule({
  declarations: [
    ListaCriticasPage,
  ],
  imports: [
    IonicPageModule.forChild(ListaCriticasPage),
  ],
})
export class ListaCriticasPageModule {}
