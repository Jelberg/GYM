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

  //Metodo que insetar el peso del usuario
  public cargarPeso():void{
    console.log( this.nuevoPeso );
    let urlPeticion = "F0M04_Progreso_Peso/insertaProgresoPeso?id_usuario=1&peso="+this.nuevoPeso;
    this.userService.postDato( urlPeticion ).subscribe( data => {
      let i: number = 0;
      let mensaje: string = "";
      while ( i < data.lenght ){
        mensaje = data[i].data;
      }
      alert("Peso agregado correctamente");
    });
  }
  
  //Metodo que eleminar el peso ingresado en la semana
  public eliminarPeso():void {
    console.log( this.nuevoPeso );
    let urlPeticion = "F0M04_Progreso_Peso/eliminarPeso?id_usuario=1";
    this.userService.deleteDato( urlPeticion ).subscribe( data => {
      let i: number = 0;
      let mensaje: string = "";
      while ( i < data.lenght ){
        mensaje = data[i].data;
      }

    });

    alert("Peso eliminado");
  }

  //Metodo para actualizar el peso
  public refrescarPeso():void {
    console.log( this.nuevoPeso );
    let urlPeticion = "F0M04_Progreso_Peso/actualizaProgresoPeso?id_usuario=1&peso="+this.nuevoPeso;
    this.userService.postDato( urlPeticion ).subscribe( data => {
      let i: number = 0;
      let mensaje: string = "";
      while ( i < data.lenght ){
        mensaje = data[i].data;
      }

    });

    alert("Peso actualizado");
  }
}
