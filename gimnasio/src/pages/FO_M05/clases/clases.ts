import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, Nav} from 'ionic-angular';
import { AlertController } from 'ionic-angular';
import {ClaseParticularPage} from '../clase-particular/clase-particular';

/**
 * Generated class for the ClasesPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-clases',
  templateUrl: 'clases.html',
})
export class ClasesPage {
public items: Array<{id: number, titulo: string, descripion: string, img:string, instructor:string, fecha: string, duracion: number, hora:string, capacidad:number, disponibilidad:number}>;

  constructor(public navCtrl: NavController, public navParams: NavParams, public alertCtrl: AlertController) {
    this.items = [
      {id: 1, titulo:"Yoga", descripion:"sbsdgsdsdfdsfsd dsdssdvsdvsda vsdsd s", img:"../assets/imgs/clasesYoga.jpg", instructor:"Estela Rodriguez", fecha:"24/10/2017", duracion: 60, hora: "3:00 pm",disponibilidad:20, capacidad:50},
      {id: 2,titulo:"Spinning",descripion:"sbsdgsdsdfdsfsd dsdssdvsdvsda vsdsd s", img:"../assets/imgs/claseSpinning.jpg", instructor:"Maria Josefa", fecha:"26/10/2017", duracion: 60, hora: "4:00 pm",disponibilidad:21, capacidad:50},
      {id: 3,titulo:"Defensa Personal",descripion:"sbsdgsdsdfdsfsd dsdssdvsdvsda vsdsd s", img:"../assets/imgs/clasesDefensaPersonal.jpeg", instructor:"Pedro Alvarez", fecha:"28/10/2017", duracion: 60, hora: "5:00 pm",disponibilidad:23, capacidad:50},
      {id: 4,titulo:"Boxeo",descripion:"sbsdgsdsdfdsfsd dsdssdvsdvsda vsdsd s", img:"../assets/imgs/clasesBoxeo.jpeg", instructor:"Jesus Rodriguez", fecha:"30/10/2017", duracion: 60, hora: "6:00 pm",disponibilidad:20, capacidad:50},
      {id: 5,titulo:"KickBoxing",descripion:"sbsdgsdsdfdsfsd dsdssdvsdvsda vsdsd s", img:"../assets/imgs/claseKickboxing.png", instructor:"Marcos Rodriguez", fecha:"7/11/2017", duracion: 60, hora: "7:00 pm",disponibilidad:12, capacidad:50}
    ];
  }

    private newFunction() {
        return {};
    }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ClasesPage');
  }
  presentAlert() {
    const alert = this.alertCtrl.create({
      title: 'Clase',
      subTitle: 'Clase Agregada Satisfactoriamente',
      buttons: ['OK']
    });
    alert.present();
  }

  //Deberia de rootear al usuario desde la pagina de clases al darle a la clase de la que quiere ver el detalle
  goToClaseParticular(id: number,titulo: string, descripcion: string,img: string, instructor: string, fecha:string, duracion: number,disponibilidad:number,capacidad:number){
    this.navCtrl.push(ClaseParticularPage,{navControler:this.navCtrl, navParametros:this.navParams, alertControler:this.alertCtrl});
  }

  // Deberia de hacer todo el proceso apra reservar una clase
  reservarClase(id: number){
    console.log('Reserva Agregada');
  }

}
