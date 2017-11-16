import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, ActionSheetController, AlertController, ToastController } from 'ionic-angular';

import { PlanPage } from '../plan/plan';
import { PlanRutinasPage } from '../plan-rutinas/plan-rutinas';

import { Http, Headers} from '@angular/http'
import { UserServiceProvider } from '../../../providers/user-service/user-service';

@IonicPage()
@Component({
  selector: 'page-workout-plans',
  templateUrl: 'workout-plans.html',
})
export class WorkoutPlansPage {

  public listaPlanes: Array<{}>;
  public idUsuario: number;

  constructor(public navCtrl: NavController, public navParams: NavParams, public actionSheetCtrl: ActionSheetController, public alertCtrl: AlertController, public toastCtrl: ToastController, private userService: UserServiceProvider) {
    this.idUsuario=1;
    this.getPlan();
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad WorkoutPlansPage');  
  }

  /**
  * Funcion recibe el id de usuario y busca 
  * todos los planes que tiene
  * @returns  lista de todos los planes del usuario
  */
  public getPlan(){
    let urlPeticion: string = "FOM03_Plan/getPlan?idUsuario="+this.idUsuario;
    this.userService.getDato( urlPeticion ).subscribe( response => {
      this.listaPlanes=response;
      console.log(this.listaPlanes);
    })
  }

  /**
   * Funcion que elimina un plan de la lista del usuario
   * @param nombre se busca el plan a eliminar por el nombre
   * @param descrip   con su descripcion
   * @returns no retorna un valor
   */
  public eliminarPlan( nombre: string, descripcion: string )
  {
    let urlPeticion: string = "FOM03_Plan/eliminaPlan?idUsuario="+this.idUsuario+
                              "&nombre="+nombre+"&descrip="+descripcion;
      this.userService.getDato( urlPeticion ).subscribe( response => {
        console.log(this.listaPlanes);
    })
  }

  /**
  * Funcion que agrega un nuevo plan al usuario 
  * @param nombre recibe el nombre del plan
  * @param descrip recibe la descripcion del plan
  */
    public setPlan(nombre: string, descripcion: string):void
    {
      let urlPeticion: string = "FOM03_Plan/setPlan?idUsuario="+this.idUsuario+"&nombre="+nombre+"&descrip="+descripcion;
      this.userService.postDato( urlPeticion ).subscribe( data => {
        /*this.respuesta =data;
        console.log(this.respuesta);*/
    })
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
 
  ConfirmarEliminacion(nombre: string, descripcion: string) {
    const alert = this.alertCtrl.create({
      title: 'Eliminar plan de entrenamiento?',
      message: 'Esta seguro que desea eliminar el plan '+nombre+'?',
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
            this.eliminarPlan(nombre,descripcion);
            console.log('Plan eliminado');
            this.mensajeEliminar();
          }
        }
      ]
    });
    alert.present();
  }

  mensajeEliminar(){
    let toast = this.toastCtrl.create({
      message: 'Plan eliminado satisfactoriamente',
      duration: 3000,
      position: 'middle'
    });
    toast.present();
    this.getPlan();
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
                this.setPlan(data.nombrePlan,data.descripcionPlan);
                console.log('Plan creado');
                this.mensajeCrear();
              }
            }
            
          ]
        });
        prompt.present();
    }

    mensajeCrear(){
      let toast = this.toastCtrl.create({
        message: 'Plan creado satisfactoriamente',
        duration: 3000,
        position: 'middle'
      });
      toast.present();
      this.getPlan();
    }

goToRutinas(planNombre){
  this.navCtrl.push(PlanRutinasPage, {planNombre: planNombre});
}


  goToPlan(page){
    this.navCtrl.push(PlanPage);
  }

}
