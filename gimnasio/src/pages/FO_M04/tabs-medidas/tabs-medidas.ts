import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { ProgresoMedidasPage } from '../ProgresoMedidas/progresomedidas';
import { CambiarMedidasPage } from '../cambiar-medidas/cambiar-medidas';
import { ProgresoComentarioPage } from '../progreso-comentario/progreso-comentario';

@IonicPage()
@Component({
  selector: 'page-tabs-medidas',
  templateUrl: 'tabs-medidas.html'
})
export class TabsMedidasPage {

  grafica: any = ProgresoMedidasPage;
  medidas: any = CambiarMedidasPage;
  comentarios: any = ProgresoComentarioPage;
  constructor(public navCtrl: NavController, public navParams: NavParams)
  {
  	

  }
  ionViewDidLoad() 
  {
    console.log('ionViewDidLoad TabsMedidasPage');
  }
}