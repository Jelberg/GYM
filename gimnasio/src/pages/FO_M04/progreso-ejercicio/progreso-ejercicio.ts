import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { UserServiceProvider } from '../../../providers/user-service/user-service'

import { ListaEjerciciosPage } from '../lista-ejercicios/lista-ejercicios';
import { ListaContactosPage } from '../lista-contactos/lista-contactos';

/**
 * Generated class for the ProgresoEjercicioPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-progreso-ejercicio',
  templateUrl: 'progreso-ejercicio.html',
})
export class ProgresoEjercicioPage {

  listaRecibida

  constructor(public navCtrl: NavController, 
              public navParams: NavParams,
              private userService : UserServiceProvider) {

                //this.listaRecibida = navParams.get('listaRecibida');
                this.listaRecibida = navParams.data;
  }

  ionViewDidLoad() {
    console.log('Ventana progreso ejercicio - Elemento recibido: '+ this.listaRecibida);
  }

  goToListaContactosPage(){
    this.navCtrl.push(ListaContactosPage);
  }

  goToSeleccionarEjercicioPage(){
    this.navCtrl.push(ListaEjerciciosPage);
  }

}
