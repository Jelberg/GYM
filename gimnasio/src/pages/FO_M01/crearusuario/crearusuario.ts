import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

/**
 * Generated class for the CrearusuarioPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-crearusuario',
  templateUrl: 'crearusuario.html',
})
export class CrearusuarioPage {
  public editar: string = "true";
  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }
  volver() {
    this.navCtrl.pop();
  }
  ionViewDidLoad() {
    console.log('ionViewDidLoad CrearusuarioPage');
  }

}
