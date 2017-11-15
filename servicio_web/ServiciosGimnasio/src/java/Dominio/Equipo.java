/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;

/**
 *
 * @author Juan Zozaya
 */
public class Equipo implements Serializable {
    
    private String _nombre;
    private int id;

  
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    } 

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }
    
    
}
