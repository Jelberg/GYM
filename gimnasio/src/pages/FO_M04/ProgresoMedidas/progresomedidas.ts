import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

@IonicPage()
@Component ({

	selector: 'page-progresomedidas', 
	templateUrl: 'progresomedidas.html',

})

export class ProgresoMedidasPage {

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ProgresoMedidasPage');
  }

}