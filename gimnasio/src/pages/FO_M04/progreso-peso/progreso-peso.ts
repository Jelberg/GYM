import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { UserServiceProvider } from '../../../providers/user-service/user-service';

@IonicPage()
@Component({
  selector: 'page-progreso-peso',
  templateUrl: 'progreso-peso.html'
})
export class ProgresoPesoPage {
  //Arreglos para el manejo de la informacion traida de los servicios
  dataProbar: number = 0;
  listaPeso = [];
  listaFecha = [];
  uno: number = 0;
  dos: number = 0;
  tres: number = 0;
  constructor(public navCtrl: NavController, public navParams: NavParams, 
              private userService: UserServiceProvider)
  {
  	this.getProgreso();
  }
  ionViewDidLoad() 
  {
    console.log('ionViewDidLoad ProgresoPesoPage');
  }

  /*Metodo en la que se realiza la llamada al servicio 
  y trae lo correspondiste al peso del usuario
  */
  getProgreso(){
    let urlPeticion: string = "F0M04_Progreso_Peso/getProgresoP?id_usuario="+localStorage.getItem("id");
    this.userService.getDato( urlPeticion ).subscribe(data => {
      let i: number = 0;
      while ( i < data.length ){
        this.listaPeso[i] = data[i]._peso;
        this.listaFecha[i] = data[i]._fechaP;
        i++;
      }
      this.setLine();
    });
  }

  //Gracia por defecto
  public lineChartData:Array<any> = [{
    data: [10,20,30,40,50], label: "Peso"
  }];

  public lineChartLabels:Array<any> = ["Sem 1", "Sem 2", "Sem 3", "Sem 4", "Sem 5"];
  public lineChartOptions:any = {
    responsive: true
  };
  public lineChartColors:Array<any> = [
    { // grey
      backgroundColor: 'rgba(148,159,177,0.2)',
      borderColor: 'rgba(148,159,177,1)',
      pointBackgroundColor: 'rgba(148,159,177,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(148,159,177,0.8)'
    }
    
  ];
  public lineChartLegend:boolean = false;
  public lineChartType:string = 'line';

  //Metodo que genera la grafica
  setLine(){
    this.lineChartData = [];
    //this.lineChartLabels = [];
    let arreglo: any = [];
    let arregloFecha: any = []
    for ( let peso of this.listaPeso ) {
      arreglo.push(peso);
    }
    for ( let fecha of this.listaFecha ){
      arregloFecha.push( fecha );
    }
    this.lineChartData.push({
      label: 'Peso',
      data: arreglo
    });
  }
  public chartClicked(e:any):void {
    console.log(e);
  }
  public chartHovered(e:any):void {
    console.log(e);
  }  
}
