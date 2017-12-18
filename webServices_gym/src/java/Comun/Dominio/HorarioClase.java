/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun.Dominio;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author marvian
 */
public class HorarioClase extends Entidad {
    private int id;
    private Date fecha;
    private String dia;
    private int capacidad;
    private Time horaInicio;
    private Time horaFin;
    private String status;
    private int duracion;
    private int nombreclase;
    private int instructor;
    private String Descripcion;
    private String nombreConsulta;
    private String instructorConsulta;

    public HorarioClase(int _id, Date _fecha, String _dia, int _capacidad, 
            Time _horaInicio, Time _horaFin, String _status, int _duracion, 
            int _nombreclase, int _instructor, String _descripcion) {
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
        this.Descripcion = _descripcion;
    }

    public HorarioClase(){
        super();
    }
    public HorarioClase(int id){
        super(id);
    }

    public HorarioClase(String nombre, String descripcion) {
        super ();
        this.nombreclase = nombreclase;
        this.Descripcion = descripcion;
    }

    public HorarioClase(java.util.Date fecha, String dia, int capacidad, 
            Time hora_inicio, Time hora_fin, String status, int duracion, 
            int nombreclase, int instructor) {
       super ();
       this.fecha = (Date) fecha;
       this.dia = dia;
       this.capacidad = capacidad;
       this.horaInicio = horaInicio;
       this.horaFin = horaFin;
       this.status = status;
       this.duracion = duracion;
       this.nombreclase = nombreclase;
       this.instructor = instructor;
    }

    HorarioClase(int nombreclase, int instructor, Date fecha, String dia, 
            int capacidad, Time hora_inicio, Time hora_fin) {
        super();
        this.nombreclase = nombreclase;
        this.instructor = instructor;
        this.fecha = fecha;
        this.dia = dia;
        this.capacidad = capacidad;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    public HorarioClase(java.util.Date fecha, String dia, int capacidad, 
            Time hora_inicio, Time hora_fin, String status, int duracion, 
            String nombreclase, String instructor) {
       super ();
       this.fecha = (Date) fecha;
       this.dia = dia;
       this.capacidad = capacidad;
       this.horaInicio = horaInicio;
       this.horaFin = horaFin;
       this.status = status;
       this.duracion = duracion;
       this.nombreConsulta = nombreclase;
       this.instructorConsulta = instructor;
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

    public int getNombreclase() {
        return nombreclase;
    }

    public void setNombreclase(int _nombreclase) {
        this.nombreclase = _nombreclase;
    }

    public int getInstructor() {
        return instructor;
    }

    public void setInstructor(int _instructor) {
        this.instructor = _instructor;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /**
     * @return the nombreConsulta
     */
    public String getNombreConsulta() {
        return nombreConsulta;
    }

    /**
     * @param nombreConsulta the nombreConsulta to set
     */
    public void setNombreConsulta(String nombreConsulta) {
        this.nombreConsulta = nombreConsulta;
    }

    /**
     * @return the instructorConsulta
     */
    public String getInstructorConsulta() {
        return instructorConsulta;
    }

    /**
     * @param instructorConsulta the instructorConsulta to set
     */
    public void setInstructorConsulta(String instructorConsulta) {
        this.instructorConsulta = instructorConsulta;
    }
    
    
    
}
