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
public class Critica {
    int _id;
    Date _fecha;
    String _comentario;
    int _valoracion;
    int _referenciaHc;

    public Critica() {
    }

    public Critica(int _id, Date _fecha, String _comentario, int _valoracion, int _referenciaHc) {
        this._id = _id;
        this._fecha = _fecha;
        this._comentario = _comentario;
        this._valoracion = _valoracion;
        this._referenciaHc = _referenciaHc;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public Date getFecha() {
        return _fecha;
    }

    public void setFecha(Date _fecha) {
        this._fecha = _fecha;
    }

    public String getComentario() {
        return _comentario;
    }

    public void setComentario(String _comentario) {
        this._comentario = _comentario;
    }

    public int getValoracion() {
        return _valoracion;
    }

    public void setValoracion(int _valoracion) {
        this._valoracion = _valoracion;
    }

    public int getReferenciaHc() {
        return _referenciaHc;
    }

    public void setReferenciaHc(int _referenciaHc) {
        this._referenciaHc = _referenciaHc;
    }
    
    
    
    
}
