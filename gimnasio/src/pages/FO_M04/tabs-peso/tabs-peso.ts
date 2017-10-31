import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { ProgresoPesoPage } from '../progreso-peso/progreso-peso';
import { CambiarPesoPage } from '../cambiar-peso/cambiar-peso';
import { ProgresoComentarioPage } from '../progreso-comentario/progreso-comentario';

@IonicPage()
@Component({
  selector: 'page-tabs-peso',
  templateUrl: 'tabs-peso.html'
})
export class TabsPesoPage {

  grafica: any = ProgresoPesoPage;
  peso: any = CambiarPesoPage;
  comentarios: any = ProgresoComentarioPage;
  constructor(public navCtrl: NavController, public navParams: NavParams)
  {
  	

  }
  ionViewDidLoad() 
  {
    console.log('ionViewDidLoad TabsPesoPage');
  }
}
