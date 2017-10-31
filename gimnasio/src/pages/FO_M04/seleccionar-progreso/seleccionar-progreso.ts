import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

import { ProgresoEjercicioPage } from '../progreso-ejercicio/progreso-ejercicio';
import { TabsMedidasPage } from '../tabs-medidas/tabs-medidas';
import { TabsPesoPage } from '../tabs-peso/tabs-peso';
import { TabsEjercicioPage } from '../tabs-ejercicio/tabs-ejercicio';

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

  openTabsEjercicioPage(){
    this.navCtrl.push(TabsEjercicioPage);
  }
  openProgresoMedidasPage(){
    this.navCtrl.push(TabsMedidasPage);
  }
  openTabsPesoPage()
  {
    this.navCtrl.push( TabsPesoPage );
  }

}
