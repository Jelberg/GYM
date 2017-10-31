import { Component } from '@angular/core';

/**
 * Generated class for the BarraComponent component.
 *
 * See https://angular.io/api/core/Component for more info on Angular
 * Components.
 */
@Component({
  selector: 'barra',
  templateUrl: 'barra.html'
})
export class BarraComponent {

  text: string;

  constructor() {
    console.log('Hello BarraComponent Component');
    this.text = 'Hello World';
  }

}
