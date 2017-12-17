/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun.Dominio;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author MinervaMorales
 */
public class Rutina extends Entidad{
    
    private String _nombre;
    private String _dia;
    private String _usuario;
    private int cantidadEjercicios;
    //private ArrayList<trabajo> _listaEjercicios;
    
    public Rutina(){
    
    }
    public Rutina(int id){
    super(id);
    }
    
    public Rutina( int id, String nombre, String dia )
    {
        super(id);
        this._nombre= nombre;
        this._dia= dia;   
    
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
