import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ProgresoMedidasPage } from './progresomedidas';

import { SeleccionarProgresoPage } from '../seleccionar-progreso/seleccionar-progreso';

@NgModule({
  declarations: [
    ProgresoMedidasPage,
    SeleccionarProgresoPage
  ],
  imports: [
    IonicPageModule.forChild(ProgresoMedidasPage),
  ],
})
export class ProgresoMedidasPageModule {}{}