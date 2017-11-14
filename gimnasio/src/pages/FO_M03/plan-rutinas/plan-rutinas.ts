import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, ActionSheetController, AlertController } from 'ionic-angular';

import { PlanPage } from '../plan/plan';
import { ModificarRutinaPage } from '../modificar-rutina/modificar-rutina';

@IonicPage()
@Component({
  selector: 'page-plan-rutinas',
  templateUrl: 'plan-rutinas.html',
})
export class PlanRutinasPage {

  public planID: number;
  constructor(public navCtrl: NavController, public navParams: NavParams, public actionSheetCtrl: ActionSheetController, public alertCtrl: AlertController) {
    this.planID = this.navParams.get('planID');
    console.log(this.planID);
  }

  ionViewDidLoad() {
    //console.log('ionViewDidLoad RoutinesPage');
  }


  presentActionSheet() {
    const actionSheet = this.actionSheetCtrl.create({
      title: 'Compartir rutina',
      buttons: [
        {
          text: 'Amigos',
          role: '',
          handler: () => {
            console.log('Archive clicked');
          }
        },
        {
          text: 'Comunidad',
          handler: () => {
            console.log('Archive clicked');
          }
        },
        {
          text: 'Cancelar',
          role: 'cancel',
          handler: () => {
            console.log('Cancel clicked');
          }
        }
      ]
    });
 
    actionSheet.present();
  }


  ConfirmarEliminacion() {
    const alert = this.alertCtrl.create({
      title: 'Eliminar rutina?',
      message: 'Está seguro que desea eliminar la rutina?',
      buttons: [
        {
          text: 'Cancelar',
          role: 'cancel',
          handler: () => {
            console.log('Cancel clicked');
          }
        },
        {
          text: 'Aceptar',
          handler: () => {
            console.log('Aceptar clicked');
          }
        }
      ]
    });
    alert.present();
  }


  modificarRutina() {
    
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

  goToPlan(page){
    this.navCtrl.push(PlanPage);
  }

  goToEjercicios(rutinaID){
    this.navCtrl.push(ModificarRutinaPage, {rutinaID: rutinaID});
  }

}
