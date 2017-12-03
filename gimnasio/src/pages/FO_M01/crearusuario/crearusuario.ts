import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { HomePage } from '../../home/home';
import { IniciarsesionPage} from '../iniciarsesion/iniciarsesion'
import { AlertController } from 'ionic-angular/components/alert/alert-controller';
import { UserServiceProvider } from '../../../providers/user-service/user-service';
import { Jsonp } from '@angular/http/src/http';
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
  usuario : string;
  password :string;
  password2: string;
  nombre : string;
  apellido :string;
  myDate :Date;
  correo: string;
  telefono :string;
  estatura :number;
  genero :string;
  public entrenador: boolean;
  public codigo: number;
  public class : any []=[];
  public class2 : any;
  public users:any;
  private cgenero : any;
  private radioopen : boolean;
  constructor(public navCtrl: NavController,
              public navParams: NavParams,
              public alertCtrl: AlertController,
              public userService: UserServiceProvider) 
              {
                this.users = []
              }
              
              
  volver() {
    this.navCtrl.pop();
  }
  ionViewDidLoad() {
      document.getElementById("genero").innerHTML = "Seleccionar";
    
  }

  fechaActual(){
    var date = new Date().toLocaleDateString();
    return date;
  }

  confirmarpas(){
    if (this.password==this.password2)
    {
      return false;
    }
    else 
    {
      return true;
    }
  }

validarEntrenador(){

  {
    let url = "BOM02_Entrenador/getEntrenador?correo="+this.correo;
    this.userService.getDato(url).subscribe(data => {    
      let i: number = 0;
      if ( i < data.length ){
        this.class[i] = data[i];
        this.radioopen=true;
      }
      console.log(this.class[0]);
      if (this.class[0])
      {
        this.radioopen=true;
      }
      else
      {
        this.radioopen=false;
      }
  },
  (error) =>{
    console.error(error);
    this.radioopen = false
  }
) 
  }
  return this.radioopen;
}

  insertarUsuario(){


    this.entrenador=this.validarEntrenador();
    console.log("bool "+this.entrenador)
    if ((this.usuario) && (this.password) && (this.password2) && (this.nombre) && (this.apellido) && (this.correo) && (this.estatura) && (this.telefono))
    {
      if (this.password.length>=5) // no avanzara si no se cumple la condicion
      {
        if (this.myDate)
          if ((this.genero))
          {
            if (this.confirmarpas()==false)
            {
              var x;
              let url = "Login/insertausuario?nombre="+this.nombre+"&apellido="+this.apellido+"&fechanac="+this.myDate+"&sexo="+this.genero+"&correo="+this.correo+"&usuario="+this.usuario+"&password="+this.password+"&estatura="+this.estatura+"&telefono="+this.telefono+"&entrenador="+this.entrenador;
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
                  if(x.id=="Se inserto el usuario")
                  {
                    this.mensajeexito("Usuario creado correctamente")
                    this.navCtrl.setRoot(IniciarsesionPage);
                  }
                  else this.mensajeerror("Problema no identificado")
                         
              },
              (error) =>{
                console.error(error);
              }
            )              
            }
            else
            {
              this.mensajeerror("Las contrasenas no coinciden")
            }

          }
          else 
          {
            this.mensajeerror("Debe seleccionar su genero")
          }
        else
        {
          this.mensajeerror("Fecha de nacimiento invalida")
        }
      }
    }
  }


  irahomeusuario() {
    this.navCtrl.setRoot(HomePage);
 }

/* metodo que cambia el genero por el seleccionado en el checkbox*/
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
        
        if (this.cgenero=="Femenino")
        {
          this.genero="F";
        }
        if (this.cgenero=="Masculino")
        {
          this.genero="M"
        }
      }}
    });
    alert.present().then(() => {
      this.radioopen=true;
    })
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
