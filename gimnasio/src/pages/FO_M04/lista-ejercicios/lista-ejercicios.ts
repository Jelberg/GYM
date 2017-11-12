import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { UserServiceProvider } from '../../../providers/user-service/user-service';

/**
 * Generated class for the ListaEjerciciosPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-lista-ejercicios',
  templateUrl: 'lista-ejercicios.html',
})
export class ListaEjerciciosPage {

  listaEjercicios = [];

  constructor(public navCtrl: NavController, public navParams: NavParams,
                              private userService: UserServiceProvider) 
  {
    this.getListaEjercicios();
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ListaEjerciciosPage');
  }

  getListaEjercicios(){
    let urlPeticion: string = "FOM03_Rutina/getEjerciciosRealizados?idUsuario=1";
    this.userService.getDato( urlPeticion ).subscribe(data => this.listaEjercicios = data);
    console.log(this.listaEjercicios);
    console.log(11111);
  
    //luego de => se agrega a la lista, tipo asi: => this.listaProgresos
  }

}
