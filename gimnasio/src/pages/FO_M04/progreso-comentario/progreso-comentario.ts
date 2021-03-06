import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { ComentarioPage } from '../comentario/comentario';
import { UserServiceProvider } from '../../../providers/user-service/user-service';
import { classcomentario } from '../progreso-comentario/classcomentario';

@IonicPage()
@Component({
  selector: 'page-progreso-comentario',
  templateUrl: 'progreso-comentario.html'
})
export class ProgresoComentarioPage {

  //Arreglos para el manejo de la  informacion traida desde el servicio
  mensaje = [];
  nombre = [];
  fecha = [];
  progreso = [];
  
  constructor(public navCtrl: NavController, public navParams: NavParams,  private userService : UserServiceProvider)
  {
    this.getProgresosCompartidos();
  }
  ionViewDidLoad() 
  {
    console.log('ionViewDidLoad ProgresoComentarioPage');
  }

  /*Metodo que hace el llamado al servicio web y devuelve la informacion
  de cada progreso compartido
  */
  getProgresosCompartidos(){
    let urlPeticion: string = "FOM04_Comentario/getProgresos?usuario_id="+localStorage.getItem("id");
     this.userService.getDato( urlPeticion ).subscribe(data => {
        let i: number = 0;
        while ( i < data.length ){
          this.progreso.push(
            new classcomentario (data[i]._id,
                                data[i]._NombreUsuario,
                                data[i]._mensaje,
                                data[i]._fecha)
          );
          i++;
        }
      }); 
  }

  goToComentario(idProgCompartido: String){
    this.navCtrl.push(ComentarioPage, {id : idProgCompartido});
  }
}
