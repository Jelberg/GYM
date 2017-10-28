import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, Nav} from 'ionic-angular';
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
public items: Array<{id: number, titulo: string, descripion: string, img:string, instructor:string, fecha: string}>;
*/
  constructor(public navCtrl: NavController, public navParams: NavParams) {
    /*  AUN NO SE SI FUNCIONA -- ESTOY OFFLINE
    this.items = [
      {id: 1, titulo:"Yoga", descripion:"sbsdgsdsdfdsfsd dsdssdvsdvsda vsdsd s", img:"../assets/imgs/clasesYoga.jpg", instructor:"Estela Rodriguez", fecha:"24/10/2017 3:00 pm"},
      {id: 2,titulo:"Spinning",descripion:"sbsdgsdsdfdsfsd dsdssdvsdvsda vsdsd s", img:"../assets/imgs/claseSpinning.jpg", instructor:"Maria Josefa", fecha:"26/10/2017 3:00 pm"},
      {id: 3,titulo:"Defensa Personal",descripion:"sbsdgsdsdfdsfsd dsdssdvsdvsda vsdsd s", img:"../assets/imgs/clasesDefensaPersonal.jpeg", instructor:"Pedro Alvarez", fecha:"28/10/2017 3:00 pm"},
      {id: 4,titulo:"Boxeo",descripion:"sbsdgsdsdfdsfsd dsdssdvsdvsda vsdsd s", img:"../assets/imgs/clasesBoxeo.jpeg", instructor:"Jesus Rodriguez", fecha:"30/10/2017 3:00 pm"},
      {id: 5,titulo:"KickBoxing",descripion:"sbsdgsdsdfdsfsd dsdssdvsdvsda vsdsd s", img:"../assets/imgs/claseKickboxing.png", instructor:"Marcos Rodriguez", fecha:"7/11/2017 3:00 pm"}
    ];*/
  }

    private newFunction() {
        return {};
    }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ClasesPage');
  }
/*   AUN NO SE SI FUNCIONA -- ESTOY OFFLINE

  //Deberia de rootear al usuario desde la pagina de clases al darle a la clase de la que quiere ver el detalle
  goToParticularClase(id: number,titulo: string, descripcion: string img: string, isntructor: string, fecha:string){
    this.navCtrl.push(particularPage,{id: id, titulo:titulo, img:img, instructor:instructor, fecha:fecha});
  }

  // Deberia de hacer todo el proceso apra reservar una clase
  reservarClase(id: number){

  }

*/
}
