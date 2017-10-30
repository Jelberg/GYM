import { NgModule, ErrorHandler } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

import {InicioPage} from '../pages/inicio/inicio';
import {ClasesPage} from '../pages/clases/clases';
import {ReservasPage} from '../pages/reservas/reservas';
import {ClasesParticipadasPage} from '../pages/clases-participadas/clases-participadas';
import {ComentarClasePage} from '../pages/comentar-clase/comentar-clase';
import { ClaseParticularPage} from '../pages/clase-particular/clase-particular';

@NgModule({
  declarations: [
    MyApp,
    InicioPage,
    ClasesPage,
    ReservasPage,
    ClasesParticipadasPage,
    ComentarClasePage,
    ClaseParticularPage
  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp)
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    InicioPage,
    ClasesPage,
    ReservasPage,
    ClasesParticipadasPage,
    ComentarClasePage,
    ClaseParticularPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
