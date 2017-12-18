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
public class Plan {
    private int _id;
    private String _nombre;
    private String _descripcion;
    private ArrayList<Rutina> _listaRutina = new ArrayList<Rutina>();

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

    public String getDescripcion() {
        return _descripcion;
    }

    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }
    
    public ArrayList<Rutina> getListaRutina() {
        return _listaRutina;
    }

    public void setListaRutina(ArrayList<Rutina> _listaRutina) {
        this._listaRutina = _listaRutina;
    }
    
    
}

