import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController, ModalController } from 'ionic-angular';
import { Contacts, Contact, ContactField, ContactName } from '@ionic-native/contacts';

/**
 * Generated class for the AmigosPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-amigos',
  templateUrl: 'amigos.html',
})
export class AmigosPage {
  personas : string;
  /**
   * listaContactos, se encarga de almacenar el listado de contactos recuperados del dispositivo.
   */
  listaContactos:any[]=[];
  constructor(public navCtrl: NavController, private contacts:Contacts, private modalCtrl:ModalController) {
    this.cargarListaContactos();
  }
  /**
   * Funcion encargada de cargar la lista de contactos del celular
   */
  cargarListaContactos(){
    this.contacts.find(["*"])
    .then(res => {
      console.log({funcion:'CargarListaContactos',res:res})
      let datosMostrar:any[]=[];
      res.map((item) =>{
        if(item.displayName != null && item.phoneNumbers != null){
          datosMostrar.push({displayName:item.displayName,phoneNumbers:item.phoneNumbers})
        }        
      })
      console.log({funcion:'CargarListaContactos',datosMostrar:datosMostrar})
      this.listaContactos = datosMostrar;
    },error => {
      console.log({error:error})
    })
  }

  public agregarAmigos(){
    
  }
  
}
