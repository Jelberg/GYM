import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { CambiarPesoPage } from './cambiar-peso';

import { SeleccionarProgresoPage } from '../seleccionar-progreso/seleccionar-progreso';

@NgModule({
  declarations: [
    CambiarPesoPage,
    SeleccionarProgresoPage
  ],
  imports: [
    IonicPageModule.forChild( CambiarPesoPage ),
  ],
})
export class CambiarPesoPageModule {}
