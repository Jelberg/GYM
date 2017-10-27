import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

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

public items: Array<{titulo: string, img:string, instructor:string, fecha: string}>;

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

    private newFunction() {
        return {};
    }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ClasesPage');
  }

}
