import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { SeleccionarProgresoPage } from './seleccionar-progreso';

@NgModule({
  declarations: [
    SeleccionarProgresoPage,
  ],
  imports: [
    IonicPageModule.forChild(SeleccionarProgresoPage),
  ],
})
export class SeleccionarProgresoPageModule {}
