import { Component } from '@angular/core';
import { UserServiceProvider } from '../../providers/user-service/user-service';

@Component({
  selector: 'linea-peso',
  templateUrl: 'linea-peso.html'
})
export class LineaPesoComponent
{
  
  userService: UserServiceProvider;
  listaPeso = [];
  listaFecha = [];
  getProgreso(){
    let urlPeticion: string = "F0M04_Progreso_Peso/getProgresoP?id_usuario=1";
    this.userService.getDato( urlPeticion ).subscribe(data => {
      let i: number = 0;
      while ( i < data.length ){
        this.listaPeso[i] = data[i]._peso;
        this.listaFecha[i] = data[i]._fechaP;
        i++;
      }
      console.log( this.listaFecha );
      console.log( this.listaPeso );
    });
    //luego de => se agrega a la lista, tipo asi: => this.listaProgresos
  }
  /*userService: UserServiceProvider;
  listaProgresos = [];
  public getProgreso(){
    let urlPeticion: string = "F0M04_Progreso_Peso/getProgresoP?id_usuario=1";
    this.userService.getDato( urlPeticion ).subscribe( data => this.listaProgresos = data );
  }*/

	public lineChartData:Array<any> = [
    {data: this.listaPeso, label: 'Peso'}
  ];
  public lineChartLabels:Array<any> = this.listaFecha;
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
  public llenado():void{

  }
	
}