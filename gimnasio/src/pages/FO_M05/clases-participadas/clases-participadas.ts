import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { ComentarClasePage } from '../comentar-clase/comentar-clase';
import { UserServiceProvider } from '../../../providers/user-service/user-service';

/**
 * Generated class for the ClasesParticipadasPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-clases-participadas',
  templateUrl: 'clases-participadas.html',
})
export class ClasesParticipadasPage {

  listaCriticas: any[]=[];
  id_user: number;
  
  


  //public items:Array<{id:number,titulo:string,instructor:string,fecha:string,hora:string,img:string}>;
  constructor(
    public navCtrl: NavController, 
    public navParams: NavParams,
    public userService: UserServiceProvider
  ) 
    {
      this. cargarClasesSinComentar();
 /*   this.items=[
    {id: 1, titulo:"Yoga", img:"../../../assets/imgs/clasesYoga.jpg", instructor:"Estela Rodriguez", fecha:"24/10/2017", hora: "3:00 pm"},
    {id: 2,titulo:"Spinning", img:"../../../assets/imgs/claseSpinning.jpg", instructor:"Maria Josefa", fecha:"26/10/2017", hora: "4:00 pm"},
    {id: 3,titulo:"Defensa Personal", img:"../../../assets/imgs/clasesDefensaPersonal.jpeg", instructor:"Pedro Alvarez", fecha:"28/10/2017", hora: "5:00 pm"}];
 */ 
  }

  ionViewDidLoad() {
   
  }

  /**
   * Metodo para llenar las clases que se han participado en los 
   * ultimos 30 dias de los cuales no se han hecho comentario y/o valoracion
   */
  public cargarClasesSinComentar():void{
    
    //PENDIENTE DE CAMBIAR EL 3 POR LA ID DEL USUARIO *******
    let url = "FOM05_Critica/sinCritica?id=1";
    this.userService.getDato(url).subscribe(data => {    
        let i: number = 0;
        while ( i < data.length ){
        this.listaCriticas[i] = data[i];
        i++;}
      console.log(this.listaCriticas[0]);
    },
    (error) =>{
      console.error(error);
    }
  )
  }

  goToComentar(){
    this.navCtrl.push(ComentarClasePage);
  }

  

}
