import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

@IonicPage()
@Component({
  selector: 'page-progreso-peso',
  templateUrl: 'progreso-peso.html'
})
export class ProgresoPesoPage {

  
  constructor(public navCtrl: NavController, public navParams: NavParams)
  {
  	

  }
  ionViewDidLoad() 
  {
    console.log('ionViewDidLoad ProgresoPesoPage');
  }
}
