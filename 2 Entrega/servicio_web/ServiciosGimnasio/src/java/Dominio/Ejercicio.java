/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;

/**
 *
 * @author MinervaMorales
 */
public class Ejercicio {
    private int _id;
    private String _nombre;
    private String _grupomuscular;
    private String _maquina;
    private String _equipo;
    
    
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

    public String getGrupomuscular() {
        return _grupomuscular;
    }

    public void setGrupomuscular(String _grupomuscular) {
        this._grupomuscular = _grupomuscular;
    }


    public String getMaquina() {
        return _maquina;
    }

    public void setMaquina(String _maquina) {
        this._maquina = _maquina;
    }

    public String getEquipo() {
        return _equipo;
    }

    public void setEquipo(String _equipo) {
        this._equipo = _equipo;
    }

 
    
}
