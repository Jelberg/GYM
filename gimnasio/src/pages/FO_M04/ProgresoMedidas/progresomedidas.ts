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

  listaMedida = [];
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

        if (data[i]._tipo = 1) {
        	this.listaTipoEscapula[posicionEscapula] = data[i]._medida;
        	posicionEscapula++;
        }

        if (data[i]._tipo = 2) {
        	this.listaTipoTricep[posicionTricep] = data[i]._medida;
        	posicionTricep++;
        }

        if (data[i]._tipo = 3) {
        	this.listaTipoAbdomen[posicionAbdomen] = data[i]._medida;
        	posicionAbdomen++;
        }

        if (data[i]._tipo = 4) {
        	this.listaTipoCuadricep[posicionCuadrice] = data[i]._medida;
        	posicionCuadrice++;
        }

        i++;
      }
       this.setLine();
    });
  }

  public lineChartData:Array<any> = [{
    data: [6,8,10,12,14,16,18], label: "Medidas"
  }];

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
    }    
  ];

  public lineChartLegend:boolean = false;
  public lineChartType:string = 'line';

  setLine(){
    this.lineChartData = [];
    //this.lineChartLabels = [];
    let arreglomedida: any = [];
    let arreglotipoEscapula: any = [];

    for ( let medida of this.listaMedida ) {
      arreglomedida.push(medida);
    }
    
    this.lineChartData.push({
      label: 'Medida',
      data: arreglomedida
    });
    
  }
  public chartClicked(e:any):void {
    console.log(e);
  }
  public chartHovered(e:any):void {
    console.log(e);
  }  
 
}