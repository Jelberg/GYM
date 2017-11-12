import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { GestiNDeReservasPage } from '../gesti-nde-reservas/gesti-nde-reservas';
import { ReservasRealizadasPage } from '../reservas-realizadas/reservas-realizadas';
import { DetalleReservaPage } from '../detalle-reserva/detalle-reserva';
import { ChatPage } from '../chat/chat';


@Component({
  selector: 'page-horarios-entrenador',
  templateUrl: 'horarios-entrenador.html'
})
export class HorariosEntrenadorPage {

  constructor(public navCtrl: NavController) {
  }
  goToGestiNDeReservas(params){
    if (!params) params = {};
    this.navCtrl.push(GestiNDeReservasPage);
  }goToReservasRealizadas(params){
    if (!params) params = {};
    this.navCtrl.push(ReservasRealizadasPage);
  }goToDetalleReserva(params){
    if (!params) params = {};
    this.navCtrl.push(DetalleReservaPage);
  }goToChat(params){
    if (!params) params = {};
    this.navCtrl.push(ChatPage);
  }goToHorariosEntrenador(params){
    if (!params) params = {};
    this.navCtrl.push(HorariosEntrenadorPage);
  }
}
