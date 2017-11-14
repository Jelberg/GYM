import { Component, ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController } from 'ionic-angular';
import {Http, Headers} from '@angular/http';
import { ModificarRutinaPage } from '../modificar-rutina/modificar-rutina';
import { TabsLogPage } from '../tabs-log/tabs-log';
import { UserServiceProvider } from '../../../providers/user-service/user-service';
import { CompartirRutinaPage } from '../compartir-rutina/compartir-rutina';


@IonicPage()
@Component({
  selector: 'page-rutina',
  templateUrl: 'rutina.html',
})
export class RutinaPage {

  public listaRutinas: Array<{}>;
  public idUsuario: number;
  public respuesta: string;

  
    @ViewChild('NAV')nav : NavController;
    constructor(public navCtrl: NavController, 
      public navParams: NavParams, 
      public alertCtrl: AlertController,
      private userService: UserServiceProvider)
    {
      this.idUsuario=1;
      this.getRutinas();
    }
  
    ionViewDidLoad() {
      console.log('ionViewDidLoad RutinaPage');
    }


    /**Funcion recibe el id de usuario y busca 
     * todas las rutinas que tiene
     * @returns  lista de todas las rutinas del usuario
     */
    public getRutinas()
    {
      let urlPeticion: string = "FOM03_Rutina/getRutina?idUsuario="+this.idUsuario;
      this.userService.getDato( urlPeticion ).subscribe( response => {
        this.listaRutinas=response;
        console.log(this.listaRutinas);
    })
    }

    /**
     * Funcion que agrega una nueva rutina al usuario 
     * @param nombre recibe el nombre de la rutina
     * @param dia recibe el dia a realizar la rutina
     */
    public setRutinas(nombre: string, dia: string):void
    {
      let urlPeticion: string = "FOM03_Rutina/setRutina?idUsuario="+this.idUsuario+"&nombre="+nombre+"&dia="+dia;
      this.userService.postDato( urlPeticion ).subscribe( data => {
        /*this.respuesta =data;
        console.log(this.respuesta);*/
    })
  }

  /**
   * Funcion que elimina una rutina de la lista del usuario
   * @param nombre se busca la rutina a eliminar por el nombre
   * @param dia   y el dia que se realiza
   * @returns no retorna un valor
   */
  public eliminarRutina( nombre: string, dia: string )
  {
    let urlPeticion: string = "FOM03_Rutina/eliminarRutina?idUsuario="+this.idUsuario+
                              "&nombre="+nombre+"&dia="+dia;
      this.userService.getDato( urlPeticion ).subscribe( response => {
        console.log(this.listaRutinas);
    })
  }
    
  /**
   *Funcion que agrega una rutina al usuario
   *se recibe el nombre de la rutina y el dia a ser realizada
   */
    public agregarRutina() 
    {
      
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
                  this.setRutinas(data.nombreRutina,data.diaRutina);
                  console.log('Rutina Creada');
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

        /**
         * Funcion que redirecciona a la pagina de modificar rutina
         */
        
        public goToModificar()
        {
          this.navCtrl.push(ModificarRutinaPage);
        }

        /**
         * Funcion que redirecciona a la pagina de log
         * donde se almacena la bitacora de los ejercicios realizados
         */
        public goToLog()
        {
          this.navCtrl.push(TabsLogPage);
        }

        /**
         * Funcion que despliega un Alert de confirmacion para eliminar
         * una rutina de la lista del usuario
         * @param nombre recibe el nombre de la rutina a ser eliminada 
         * @param dia  recibe el dia de realizacion de la rutina
         */
      
       public presentConfirm(nombre: string, dia: string) 
       {
          const alert = this.alertCtrl.create({
            title: 'Eliminar Rutina',
            message: '¿Seguro que deseas eliminar '+nombre+' '+dia+'?',
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
                  this.eliminarRutina(nombre,dia);
                  console.log('Rutina Eliminada');
                  this.mensajeRutinaEliminada();
                }
              }
            ]
          });
        
          alert.present();
         
        }

        /**
         * Funcion que se encarga de desplegar un mensaje en pantalla
         * confirmando la eliminacion de una rutina
         */
        
       public  mensajeRutinaEliminada() {
          const alert = this.alertCtrl.create({
            title: 'Rutina Eliminada',
            subTitle: 'La rutina seleccionada fue eliminada satisfactoriamente',
            buttons: ['Aceptar']
          });
          alert.present();
          this.navCtrl.push(RutinaPage);
        }
      
        /**
         * Funcion que retorna un mensaje de confirmacion de 
         * creacion de una rutina
         */
        public mensajeRutinaCreada() {
          const alert = this.alertCtrl.create({
            title: 'Rutina Creada',
            subTitle: 'La rutina  fue creada satisfactoriamente',
            buttons: ['Aceptar']
          });
          alert.present();
          this.goToModificar();
        }
        
}
