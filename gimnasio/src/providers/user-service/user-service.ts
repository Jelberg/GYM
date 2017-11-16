import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
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

  //private URL: string = "http://localhost:8080/ServiciosGimnasio/"
  private URL: string = "http://localhost:8080/web/"
 //private URL: string = "http://190.79.86.82:8080/web/"

  constructor(/*public http: Http,*/ private http: Http ) {
    console.log('Hello UserServiceProvider Provider');
    
  }

  //Funcion para probar Web Service
  getDato( urlComplementaria: string ){
    return this.http.get( this.URL+urlComplementaria )
    .map( this.datosMapa )
    .do( this.p ) 
  }
  postDato ( urlComplementaria: string ) {
    return this.http.post ( this.URL+urlComplementaria, null, null )
    .map( this.datosMapa )
    .do( this.p ) 
  }
  deleteDato ( urlComplementaria: string ){
    return this.http.delete( this.URL+urlComplementaria, null )
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
  
  ///Conexion FOM03
public post2(apiUrl: string) {
  
    return this.http.post(this.URL+apiUrl, 
    {
      headers: { 'Content-Type': 'application/json', 'Access-Control-Allow-Origin' : '*', 'Access-Control-Allow-Methods': 'POST, GET, OPTIONS, DELETE' }
    })
    .subscribe(data => {
      return console.log(data);
    });
}



    

  

  

//FUNCION DE PRUEBA, NO USAR 
  apiUrl = 'http://localhost:8080/ServiciosGimnasio/FOM05_Critica/sinCritica?id=4';
  //apiUrl ='https://jsonplaceholder.typicode.com/users';
  getUsers() {
    return new Promise(resolve => {
      this.http.get(this.apiUrl).subscribe(data => {
        resolve(data);
      }, err => {
        console.log(err);
      });
    });
  }

}
