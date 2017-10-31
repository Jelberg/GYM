import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { AgregarMedidasPage } from '../ProgresoMedidas/agregarmedidas';
import { ProgresoMedidasPage } from './progresomedidas';



@NgModule({
  declarations: [
  	AgregarMedidasPage,
    ProgresoMedidasPage    
  ],
  imports: [
    IonicPageModule.forChild(AgregarMedidasPage),
  ],
})
export class AgregarMedidasPageModule {}{}