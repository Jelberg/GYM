/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.sql.Date;

/**
 *
 * @author marvian
 */
public class Progreso_Medida {
    private int _id;
    private int _medida;
    private String _tipo;
    private String _fechaM;
    private String _sobrenombre;
    
    public Progreso_Medida(){
    }
    
    public Progreso_Medida(int id, int medida, String tipo, 
    String fechaM, String sobrenombre){
        this._id = id;
        this._medida = medida;
        this._tipo = tipo;
        this._fechaM = fechaM;
        this._sobrenombre = sobrenombre;
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
     * @return the _medida
     */
    public int getMedida() {
        return _medida;
    }

    /**
     * @param _medida the _medida to set
     */
    public void setMedida(int _medida) {
        this._medida = _medida;
    }

    /**
     * @return the _tipo
     */
    public String getTipo() {
        return _tipo;
    }

    /**
     * @param _tipo the _tipo to set
     */
    public void setTipo(String _tipo) {
        this._tipo = _tipo;
    }

    /**
     * @return the _fechaM
     */
    public String getFechaM() {
        return _fechaM;
    }

    /**
     * @param _fechaM the _fechaM to set
     */
    public void setFechaM(String _fechaM) {
        this._fechaM = _fechaM;
    }

    /**
     * @return the _sobrenombre
     */
    public String getSobrenombre() {
        return _sobrenombre;
    }

    /**
     * @param _sobrenombre the _sobrenombre to set
     */
    public void setSobrenombre(String _sobrenombre) {
        this._sobrenombre = _sobrenombre;
    }
    
    
    
    
}
