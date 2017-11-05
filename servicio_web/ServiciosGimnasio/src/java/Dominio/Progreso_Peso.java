/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.time.LocalDate;

/**
 *
 * @author marvian
 */
public class Progreso_Peso {
    private int _id;
    private int _peso;
    private LocalDate _fechaP;
    
    public Progreso_Peso(){    
    }

    public Progreso_Peso(int id, int peso, LocalDate fechaP){
        this._id = id;
        this._peso = peso;
        this._fechaP = fechaP;
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
    public void setId(int _id) {
        this._id = _id;
    }

    /**
     * @return the _peso
     */
    public int getPeso() {
        return _peso;
    }

    /**
     * @param _peso the _peso to set
     */
    public void setPeso(int _peso) {
        this._peso = _peso;
    }

    /**
     * @return the _fechaP
     */
    public LocalDate getFechaP() {
        return _fechaP;
    }

    /**
     * @param _fechaP the _fechaP to set
     */
    public void setFechaP(LocalDate _fechaP) {
        this._fechaP = _fechaP;
    }
    
    
    
    
}
