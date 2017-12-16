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
  usuario2 : string;
  password2 :string;
  password3: string;
  nombre2 : string;
  apellido2 :string;
  correo2: string;
  telefono2 :string;
  estatura2 :number;
  genero2 :string;
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

    let url = "Registrar_Usuario/getUsuario?idUsuario="+localStorage.getItem("id");
    this.userService.getDato(url).subscribe(data => {    
        let i: number = 0;
        while ( i < data.length ){
        this.class[i] = data[i];
      i++;}
      console.log(this.class[0]);
      if (this.class[0])
      {
        document.getElementById("nombre").innerHTML=this.class[0].nombre+" "+this.class[0].apellido;
        document.getElementById("usuario").innerHTML=this.class[0].usuario;
        document.getElementById("correo").innerHTML=this.class[0].correo;
        document.getElementById("telefono").innerHTML=this.class[0].telefono;
        document.getElementById("estatura").innerHTML= this.class[0].estatura;       
        document.getElementById("fechanac").innerHTML= this.class[0].fecha_nac;
        if (this.class[0].sexo=="M")
        document.getElementById("genero").innerHTML= "Masculino"
        else
        document.getElementById("genero").innerHTML= "Femenino"


        this.nombre2=this.class[0].nombre;
        this.apellido2=this.class[0].apellido;
        this.usuario2=this.class[0].usuario;
        this.password2=this.class[0].password;
        this.password3=this.class[0].password;
        this.correo2=this.class[0].correo;
        this.telefono2=this.class[0].telefono;
        this.estatura2= this.class[0].estatura;       
        if (this.class[0].sexo=="M")
        this.genero2= "Masculino"
        else
        this.genero2= "Femenino"
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
          document.getElementById("genero2").innerHTML= this.cgenero;
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
            
            this.editar =this.modificarUsu()
            }
          }
        ]
      });
      confirm.present();
    }
    }


    modificarUsu(){
    if ((this.usuario2) && (this.password2) && (this.password3) && (this.nombre2) &&(this.apellido2) && (this.correo2) && (this.estatura2) && (this.telefono2)){
      {
        if (this.password2.length>=5){
          var x;
          var gen;
          if (this.genero2=="Masculino")
          gen="M"
          else
          gen="F"
          let url = "Registrar_Usuario/modificaUsuario?id="+localStorage.getItem("id")+"&nombre="+this.nombre2+"&apellido="+this.apellido2+"&sexo="+gen+"&correo="+this.correo2+"&usuario="+this.usuario2+"&password="+this.password2+"&estatura="+this.estatura2+"&telefono="+this.telefono2+"&entrenador="+localStorage.getItem("entrenador");
          this.userService.postDato2(url).subscribe(data => {    
              let i: number = 0;
              console.log(data);     
                x = data;
                console.log(x);
              
              this.radioopen=false;
              if(x.id=="usuario duplicado")
              this.mensajeerror("Ya existe ese nombre de usuario en el sistema")
              else
              if(x.id=="correo duplicado")
              this.mensajeerror("Ya existe ese correo en el sistema")
              else
              if(x.id=="Se actualizo el usuario")
              {
                this.mensajeexito("Usuario actualizado correctamente")
                this.navCtrl.setRoot(HomePage);
                return true;
              }
              else this.mensajeerror("Problema no identificado")
                     
          },
          (error) =>{
            console.error(error);
          }
        ); return false;
        }
        else
        this.mensajeerror("Contrasena muy corta")
        return false;
      }
    }
    else
    this.mensajeerror("Debe llenar todos los campos")
    return false;
    }


    confirmarpas(){
      if (this.password2==this.password3)
      {
        return false;
      }
      else 
      {
        return true;
      }
    }



      /* metodo que muestra un  mensaje de error */
mensajeerror( mensaje )
{
  let alert = this.alertCtrl.create();
  alert.setTitle('Error'); 
  alert.setMessage(mensaje)
  alert.addButton({
    text: 'OK',
  });
  alert.present().then(() => {
    this.radioopen=true;
  })
}

mensajeexito( mensaje )
{
  let alert = this.alertCtrl.create();
  alert.setTitle('Exito'); 
  alert.setMessage(mensaje)
  alert.addButton({
    text: 'OK',
  });
  alert.present().then(() => {
    this.radioopen=true;
  })
}

}
