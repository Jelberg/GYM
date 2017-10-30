import { Component , ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams, Nav,AlertController } from 'ionic-angular';
import { ClasesParticipadasPage} from '../clases-participadas/clases-participadas';

/**
 * Generated class for the ComentarClasePage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
  
@Component({
  selector: 'page-comentar-clase',
  templateUrl: 'comentar-clase.html',
})
export class ComentarClasePage {
  @ViewChild('NAV') nav:Nav;
  constructor(public navCtrl: NavController, public navParams: NavParams, public alertCtrl: AlertController) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ComentarClasePage');
  }

  enviarComentario(){
    let alert = this.alertCtrl.create({
      title: 'Comentario',
      subTitle: 'Comentario Enviado!',
      buttons: ['OK']
    });
    alert.present();

    /* HAY QUE ROOTEARLO A LA PAGINA ANTERIOR */
  }

}
