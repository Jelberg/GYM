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

  //Metodo para hacer el llamado al servicio e insertar en la base de datos
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
    this.userService.postDato( urlPeticion3 ).subscribe( datas => {
      let mensaje: string = "";
      let keys = Object.keys(datas);
      let key: string = "";
      key = keys[0];
      mensaje = datas[key];
      this.abrirToast( mensaje );
    });
    
  }

 
  //Metodo que me permite actualizar las medidas segun lo que inserto el usuario
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

    console.log( this.Tricep );
    let urlPeticion1 = "F0M04_Progreso_Medida/actualizaMedida?id_usuario=1&medida="+this.Tricep+"&tipo_medida=Tricep";
    this.userService.postDato( urlPeticion1 ).subscribe( data => {
      let i: number = 0;
      let mensaje: string = "";
      while ( i < data.lenght ){
        mensaje = data[i].data;
      }

    });

    console.log( this.Abdomen);
    let urlPeticion2 = "F0M04_Progreso_Medida/actualizaMedida?id_usuario=1&medida="+this.Abdomen+"&tipo_medida=Abdomen";
    this.userService.postDato( urlPeticion2 ).subscribe( data => {
      let i: number = 0;
      let mensaje: string = "";
      while ( i < data.lenght ){
        mensaje = data[i].data;
      }

    });

    console.log( this.Cuadricep );
    let urlPeticion3 = "F0M04_Progreso_Medida/actualizaMedida?id_usuario=1&medida="+this.Cuadricep+"&tipo_medida=Cuadricep";
    this.userService.postDato( urlPeticion3 ).subscribe( datas => {
      let mensaje: string = "";
      let keys = Object.keys(datas);
      let key: string = "";
      key = keys[0];
      mensaje = datas[key];
      this.abrirToast( mensaje );

    });


  }

  //Metodo que permite eliminar las medidas ingresadas en el mes 
  public eliminarMedidas():void{

    console.log( this.Escapula );
    let urlPeticion = "F0M04_Progreso_Medida/eliminarMedidas?id_usuario=1&tipo_medida=Escapula"
    this.userService.deleteDato( urlPeticion ).subscribe( data => {
      let i: number = 0;
      let mensaje: string = "";
      while ( i < data.lenght ){
        mensaje = data[i].data;
      }

    });

    console.log( this.Tricep );
    let urlPeticion1 = "F0M04_Progreso_Medida/eliminarMedidas?id_usuario=1&tipo_medida=Tricep"
    this.userService.deleteDato( urlPeticion1 ).subscribe( data => {
      let i: number = 0;
      let mensaje: string = "";
      while ( i < data.lenght ){
        mensaje = data[i].data;
      }

    });

    console.log( this.Abdomen );
    let urlPeticion2 = "F0M04_Progreso_Medida/eliminarMedidas?id_usuario=1&tipo_medida=Abdomen"
    this.userService.deleteDato( urlPeticion2 ).subscribe( data => {
      let i: number = 0;
      let mensaje: string = "";
      while ( i < data.lenght ){
        mensaje = data[i].data;
      }

    });

    console.log( this.Cuadricep );
    let urlPeticion3 = "F0M04_Progreso_Medida/eliminarMedidas?id_usuario=1&tipo_medida=Cuadricep"
    this.userService.deleteDato( urlPeticion3 ).subscribe( datas => {
      let mensaje: string = "";
      let keys = Object.keys(datas);
      let key: string = "";
      key = keys[0];
      mensaje = datas[key];
      this.abrirToast( mensaje );

    });

    

  }
  //Metodo que abre mensaje al realizar una accion.
  public abrirToast( mensaje: string ):void {
    let toast = this.toastCtrl.create({
      message: mensaje,
      duration: 3000,
      position: 'middle'
    });
    toast.present();
  }

}
