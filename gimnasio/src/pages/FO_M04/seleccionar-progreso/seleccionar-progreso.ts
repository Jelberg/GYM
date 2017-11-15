import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

import { ProgresoEjercicioPage } from '../progreso-ejercicio/progreso-ejercicio';
import { TabMedidaPage } from '../tab-medida/tab-medida';
import { TabsPesoPage } from '../tabs-peso/tabs-peso';
import { TabsEjercicioPage } from '../tabs-ejercicio/tabs-ejercicio';
import { ListaEjerciciosPage } from '../lista-ejercicios/lista-ejercicios';

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

  openListaEjercicioPage(){
    this.navCtrl.push(ListaEjerciciosPage);
  }
  openProgresoMedidasPage(){
    this.navCtrl.push(TabMedidaPage);
  }
  openTabsPesoPage()
  {
    this.navCtrl.push( TabsPesoPage );
  }

}
