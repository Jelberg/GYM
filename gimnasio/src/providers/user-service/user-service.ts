import { Injectable } from '@angular/core';
//import { Http } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import 'rxjs/add/operator/map';

/*
  Generated class for the UserServiceProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class UserServiceProvider {

  constructor(/*public http2: Http,*/ private http: HttpClient) {
    console.log('Hello UserServiceProvider Provider');
  }

  //Funcion para probar Web Service
  getDato(){
    
    var url = 'http://localhost:8080/ServiciosGimnasio/FOM04_Progreso_Ejercicio/getDatoPrueba';
    var response = this.http.get<JSON>(url);
    debugger;
    return response;
  }

}
