/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.sql.Date;

/**
 *
 * @author Elberg
 */
public class ClasesParticipadas {
    private int _idHc;
    private String _nombreIns;
    private String _apellidoIns;
    private Date _fecha;
    private String _nombreClase;

    public ClasesParticipadas() {
    }

    public ClasesParticipadas(int _idHc, String _nombreIns, String _apellidoIns, Date _fecha, String _nombreClase) {
        this._idHc = _idHc;
        this._nombreIns = _nombreIns;
        this._apellidoIns = _apellidoIns;
        this._fecha = _fecha;
        this._nombreClase = _nombreClase;
    }

    public int getIdHc() {
        return _idHc;
    }

    public void setIdHc(int _idHc) {
        this._idHc = _idHc;
    }

    public String getNombreIns() {
        return _nombreIns;
    }

    public void setNombreIns(String _nombreIns) {
        this._nombreIns = _nombreIns;
    }

    public String getApellidoIns() {
        return _apellidoIns;
    }

    public void setApellidoIns(String _apellidoIns) {
        this._apellidoIns = _apellidoIns;
    }

    public Date getFecha() {
        return _fecha;
    }

    public void setFecha(Date _fecha) {
        this._fecha = _fecha;
    }

    public String getNombreClase() {
        return _nombreClase;
    }

    public void setNombreClase(String _nombreClase) {
        this._nombreClase = _nombreClase;
    }
    
    
}
