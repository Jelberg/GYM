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
    private String _usuario;
    private String _clase;
    private String _instructor;

    public Horario_Clase(int _id, Date _fecha, String _dia, int _capacidad, Time _horaInicio, Time _horaFin, int _status, int _duracion, String _usuario, String _clase, String _instructor) {
        this._id = _id;
        this._fecha = _fecha;
        this._dia = _dia;
        this._capacidad = _capacidad;
        this._horaInicio = _horaInicio;
        this._horaFin = _horaFin;
        this._status = _status;
        this._duracion = _duracion;
        this._usuario = _usuario;
        this._clase = _clase;
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

    public String getUsuario() {
        return _usuario;
    }

    public String getClase() {
        return _clase;
    }

    public String getInstructor() {
        return _instructor;
    }

    public void setUsuario(String _usuario) {
        this._usuario = _usuario;
    }

    public void setClase(String _clase) {
        this._clase = _clase;
    }

    public void setInstructor(String _instructor) {
        this._instructor = _instructor;
    }
    
    
    
    
}
