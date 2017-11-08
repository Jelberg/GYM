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
  public titulo:string;
  public descripcion:string;
  public img:string;
  public instructor:string;
  public fecha:string;
  public duracion:number;
  public capacidad:number;
  constructor(public navCtrl: NavController, public navParams: NavParams, public alertCtrl: AlertController){  

    this.descripcion="sbsdgsdsdfdsfsd dsdssdvsdvsda vsdsd s";
    this.img="../assets/imgs/clasesYoga.jpg";
    this.instructor="Estela Rodriguez";
    this.fecha="24/10/2017 3:00 pm";
    this.duracion= 60;
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
