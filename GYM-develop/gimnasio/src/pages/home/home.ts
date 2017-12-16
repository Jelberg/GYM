import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { UserServiceProvider } from '../../../src/providers/user-service/user-service';
import { AlertController } from 'ionic-angular/components/alert/alert-controller';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {
  public users:any;
  public class : any []=[];

  constructor(public navCtrl: NavController, 
    public navParams: NavParams,
    public alertCtrl: AlertController,
    public userService: UserServiceProvider) {
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
            document.getElementById("usuario").innerHTML=this.class[0].usuario;
          }
        },
        (error) =>{
          console.error(error);
        }
    )
  }

}
