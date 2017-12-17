import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { UserServiceProvider } from '../../../providers/user-service/user-service';
import { ToastController } from 'ionic-angular';
import { AlertController } from 'ionic-angular';

@IonicPage()
@Component({
  selector: 'page-cambia-medida',
  templateUrl: 'cambia-medida.html'
})
export class CambiaMedidaPage {

  Escapula: string;
  Tricep: number;
  Abdomen: number;
  Cuadricep: number;
  radioopen : boolean;
  medida: any[]=[];
  constructor(public navCtrl: NavController, public navParams: NavParams,
               private userService: UserServiceProvider, public toastCtrl: ToastController,
               public alertCtrl: AlertController)
  {  	

  }

  ionViewDidLoad() 
  {
    console.log('ionViewDidLoad CambiaMedidaPage');
  }

  //Metodo para hacer el llamado al servicio e insertar en la base de datos
  public cargarMedida():void{
    if (!(this.Escapula) || !(this.Tricep) || !( this.Abdomen ) || !( this.Cuadricep ) )
    {
     this.mensajeerror("Debe llenar todos los campos")
    }
    else {
    console.log( this.Escapula );
    let urlPeticion = "F0M04_Progreso_Medida/insertaMedidas?id_usuario=1&medida="+this.Escapula+"&tipo_medida="+1;
    this.userService.getDato( urlPeticion ).subscribe( data => {
      let i: number = 0;
      while ( i < data.length ){
      this.medida[i] = data[i];
      i++;}
      console.log(this.medida[0]);
      
  },
      (error) =>{
        //console.log(error);
      
      
    });
    console.log( this.Tricep );
    let urlPeticion1 = "F0M04_Progreso_Medida/insertaMedidas?id_usuario=1&medida="+this.Tricep+"&tipo_medida="+2;
    this.userService.getDato( urlPeticion1 ).subscribe( data => {
      let i: number = 0;
      while ( i < data.length ){
      this.medida[i] = data[i];
      i++;}
      console.log(this.medida[0]);
      
  },
      (error) =>{
        //console.log(error);
      
    });

    console.log( this.Abdomen );
    let urlPeticion2 = "F0M04_Progreso_Medida/insertaMedidas?id_usuario=1&medida="+this.Abdomen+"&tipo_medida="+3;
    this.userService.getDato( urlPeticion2 ).subscribe( data => {
      let i: number = 0;
      while ( i < data.length ){
      this.medida[i] = data[i];
      i++;}
      console.log(this.medida[0]);
      
  },
      (error) =>{
        //console.log(error);
      
    });

    console.log( this.Cuadricep );
    let urlPeticion3 = "F0M04_Progreso_Medida/insertaMedidas?id_usuario=1&medida="+this.Cuadricep+"&tipo_medida="+4;
    this.userService.getDato( urlPeticion3 ).subscribe( datas => {
      let i: number = 0;
      while ( i < datas.length ){
      this.medida[i] = datas[i];
      i++;}
      console.log(this.medida[0]);
      
  },
      (error) =>{
        //console.log(error);
    });
  }
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
}
