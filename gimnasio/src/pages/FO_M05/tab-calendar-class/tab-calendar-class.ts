import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
//import { ReservasPage} from '../reservas/reservas';
import { ClasesPage} from '../clases/clases';

@Component({
  templateUrl: 'tab-calendar-class.html',
})

export class TabCalendarClassPage {
    tab1Root = ClasesPage;
    tab2Root = ClasesPage;
    tab3Root = ClasesPage;
  


  ionViewDidLoad() {
    console.log('ionViewDidLoad ReservasPage');
  }

}
