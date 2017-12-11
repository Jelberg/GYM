import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { AlertController } from 'ionic-angular';
import { CrearusuarioPage} from '../crearusuario/crearusuario';
import { HomePage } from '../../home/home';
import { UserServiceProvider } from '../../../providers/user-service/user-service';
import { RecuperarPassPage } from '../recuperar-pass/recuperar-pass';
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
  usuario : string;
  password : string;
  radioopen : boolean;
  public class : any []=[];
  constructor(
    public navCtrl: NavController, 
    public navParams: NavParams, 
    public alertCtrl: AlertController,
    public userService: UserServiceProvider
    ) {
  }



  irapaginacrear() {
    this.navCtrl.push(CrearusuarioPage);
}



  irahomeusuario() {
   this.navCtrl.setRoot(HomePage);
}

/**
   * Metodo trae al usuario que esta inicializando
   */
 public iniciarSesion() { 
   if (!(this.usuario) || !(this.password))
   {
    this.mensajeerror("Debe llenar todos los campos")
   }
   else
   {
    let url = "Login/IniciarSesion?usuario="+this.usuario+"&password="+this.password;
    this.userService.getDato(url).subscribe(data => {    
        let i: number = 0;
        while ( i < data.length ){
        this.class[i] = data[i];
      i++;}
      console.log(this.class[0]);
      if (this.class[0])
      {
        localStorage.setItem("id",this.class[0]._id)
        localStorage.setItem("entrenador",this.class[0].entrenador)
        console.log(localStorage.getItem("id"));
        this.radioopen=false;
        this.irahomeusuario() 
      }
      else 
      {
        this.mensajeerror("Usuario y/o contrasena invalido")
      }
    },
    (error) =>{
      console.error(error);
    }
  )
}
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
          
        }
      },
      {
        text: 'Ok',
        handler: data => {
          if (data.Correo!="") 
          {
          localStorage.setItem("correo",data.Correo);
          this.navCtrl.setRoot(RecuperarPassPage);
          console.log(data)
          }
          else
          this.mensajeerror("Introduzca el correo")
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
