import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

@IonicPage()
@Component({
  selector: 'page-progreso-comentario',
  templateUrl: 'progreso-comentario.html'
})
export class ProgresoComentarioPage {

  
  constructor(public navCtrl: NavController, public navParams: NavParams)
  {
  	

  }
  ionViewDidLoad() 
  {
    console.log('ionViewDidLoad ProgresoComentarioPage');
  }
}
