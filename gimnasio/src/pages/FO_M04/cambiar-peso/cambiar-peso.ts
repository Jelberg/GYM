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
  constructor( public navCtrl: NavController, public navParams: NavParams,
               private userService: UserServiceProvider, public toastCtrl: ToastController )
  {
  	

  }
  ionViewDidLoad() 
  {
    console.log('ionViewDidLoad CambiarPesoPage');
  }
  public cargarPeso():void{
    console.log( this.nuevoPeso );
    let urlPeticion = "F0M04_Progreso_Peso/insertaProgresoPeso?id_usuario=1&peso="+this.nuevoPeso;
    this.userService.postDato( urlPeticion ).subscribe( datas => {
      let mensaje: string = "";
      let keys = Object.keys(datas);
      let key: string = "";
      key = keys[0];
      mensaje = datas[key];
      this.abrirToast( mensaje );
    });
  }
  public abrirToast( mensaje: string ):void {
    let toast = this.toastCtrl.create({
      message: mensaje,
      duration: 3000,
      position: 'middle'
    });
    toast.present();
  }
  public eliminarPeso():void {
    console.log( this.nuevoPeso );
    let urlPeticion = "F0M04_Progreso_Peso/eliminarPeso?id_usuario=1";
    this.userService.deleteDato( urlPeticion ).subscribe( datas => {
      let mensaje: string = "";
      let keys = Object.keys(datas);
      let key: string = "";
      key = keys[0];
      mensaje = datas[key];
      this.abrirToast( mensaje );
    });
  }

  public refrescarPeso():void {
    console.log( this.nuevoPeso );
    let urlPeticion = "F0M04_Progreso_Peso/actualizaProgresoPeso?id_usuario=1&peso="+this.nuevoPeso;
    this.userService.postDato( urlPeticion ).subscribe( datas => {
      let mensaje: string = "";
      let keys = Object.keys(datas);
      let key: string = "";
      key = keys[0];
      mensaje = datas[key];
      this.abrirToast( mensaje );

    });
  }
}
