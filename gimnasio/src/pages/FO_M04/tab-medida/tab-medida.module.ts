import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { TabMedidaPage } from './tab-medida';

import { SeleccionarProgresoPage } from '../seleccionar-progreso/seleccionar-progreso';

@NgModule({
  declarations: [
    TabMedidaPage,
    SeleccionarProgresoPage
  ],
  imports: [
    IonicPageModule.forChild(TabMedidaPage),
  ],
})
export class TabMedidaPageModule {}
