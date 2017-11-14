import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { UserServiceProvider } from '../../../providers/user-service/user-service';
import { ToastController } from 'ionic-angular';

@IonicPage()
@Component({
  selector: 'page-cambia-medida',
  templateUrl: 'cambia-medida.html'
})
export class CambiaMedidaPage {

  Escapula: number;
  constructor(public navCtrl: NavController, public navParams: NavParams,
               private userService: UserServiceProvider, public toastCtrl: ToastController)
  {  	

  }

  ionViewDidLoad() 
  {
    console.log('ionViewDidLoad CambiaMedidaPage');
  }

  public cargarMedida():void{
    console.log( this.Escapula );
    let urlPeticion = "F0M04_Progreso_Medida/insertaMedidas?id_usuario=1&medida="+this.Escapula;
    this.userService.postDato( urlPeticion ).subscribe( data => {
      let i: number = 0;
      let mensaje: string = "";
      while ( i < data.lenght ){
        mensaje = data[i].data;
      }
      alert("Medidas agregadas correctamente");
    });
  }

  public abrirToast( mensaje: string ):void {
    let toast = this.toastCtrl.create({
      message: mensaje,
      duration: 3000
    });
    toast.present();
  }

}
