import { Component, ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController, ToastController, FabContainer } from 'ionic-angular';

import { TabsRutinaPage } from '../tabs-rutina/tabs-rutina';
import { CompartirRutinaPage } from '../compartir-rutina/compartir-rutina';
import { TabsLogPage } from '../tabs-log/tabs-log';

import { Http, Headers} from '@angular/http'
import { UserServiceProvider } from '../../../providers/user-service/user-service';

@IonicPage()
@Component({
  selector: 'page-rutina',
  templateUrl: 'rutina.html',
})
export class RutinaPage {

    public listaRutinas: Array<{}>;
    public idUsuario: number;
  
    tabRutina = TabsRutinaPage;
    tabAmigos = CompartirRutinaPage;
    tabLog = TabsLogPage;

  @ViewChild('NAV') nav: NavController;
  constructor(public navCtrl: NavController, public navParams: NavParams, public alertCtrl: AlertController, public toastCtrl: ToastController, private userService: UserServiceProvider) {
    this.idUsuario=1;
    this.getRutinas();
  }

  public getRutinas(){
    let urlPeticion: string = "FOM03_Rutina/getRutina?idUsuario="+this.idUsuario;
    this.userService.getDato( urlPeticion ).subscribe( response => {
      this.listaRutinas=response;
      console.log(this.listaRutinas);
    })
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad RutinaPage');
  }

  agregarRutina(){
    let prompt = this.alertCtrl.create({
      title: 'Información de la rutina',
      inputs: [
        {
          name: 'nombreRutina',
          placeholder: 'Nombre Rutina'
        },
        {
          type: 'list',
          name: 'diaRutina',
          placeholder: 'Dia'
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

  presentConfirm() {
    const alert = this.alertCtrl.create({
      title: 'Eliminar Rutina',
      message: '¿Seguro que deseas eliminar esta rutina?',
      buttons: [
        {
          text: 'Cancelar',
          role: 'cancelar',
          handler: () => {
            console.log('Cancel clicked');
          }
        },
        {
          text: 'Aceptar',
          handler: () => {
            console.log('Rutina Eliminada');
            this.mensaje();
          }
        }
      ]
    });
    alert.present();
  }
  
  mensaje(){
    let toast = this.toastCtrl.create({
      message: 'Rutina eliminada',
      duration: 1000,
      position: 'middle'
    });
    toast.present();
  }

  goToCompartirRutina(page){
    this.navCtrl.push(CompartirRutinaPage);
  }

  goToLogPage(page){
    this.navCtrl.push(TabsLogPage);
  }

  closeFab(fab: FabContainer){
    fab.close();
  }
}
