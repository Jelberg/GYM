import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, Nav} from 'ionic-angular';

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

  public items: Array<{id: number, titulo:string, img:string, instructor:string, fecha:string}>;

  constructor(public navCtrl: NavController, public navParams: NavParams) {
    this.items = [
      {id:1, titulo:"Yoga",img:"../assets/imgs/clasesYoga.jpg", instructor:"Estela Rodrigues", fecha:"24/10/2017 3:00 pm"},
      {id:2, titulo:"Boceo",img:"../assets/imgs/clasesBoxeo.jpg", instructor:"Jesus Rodriguez", fecha:"30/10/2017  3:00 pm"},
      {id:3, titulo:"KickBoxing",img:"../assets/imgs/claseKickboxing.jpg", instructor:"Marcos Rodriguez", fecha:"7/11/2017 3:00 pm"},
    ];
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ReservasPage');
  }

  /* AUN NO SE SI FUNCIONA ...  ESTOY OFFLINE

  Deberia eliminar la Reserva
  eliminarReserva(id: number){
    console.log('Reserva Eliminada');
  }
  */

}
