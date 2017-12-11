import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, Nav} from 'ionic-angular';
import { AlertController } from 'ionic-angular';
import { UserServiceProvider } from '../../../providers/user-service/user-service';

/**
 * Generated class for the ReservasPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-reservas',
  templateUrl: 'reservas.html',
})
export class ReservasPage {
  reservas : any[]=[];

  
  constructor(
    public navCtrl: NavController, 
    public navParams: NavParams, 
    public alertCtrl: AlertController,
    public userService: UserServiceProvider
  ) 
  {
    this.cargarReservas();
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ReservasPage');
  }

  /**
   * Metodo que carga las reservas hechas por el usuario
   */
  public cargarReservas():void{
    //IMPORTANTE id=1 debe cambiarse por la id del usuario instanciado
    let url = "FOM05_Reserva/consultaReservas?id=1";
    this.userService.getDato(url).subscribe(data => {    
        let i: number = 0;
        while ( i < data.length ){
        this.reservas[i] = data[i];
        i++;}
      console.log(this.reservas[0]);
      
    },
    (error) =>{
      console.error(error);
    }
  )
  }
 
  //Deberia eliminar la Reserva
  eliminarReserva(idh: StringConstructor){
    console.log('Reserva Eliminada');
    //IMPORTANTE id=1 debe cambiarse por la id del usuario instanciado
    let url = "FOM05_Reserva/deleteReserva?usuario=1&horario="+idh;
    this.userService.getDato(url).subscribe(data => {    
        let i: number = 0;
        while ( i < data.length ){
        this.reservas[i] = data[i];
        i++;}
      //console.log(this.reservas[0]);
      
    },
    (error) =>{
     // console.error(error);
    }
  )
  }
  

  presentAlert(id,no) {
    this.eliminarReserva(id);
    const alert = this.alertCtrl.create({
      title: 'Reserva',
      subTitle: 'Reserva Eliminada Satisfactoriamente',
      buttons: ['OK']
    });
    alert.present();
      this.reservas.splice(no,1);
    
  }

}
