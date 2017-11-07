import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ProgresoPesoPage } from './progreso-peso';

import { SeleccionarProgresoPage } from '../seleccionar-progreso/seleccionar-progreso';

@NgModule({
  declarations: [
    ProgresoPesoPage,
    SeleccionarProgresoPage
  ],
  imports: [
    IonicPageModule.forChild(ProgresoPesoPage),
  ],
})
export class ProgresoPesoPageModule {}
