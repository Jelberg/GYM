import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, Nav} from 'ionic-angular';
import { AlertController } from 'ionic-angular';
import {ClaseParticularPage} from '../clase-particular/clase-particular';
/* AUN NO SE SI FUNCIONA -- ESTOY OFFLINE
import ParticularPage from '../particular/partiular';
*/

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
/* AUN NO SE SI FUNCIONA -- ESTOY OFFLINE
public items: Array<{id: number, titulo: string, descripion: string, img:string, instructor:string, fecha: string, duracion: number}>;
*/
  constructor(public navCtrl: NavController, public navParams: NavParams, public alertCtrl: AlertController) {
    /*  AUN NO SE SI FUNCIONA -- ESTOY OFFLINE
    this.items = [
      {id: 1, titulo:"Yoga", descripion:"sbsdgsdsdfdsfsd dsdssdvsdvsda vsdsd s", img:"../assets/imgs/clasesYoga.jpg", instructor:"Estela Rodriguez", fecha:"24/10/2017 3:00 pm", duracion: 60},
      {id: 2,titulo:"Spinning",descripion:"sbsdgsdsdfdsfsd dsdssdvsdvsda vsdsd s", img:"../assets/imgs/claseSpinning.jpg", instructor:"Maria Josefa", fecha:"26/10/2017 3:00 pm, duracion: 60},
      {id: 3,titulo:"Defensa Personal",descripion:"sbsdgsdsdfdsfsd dsdssdvsdvsda vsdsd s", img:"../assets/imgs/clasesDefensaPersonal.jpeg", instructor:"Pedro Alvarez", fecha:"28/10/2017 3:00 pm, duracion: 60},
      {id: 4,titulo:"Boxeo",descripion:"sbsdgsdsdfdsfsd dsdssdvsdvsda vsdsd s", img:"../assets/imgs/clasesBoxeo.jpeg", instructor:"Jesus Rodriguez", fecha:"30/10/2017 3:00 pm, duracion: 60},
      {id: 5,titulo:"KickBoxing",descripion:"sbsdgsdsdfdsfsd dsdssdvsdvsda vsdsd s", img:"../assets/imgs/claseKickboxing.png", instructor:"Marcos Rodriguez", fecha:"7/11/2017 3:00 pm, duracion: 60}
    ];*/
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
  goToClaseParticular(){
    this.navCtrl.push(ClaseParticularPage);
  }
/*   AUN NO SE SI FUNCIONA -- ESTOY OFFLINE

  //Deberia de rootear al usuario desde la pagina de clases al darle a la clase de la que quiere ver el detalle
  goToParticularClase(id: number,titulo: string, descripcion: string img: string, isntructor: string, fecha:string, duracion: number){
    this.navCtrl.push(particularPage,{id: id, titulo:titulo, img:img, instructor:instructor, fecha:fecha, duracion: duracion});
  }

  // Deberia de hacer todo el proceso apra reservar una clase
  reservarClase(id: number){
    console.log('Reserva Agregada');
  }

*/




}
