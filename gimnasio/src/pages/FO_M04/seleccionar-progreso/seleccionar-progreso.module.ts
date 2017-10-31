import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { SeleccionarProgresoPage } from './seleccionar-progreso';

import { ProgresoEjercicioPage } from '../progreso-ejercicio/progreso-ejercicio';

@NgModule({
  declarations: [
    SeleccionarProgresoPage,
    ProgresoEjercicioPage
  ],
  imports: [
    IonicPageModule.forChild(SeleccionarProgresoPage),
  ],
})
export class SeleccionarProgresoPageModule {}
