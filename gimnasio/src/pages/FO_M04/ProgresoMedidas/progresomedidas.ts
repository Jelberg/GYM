import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { UserServiceProvider } from '../../../providers/user-service/user-service';


@IonicPage()
@Component ({

	selector: 'page-progresomedidas', 
	templateUrl: 'progresomedidas.html',
})

export class ProgresoMedidasPage {

  constructor(public navCtrl: NavController, public navParams: NavParams,
  			  private userService: UserServiceProvider) {

  	this.getProgresoM()
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ProgresoMedidasPage');
  }

  getProcesoM(){
  	let urlPeticion: string = "F0M04_Progreso_Peso/getProgresoP?id_usuario=1";
    this.userService.getDato( urlPeticion ).subscribe(data => console.log(data));
    //luego de => se agrega a la lista, tipo asi: => this.listaProgresos

  }


}