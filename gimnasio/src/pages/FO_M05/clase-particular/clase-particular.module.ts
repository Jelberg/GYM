import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ClaseParticularPage } from './clase-particular';

@NgModule({
  declarations: [
    ClaseParticularPage,
  ],
  imports: [
    IonicPageModule.forChild(ClaseParticularPage),
  ],
})
export class ClaseParticularPageModule {}
