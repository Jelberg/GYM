import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { Contacts, Contact, ContactField, ContactName } from '@ionic-native/contacts';

//Gráficos
import { ChartsModule } from 'ng2-charts';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
//M01
import { AmigosPage } from '../pages/FO_M01/amigos/amigos';
import { CrearusuarioPage } from '../pages/FO_M01/crearusuario/crearusuario';
import { IniciarsesionPage } from '../pages/FO_M01/iniciarsesion/iniciarsesion';
import { PerfilPage} from '../pages/FO_M01/perfil/perfil'
import { RecuperarPassPage } from '../pages/FO_M01/recuperar-pass/recuperar-pass';
// fin M01
//M03 
import { RutinaPage } from '../pages/FO_M03/rutina/rutina';
import { TabsLogPage } from '../pages/FO_M03/tabs-log/tabs-log';
import { TabsRutinaPage } from '../pages/FO_M03/tabs-rutina/tabs-rutina';
import { ModificarRutinaPage } from '../pages/FO_M03/modificar-rutina/modificar-rutina';
import { CompartirRutinaPage } from '../pages/FO_M03/compartir-rutina/compartir-rutina';
import { PlanPage } from '../pages/FO_M03/plan/plan';
import { WorkoutPlansPage } from '../pages/FO_M03/workout-plans/workout-plans';
import { PlanRutinasPage } from '../pages/FO_M03/plan-rutinas/plan-rutinas';
import { EjerciciosPage } from '../pages/FO_M03/ejercicios/ejercicios';
import { EjercicioRutinaPage } from '../pages/FO_M03/ejercicio-rutina/ejercicio-rutina';
//FIN M03

//M04
import { SeleccionarProgresoPage } from '../pages/FO_M04/seleccionar-progreso/seleccionar-progreso';
import { LineaComponent } from '../components/linea/linea';
import { BarraComponent } from '../components/barra/barra';
import { LineaMedidasComponent } from '../components/lineaMedidas/lineaMedidas';
import { LineaPesoComponent } from '../components/linea-peso/linea-peso'
import { ProgresoEjercicioPage } from '../pages/FO_M04/progreso-ejercicio/progreso-ejercicio';
import { ListaEjerciciosPage } from '../pages/FO_M04/lista-ejercicios/lista-ejercicios';
import { ListaContactosPage } from '../pages/FO_M04/lista-contactos/lista-contactos';
import { ProgresoMedidasPage } from '../pages/FO_M04/ProgresoMedidas/progresomedidas'
import { ProgresoPesoPage } from '../pages/FO_M04/progreso-peso/progreso-peso'
import { CambiarPesoPage } from '../pages/FO_M04/cambiar-peso/cambiar-peso'
import { TabsPesoPage } from '../pages/FO_M04/tabs-peso/tabs-peso'
import { ProgresoComentarioPage } from '../pages/FO_M04/progreso-comentario/progreso-comentario';
import { TabsEjercicioPage } from '../pages/FO_M04/tabs-ejercicio/tabs-ejercicio';
//import { TabsMedidasPage } from '../pages/FO_M04/tabs-medidas/tabs-medidas';
//import { CambiarMedidasPage } from '../pages/FO_M04/cambiar-medidas/cambiar-medidas';
import { CambiaMedidaPage } from '../pages/FO_M04/cambia-medida/cambia-medida';
import { TabMedidaPage } from '../pages/FO_M04/tab-medida/tab-medida';
import { ComentarioPage } from '../pages/FO_M04/comentario/comentario'
//FIN M04
//M05
import { ClasesPage } from '../pages/FO_M05/clases/clases';
import { ReservasPage } from '../pages/FO_M05/reservas/reservas';
import { ClaseParticularPage} from '../pages/FO_M05/clase-particular/clase-particular';
import { ClasesParticipadasPage} from '../pages/FO_M05/clases-participadas/clases-participadas';
import { ComentarClasePage} from '../pages/FO_M05/comentar-clase/comentar-clase';
import { TabCalendarClassPage} from '../pages/FO_M05/tab-calendar-class/tab-calendar-class';
import { UserServiceProvider } from '../providers/user-service/user-service';
import { ListaClasesPage } from '../pages/FO_M05/lista-clases/lista-clases';
import { ListaCriticasPage } from '../pages/FO_M05/lista-criticas/lista-criticas';
//FIN M05
// M06
//import  { AsignarRutinaPage} from '../pages/FO_M06/asignar-rutina/asignar-rutina';
import  { ChatPage} from '../pages/FO_M06/chat/chat';
//import  { ChatEntrenadorPage} from '../pages/FO_M06/chat-entrenador/chat-entrenador';
import { DetalleReservaPage} from '../pages/FO_M06/detalle-reserva/detalle-reserva';
import { GestiNDeReservasPage} from '../pages/FO_M06/gesti-nde-reservas/gesti-nde-reservas';
import { HorariosEntrenadorPage} from '../pages/FO_M06/horarios-entrenador/horarios-entrenador';
import  { ReservasRealizadasPage} from '../pages/FO_M06/reservas-realizadas/reservas-realizadas';


//FIN M06


@NgModule({
  declarations: [
    MyApp,
    HomePage,
    AmigosPage,
    RecuperarPassPage,
    CrearusuarioPage,
    IniciarsesionPage,
    PerfilPage,
    SeleccionarProgresoPage,
    LineaComponent,
    BarraComponent,
    LineaMedidasComponent,
    LineaPesoComponent,
    ProgresoEjercicioPage,
    ProgresoMedidasPage,
    ProgresoEjercicioPage,
    ListaEjerciciosPage,
    ListaContactosPage,
    ProgresoPesoPage,
    CambiarPesoPage,
    ProgresoComentarioPage,
    ComentarioPage,
    TabsPesoPage,
    TabsEjercicioPage,
    //TabsMedidasPage,
    //CambiarMedidasPage,
    CambiaMedidaPage,
    TabMedidaPage,
    ProgresoEjercicioPage,
    RutinaPage,
    ModificarRutinaPage,
    TabsLogPage,
    CompartirRutinaPage,
    PlanPage,
    WorkoutPlansPage,
    PlanRutinasPage,
    EjerciciosPage,
    EjercicioRutinaPage,
    ClasesPage,
    ReservasPage,
    ClaseParticularPage,
    ClasesParticipadasPage,
    ComentarClasePage,
    TabCalendarClassPage,
    ReservasRealizadasPage,
    HorariosEntrenadorPage,
    GestiNDeReservasPage,
    DetalleReservaPage,
    ListaCriticasPage,
    


    ListaClasesPage
  ],
  imports: [
    BrowserModule,
    HttpModule,
    IonicModule.forRoot(MyApp,{
      tabsPlacement:'bottom',
      platforms:{
        android:{
          tabsPlacement:'top'
        },
        ios:{
          tabsPlacement:'top'
        },
        windows:{
          tabsPlacement:'top'
        }
      }
  }),
    ChartsModule
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    AmigosPage,
    CrearusuarioPage,
    RecuperarPassPage,
    IniciarsesionPage,
    PerfilPage,
    SeleccionarProgresoPage,
    ProgresoEjercicioPage,
    ProgresoMedidasPage,
    ListaEjerciciosPage,
    ListaContactosPage,
    ProgresoPesoPage,
    CambiarPesoPage,
    ProgresoComentarioPage,
    ComentarioPage,
    TabsPesoPage,
    TabsEjercicioPage,
    //TabsMedidasPage,
    //CambiarMedidasPage,
    CambiaMedidaPage,
    TabMedidaPage,
    RutinaPage,
    ModificarRutinaPage,
    TabsLogPage,
    CompartirRutinaPage,
    PlanPage,
    WorkoutPlansPage,
    PlanRutinasPage,
    EjerciciosPage,
    EjercicioRutinaPage,
    ClasesPage,
    ClaseParticularPage,
    ClasesParticipadasPage,
    ComentarClasePage,
    ReservasPage,
    TabCalendarClassPage,
    ReservasRealizadasPage,
    HorariosEntrenadorPage,
    GestiNDeReservasPage,
    DetalleReservaPage,
    
    ListaCriticasPage,
    ListaClasesPage
  ],
  providers: [
    Contacts, Contact,
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    UserServiceProvider
  ]
})
export class AppModule {}
