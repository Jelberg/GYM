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
import { LineaMedidasComponent } from '../components/lineaMedidas/lineaMedidas';
import { LineaPesoComponent } from '../components/linea-peso/linea-peso'



import { ProgresoEjercicioPage } from '../pages/FO_M04/progreso-ejercicio/progreso-ejercicio';
import { ListaEjerciciosPage } from '../pages/FO_M04/lista-ejercicios/lista-ejercicios';
import { ListaContactosPage } from '../pages/FO_M04/lista-contactos/lista-contactos';
import { ProgresoMedidasPage } from '../pages/FO_M04/ProgresoMedidas/progresomedidas'
import { AgregarMedidasPage } from '../pages/FO_M04/ProgresoMedidas/agregarmedidas' ;
import { ProgresoPesoPage } from '../pages/FO_M04/progreso-peso/progreso-peso'


@NgModule({
  declarations: [
    MyApp,
    HomePage,
    SeleccionarProgresoPage,
    LineaComponent,
    BarraComponent,
    LineaMedidasComponent,
    LineaPesoComponent,
    ProgresoEjercicioPage,
    ProgresoMedidasPage,
    AgregarMedidasPage,
    ProgresoEjercicioPage,
    ListaEjerciciosPage,
    ListaContactosPage,
    ProgresoPesoPage

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
    ProgresoMedidasPage,
    AgregarMedidasPage,
    ListaEjerciciosPage,
    ListaContactosPage,
    ProgresoPesoPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
