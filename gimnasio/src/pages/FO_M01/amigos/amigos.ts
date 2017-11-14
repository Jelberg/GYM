import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController } from 'ionic-angular';
/**
 * Generated class for the AmigosPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-amigos',
  templateUrl: 'amigos.html',
})
export class AmigosPage {

  constructor(
    public navCtrl: NavController,
    public navParams: NavParams,
    public alertCtrl: AlertController) {
      
    }

  ionViewDidLoad() {
    console.log('ionViewDidLoad AmigosPage');
  }

  agregaramigos(){
    let alert = this.alertCtrl.create();
    alert.setTitle('Selecciona amigos a invitar');

    alert.addInput({
      type: 'checkbox',
      label: 'Pablo Escobar',
      value: 'value1',
      checked: true
    });

    alert.addInput({
      type: 'checkbox',
      label: 'Kid Cannabis',
      value: 'value2'
    });

    alert.addButton('Cancelar');
    alert.addButton({
      text: 'Aceptar',
      handler: data => {
      }
    });
    alert.present();
  }
}
