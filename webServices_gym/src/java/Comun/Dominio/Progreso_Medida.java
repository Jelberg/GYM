/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun.Dominio;

import java.sql.Date;

/**
 *
 * @author marvian
 */
public class Progreso_Medida extends Entidad {
    private int _idUsuario;
    private int _medida;
    private String _tipo;
    private String _fechaM;
    private String _sobrenombre;
    
    public Progreso_Medida(){
        
    }
    
    public Progreso_Medida(int idUsuario, int medida, String tipo_Medida){
        this._idUsuario = idUsuario;
        this._medida = medida;
        this._tipo = tipo_Medida;
    }
    
    public Progreso_Medida(int _idUsuario, int _medida, String _tipo, String _fechaM, String _sobrenombre, int id) {
        super(id);
        this._idUsuario = _idUsuario;
        this._medida = _medida;
        this._tipo = _tipo;
        this._fechaM = _fechaM;
        this._sobrenombre = _sobrenombre;
    }

    public Progreso_Medida(int _idUsuario, int _medida, String _tipo, String _fechaM, String _sobrenombre) {
        this._idUsuario = _idUsuario;
        this._medida = _medida;
        this._tipo = _tipo;
        this._fechaM = _fechaM;
        this._sobrenombre = _sobrenombre;
    }
    
    

    /**
     * @return the _id
     */
    public int getIdUsuario() {
        return _idUsuario;
    }

    /**
     * @param _id the _id to set
     */
    public void setIdUsuario(int _idUsuario) {
        this._idUsuario = _idUsuario;
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
