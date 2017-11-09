import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, Nav} from 'ionic-angular';
import { AlertController } from 'ionic-angular';

/**
 * Generated class for the ReservasPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-reservas',
  templateUrl: 'reservas.html',
})
export class ReservasPage {

  public items: Array<{id: number, titulo:string, img:string, instructor:string, fecha:string, duracion:number, capacidad:number, disponibilidad:number}>;

  constructor(public navCtrl: NavController, public navParams: NavParams, public alertCtrl: AlertController) {
    this.items = [
      {id:1, titulo:"Yoga",img:"../../assets/imgs/clasesYoga.jpg", instructor:"Estela Rodrigues", fecha:"24/10/2017 3:00 pm", duracion:60, capacidad:50, disponibilidad:20},
      {id:2, titulo:"Boceo",img:"../../assets/imgs/clasesBoxeo.jpeg", instructor:"Jesus Rodriguez", fecha:"30/10/2017  3:00 pm", duracion:60,capacidad:50, disponibilidad:20},
      {id:3, titulo:"KickBoxing",img:"../../assets/imgs/claseKickboxing.png", instructor:"Marcos Rodriguez", fecha:"7/11/2017 3:00 pm", duracion:60,capacidad:50, disponibilidad:20},
    ];
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ReservasPage');
  }

 
  //Deberia eliminar la Reserva
  eliminarReserva(id: number){
    console.log('Reserva Eliminada');
  }
  

  presentAlert(id) {
    const alert = this.alertCtrl.create({
      title: 'Reserva',
      subTitle: 'Reserva Eliminada Satisfactoriamente',
      buttons: ['OK']
    });
    alert.present();
  }

}
