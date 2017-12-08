import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController, ModalController } from 'ionic-angular';
import { Contacts, Contact, ContactField, ContactName } from '@ionic-native/contacts';
import { UserServiceProvider } from '../../../providers/user-service/user-service';

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
  usuario : string;
  public class : any [];
  buscar:any[]=[];
  /**
   * listaContactos, se encarga de almacenar el listado de contactos recuperados del dispositivo.
   */
  listaContactos:any[]=[];
  constructor(public navCtrl: NavController, 
    public navParams: NavParams, 
    public alertCtrl: AlertController,
    public userService: UserServiceProvider, 
    private contacts:Contacts) {
      
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


  public cargarAmigos(){
    let url = "Usuario_Amigo/getUsuario_Amigo?idUsuario="+localStorage.getItem("id");
    this.userService.getDato(url).subscribe(data => {    
        this.class = data;
    },
      (error) =>{
        console.error(error);
      }
    )
  }
  public agregarAmigos( id ){
    var x;
    let url = "Usuario_Amigo/insertaUsuario_Amigo?idUsuario="+localStorage.getItem("id")+"&idAmigo="+id
    this.userService.postDato2(url).subscribe(data => {    
        let i: number = 0;
        console.log(data);     
          x = data;
          console.log(x);
        if(x.data=="Se agregó el amigo")
        this.mensajeexito("Usuario agregado correctamente")
        else
        this.mensajeerror("Usuario ya es amigo")             
    },
    (error) =>{
      console.error(error);
    }
  )
  }
  
  public listaBuscar(){
    var arregloDeCadenas = this.usuario.split(" ");
    let url = "Registrar_Usuario/getUsuarioNomApe?nombre="+arregloDeCadenas[0]+"&apellido="+arregloDeCadenas[1];
    if (this.usuario!="")
    {
      this.userService.getDato(url).subscribe(data => {    
          let i: number = 0;
          if ( i < data.length ){
          this.buscar = data;
          }
          else
          this.mensajeerror("no se encontro usuario")
      },
        (error) =>{
          console.error(error);
        }
      )
    }
    else
    this.mensajeerror("Llene el campo de busqueda")
    
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
  })
}

}
