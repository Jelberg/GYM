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
    private int id;
    private Date fecha;
    private String dia;
    private int capacidad;
    private Time horaInicio;
    private Time horaFin;
    private String status;
    private int duracion;
    private String nombreclase;
    private String instructor;

    public Horario_Clase(int _id, Date _fecha, String _dia, int _capacidad, Time _horaInicio, Time _horaFin, String _status, int _duracion, String _nombreclase, String _instructor) {
        this.id = _id;
        this.fecha = _fecha;
        this.dia = _dia;
        this.capacidad = _capacidad;
        this.horaInicio = _horaInicio;
        this.horaFin = _horaFin;
        this.status = _status;
        this.duracion = _duracion;
        this.nombreclase = _nombreclase;
        this.instructor = _instructor;
    }

    public Horario_Clase(){
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getDia() {
        return dia;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public String getStatus() {
        return status;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public void setFecha(Date _fecha) {
        this.fecha = _fecha;
    }

    public void setDia(String _dia) {
        this.dia = _dia;
    }

    public void setCapacidad(int _capacidad) {
        this.capacidad = capacidad;
    }

    public void setHoraInicio(Time _horaInicio) {
        this.horaInicio = _horaInicio;
    }

    public void setHoraFin(Time _horaFin) {
        this.horaFin = _horaFin;
    }

    public void setStatus(String _status) {
        this.status = _status;
    }

    public void setDuracion(int _duracion) {
        this.duracion = _duracion;
    }

    public String getNombreclase() {
        return nombreclase;
    }

    public void setNombreclase(String _nombreclase) {
        this.nombreclase = _nombreclase;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String _instructor) {
        this.instructor = _instructor;
    }
    
}
