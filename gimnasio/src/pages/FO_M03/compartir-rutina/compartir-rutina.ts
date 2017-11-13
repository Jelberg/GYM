import { Component, ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController, ToastController } from 'ionic-angular';

import { ModificarRutinaPage } from '../modificar-rutina/modificar-rutina';
import { RutinaPage } from '../rutina/rutina';

@IonicPage()
@Component({
  selector: 'page-compartir-rutina',
  templateUrl: 'compartir-rutina.html',
})
export class CompartirRutinaPage {

  @ViewChild('NAV') nav : NavController;
  constructor(public navCtrl: NavController, public navParams: NavParams, public alertCtrl: AlertController, public toastCtrl: ToastController) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad CompartirRutinaPage');
  }
       
      presentConfirm() {
        const alert = this.alertCtrl.create({
          title: 'Eliminar Rutina',
          message: '¿Seguro que desea eliminar esta rutina?',
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
                this.mensajeEliminar();
              }
            }
          ]
        });
        alert.present();
      }
      
    
      goToArchivar() {
        const alert = this.alertCtrl.create({
          title: 'Agregar a mis Rutina',
          message: '¿Seguro que deseas agregar esta rutina a tu lista?',
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
                console.log('Rutina Agregada');
                this.mensajeAgregar();
              }
            }
          ]
        });
        alert.present();
      }
    
      mensajeEliminar(){
        let toast = this.toastCtrl.create({
          message: 'Rutina eliminada',
          duration: 1000,
          position: 'middle'
        });
        toast.present();
      }
    
      mensajeAgregar() {
        let toast = this.toastCtrl.create({
          message: 'Rutina agregada',
          duration: 1000,
          position: 'middle'
        });
        toast.present();
      }
}
