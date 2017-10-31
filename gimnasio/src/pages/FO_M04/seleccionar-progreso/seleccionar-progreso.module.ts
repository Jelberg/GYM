import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { SeleccionarProgresoPage } from './seleccionar-progreso';

import { ProgresoEjercicioPage } from '../progreso-ejercicio/progreso-ejercicio';
import { ProgresoMedidasPage } from '../ProgresoMedidas/progresomedidas';

@NgModule({
  declarations: [
    SeleccionarProgresoPage,
    ProgresoEjercicioPage,
    ProgresoMedidasPage
  ],
  imports: [
    IonicPageModule.forChild(SeleccionarProgresoPage),
  ],
})
export class SeleccionarProgresoPageModule {}
