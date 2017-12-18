/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author MinervaMorales
 */
public class Trabajo_Rutina {
    private int _id;
    private Date _fecha;
    private int _tiempo;
    private int _distancia;
    private int _nivel;
    private ArrayList<Serie> _listaSeries = new ArrayList<Serie>();

       
    
    
    public Trabajo_Rutina(int _id, Date _fecha, int _tiempo, int _distancia, int _nivel) {
        this._id = _id;
        this._fecha = _fecha;
        this._tiempo = _tiempo;
        this._distancia = _distancia;
        this._nivel = _nivel;
    }

    public Trabajo_Rutina() {
     
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public int getTiempo() {
        return _tiempo;
    }

    public void setTiempo(int _tiempo) {
        this._tiempo = _tiempo;
    }

    public int getDistancia() {
        return _distancia;
    }

    public void setDistancia(int _distancia) {
        this._distancia = _distancia;
    }

    public int getNivel() {
        return _nivel;
    }

    public void setNivel(int _nivel) {
        this._nivel = _nivel;
    }

    public ArrayList<Serie> getListaSeries() {
        return _listaSeries;
    }

    public void setListaSeries(ArrayList<Serie> _listaSeries) {
        this._listaSeries = _listaSeries;
    }

    public Trabajo_Rutina(Date _fecha) {
        this._fecha = _fecha;
    }

    public Date getFecha() {
        return _fecha;
    }

    public void setFecha(Date _fecha) {
        this._fecha = _fecha;
    }
    
       
}
