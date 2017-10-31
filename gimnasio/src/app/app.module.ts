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
import { ProgresoPesoPage } from '../pages/FO_M04/progreso-peso/progreso-peso'
import { CambiarPesoPage } from '../pages/FO_M04/cambiar-peso/cambiar-peso'
import { TabsPesoPage } from '../pages/FO_M04/tabs-peso/tabs-peso'
import { ProgresoComentarioPage } from '../pages/FO_M04/progreso-comentario/progreso-comentario';
import { TabsEjercicioPage } from '../pages/FO_M04/tabs-ejercicio/tabs-ejercicio';
//import { TabsMedidasPage } from '../pages/FO_M04/tabs-medidas/tabs-medidas';
//import { CambiarMedidasPage } from '../pages/FO_M04/cambiar-medidas/cambiar-medidas';
import { CambiaMedidaPage } from '../pages/FO_M04/cambia-medida/cambia-medida';
import { TabMedidaPage } from '../pages/FO_M04/tab-medida/tab-medida';

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
    ProgresoEjercicioPage,
    ListaEjerciciosPage,
    ListaContactosPage,
    ProgresoPesoPage,
    CambiarPesoPage,
    ProgresoComentarioPage,
    TabsPesoPage,
    TabsEjercicioPage,
    CambiarMedidasPage,
    TabsMedidasPage,
    //TabsMedidasPage,
    //CambiarMedidasPage,
    CambiaMedidaPage,
    TabMedidaPage

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
    ListaEjerciciosPage,
    ListaContactosPage,
    ProgresoPesoPage,
    CambiarPesoPage,
    ProgresoComentarioPage,
    TabsPesoPage,
    TabsEjercicioPage,
<<<<<<< HEAD
    CambiarMedidasPage,
    TabsMedidasPage,
    
=======
    //TabsMedidasPage,
    //CambiarMedidasPage,
    CambiaMedidaPage,
    TabMedidaPage
>>>>>>> a362253d52172f123fce0fe1a51cf69eb4f0fe33
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
