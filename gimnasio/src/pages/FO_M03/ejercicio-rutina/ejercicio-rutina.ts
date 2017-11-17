import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController} from 'ionic-angular';
import { UserServiceProvider } from '../../../providers/user-service/user-service';
import { TabsLogPage } from '../../FO_M03/tabs-log/tabs-log';
/**
 * Generated class for the EjercicioRutinaPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-ejercicio-rutina',
  templateUrl: 'ejercicio-rutina.html',
})
export class EjercicioRutinaPage {


  public idUsuario: number;
  public nombreRut: string;
  public diaRut: string;
  public listaSeries: Array<{}>;
  public nombreEjercicio: string;

  constructor(public navCtrl: NavController, public alertCtrl: AlertController,  public navParams: NavParams,  private userService: UserServiceProvider) {
    this.nombreRut = this.navParams.get('nombreRut');
    this.diaRut = this.navParams.get('diaRut');
    this.idUsuario= this.navParams.get('idUsuario');
    this.nombreEjercicio = this.navParams.get('nombreEjercicio');
    this.getSeries();
    console.log(this.listaSeries);
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad EjercicioRutinaPage');
  }

  public getSeries()
  {

      let urlPeticion: string = "FOM03_TrabajoRutina/getSeriesEjercicio?idUsuario="
                                +this.idUsuario+"&nombre="+this.nombreRut
                                +"&dia="+this.diaRut+"&ejercicio="+this.nombreEjercicio;
        this.userService.getDato( urlPeticion ).subscribe( response => {
        this.listaSeries=response;
        console.log(this.listaSeries);
    })
    
  }

  public goToLog()
  {
    this.navCtrl.push(TabsLogPage);
  }

  public agregarSerie()
  {
    let prompt = this.alertCtrl.create({
      title: 'Agregar serie',
      inputs: [
        {
          name: 'Peso',
          placeholder: 'Peso'
        },
        {
          name: 'unidad',
          placeholder: 'unidad'
        },
        {
          name: 'repeticion',
          placeholder: 'Repeticiones'
        }
        ,
        {
          name: 'descanso',
          placeholder: 'descanso (min)'
        }
      ],
      buttons: [
        {
          text: 'Cancelar',
          handler: data => {
            console.log('Cancel clicked');
          }
        },
        {
          text: 'Aceptar',
          handler: data => {
            console.log('Saved clicked');
          }
        }       
      ]
    });
    prompt.present();
  }


}
