import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { CambiarMedidasPage } from './cambiar-medidas';

import { SeleccionarProgresoPage } from '../seleccionar-progreso/seleccionar-progreso';

@NgModule({
  declarations: [
    CambiarMedidasPage,
    SeleccionarProgresoPage
  ],
  imports: [
    IonicPageModule.forChild( CambiarMedidasPage ),
  ],
})
export class CambiarMedidasPageModule {}