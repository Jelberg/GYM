import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { HomePage } from '../../home/home';
import { IniciarsesionPage} from '../iniciarsesion/iniciarsesion';
import { UserServiceProvider } from '../../../providers/user-service/user-service';
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
  public class : any []=[];
  constructor(
    public navCtrl: NavController,
    public navParams: NavParams,
    public alertCtrl: AlertController,
    public userService: UserServiceProvider)
  {
  this.users = [];
  }

  ionViewDidLoad() {

    let url = "Login/getUsuario?id="+localStorage.getItem("id");
    this.userService.getDato(url).subscribe(data => {    
        let i: number = 0;
        while ( i < data.length ){
        this.class[i] = data[i];
      i++;}
      console.log(this.class[0]);
      if (this.class[0])
      {
        document.getElementById("nombre").innerHTML=this.class[0].nombre+" "+this.class[0].apellido;
        document.getElementById("correo").innerHTML=this.class[0].correo;
        document.getElementById("telefono").innerHTML=this.class[0].telefono;
        document.getElementById("estatura").innerHTML= this.class[0].estatura;       
        document.getElementById("fechanac").innerHTML= this.class[0].fecha_nac;
        if (this.class[0].sexo=="M")
        document.getElementById("genero").innerHTML= "Masculino"
        else
        document.getElementById("genero").innerHTML= "Femenino"
        this.radioopen=false;
      }
    },
    (error) =>{
      console.error(error);
    }
  )
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
