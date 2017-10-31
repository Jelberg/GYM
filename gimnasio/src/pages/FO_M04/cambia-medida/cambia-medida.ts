import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

@IonicPage()
@Component({
  selector: 'page-cambia-medida',
  templateUrl: 'cambia-medida.html'
})
export class CambiaMedidaPage {

  
  constructor(public navCtrl: NavController, public navParams: NavParams)
  {
  	

  }
  ionViewDidLoad() 
  {
    console.log('ionViewDidLoad CambiaMedidaPage');
  }
}
