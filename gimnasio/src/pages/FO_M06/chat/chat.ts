import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { DetalleReservaPage } from '../detalle-reserva/detalle-reserva';
import { ReservasRealizadasPage } from '../reservas-realizadas/reservas-realizadas';
import { GestiNDeReservasPage } from '../gesti-nde-reservas/gesti-nde-reservas';
import { HorariosEntrenadorPage } from '../horarios-entrenador/horarios-entrenador';


@Component({
  selector: 'page-chat',
  templateUrl: 'chat.html'
})
export class ChatPage {

  constructor(public navCtrl: NavController) {
  }
  goToDetalleReserva(params){
    if (!params) params = {};
    this.navCtrl.push(DetalleReservaPage);
  }goToReservasRealizadas(params){
    if (!params) params = {};
    this.navCtrl.push(ReservasRealizadasPage);
  }goToGestiNDeReservas(params){
    if (!params) params = {};
    this.navCtrl.push(GestiNDeReservasPage);
  }goToHorariosEntrenador(params){
    if (!params) params = {};
    this.navCtrl.push(HorariosEntrenadorPage);
  }goToChat(params){
    if (!params) params = {};
    this.navCtrl.push(ChatPage);
  }
}
