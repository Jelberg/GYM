import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { GestiNDeReservasPage } from '../gesti-nde-reservas/gesti-nde-reservas';
import { HorariosEntrenadorPage } from '../horarios-entrenador/horarios-entrenador';
import { DetalleReservaPage } from '../detalle-reserva/detalle-reserva';
import { ChatPage } from '../chat/chat';

@Component({
  selector: 'page-reservas-realizadas',
  templateUrl: 'reservas-realizadas.html'
})
export class ReservasRealizadasPage {

  constructor(public navCtrl: NavController) {
  }
  goToGestiNDeReservas(params){
    if (!params) params = {};
    this.navCtrl.push(GestiNDeReservasPage);
  }goToReservasRealizadas(params){
    if (!params) params = {};
    this.navCtrl.push(ReservasRealizadasPage);
  }goToHorariosEntrenador(params){
    if (!params) params = {};
    this.navCtrl.push(HorariosEntrenadorPage);
  }goToDetalleReserva(params){
    if (!params) params = {};
    this.navCtrl.push(DetalleReservaPage);
  }goToChat(params){
    if (!params) params = {};
    this.navCtrl.push(ChatPage);
  }
}
