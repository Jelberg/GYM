import { Component, ViewChild } from '@angular/core';
import { Platform, Nav } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

import { HomePage } from '../pages/home/home';
import { ProgresoEjercicioPage } from '../pages/FO_M04/progreso-ejercicio/progreso-ejercicio';
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
      { titulo: "Progreso", component: ProgresoEjercicioPage, icon: "stats"},
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

