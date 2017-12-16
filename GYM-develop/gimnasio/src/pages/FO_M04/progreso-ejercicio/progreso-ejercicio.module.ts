import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ProgresoEjercicioPage } from './progreso-ejercicio';

import { SeleccionarProgresoPage } from '../seleccionar-progreso/seleccionar-progreso';

@NgModule({
  declarations: [
    ProgresoEjercicioPage,
    SeleccionarProgresoPage
  ],
  imports: [
    IonicPageModule.forChild(ProgresoEjercicioPage),
  ],
})
export class ProgresoEjercicioPageModule {}
