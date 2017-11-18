import { Component, ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams, ToastController, AlertController } from 'ionic-angular';

import { UserServiceProvider } from '../../../providers/user-service/user-service';
import { ModificarRutinaPage } from '../../FO_M03/modificar-rutina/modificar-rutina';
/**
 * Generated class for the EjerciciosPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-ejercicios',
  templateUrl: 'ejercicios.html',
})
export class EjerciciosPage {

  public listaEjerciciosMaquina: Array<{}>; //Se carga una lista de ejercicios por maquina
  public listaEjerciciosEquipo: Array<{}>; //y la segunda por equipo
  public idUsuario: number;
  public respuesta: string;
  public nombreRut: string;
  public diaRut: string;

  @ViewChild('NAV')nav : NavController;
  constructor(public navCtrl: NavController, 
    public navParams: NavParams, 
    public alertCtrl: AlertController,
    private userService: UserServiceProvider,  private toastCtrl: ToastController)
  {
    this.nombreRut = this.navParams.get('nombreRut');
    this.diaRut = this.navParams.get('diaRut');
    this.idUsuario=this.navParams.get('idUsuario');
    this.getEjerciciosMaquina();
    this.getEjerciciosEquipo();
  }
  
  public getEjerciciosMaquina()
  {
    let urlPeticion: string = "FOM03_TrabajoRutina/getEjerciciosMaquina?idUsuario="+this.idUsuario
                                                  +"&nombre="+this.nombreRut+"&dia="+this.diaRut;
    this.userService.getDato( urlPeticion ).subscribe( response => {
      this.listaEjerciciosMaquina=response;
      console.log(this.listaEjerciciosMaquina);
  })
  }
  public getEjerciciosEquipo()
  {
    let urlPeticion: string = "FOM03_TrabajoRutina/getEjerciciosEquipo?idUsuario="+this.idUsuario
                                                  +"&nombre="+this.nombreRut+"&dia="+this.diaRut;
    this.userService.getDato( urlPeticion ).subscribe( response => {
      this.listaEjerciciosEquipo=response;
      console.log(this.listaEjerciciosEquipo);
  })
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad EjerciciosPage');
  }

  
  setEjercicio(ejercicio: string, maquina: string, equipo: string)
  {
      this.agregarEjercicioRutina(ejercicio,maquina,equipo);
      let toast = this.toastCtrl.create({
        message: 'Ejercicio añadido',
        duration: 1000,
        position: 'middle'
      });
      toast.present();
    
  }

  public agregarEjercicioRutina(ejercicio: string, maquina: string, equipo: string):void 
  {
    
      let urlPeticion: string = "FOM03_TrabajoRutina/setEjercicioRutina?idUsuario="+this.idUsuario
                                                                        +"&nombre="+this.nombreRut
                                                                        +"&dia="+this.diaRut
                                                                        +"&ejercicio="+ejercicio
                                                                        +"&maquina="+maquina
                                                                        +"&equipo="+equipo;
      this.userService.post2(urlPeticion);
      this.mostrarEjercicioAgregado();
      this.goToModificar();

  }

 
  public mostrarEjercicioAgregado() {
    const alert = this.alertCtrl.create({
      title: 'El ejercicio fue agregado con exito',
      buttons: ['Aceptar']
    });
    alert.present();
   // this.goToModificar();
  }

  public goToModificar()
  {
    this.navCtrl.push(ModificarRutinaPage, {nombre: this.nombreRut, dia: this.diaRut, idUsuario: this.idUsuario});
  }
  
}
