import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController} from 'ionic-angular';
import { ListaClasesPage } from '../lista-clases/lista-clases';
import { UserServiceProvider } from '../../../providers/user-service/user-service';

/**
 * Generated class for the ClaseParticularPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-clase-particular',
  templateUrl: 'clase-particular.html',
})



export class ClaseParticularPage {
  public _id:string;
 
  public class : any []=[];

  constructor(
    public navCtrl: NavController, 
    public navParams: NavParams, 
    public alertCtrl: AlertController,
    public userService: UserServiceProvider
  ){  
    // con el let se optiene el parametro
      let id= this.navParams.get('navParametros');
      console.log(id);
      this._id=id;
    
     this.cargarClass();
  }
  
  /**
   * Metodo trae la informacion particular de la clase
   */
  public cargarClass():void{
    let url = "FOM05_Clase_Fecha/getClaseP?id="+this._id;
    this.userService.getDato(url).subscribe(data => {    
        let i: number = 0;
        while ( i < data.length ){
        this.class[i] = data[i];
        i++;}
      console.log(this.class[0]);
      
    },
    (error) =>{
      console.error(error);
    }
  )
  }


/**
 * Metodo para agregar la participacion del usuario
 */
  public agregarParticipacion():void{
    //IMPORTANTE CAMBIAR DEL URL usuario = 1 , este debe de ser la id instanciada
    let url = "FOM05_Reserva/addReserva?usuario=1&horario="+this._id;
    this.userService.getDato(url).subscribe(data => {    
        let i: number = 0;
        while ( i < data.length ){
        this.class[i] = data[i];
        i++;}
      console.log(this.class[0]);      
    },
    (error) =>{
      console.error(error);
    }
  )
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ClaseParticularPage');
  }

  presentAlert() {
    this.agregarParticipacion();
    const alert = this.alertCtrl.create({
      title: 'Clase',
      subTitle: 'Clase Agregada Satisfactoriamente',
      buttons: ['OK']
    });
    alert.present();
  }
}
