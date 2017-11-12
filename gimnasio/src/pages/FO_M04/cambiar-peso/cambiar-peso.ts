import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { UserServiceProvider } from '../../../providers/user-service/user-service';
import { ToastController } from 'ionic-angular';

@IonicPage()
@Component({
  selector: 'page-cambiar-peso',
  templateUrl: 'cambiar-peso.html'
})
export class CambiarPesoPage {

  nuevoPeso: number;
  constructor(public navCtrl: NavController, public navParams: NavParams,
              private userService: UserServiceProvider, public toastCtrl: ToastController )
  {
  	

  }
  ionViewDidLoad() 
  {
    console.log('ionViewDidLoad CambiarPesoPage');
  }
  public cargarPeso():void{
    console.log(nuevPeso);
    let urlPeticion = "F0M04_Progreso_Peso/insertaProgresoPeso?id_usuario=1&peso="+this.nuevoPeso;
    this.userService.postDato( urlPeticion ).subscribe( data => {
      this.abrirToast( data[0].data );
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
