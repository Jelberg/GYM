import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController} from 'ionic-angular';

/**
 * Generated class for the ClaseParticularPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-clase-particular',
  templateUrl: 'clase-particular.html',
})
export class ClaseParticularPage {

  //public item:Array<{id:number, titulo:string, descripcion:string, img:string, instructor:string, fecha:string, duracion:number}>;

  constructor(public navCtrl: NavController, public navParams: NavParams, public alertCtrl: AlertController,
              /*public id:number, public titulo:string,public descripcion:string, public img:string, public instructor:string,public fecha:string, public duracion:number*/) {

  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ClaseParticularPage');
  }
  presentAlert() {
    const alert = this.alertCtrl.create({
      title: 'Clase',
      subTitle: 'Clase Agregada Satisfactoriamente',
      buttons: ['OK']
    });
    alert.present();
  }

}
