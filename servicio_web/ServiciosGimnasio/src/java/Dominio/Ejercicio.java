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
    private ArrayList<Trabajo_Rutina> _listaTrabajoRutina = new ArrayList<Trabajo_Rutina>();
    
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
    
    
}
