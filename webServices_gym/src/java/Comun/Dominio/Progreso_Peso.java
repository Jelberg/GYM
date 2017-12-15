/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun.Dominio;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author marvian
 */
public class Progreso_Peso extends Entidad{
    private int _idUsuario;
    private int _peso;
    private Date _fechaP;
    private String _sobrenombre;

    public Progreso_Peso(){
        
    }
    
    public Progreso_Peso(int idUsuario, int peso){
        this._idUsuario = _idUsuario;
    }
    
    public Progreso_Peso(int _idUsuario, int _peso, Date _fechaP, String _sobrenombre, int id) {
        super(id);
        this._idUsuario = _id;
        this._peso = _peso;
        this._fechaP = _fechaP;
        this._sobrenombre = _sobrenombre;
    }

    public Progreso_Peso(int _idUsuario, int _peso, Date _fechaP, String _sobrenombre) {
        this._idUsuario = _idUsuario;
        this._peso = _peso;
        this._fechaP = _fechaP;
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

    public int getId() {
        return _id;
    }

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
    public Date getFechaP() {
        return _fechaP;
    }

    /**
     * @param _fechaP the _fechaP to set
     */
    public void setFechaP(Date _fechaP) {
        this._fechaP = _fechaP;
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
