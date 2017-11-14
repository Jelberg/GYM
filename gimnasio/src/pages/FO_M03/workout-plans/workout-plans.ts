import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, ActionSheetController, AlertController } from 'ionic-angular';

import { PlanPage } from '../plan/plan';
import { PlanRutinasPage } from '../plan-rutinas/plan-rutinas';


@IonicPage()
@Component({
  selector: 'page-workout-plans',
  templateUrl: 'workout-plans.html',
})
export class WorkoutPlansPage {

  constructor(public navCtrl: NavController, public navParams: NavParams, public actionSheetCtrl: ActionSheetController, public alertCtrl: AlertController) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad WorkoutPlansPage');
  }



  presentActionSheet() {
    const actionSheet = this.actionSheetCtrl.create({
      title: 'Compartir plan',
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
      title: 'Eliminar plan de entrenamiento?',
      message: 'Esta seguro que desea eliminar el plan de entrenamiento?',
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

  informacionPlan() {
    
        let prompt = this.alertCtrl.create({
          title: 'Información del plan',
          inputs: [
            {
              name: 'nombrePlan',
              placeholder: 'Nombre del plan'
            },
            {
              name: 'descripcionPlan',
              placeholder: 'Descripcion'
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

goToRutinas(planID){
  this.navCtrl.push(PlanRutinasPage, {planID: planID});
}


  goToPlan(page){
    this.navCtrl.push(PlanPage);
  }


}
