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
public class Rutina {
    private int _id;
    private String _nombre;
    private String _dia;
    private String _usuario;
    private int cantidadEjercicios;
    //private ArrayList<trabajo> _listaEjercicios;
    
    public Rutina(){
    
    }
    
    public Rutina( int id, String nombre, String dia )
    {
        this._id = id;
        this._nombre= nombre;
        this._dia= dia;   
    
    }
    
    /**
     * @return the _id
     */
    public int getId() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void setId( int _id ) {
        this._id = _id;
    }

    /**
     * @return the _nombre
     */
    public String getNombre() {
        return _nombre;
    }

    /**
     * @param nombre the_nombre to set
     */
    public void setNombre( String nombre ) {
        this._nombre = nombre;
    }

    /**
     * @return the _dia
     */
    public String getDia() {
        return _dia;
    }

    /**
     * @param dia
     */
    public void setDia( String dia) {
        this._dia = dia;
    }

    public int getCantidadEjercicios() {
        return cantidadEjercicios;
    }

    public void setCantidadEjercicios(int cantidadEjercicios) {
        this.cantidadEjercicios = cantidadEjercicios;
    }
      
    
}
