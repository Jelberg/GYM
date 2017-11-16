import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { EjercicioRutinaPage } from './ejercicio-rutina';

@NgModule({
  declarations: [
    EjercicioRutinaPage,
  ],
  imports: [
    IonicPageModule.forChild(EjercicioRutinaPage),
  ],
})
export class EjercicioRutinaPageModule {}
