import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ComentarioPage} from './comentario';

@NgModule({
  declarations: [
    ComentarioPage
  ],
  imports: [
    IonicPageModule.forChild(ComentarioPage),
  ],
})
export class ComentarioPageModule {}