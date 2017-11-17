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
    private String _status;
    private int _duracion;
    private String _nombreclase;
    private String _instructor;

    public Horario_Clase(int _id, Date _fecha, String _dia, int _capacidad, Time _horaInicio, Time _horaFin, String _status, int _duracion, String _nombreclase, String _instructor) {
        this._id = _id;
        this._fecha = _fecha;
        this._dia = _dia;
        this._capacidad = _capacidad;
        this._horaInicio = _horaInicio;
        this._horaFin = _horaFin;
        this._status = _status;
        this._duracion = _duracion;
        this._nombreclase = _nombreclase;
        this._instructor = _instructor;
    }

    public Horario_Clase(){
    }

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

    public String getStatus() {
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

    public void setStatus(String _status) {
        this._status = _status;
    }

    public void setDuracion(int _duracion) {
        this._duracion = _duracion;
    }

    public String getNombreclase() {
        return _nombreclase;
    }

    public void setNombreclase(String _nombreclase) {
        this._nombreclase = _nombreclase;
    }

    public String getInstructor() {
        return _instructor;
    }

    public void setInstructor(String _instructor) {
        this._instructor = _instructor;
    }
   
    
}
