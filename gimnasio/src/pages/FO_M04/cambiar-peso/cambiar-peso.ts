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
    this.userService.postDato( urlPeticion ).subscribe( data => {
      let i: number = 0;
      let mensaje: string = "";
      while ( i < data.lenght ){
        mensaje = data[i].data;
        //this.abrirToast( data[0].data );
      }
      alert("Peso agregado correctamente");
    });
  }
  //No logre que el toast se mostrara, pero si un alert, si logran que funcione, seria cool
  //decirme: Gilbert.
  public abrirToast( mensaje: string ):void {
    let toast = this.toastCtrl.create({
      message: mensaje,
      duration: 3000
    });
    toast.present();
  }
  public editarPeso(){
    console.log("Hola");
  }
}
