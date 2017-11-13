/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author YESIMAR
 */
public class Horario_Clase {
    private int _id;
    private Date _fecha;
    private String _dia;
    private int _capacidad;
    private Time _horaInicio;
    private Time _horaFin;
    private int _status;
    private int _duracion;

    public int getId() {
        return _id;
    }

    public Date getFecha() {
        return _fecha;
    }

    public String getDia() {
        return _dia;
    }

    public int getCapacidad() {
        return _capacidad;
    }

    public Time getHoraInicio() {
        return _horaInicio;
    }

    public Time getHoraFin() {
        return _horaFin;
    }

    public int getStatus() {
        return _status;
    }

    public int getDuracion() {
        return _duracion;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public void setFecha(Date _fecha) {
        this._fecha = _fecha;
    }

    public void setDia(String _dia) {
        this._dia = _dia;
    }

    public void setCapacidad(int _capacidad) {
        this._capacidad = _capacidad;
    }

    public void setHoraInicio(Time _horaInicio) {
        this._horaInicio = _horaInicio;
    }

    public void setHoraFin(Time _horaFin) {
        this._horaFin = _horaFin;
    }

    public void setStatus(int _status) {
        this._status = _status;
    }

    public void setDuracion(int _duracion) {
        this._duracion = _duracion;
    }
    
    
    
    
}
