import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController } from 'ionic-angular';

import { EjerciciosPage } from '../ejercicios/ejercicios';
import { TabsLogPage } from '../tabs-log/tabs-log';
import { UserServiceProvider } from '../../../providers/user-service/user-service';
import { EjercicioRutinaPage } from '../../FO_M03/ejercicio-rutina/ejercicio-rutina';
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
  public idUsuario: number;
  public nombreRut: string;
  public diaRut: string;
  public listaEjercicios: Array<{}>;

  constructor(public navCtrl: NavController, public navParams: NavParams, public alertCtrl: AlertController,  private userService: UserServiceProvider) {
    this.nombreRut = this.navParams.get('nombre');
    this.diaRut = this.navParams.get('dia');
    this.idUsuario=this.navParams.get('idUsuario');
    this.getEjercicios();
    console.log(this.rutinaID);
    console.log(this.listaEjercicios);
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ModificarRutinaPage');
  }

 
    public getEjercicios()
    {
        let urlPeticion: string = "FOM03_TrabajoRutina/getEjerciciosRutina?idUsuario="+this.idUsuario+"&nombre="+this.nombreRut+"&dia="+this.diaRut;
        this.userService.getDato( urlPeticion ).subscribe( response => {
          this.listaEjercicios=response;
          console.log(this.listaEjercicios);
      })
      
    }

  public seleccionarEjercicios() 
  {
    let alert = this.alertCtrl.create();
    alert.setTitle('Registro de Trabajo');
    alert.setMessage('¿Cuales son los ejercicios a agregar en el registro?');
    
    let list = JSON.stringify(this.listaEjercicios,['_nombre']);  
    console.log(list);
    
    
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
      }
    });
    alert.present();
  }

 /* public indicarFecha() {
    
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
      }*/

     public cambiarRutina() {
        
            let prompt = this.alertCtrl.create({
              title: 'Modificar Datos',
              message: "Ingrese el nombre de la rutina:",
              inputs: [
                {
                  name: 'nombreRutina',
                  placeholder: 'Nombre Rutina',
                  value: this.nombreRut
                },
                {
                  type: 'list',
                  name: 'diaRutina',
                  placeholder: 'Dia',
                  value: this.diaRut
                }
              ],
              buttons: [
                {
                  text: 'Aceptar',
                  handler: data => {
                    this.modificarRutina(data.nombreRutina,data.diaRutina);
                    console.log('Rutina modificada');
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


  public modificarEjercicio()
  {
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

  public ConfirmarEliminacion() 
  {
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
  public goToLog()
  {
    this.navCtrl.push(TabsLogPage);
  }

  public modificarRutina(nombreModif: string, diaModif : string):void
  {
    let urlPeticion: string = "FOM03_Rutina/modificarRutina?idUsuario="
                                +this.idUsuario+"&nombre="
                                +this.nombreRut+"&dia="+this.diaRut
                                +"&nombreModif="+nombreModif
                                +"&diaModif="+diaModif;
    this.userService.post2(urlPeticion);
  }

  public goToEjercicios(){
    this.navCtrl.push(EjerciciosPage, {idUsuario: this.idUsuario, 
                                       nombreRut: this.nombreRut, 
                                       diaRut: this.diaRut} );
  }

  public goToEjercicioRutina(nombEjercicio: string){
    this.navCtrl.push(EjercicioRutinaPage, {idUsuario: this.idUsuario, 
                                            nombreRut: this.nombreRut, 
                                            diaRut: this.diaRut,
                                            nombreEjercicio: nombEjercicio});
  }
}
