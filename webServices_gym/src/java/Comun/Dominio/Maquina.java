/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun.Dominio;

import java.io.Serializable;

/**
 *
 * @author Daniel Goncalves
 */
public class Maquina extends Entidad {
	private int _id;
    private String _nombre;    
    
     public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    } 

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public Maquina(int _id, String _nombre) {
        this._id = _id;
        this._nombre = _nombre;
    }

    public Maquina() {
        super();
    }
    
    public Maquina(int _id) {
        super(_id);
    }
}
