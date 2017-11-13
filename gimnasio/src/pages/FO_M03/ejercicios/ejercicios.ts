import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, ToastController } from 'ionic-angular';

/**
 * Generated class for the EjerciciosPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-ejercicios',
  templateUrl: 'ejercicios.html',
})
export class EjerciciosPage {

  constructor(public navCtrl: NavController, public navParams: NavParams, public toastCtrl: ToastController) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad EjerciciosPage');
  }

  mensaje(){
    let toast = this.toastCtrl.create({
      message: 'Ejercicio añadido',
      duration: 1000,
      position: 'middle'
    });
    toast.present();
  }

}
