import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

import { ProgresoEjercicioPage } from '../progreso-ejercicio/progreso-ejercicio';
import { ProgresoMedidasPage } from '../ProgresoMedidas/progresomedidas'
/**
 * Generated class for the SeleccionarProgresoPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-seleccionar-progreso',
  templateUrl: 'seleccionar-progreso.html',
})
export class SeleccionarProgresoPage {

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad SeleccionarProgresoPage');
  }

  openProgresoEjercicioPage(){
    this.navCtrl.push(ProgresoEjercicioPage);
  }
  openProgresoMedidasPage(){
    this.navCtrl.push(ProgresoMedidasPage);
  }

}
