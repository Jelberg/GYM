import { Component , ViewChild } from '@angular/core';
import { IonicPage, NavController, NavParams, Nav,AlertController } from 'ionic-angular';
import { ClasesParticipadasPage} from '../clases-participadas/clases-participadas';
import { UserServiceProvider } from '../../../providers/user-service/user-service';

/**
 * Generated class for the ComentarClasePage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
  
@Component({
  selector: 'page-comentar-clase',
  templateUrl: 'comentar-clase.html',
})
export class ComentarClasePage {
  _id : string;
  comentario : any []=[];
  
  @ViewChild('NAV') nav:Nav;
  constructor(
    public navCtrl: NavController, 
    public navParams: NavParams, 
    public alertCtrl: AlertController,
    public userService: UserServiceProvider
  ) 
  {
    let id= this.navParams.get('navParametros');
    this._id = id;
    this.cargarClaseAcomentar();
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad ComentarClasePage');
  }

  enviarComentario(){
    let alert = this.alertCtrl.create({
      title: 'Comentario',
      subTitle: 'Comentario Enviado!',
      buttons: ['OK']
    });
    alert.present();

    /* HAY QUE ROOTEARLO A LA PAGINA ANTERIOR */
  }

  public cargarClaseAcomentar():void{
    let url = "FOM05_Clase_Fecha/getClaseP?id="+this._id;
    this.userService.getDato(url).subscribe(data => {    
        let i: number = 0;
        while ( i < data.length ){
        this.comentario[i] = data[i];
        i++;}
      console.log(this.comentario[0]);
      
    },
    (error) =>{
      console.error(error);
    }
  )
  }

  /**
   * Metodo para hacer el comentario de la clase
   */
  public comentarClase():void{
    //ARREGKAR LA CONSULTA
    let url = "FOM05_Critica/insertarCritica?referencia="+this._id+"&comentario=&valoracion=";
    this.userService.getDato(url).subscribe(data => {    
        let i: number = 0;
        while ( i < data.length ){
        this.comentario[i] = data[i];
        i++;}
      console.log(this.comentario[0]);
      
    },
    (error) =>{
      //console.error(error);
    }
  )
  }

}
