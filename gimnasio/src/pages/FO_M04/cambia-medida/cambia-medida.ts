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
  Tricep: number;
  Abdomen: number;
  Cuadricep: number;
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
    let urlPeticion = "F0M04_Progreso_Medida/insertaMedidas?id_usuario=1&medida="+this.Escapula+"&tipo_medida="+1;
    this.userService.postDato( urlPeticion ).subscribe( data => {
      let i: number = 0;
      let mensaje: string = "";
      while ( i < data.lenght ){
        mensaje = data[i].data;
      }
      
    })
    console.log( this.Tricep );
    let urlPeticion1 = "F0M04_Progreso_Medida/insertaMedidas?id_usuario=1&medida="+this.Tricep+"&tipo_medida="+2;
    this.userService.postDato( urlPeticion1 ).subscribe( data => {
      let i: number = 0;
      let mensaje: string = "";
      while ( i < data.lenght ){
        mensaje = data[i].data;
      }
      
    });

    console.log( this.Abdomen );
    let urlPeticion2 = "F0M04_Progreso_Medida/insertaMedidas?id_usuario=1&medida="+this.Abdomen+"&tipo_medida="+3;
    this.userService.postDato( urlPeticion2 ).subscribe( data => {
      let i: number = 0;
      let mensaje: string = "";
      while ( i < data.lenght ){
        mensaje = data[i].data;
      }
      
    });

    console.log( this.Cuadricep );
    let urlPeticion3 = "F0M04_Progreso_Medida/insertaMedidas?id_usuario=1&medida="+this.Cuadricep+"&tipo_medida="+4;
    this.userService.postDato( urlPeticion3 ).subscribe( data => {
      let i: number = 0;
      let mensaje: string = "";
      while ( i < data.lenght ){
        mensaje = data[i].data;
      }
      
    });
    alert("Medidas agregadas correctamente");
  }

 

  public refrescarMedidas():void{

    console.log( this.Escapula );
    let urlPeticion = "F0M04_Progreso_Medida/actualizaMedida?id_usuario=1&medida="+this.Escapula+"&tipo_medida=Escapula";
    this.userService.postDato( urlPeticion ).subscribe( data => {
      let i: number = 0;
      let mensaje: string = "";
      while ( i < data.lenght ){
        mensaje = data[i].data;
      }

    });

  }

  public eliminarMedidas():void{

    console.log( this.Escapula );
    let urlPeticion = "F0M04_Progreso_Medida/eliminarMedidas?id_usuario=1&tipo_medida=Escapula"
    this.userService.postDato( urlPeticion ).subscribe( data => {
      let i: number = 0;
      let mensaje: string = "";
      while ( i < data.lenght ){
        mensaje = data[i].data;
      }

    });

  }



}
