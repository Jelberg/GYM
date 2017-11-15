import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { UserServiceProvider } from '../../../providers/user-service/user-service';
import { TabsEjercicioPage } from '../tabs-ejercicio/tabs-ejercicio';

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
     this.userService.getDato( urlPeticion ).subscribe(data => {
        let i: number = 0;
        while ( i < data.length ){
          this.listaEjercicios[i] = data[i];
          i++;
        }
      }); 
  }

  itemSelected(listaEjercicios: string){
    this.navCtrl.push(TabsEjercicioPage, {lista : listaEjercicios});
    console.log('itemSelected, valor listaEjercicios ' + listaEjercicios);
  }

}
