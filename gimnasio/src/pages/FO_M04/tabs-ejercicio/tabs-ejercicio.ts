import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { ProgresoEjercicioPage } from '../progreso-ejercicio/progreso-ejercicio';
import { ProgresoComentarioPage } from '../progreso-comentario/progreso-comentario';
import { ListaContactosPage } from '../lista-contactos/lista-contactos';

@IonicPage()
@Component({
  selector: 'page-tabs-ejercicio',
  templateUrl: 'tabs-ejercicio.html'
})
export class TabsEjercicioPage {

  grafica: any = ProgresoEjercicioPage;
  comentarios: any = ProgresoComentarioPage;
  constructor(public navCtrl: NavController, public navParams: NavParams)
  {
  	

  }
  ionViewDidLoad() 
  {
    console.log('ionViewDidLoad TabsEjercicioPage');
  }

  goToListaContactosPage(){
    this.navCtrl.push(ListaContactosPage);
  }
}
