import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

@IonicPage()
@Component({
  selector: 'page-cambiar-peso',
  templateUrl: 'cambiar-peso.html'
})
export class CambiarPesoPage {

  
  constructor(public navCtrl: NavController, public navParams: NavParams)
  {
  	

  }
  ionViewDidLoad() 
  {
    console.log('ionViewDidLoad CambiarPesoPage');
  }
}
