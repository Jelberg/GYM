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


@NgModule({
  declarations: [
    MyApp,
    HomePage,
    SeleccionarProgresoPage,
    LineaComponent,
    BarraComponent,
    ProgresoEjercicioPage
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
    ProgresoEjercicioPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
