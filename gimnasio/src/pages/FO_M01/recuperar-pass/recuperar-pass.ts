import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { HomePage } from '../../home/home';
import { IniciarsesionPage} from '../iniciarsesion/iniciarsesion'
import { AlertController } from 'ionic-angular/components/alert/alert-controller';
import { UserServiceProvider } from '../../../providers/user-service/user-service';
import { Jsonp } from '@angular/http/src/http';
/**
 * Generated class for the CrearusuarioPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */


@IonicPage()
@Component({
  selector: 'page-recuperarpass',
  templateUrl: 'recuperar-pass.html',
})
export class recuperar_passPage {
  password :string;
  password2: string;
  codigo :number;
  public class : any []=[];
  public users:any;
  private cgenero : any;
  private radioopen : boolean;
  constructor(public navCtrl: NavController,
              public navParams: NavParams,
              public alertCtrl: AlertController,
              public userService: UserServiceProvider) 
              {
                this.users = []
              }
              
              
  volver() {
    this.navCtrl.pop();
  }
  ionViewDidLoad() {
    
  }


  confirmarpas(){
    if (this.password==this.password2)
    {
      return false;
    }
    else 
    {
      return true;
    }
  }

  Nuevacontrasena(){
    var correo = localStorage.getItem("correo");
    localStorage.removeItem("correo");
    

  }


  irahomeusuario() {
    this.navCtrl.setRoot(HomePage);
 }


  /* metodo que muestra un  mensaje de error */
mensajeerror( mensaje )
{
  let alert = this.alertCtrl.create();
  alert.setTitle('Error'); 
  alert.setMessage(mensaje)
  alert.addButton({
    text: 'OK',
  });
  alert.present().then(() => {
    this.radioopen=true;
  })
}

mensajeexito( mensaje )
{
  let alert = this.alertCtrl.create();
  alert.setTitle('Exito'); 
  alert.setMessage(mensaje)
  alert.addButton({
    text: 'OK',
  });
  alert.present().then(() => {
    this.radioopen=true;
  })
}
}
