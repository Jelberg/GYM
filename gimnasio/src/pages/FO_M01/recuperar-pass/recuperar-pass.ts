import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { HomePage } from '../../home/home';
import { IniciarsesionPage} from '../iniciarsesion/iniciarsesion'
import { AlertController } from 'ionic-angular/components/alert/alert-controller';
import { UserServiceProvider } from '../../../providers/user-service/user-service';
import { Jsonp } from '@angular/http/src/http';


/**
 * Generated class for the RecuperarPassPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-recuperar-pass',
  templateUrl: 'recuperar-pass.html',
})
export class RecuperarPassPage { 
  password :string;
  password2: string;
  codigo :number;
  public class : any []=[];
  public users:any;
  public cod : any;
  private corre :string;
  private radioopen : boolean;


  constructor(public navCtrl: NavController,
    public navParams: NavParams,
    public alertCtrl: AlertController,
    public userService: UserServiceProvider) {
      
      this.users = []
  }

  volver() {
    this.navCtrl.pop();
  }
  ionViewDidLoad() {
    this.Nuevacontrasena();

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

  getCodigo( correo )
  {
    let url = "Login/getUsuarioCorreo?correo="+correo;
    this.userService.getDato(url).subscribe(data => {    
        let i: number = 0;
        while ( i < data.length ){
        this.class[i] = data[i];
      i++;}
      console.log(this.class[0]);
      if (this.class[0])
      {
        localStorage.setItem("id",this.class[0].id)
        localStorage.setItem("entrenador",this.class[0].entrenador)
        console.log(localStorage.getItem("entrenador"));
        this.radioopen=false;
        this.irahomeusuario() 
      }
      else 
      {
        this.mensajeerror("Usuario y/o contrasena invalido")
      }
    },
    (error) =>{
      console.error(error);
    }
  )
  }
  cargar(){}
  Nuevacontrasena(){
    var correo = localStorage.getItem("correo");
    console.log(localStorage.getItem("correo"))
    this.corre=correo;
    localStorage.removeItem("correo");
    //if (this.validarCorreo(correo,this.cargar())==true)
    {
      var x;
      let url = "Login/updateCodigo?correo="+correo;
      this.userService.postDato2(url).subscribe(data => {    
          let i: number = 0;
          console.log(data);     
            x = data;
            console.log(x);
          
          this.radioopen=false;
          if(x.error!="Problema enviando el codigo, por favor intente mas tarde")
          {
             this.cod=parseInt(x.id);
          }
          else {
            this.mensajeerror("No se encontro el correo")
            this.navCtrl.setRoot(IniciarsesionPage);
          }     
      },
      (error) =>{
        console.error(error);
      }
    )      
    }
    //else
    //{
    //  console.log(this.radioopen)
    //  this.mensajeerror("Correo erroneo")
    //  this.navCtrl.setRoot(IniciarsesionPage);
    //}








  }


  

  cambiarContrasena()
  {
    console.log(this.cod)
    if (this.cod==this.codigo)
    {
      if (this.confirmarpas()==false)
      {
        var x;
        let url = "Login/updatePass?correo="+this.corre+"&password="+this.password;
        this.userService.postDato2(url).subscribe(data => {    
            let i: number = 0;
            console.log(data);     
              x = data;
              console.log(x);
            
            this.radioopen=false;
            if(x.id!="")
            {
               if (x.id == "Se actualizo la contrasena")
               {
                 this.mensajeexito(x.id)
                 this.navCtrl.setRoot(IniciarsesionPage);
               }
               else
               this.mensajeerror(x.id)
            }
            else this.mensajeerror("Problema no identificado")
                   
        },
        (error) =>{
          console.error(error);
        }
      )
      }
      else 
      this.mensajeerror("Las contrasenas no coinciden")
    }
    else
    this.mensajeerror("El codigo es incorrecto ")
  }


  //Valida que el correo este metido en el sistema
  validarCorreo(correo, callback )
  {
        
        let url = "Login/getUsuarioCorreo?correo="+correo;
        this.userService.getDato(url).subscribe(data => {    
          let i: number = 0;       
            this.radioopen=true;console.log(data.id+"MIRAA");
            if (data.id=="0")
            localStorage.setItem("aux","false");
            else
            localStorage.setItem("aux","true");
          
          console.log(localStorage.getItem("aux"));
      },
      (error) =>{
        console.error(error);
        this.radioopen = false
      }
    ) 
    callback
    if (localStorage.getItem("aux")=="true")
    {
      
      this.radioopen=true;
      localStorage.removeItem("aux")
    }
    else
    {
      
      this.radioopen=false;
      localStorage.removeItem("aux")
    }
      
      console.log(this.class)
      console.log(this.radioopen)
      return this.radioopen;
}






  irahomeusuario() {
    this.navCtrl.setRoot(HomePage);
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


