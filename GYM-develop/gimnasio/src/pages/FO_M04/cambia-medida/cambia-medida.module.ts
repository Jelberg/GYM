import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { CambiaMedidaPage } from './cambia-medida';

import { SeleccionarProgresoPage } from '../seleccionar-progreso/seleccionar-progreso';

@NgModule({
  declarations: [
    CambiaMedidaPage,
    SeleccionarProgresoPage
  ],
  imports: [
    IonicPageModule.forChild( CambiaMedidaPage ),
  ],
})
export class CambiaMedidaPageModule {}
