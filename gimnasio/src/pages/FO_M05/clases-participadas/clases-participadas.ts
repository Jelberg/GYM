import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { ComentarClasePage } from '../comentar-clase/comentar-clase';

/**
 * Generated class for the ClasesParticipadasPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-clases-participadas',
  templateUrl: 'clases-participadas.html',
})
export class ClasesParticipadasPage {
  public items:Array<{id:number,titulo:string,instructor:string,fecha:string,hora:string,img:string}>;
  constructor(public navCtrl: NavController, public navParams: NavParams) {
    this.items=[
    {id: 1, titulo:"Yoga", img:"../../../assets/imgs/clasesYoga.jpg", instructor:"Estela Rodriguez", fecha:"24/10/2017", hora: "3:00 pm"},
    {id: 2,titulo:"Spinning", img:"../../../assets/imgs/claseSpinning.jpg", instructor:"Maria Josefa", fecha:"26/10/2017", hora: "4:00 pm"},
    {id: 3,titulo:"Defensa Personal", img:"../../../assets/imgs/clasesDefensaPersonal.jpeg", instructor:"Pedro Alvarez", fecha:"28/10/2017", hora: "5:00 pm"}];
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ClasesParticipadasPage');
  }

  goToComentar(){
    this.navCtrl.push(ComentarClasePage);
  }

}
