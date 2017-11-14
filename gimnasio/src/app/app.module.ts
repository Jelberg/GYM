import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { HttpModule } from '@angular/http';

//Gráficos
import { ChartsModule } from 'ng2-charts';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
//M01
import { AmigosPage } from '../pages/FO_M01/amigos/amigos';
import { CrearusuarioPage } from '../pages/FO_M01/crearusuario/crearusuario';
import { IniciarsesionPage } from '../pages/FO_M01/iniciarsesion/iniciarsesion';
import { PerfilPage} from '../pages/FO_M01/perfil/perfil'
// fin M01
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
//FIN M04
//M05
import { ClasesPage } from '../pages/FO_M05/clases/clases';
import { ReservasPage } from '../pages/FO_M05/reservas/reservas';
import { ClaseParticularPage} from '../pages/FO_M05/clase-particular/clase-particular';
import { ClasesParticipadasPage} from '../pages/FO_M05/clases-participadas/clases-participadas';
import { ComentarClasePage} from '../pages/FO_M05/comentar-clase/comentar-clase';
import { TabCalendarClassPage} from '../pages/FO_M05/tab-calendar-class/tab-calendar-class'
import { RealizarValoracionPage} from '../pages/FO_M05/realizar-valoracion/realizar-valoracion';
import { UserServiceProvider } from '../providers/user-service/user-service';
//FIN M05



@NgModule({
  declarations: [
    MyApp,
    HomePage,
    AmigosPage,
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
    TabsPesoPage,
    TabsEjercicioPage,
    //TabsMedidasPage,
    //CambiarMedidasPage,
    CambiaMedidaPage,
    TabMedidaPage,
    ProgresoEjercicioPage,
    ClasesPage,
    ReservasPage,
    ClaseParticularPage,
    ClasesParticipadasPage,
    ComentarClasePage,
    RealizarValoracionPage,
    TabCalendarClassPage
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
    TabsPesoPage,
    TabsEjercicioPage,
    //TabsMedidasPage,
    //CambiarMedidasPage,
    CambiaMedidaPage,
    TabMedidaPage,
    ClasesPage,
    ClaseParticularPage,
    ClasesParticipadasPage,
    ComentarClasePage,
    ReservasPage,
    RealizarValoracionPage,
    TabCalendarClassPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    UserServiceProvider
  ]
})
export class AppModule {}
