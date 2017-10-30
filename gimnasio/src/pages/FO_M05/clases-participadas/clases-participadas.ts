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

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ClasesParticipadasPage');
  }

  goToComentar(){
    this.navCtrl.push(ComentarClasePage);
  }

}
