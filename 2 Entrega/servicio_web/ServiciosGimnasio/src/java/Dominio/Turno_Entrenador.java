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
public class Turno_Entrenador {
    private int _id;
    private Date _fecha;
    private String _tanda;
    private Time _horaInicio;
    private Time _horaFin;
    private String _turno;
    private String _entrenador;

    public Turno_Entrenador(int _id, Date _fecha, String _tanda, Time _horaInicio, Time _horaFin, String _turno, String _entrenador) {
        this._id = _id;
        this._fecha = _fecha;
        this._tanda = _tanda;
        this._horaInicio = _horaInicio;
        this._horaFin = _horaFin;
        this._turno = _turno;
        this._entrenador = _entrenador;
    }

    public Turno_Entrenador() {
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public Date getFecha() {
        return _fecha;
    }

    public void setFecha(Date _fecha) {
        this._fecha = _fecha;
    }

    public String getTanda() {
        return _tanda;
    }

    public void setTanda(String _tanda) {
        this._tanda = _tanda;
    }

    public Time getHoraInicio() {
        return _horaInicio;
    }

    public void setHoraInicio(Time _horaInicio) {
        this._horaInicio = _horaInicio;
    }

    public Time getHoraFin() {
        return _horaFin;
    }

    public void setHoraFin(Time _horaFin) {
        this._horaFin = _horaFin;
    }

    public String getTurno() {
        return _turno;
    }

    public void setTurno(String _turno) {
        this._turno = _turno;
    }

    public String getEntrenador() {
        return _entrenador;
    }

    public void setEntrenador(String _entrenador) {
        this._entrenador = _entrenador;
    }

    
}
