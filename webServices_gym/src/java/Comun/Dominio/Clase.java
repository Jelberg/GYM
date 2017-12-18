/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun.Dominio;

import java.sql.Date;

/**
 *
 * @author marvian
 */
public class Clase extends Entidad {
    
    
    private String _nombre;
    private String _descripcion;
    private String _Instructor;
    private Date _fecha;
    private Date _horaInicio;
    private Date _horaFin;
    private int _capacidad;

 
    public Clase(String _nombre) {
        this._nombre = _nombre;
    }
    
    public Clase(int _id, String _nombre, String _descripcion, 
            String _idInstructor, Date _fecha, Date _horaInicio, Date _horaFin, 
            int _capacidad) {
        super (_id);
        this._nombre = _nombre;
        this._descripcion = _descripcion;
        this._Instructor = _idInstructor;
        this._fecha = _fecha;
        this._horaInicio = _horaInicio;
        this._horaFin = _horaFin;
        this._capacidad = _capacidad;
    }

    Clase(String nombre, String descripcion) {
        super();
        this._nombre = _nombre;
        this._descripcion = _descripcion;
    }

    Clase(String nombre, String descripcion, String Instructor, 
            java.util.Date fecha, java.util.Date horaInicio, 
            java.util.Date horaFin, int capacidad) {
        super();
        this._nombre = _nombre;
        this._descripcion = _descripcion;
        this._Instructor = _Instructor;
        this._fecha = _fecha;
        this._horaInicio = _horaInicio;
        this._horaFin = _horaFin;
        this._capacidad = _capacidad;
    }

    

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String getDescripcion() {
        return _descripcion;
    }

    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public String getInstructor() {
        return _Instructor;
    }

    public void setInstructor(String _Instructor) {
        this._Instructor = _Instructor;
    }

    public Date getFecha() {
        return _fecha;
    }

    public void setFecha(Date _fecha) {
        this._fecha = _fecha;
    }

    public Date getHoraInicio() {
        return _horaInicio;
    }

    public void setHoraInicio(Date _horaInicio) {
        this._horaInicio = _horaInicio;
    }

    public Date getHoraFin() {
        return _horaFin;
    }

    public void setHoraFin(Date _horaFin) {
        this._horaFin = _horaFin;
    }

    public int getCapacidad() {
        return _capacidad;
    }

    public void setCapacidad(int _capacidad) {
        this._capacidad = _capacidad;
    }
    
     public Clase() {
        super();
    }
    
    public Clase(int _id) {
        super(_id);
    }
    
  
  
    
}
