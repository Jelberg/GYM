import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ComentarClasePage } from './comentar-clase';

@NgModule({
  declarations: [
    ComentarClasePage,
  ],
  imports: [
    IonicPageModule.forChild(ComentarClasePage),
  ],
})
export class ComentarClasePageModule {}
