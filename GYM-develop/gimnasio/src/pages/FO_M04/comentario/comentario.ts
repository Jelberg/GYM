import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

@IonicPage()
@Component({
  selector: 'page-comentario',
  templateUrl: 'comentario.html',
})

export class ComentarioPage {

  id

  constructor(public navCtrl: NavController, public navParams: NavParams) {
    this.id = navParams.get('id');
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ComentarioPage');
  }

}