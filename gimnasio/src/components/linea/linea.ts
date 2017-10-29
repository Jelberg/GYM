import { Component } from '@angular/core';

/**
 * Generated class for the LineaComponent component.
 *
 * See https://angular.io/api/core/Component for more info on Angular
 * Components.
 */
@Component({
  selector: 'linea',
  templateUrl: 'linea.html'
})
export class LineaComponent {

  text: string;

  constructor() {
    console.log('Hello LineaComponent Component');
    this.text = 'Hello World';
  }

}
