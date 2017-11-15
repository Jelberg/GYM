import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { ReservasRealizadasPage } from '../reservas-realizadas/reservas-realizadas';
import { GestiNDeReservasPage } from '../gesti-nde-reservas/gesti-nde-reservas';
import { HorariosEntrenadorPage } from '../horarios-entrenador/horarios-entrenador';
import { ChatPage } from '../chat/chat';

@Component({
  selector: 'page-detalle-reserva',
  templateUrl: 'detalle-reserva.html'
})
export class DetalleReservaPage {

  constructor(public navCtrl: NavController) {
  }
  goToReservasRealizadas(params){
    if (!params) params = {};
    this.navCtrl.push(ReservasRealizadasPage);
  }goToGestiNDeReservas(params){
    if (!params) params = {};
    this.navCtrl.push(GestiNDeReservasPage);
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
