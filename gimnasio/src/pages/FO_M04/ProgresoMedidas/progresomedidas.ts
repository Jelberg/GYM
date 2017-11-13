import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { UserServiceProvider } from '../../../providers/user-service/user-service';
import { ListaEjerciciosPage } from '../lista-ejercicios/lista-ejercicios';
import { ListaContactosPage } from '../lista-contactos/lista-contactos';


@IonicPage()
@Component ({

	selector: 'page-progresomedidas', 
	templateUrl: 'progresomedidas.html',
})

export class ProgresoMedidasPage {

  listaFecha = [];
  listaTipoEscapula = [];
  listaTipoTricep = [];
  listaTipoAbdomen = [];
  listaTipoCuadricep = [];

  constructor(public navCtrl: NavController, public navParams: NavParams,
  			  private userService: UserServiceProvider) {

  	this.getProgreso()

  	}

  	ionViewDidLoad() 
  {
    console.log('ionViewDidLoad ProgresoMedidasPage');
  }

  getProgreso(){
    let urlPeticion: string = "F0M04_Progreso_Medida/getProgresoM?id_usuario=1";
    this.userService.getDato( urlPeticion ).subscribe(data => {

      let posicionEscapula: number = 0;
 	  let posicionTricep: number = 0;
  	  let posicionAbdomen: number = 0;
      let posicionCuadrice: number = 0;
      let i: number = 0;

      while ( i < data.length ){

        this.listaFecha[i] = data[i]._fechaM;

        if (data[i]._tipo == "Escapula") {
        	this.listaTipoEscapula[posicionEscapula] = data[i]._medida;
        	posicionEscapula++;
        }

        if (data[i]._tipo == "Tricep") {
        	this.listaTipoTricep[posicionTricep] = data[i]._medida;
        	posicionTricep++;
        }

        if (data[i]._tipo == "Abdomen") {
        	this.listaTipoAbdomen[posicionAbdomen] = data[i]._medida;
        	posicionAbdomen++;
        }

        if (data[i]._tipo == "Cuadricep") {
        	this.listaTipoCuadricep[posicionCuadrice] = data[i]._medida;
        	posicionCuadrice++;
        }

        i++;
      }
      
      this.setLineT();;
    });
  }

  public lineChartData:Array<any> = [
  {data: [10,20,30,40,50], label: "Peso"},
  {data: [60,70,80,60,70], label: "DOS"},
  {data: [60,70,80,60,70], label: "TRES"},
  {data: [60,70,80,60,70], label: "CUATRO"}
  ];


  public lineChartLabels:Array<any> = ["Enero", "Febrero", "Marzo", "Abril", "Mayo"];
  
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
    },
    { // dark grey
      backgroundColor: 'rgba(77,83,96,0.2)',
      borderColor: 'rgba(77,83,96,1)',
      pointBackgroundColor: 'rgba(77,83,96,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(77,83,96,1)'
    }
  ];

  public lineChartLegend:boolean = true;

  public lineChartType:string = 'line';

  
  setLineT(){

    this.lineChartData = [];
    let arregloEscapula: any = [];
    let arregloTricep: any = [];
    let arregloAbdomen: any = [];
    let arregloCuadricep: any = []
    for ( let medida of this.listaTipoCuadricep ) {
      arregloCuadricep.push(medida);
    }
    for ( let fecha of this.listaTipoEscapula ){
      arregloEscapula.push( fecha );
    }
    for ( let medida of this.listaTipoTricep ) {
      arregloTricep.push(medida);
    }
    for ( let fecha of this.listaTipoAbdomen ){
      arregloAbdomen.push( fecha );
    }
    this.lineChartData.push(

      {label: 'Escapula', data: arregloEscapula },
      {label: 'Tricep', data: arregloTricep },      
      {label: 'Cuadricep', data: arregloCuadricep },            
      {label: 'Abdomen', data: arregloAbdomen },
    );
  }

  public chartClicked(e:any):void {
    console.log(e);
  }

  public chartHovered(e:any):void {
    console.log(e);
  }  
 
}