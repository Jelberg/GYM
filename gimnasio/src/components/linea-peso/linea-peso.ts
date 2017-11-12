import { Component } from '@angular/core';
import { UserServiceProvider } from '../../providers/user-service/user-service';

@Component({
  selector: 'linea-peso',
  templateUrl: 'linea-peso.html'
})
export class LineaPesoComponent
{
  /*userService: UserServiceProvider;
  listaProgresos = [];
  public getProgreso(){
    let urlPeticion: string = "F0M04_Progreso_Peso/getProgresoP?id_usuario=1";
    this.userService.getDato( urlPeticion ).subscribe( data => this.listaProgresos = data );
  }*/

	public lineChartData:Array<any> = [
    {data: [ 40,50, 60, 62, 66, 70, 50, 60, 70, 80, 90, 100], label: 'Peso'}
  ];
  public lineChartLabels:Array<any> = ['Sem 1', 'Sem 2', 'Sem 3', 'Sem 4'];
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