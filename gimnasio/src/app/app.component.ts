import { Component, ViewChild } from '@angular/core';
import { Platform, Nav } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

import { HomePage } from '../pages/home/home';
import { SeleccionarProgresoPage } from '../pages/FO_M04/seleccionar-progreso/seleccionar-progreso';
//import { ClasesPage } from '../pages/FO_M05/clases/clases';
import { ReservasPage } from '../pages/FO_M05/reservas/reservas';
import { ClasesParticipadasPage} from '../pages/FO_M05/clases-participadas/clases-participadas';
import { TabCalendarClassPage} from '../pages/FO_M05/tab-calendar-class/tab-calendar-class'


@Component({
  templateUrl: 'app.html'
})
export class MyApp {
  @ViewChild('NAV') nav: Nav;
  rootPage:any = HomePage;
  public pages: Array< { titulo: string, component: any, icon:string } >;

  constructor(platform: Platform, statusBar: StatusBar, splashScreen: SplashScreen) {

    this.rootPage = HomePage;
    /* En el bloque de abajo, pueden agregar la pagina inicial de su modulo
      a la que se accedera desde el menu lateral */
    this.pages = [
      { titulo: "Inicio", component: HomePage, icon: "home"},
      { titulo: "Progreso", component: SeleccionarProgresoPage, icon: "stats"},
      {titulo: 'Clases',component:TabCalendarClassPage, icon: 'bicycle'},
      {titulo: 'Reservas',component:ReservasPage, icon: 'calendar'} ,
      {titulo: 'Clases Participadas',component:ClasesParticipadasPage, icon: 'done-all'},
    ];

    platform.ready().then(() => {
      // Okay, so the platform is ready and our plugins are available.
      // Here you can do any higher level native things you might need.
      statusBar.styleDefault();
      splashScreen.hide();
    });
  }

  goToPage(page){
    this.nav.setRoot(page);
  }
}

