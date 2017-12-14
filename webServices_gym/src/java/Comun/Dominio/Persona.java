/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun.Dominio;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author simon
 */
public class Persona extends Entidad implements Serializable{

    
    private String nombre;
    private String apellido;    
    private Date fecha_nac;
    private String sexo;
    private String correo;

    public Persona(String nombre, String apellido, String sexo, String correo, int id) {
        super(id);
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.correo = correo;
    }

    public Persona( int id, String nombre, String apellido, Date fecha_nac,
                    String sexo, String correo){
        super(id);
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nac = fecha_nac;
        this.sexo = sexo;
        this.correo = correo;
    }
    public Persona(){}

    public Persona(String nombre, String apellido, Date fecha_nac, String sexo, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nac = fecha_nac;
        this.sexo = sexo;
        this.correo = correo;
    }

    public Persona(String nombre, String apellido, int id) {
        super(id);
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
