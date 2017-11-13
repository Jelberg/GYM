import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { HomePage } from '../../home/home';
import { IniciarsesionPage} from '../iniciarsesion/iniciarsesion'
import { AlertController } from 'ionic-angular/components/alert/alert-controller';

/**
 * Generated class for the PerfilPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-perfil',
  templateUrl: 'perfil.html',
})
export class PerfilPage {
  public users:any;
  private editar: boolean = true;
  private cgenero : any;
  private radioopen : boolean;
  constructor(
    public navCtrl: NavController,
    public navParams: NavParams,
    public alertCtrl: AlertController)
  {
  this.users = [];
  }

  ionViewDidLoad() {
    var usuariodata ='{"nombre":"Javier Hernandez", "fechanac":"28/07/1995", "altura":"180", "correo":"javierhzo1995@gmail.com", "telefono":"+584123621328", "genero":"Masculino"}'; 
    this.users = JSON.parse(usuariodata);
    document.getElementById("nombre").innerHTML= this.users.nombre;
    document.getElementById("correo").innerHTML= this.users.correo;
    document.getElementById("telefono").innerHTML= this.users.telefono;
    document.getElementById("estatura").innerHTML= this.users.altura;
    document.getElementById("genero").innerHTML= this.users.genero;
    document.getElementById("fechanac").innerHTML= this.users.fechanac;
  }
  cerrarsesion() {
    this.navCtrl.setRoot(IniciarsesionPage);}
    cambiargenero(){
      let alert = this.alertCtrl.create();
      alert.setTitle('Genero');
    
      alert.addInput({
        type: 'radio',
        label: 'Masculino',
        value: 'Masculino',
        checked: false
      });
    
      alert.addInput({
        type: 'radio',
        label: 'Femenino',
        value: 'Femenino',
        checked: false
      });
    
    
      alert.addInput({
        type: 'radio',
        label: 'Otro',
        value: 'Otro',
        checked: false  
      });
    
      alert.addButton('Cancel');
      alert.addButton({
        text: 'OK',
        handler: data => {
          this.cgenero = data;
          if (!this.cgenero){
            
          }else{
          this.radioopen = false;
          document.getElementById("genero").innerHTML= this.cgenero;
        }}
      });
      alert.present().then(() => {
        this.radioopen=true;
      })
    }
    
    
    editarperfil(){
    if (this.editar === true){
      
      this.editar = false;
    } else{
      let confirm = this.alertCtrl.create({
        title: 'Guardar cambios?',
        buttons: [
          {
            text: 'Cancelar',
            handler: () => {
            // agregar aqui codigo de cancelar
            this.editar =true;
            this.navCtrl.setRoot(HomePage);
            }
          },  
          {
            text: 'Aceptar',
            handler: () => {
            //agregar aqui codigo de aceptar
            this.editar =true;
            }
          }
        ]
      });
      confirm.present();
    }
    }




}
