import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { ReservasRealizadasPage } from '../reservas-realizadas/reservas-realizadas';
import { DetalleReservaPage } from '../detalle-reserva/detalle-reserva';
import { ChatPage } from '../chat/chat';
import { HorariosEntrenadorPage } from '../horarios-entrenador/horarios-entrenador';

@Component({
  selector: 'page-gesti-nde-reservas',
  templateUrl: 'gesti-nde-reservas.html'
})
export class GestiNDeReservasPage {

  constructor(public navCtrl: NavController) {
  }
  goToReservasRealizadas(params){
    if (!params) params = {};
    this.navCtrl.push(ReservasRealizadasPage);
  }goToGestiNDeReservas(params){
    if (!params) params = {};
    this.navCtrl.push(GestiNDeReservasPage);
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
