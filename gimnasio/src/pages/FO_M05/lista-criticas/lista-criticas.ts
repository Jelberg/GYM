import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { UserServiceProvider } from '../../../providers/user-service/user-service';

/**
 * Generated class for the ListaCriticasPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-lista-criticas',
  templateUrl: 'lista-criticas.html',
})
export class ListaCriticasPage {
  lista : any[]= [];

  constructor(
    public navCtrl: NavController,
     public navParams: NavParams,
     public userService: UserServiceProvider
  )
  {
    this.cargarCriticasUsuario();
  }

  /**
   * Metodo para listar las criticas hechas por el usuario
   */
  public cargarCriticasUsuario():void{
    //IMPORTANTE , referencia = 1 tiene que pasarse el id del usuario 
    let url = "FOM05_Critica/consultarCriticas?referencia=1";
    this.userService.getDato(url).subscribe(data => {    
        let i: number = 0;
        while ( i < data.length ){
        this.lista[i] = data[i];
        i++;}
      console.log(this.lista[0]);
      
    },
    (error) =>{
      console.error(error);
    }
  )
  }
  ionViewDidLoad() {
    console.log('ionViewDidLoad ListaCriticasPage');
  }

}
