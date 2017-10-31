import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { ProgresoMedidasPage } from '../ProgresoMedidas/progresomedidas';
import { CambiaMedidaPage } from '../cambia-medida/cambia-medida';
import { ProgresoComentarioPage } from '../progreso-comentario/progreso-comentario';

@IonicPage()
@Component({
  selector: 'page-tab-medida',
  templateUrl: 'tab-medida.html'
})
export class TabMedidaPage {

  grafica: any = ProgresoMedidasPage;
  peso: any = CambiaMedidaPage;
  comentarios: any = ProgresoComentarioPage;
  constructor(public navCtrl: NavController, public navParams: NavParams)
  {
  	

  }
  ionViewDidLoad() 
  {
    console.log('ionViewDidLoad TabMedidaPage');
  }
}
