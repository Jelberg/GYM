import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController } from 'ionic-angular';

import { EjerciciosPage } from '../ejercicios/ejercicios';

/**
 * Generated class for the ModificarRutinaPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-modificar-rutina',
  templateUrl: 'modificar-rutina.html',
})
export class ModificarRutinaPage {

  public rutinaID: number;
  constructor(public navCtrl: NavController, public navParams: NavParams, public alertCtrl: AlertController) {
    this.rutinaID = this.navParams.get('rutinaID');
    console.log(this.rutinaID);
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ModificarRutinaPage');
  }

 

  seleccionarEjercicios() {
    let alert = this.alertCtrl.create();
    alert.setTitle('Registro de Trabajo');
    alert.setMessage('¿Cuales son los ejercicios a agregar en el registro?');
    
    let list = ["Curl de Biceps", "Press banca", "Mancuernas"];
    
    for (let i of list) {

      alert.addInput({
        type: 'checkbox',
        label: i,
        value: i
      });
    }

  /*  alert.addInput({
      type: 'checkbox',
      label: 'Curl',
      value: 'Curl de biceps',
      checked: true
    });

    alert.addInput({
      type: 'checkbox',
      label: 'press',
      value: 'Press de Banca'
    });

    alert.addInput({
      type: 'checkbox',
      label: 'barra',
      value: 'Barra'
    });*/

    alert.addButton('Cancelar');
    alert.addButton({
      text: 'Aceptar',
      handler: data => {
        console.log('Checkbox data:', data);
        //this.testCheckboxOpen = false;
        //this.testCheckboxResult = data;
        this.indicarFecha();
      }
    });
    alert.present();
  }

  indicarFecha() {
    
        let prompt = this.alertCtrl.create({
          title: 'Registro de Trabajo',
          message: "Ingrese la fecha:",
          inputs: [
            {
              type: 'date',
              name: 'diaRutina',
              placeholder: 'Dia'
            }
          ],
          buttons: [
            {
              text: 'Aceptar',
              handler: data => {
                console.log('Saved clicked');
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

      ModificarRutina() {
        
            let prompt = this.alertCtrl.create({
              title: 'Modificar Datos',
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


  modificarEjercicio(){
    let prompt = this.alertCtrl.create({
      title: 'Modificar Ejercicio',
      inputs: [
        {
          name: 'serie',
          placeholder: 'Series'
        },
        {
          name: 'repeticion',
          placeholder: 'Repeticiones'
        },
        {
          name: 'peso',
          placeholder: 'Peso'
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

  ConfirmarEliminacion() {
    const alert = this.alertCtrl.create({
      title: 'Eliminar ejercicio de la rutina',
      message: 'Está seguro que desea eliminar el ejercicio de la rutina?',
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

  goToEjercicios(page){
    this.navCtrl.push(EjerciciosPage);
  }
}
