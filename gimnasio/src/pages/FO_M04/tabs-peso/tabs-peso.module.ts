import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { TabsPesoPage } from './tabs-peso';

import { SeleccionarProgresoPage } from '../seleccionar-progreso/seleccionar-progreso';

@NgModule({
  declarations: [
    TabsPesoPage,
    SeleccionarProgresoPage
  ],
  imports: [
    IonicPageModule.forChild(TabsPesoPage),
  ],
})
export class TabsPesoPageModule {}
