/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun.Dominio;

import java.awt.Image;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author simon
 */
public class Instructor extends Persona implements Serializable {
    
    private Image foto;

 
    
    
    public Instructor( int id, String nombre, String apellido, Date fecha_nac, String sexo, String correo) {
        super(id, nombre, apellido, fecha_nac, sexo, correo);
    }
    
    public Instructor(String nombre, String apellido, Date fecha_nac, String sexo, String correo) {
        super(nombre, apellido, fecha_nac, sexo, correo);
    }
    
    public Instructor(){}
    
    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }
    
}
