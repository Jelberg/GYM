import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
//import { HttpClient } from '@angular/common/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';

/*
  Generated class for the UserServiceProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class UserServiceProvider {
  private URL: string = "http://localhost:8080/ServiciosGimnasio/"
  constructor(/*public http: Http,*/ private http: Http ) {
    console.log('Hello UserServiceProvider Provider');
  }

  //Funcion para probar Web Service
  getDato( urlComplementaria: string ){
    return this.http.get( this.URL+urlComplementaria )
    .map( this.datosMapa )
    .do( this.p )
  }
  public getURL(): string {
    return this.URL;
  }
  public setURL( URL: string ){
    this.URL = URL;
  }
  public datosMapa(res: Response){
    return res.json();
  }
  public p ( res: Response ){
    return console.log(res);
  }

}
