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
  public disponibilidad:number;
  constructor(public navCtrl: NavController, public navParams: NavParams, public alertCtrl: AlertController,
    id: number,titulo: string, descripcion: string, instructor: string, fecha:string,capacidad:number
  ){  

    this.descripcion=descripcion;
    this.img="../assets/imgs/clasesYoga.jpg";
    this.instructor=instructor;
    this.fecha=fecha;
    this.duracion= 60;
    this.capacidad=capacidad;
    this.disponibilidad=20;
    this.titulo = titulo;
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
