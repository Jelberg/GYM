import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { UserServiceProvider } from '../../../providers/user-service/user-service';
import {ClaseParticularPage} from '../clase-particular/clase-particular';
import { AlertController } from 'ionic-angular';

/**
 * Generated class for the ListaClasesPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-lista-clases',
  templateUrl: 'lista-clases.html',
})
export class ListaClasesPage {
  clases: any[]=[];

  constructor(
    public navCtrl: NavController,
     public navParams: NavParams, 
     public userService: UserServiceProvider,
     public alertCtrl: AlertController
    )
      {
    this.cargarClases();
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ListaClasesPage');
  }


  /**
   * Metodo que carga todas las clases
   */
  public cargarClases():void{
    let url = "FOM05_Clase_Fecha/listaClases";
    this.userService.getDato(url).subscribe(data => {    
        let i: number = 0;
        while ( i < data.length ){
        this.clases[i] = data[i];
        i++;}
      console.log(this.clases[0]);
    },
    (error) =>{
      console.error(error);
    }
  )
  }

  presentAlert() {
    const alert = this.alertCtrl.create({
      title: 'Clase',
      subTitle: 'Clase Agregada Satisfactoriamente',
      buttons: ['OK']
    });
    alert.present();
  }

  goToClaseParticular(id: number,titulo: string, descripcion: string, instructor: string, fecha:string,capacidad:number){
    this.navCtrl.push(ClaseParticularPage,{navControler:this.navCtrl, navParametros:this.navParams, alertControler:this.alertCtrl,
      id,titulo, descripcion, instructor, fecha,capacidad
    });
  }

}
