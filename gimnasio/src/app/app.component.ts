import { Component, ViewChild } from '@angular/core';
import { Platform, Nav } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

import { HomePage } from '../pages/home/home';
import { SeleccionarProgresoPage } from '../pages/FO_M04/seleccionar-progreso/seleccionar-progreso';
import { RutinaPage } from '../pages/FO_M03/rutina/rutina';
import { WorkoutPlansPage } from '../pages/FO_M03/workout-plans/workout-plans';
//import { ClasesPage } from '../pages/FO_M05/clases/clases';
import { ReservasPage } from '../pages/FO_M05/reservas/reservas';
import { AmigosPage } from '../pages/FO_M01/amigos/amigos';
import { CrearusuarioPage } from '../pages/FO_M01/crearusuario/crearusuario';
import { IniciarsesionPage } from '../pages/FO_M01/iniciarsesion/iniciarsesion';
import { PerfilPage} from '../pages/FO_M01/perfil/perfil'
import { ClasesParticipadasPage} from '../pages/FO_M05/clases-participadas/clases-participadas';
import { ListaClasesPage} from '../pages/FO_M05/lista-clases/lista-clases';
import { TabCalendarClassPage} from '../pages/FO_M05/tab-calendar-class/tab-calendar-class';
import  { ReservasRealizadasPage} from '../pages/FO_M06/reservas-realizadas/reservas-realizadas';
import { HorariosEntrenadorPage} from '../pages/FO_M06/horarios-entrenador/horarios-entrenador';
import { GestiNDeReservasPage} from '../pages/FO_M06/gesti-nde-reservas/gesti-nde-reservas';
import { DetalleReservaPage} from '../pages/FO_M06/detalle-reserva/detalle-reserva';
import { ChatPage} from '../pages/FO_M06/chat/chat';

@Component({
  templateUrl: 'app.html'
})
export class MyApp {
  @ViewChild('NAV') nav: Nav;
  rootPage:any = IniciarsesionPage;
  public pages: Array< { titulo: string, component: any, icon:string } >;

  constructor(platform: Platform, statusBar: StatusBar, splashScreen: SplashScreen) {

    this.rootPage = IniciarsesionPage;
    /* En el bloque de abajo, pueden agregar la pagina inicial de su modulo
      a la que se accedera desde el menu lateral */
    this.pages = [
      {titulo: "Inicio", component: HomePage, icon: "home"},
      {titulo: "perfil", component: PerfilPage, icon: "person"},
      {titulo: "amigos", component: AmigosPage, icon: "people"},
      {titulo: "Progreso", component: SeleccionarProgresoPage, icon: "stats"},
      { titulo: "Rutinas", component: RutinaPage, icon: "body"},
      {titulo: 'Clases',component: ListaClasesPage, icon: 'bicycle'},
      {titulo: 'Reservas',component:ReservasPage, icon: 'calendar'} ,
      {titulo: 'Clases Participadas',component:ClasesParticipadasPage, icon: 'done-all'},
      {titulo: 'Reservar entrenador',component:ReservasRealizadasPage, icon: 'calendar'},
      {titulo: 'Chat',component:ChatPage, icon: 'mail'},
      {titulo: 'Asignar Rutina(entrenador)',component:ChatPage, icon: 'stast'},
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

