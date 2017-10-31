import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';

//Gráficos
import { ChartsModule } from 'ng2-charts';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { SeleccionarProgresoPage } from '../pages/FO_M04/seleccionar-progreso/seleccionar-progreso';
import { LineaComponent } from '../components/linea/linea';
import { BarraComponent } from '../components/barra/barra';

import { ProgresoEjercicioPage } from '../pages/FO_M04/progreso-ejercicio/progreso-ejercicio';

//M05
import { ClasesPage } from '../pages/FO_M05/clases/clases';
import { ReservasPage } from '../pages/FO_M05/reservas/reservas';
import { ClaseParticularPage} from '../pages/FO_M05/clase-particular/clase-particular';
import { ClasesParticipadasPage} from '../pages/FO_M05/clases-participadas/clases-participadas';
import { ComentarClasePage} from '../pages/FO_M05/comentar-clase/comentar-clase';
import { TabCalendarClassPage} from '../pages/FO_M05/tab-calendar-class/tab-calendar-class'
import { RealizarValoracionPage} from '../pages/FO_M05/realizar-valoracion/realizar-valoracion';
//FIN M05


@NgModule({
  declarations: [
    MyApp,
    HomePage,
    SeleccionarProgresoPage,
    LineaComponent,
    BarraComponent,
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
    IonicModule.forRoot(MyApp),
    ChartsModule
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    SeleccionarProgresoPage,
    ProgresoEjercicioPage,
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
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
