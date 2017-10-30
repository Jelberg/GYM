import { Component, ViewChild} from '@angular/core';
import { Platform, Nav, MenuController} from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

import { InicioPage } from '../pages/inicio/inicio';
import { ClasesPage } from '../pages/clases/clases';
import { ReservasPage} from '../pages/reservas/reservas';
import { ClasesParticipadasPage } from '../pages/clases-participadas/clases-participadas';
import { ComentarClasePage } from '../pages/comentar-clase/comentar-clase';

@Component({
  templateUrl: 'app.html'
})
export class MyApp {

  @ViewChild('NAV') nav:Nav;
  public rootPage:any;
  public pages: Array<{titulo: string, component: any, icon:string}>;

  constructor(platform: Platform, statusBar: StatusBar, splashScreen: SplashScreen, menu:MenuController) {
    menu.enable(true);
    this.rootPage = InicioPage;
    this.pages = [
      {titulo: 'Inicio',component:InicioPage, icon: 'home'},
      {titulo: 'Clases',component:ClasesPage, icon: 'bicycle'},
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


