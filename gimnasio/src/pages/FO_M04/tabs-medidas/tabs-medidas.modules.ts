import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { TabsMedidasPage } from './tabs-medidas';

import { SeleccionarProgresoPage } from '../seleccionar-progreso/seleccionar-progreso';

@NgModule({
  declarations: [
    TabsMedidasPage,
    SeleccionarProgresoPage
  ],
  imports: [
    IonicPageModule.forChild(TabsMedidasPage),
  ],
})
export class TabsMedidasPageModule {}