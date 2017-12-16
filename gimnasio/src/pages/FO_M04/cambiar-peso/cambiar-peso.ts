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
  agregarpeso: any[]=[];

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
    this.userService.getDato(urlPeticion).subscribe(data => {    
      let i: number = 0;
      while ( i < data.length ){
      this.agregarpeso[i] = data[i];
      i++;}
    console.log(this.agregarpeso[0]);
  },
  (error) =>{
    console.error(error);
  }
)
    /*  let mensaje:string="";
      let keys = Object.keys(data);
      let key: string ="";
      key = keys[0];
      mensaje = data[key];
      this.abrirToast(mensaje);
    });
    */
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
  //Metodo que eleminar el peso ingresado en la semana
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
  //Metodo para actualizar el peso
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
