import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { AlertController } from 'ionic-angular';
import { CrearusuarioPage} from '../crearusuario/crearusuario';
import { HomePage } from '../../home/home';

/**
 * Generated class for the IniciarsesionPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-iniciarsesion',
  templateUrl: 'iniciarsesion.html',
})
export class IniciarsesionPage {

  constructor(
    public navCtrl: NavController,
    public navParams: NavParams,
    public alertCtrl: AlertController
    ) {
  }
  irapaginacrear() {
    this.navCtrl.push(CrearusuarioPage);
}
irahomeusuario() {
   this.navCtrl.setRoot(HomePage);
}
recoverPassword() {
  const alert = this.alertCtrl.create({
    title: 'Recuperar Contraseña',
    subTitle:'Ingrese Correo Electronico',
    inputs: [
      {
        name: 'Correo',
        placeholder: 'Correo:',
        type: 'email'
      },
    ],
    buttons: [
      {
        text: 'Cancelar',
        role: 'cancel',
        handler: data => {
          console.log('Cancel clicked');
        }
      },
      {
        text: 'Ok',
        handler: data => {
          console.log('Cancel clicked');
        }
      }
    ]
  });
  alert.present();
}
  ionViewDidLoad() {
    console.log('ionViewDidLoad IniciarsesionPage');
  }

}
