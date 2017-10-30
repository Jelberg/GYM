import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ClasesPage } from './clases';

@NgModule({
  declarations: [
    ClasesPage,
  ],
  imports: [
    IonicPageModule.forChild(ClasesPage),
  ],
})
export class ClasesPageModule {}
