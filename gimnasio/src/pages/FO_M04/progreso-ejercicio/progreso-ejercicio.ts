import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { UserServiceProvider } from '../../../providers/user-service/user-service'

import { ListaEjerciciosPage } from '../lista-ejercicios/lista-ejercicios';
import { ListaContactosPage } from '../lista-contactos/lista-contactos';

/**
 * Generated class for the ProgresoEjercicioPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-progreso-ejercicio',
  templateUrl: 'progreso-ejercicio.html',
})
export class ProgresoEjercicioPage {

  listaRecibida
  peso = [];
  repeticion = [];
  mes = [];

  constructor(public navCtrl: NavController, 
              public navParams: NavParams,
              private userService : UserServiceProvider) {
      this.listaRecibida = navParams.data;
      this.getDatosEjercicio();
  }

ionViewDidLoad() {
  console.log('ionViewDidLoad ProgresoMedidasPage');
  }

foo(){
  this.lineChartData.push(
    {label: 'Repeticiones', data: this.repeticion},
    {label: 'Peso', data: this.peso},
  );
}

getDatosEjercicio(){
  let urlPeticion: string = "FOM03_Rutina/getEjercicios6meses?idUsuario=1&ejercicio="+this.listaRecibida;
   this.userService.getDato( urlPeticion ).subscribe(data => {
      let i: number = 0;
      while ( i < data.length ){
        this.peso[i] = data[i].peso;
        this.repeticion[i] = data[i].repeticion;
        this.mes[i] = data[i].mes;
        i++;
      }
      this.setLineT();
    }); 
}

setLineT(){
  
      this.lineChartData = [];
      this.lineChartLabels = [];
      let arregloPeso: any = [];
      let arregloRepeticiones: any = [];
      let arregloMeses: any = [];
      for ( let datoPeso of this.peso ) {
        arregloPeso.push(datoPeso);
      }
      for ( let datoRep of this.repeticion ){
        arregloRepeticiones.push( datoRep );
      }
      for ( let datoMes of this.mes ){
        arregloMeses.push( datoMes );
        
        //this.lineChartLabels.push(datoMes);
        
      }
      this.lineChartLabels.push(arregloMeses);
      console.log('#### Chart Labels: ' + this.lineChartLabels);
      this.lineChartData.push(
        {label: 'Peso', data: arregloPeso },
        {label: 'Repeticiones', data: arregloRepeticiones },      
      );
      //this.lineChartLabels = arregloMeses;
    }

goToListaContactosPage(){
  this.navCtrl.push(ListaContactosPage);
}

goToSeleccionarEjercicioPage(){
  this.navCtrl.push(ListaEjerciciosPage);
}

public lineChartData:Array<any> = [
  {data: [10, 20, 30, 40, 50, 60, 70], label: 'Repeticiones'},
  {data: [15, 25, 35, 45, 55, 65, 75], label: 'Peso'},
  
];
//public lineChartLabels:Array<any> = ['1', '2', '3', '4', '5', '6', '7'];
public lineChartLabels:Array<any> = [
  {data: [1, 2, 3, 4, 5, 6]}
];
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
  },
  { // grey
    backgroundColor: 'rgba(148,159,177,0.2)',
    borderColor: 'rgba(148,159,177,1)',
    pointBackgroundColor: 'rgba(148,159,177,1)',
    pointBorderColor: '#fff',
    pointHoverBackgroundColor: '#fff',
    pointHoverBorderColor: 'rgba(148,159,177,0.8)'
  }
];

public lineChartLegend:boolean = true;
public lineChartType:string = 'line';

public randomize():void {
  let _lineChartData:Array<any> = new Array(this.lineChartData.length);
  for (let i = 0; i < this.lineChartData.length; i++) {
    _lineChartData[i] = {data: new Array(this.lineChartData[i].data.length), label: this.lineChartData[i].label};
    for (let j = 0; j < this.lineChartData[i].data.length; j++) {
      _lineChartData[i].data[j] = Math.floor((Math.random() * 100) + 1);
    }
  }
  this.lineChartData = _lineChartData;
}

// events
public chartClicked(e:any):void {
  console.log(e);
}

public chartHovered(e:any):void {
  console.log(e);
}

}
