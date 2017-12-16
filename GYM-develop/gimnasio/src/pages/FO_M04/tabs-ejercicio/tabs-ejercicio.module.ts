import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { TabsEjercicioPage } from './tabs-ejercicio';

import { SeleccionarProgresoPage } from '../seleccionar-progreso/seleccionar-progreso';

@NgModule({
  declarations: [
    TabsEjercicioPage,
    SeleccionarProgresoPage
  ],
  imports: [
    IonicPageModule.forChild(TabsEjercicioPage),
  ],
})
export class TabsEjercicioPageModule {}
