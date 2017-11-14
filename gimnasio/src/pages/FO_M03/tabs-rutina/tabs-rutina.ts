import { Component, ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController } from 'ionic-angular';

import { ModificarRutinaPage } from '../modificar-rutina/modificar-rutina';

@IonicPage()
@Component({
  selector: 'page-tabs-rutina',
  templateUrl: 'tabs-rutina.html',
})
export class TabsRutinaPage {

  @ViewChild('NAV')nav : NavController;
  constructor(public navCtrl: NavController, public navParams: NavParams, public alertCtrl: AlertController) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad TabsRutinaPage');
  }

  agregarRutina() {
    
        let prompt = this.alertCtrl.create({
          title: 'Nueva Rutina',
          message: "Ingrese el nombre de la rutina:",
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
              text: 'Aceptar',
              handler: data => {
                console.log('Saved clicked');
                this.mensajeRutinaCreada();
              }
            },
            {
              text: 'Cancelar',
              handler: data => {
                console.log('Cancel clicked');
              }
            }
            
          ]
        });
        prompt.present();
      }
      
      goToModificar()
      {
        this.navCtrl.push(ModificarRutinaPage);
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
              text: 'Eliminar',
              handler: () => {
                console.log('Rutina Eliminada');
                this.mensajeRutinaEliminada();
              }
            }
          ]
        });
        alert.present();
      }
      
      mensajeRutinaEliminada() {
        const alert = this.alertCtrl.create({
          title: 'Rutina Eliminada',
          subTitle: 'La rutina seleccionada fue eliminada satisfactoriamente',
          buttons: ['Aceptar']
        });
        alert.present();
      }
    
      mensajeRutinaCreada() {
        const alert = this.alertCtrl.create({
          title: 'Rutina Creada',
          subTitle: 'La rutina seleccionada fue creada satisfactoriamente',
          buttons: ['Aceptar']
        });
        alert.present();
        this.goToModificar();
      }

}
