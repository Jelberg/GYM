import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { HomePage } from '../../home/home';
import { AlertController } from 'ionic-angular/components/alert/alert-controller';
/**
 * Generated class for the CrearusuarioPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */


@IonicPage()
@Component({
  selector: 'page-crearusuario',
  templateUrl: 'crearusuario.html',
})
export class CrearusuarioPage {
  public users:any;
  private cgenero : any;
  private radioopen : boolean;
  public editar: string = "true";
  constructor(public navCtrl: NavController,
              public navParams: NavParams,
              public alertCtrl: AlertController) 
              {
                this.users = []
              }
  volver() {
    this.navCtrl.pop();
  }
  ionViewDidLoad() {
      document.getElementById("fechanac").innerHTML = this.fechaActual();
      document.getElementById("genero").innerHTML = "Seleccionar";
    
  }

  fechaActual(){
    var date = new Date().toLocaleDateString();
    return date;
  }

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
}
