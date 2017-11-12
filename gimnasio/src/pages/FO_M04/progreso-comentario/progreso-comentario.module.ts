import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ProgresoComentarioPage } from './progreso-comentario';

import { SeleccionarProgresoPage } from '../seleccionar-progreso/seleccionar-progreso';

@NgModule({
  declarations: [
    ProgresoComentarioPage,
    SeleccionarProgresoPage
  ],
  imports: [
    IonicPageModule.forChild(ProgresoComentarioPage),
  ],
})
export class ProgresoComentarioPageModule {}
