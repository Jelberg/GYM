/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author MinervaMorales
 */
public class Ejercicio_Maquina_Equipo implements Serializable{

    private int id;
    private String nombre;
    private String grupomuscular;
    private int maquina;
    private int equipo;
    private String equipamiento; 
 

    public int getId() {
        return id;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String _nombre) {
        this.nombre = _nombre;
    }

    public String getGrupomuscular() {
        return grupomuscular;
    }

    public void setGrupomuscular(String _grupomuscular) {
        this.grupomuscular = _grupomuscular;
    }

    public int getMaquina() {
        return maquina;
    }

    public void setMaquina(int _maquina) {
        this.maquina = _maquina;
    }

    public int getEquipo() {
        return equipo;
    }

    public void setEquipo(int _equipo) {
        this.equipo = _equipo;
    }

}
