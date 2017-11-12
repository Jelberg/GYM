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

  //dato: any;
  dato 
 

  constructor(public navCtrl: NavController, 
              public navParams: NavParams,
              private userService : UserServiceProvider) {
  }

  ionViewDidLoad() {
    //console.log('ionViewDidLoad ProgresoEjercicioPage');
    /*this.userService.getDato().subscribe(
      (data) => {
        console.log('Asignando data del json');
        this.dato = data;
        
      },
      (error) =>{
        console.error(error);
      }
    )*/
    
  }

  goToListaContactosPage(){
    this.navCtrl.push(ListaContactosPage);
  }

  goToSeleccionarEjercicioPage(){
    this.navCtrl.push(ListaEjerciciosPage);
  }

}
