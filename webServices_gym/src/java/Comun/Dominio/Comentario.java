/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun.Dominio;

import java.io.Serializable;

/**
 *
 * @author marvian
 */
public class Comentario extends Entidad {
    private int _id;
    private String _mensaje;
    private String _NombreUsuario;
    private String _fecha;
    
    public Comentario(){
    }

    public Comentario(int _id, String _mensaje) {
        this._id = _id;
        this._mensaje = _mensaje;
    }

    public Comentario(int _id, String _mensaje, String _NombreUsuario, String _fecha) {
        this._id = _id;
        this._mensaje = _mensaje;
        this._NombreUsuario = _NombreUsuario;
        this._fecha = _fecha;
    }
    
    public String getFecha() {
        return _fecha;
    }

    public void setFecha(String _fecha) {
        this._fecha = _fecha;
    }
    
    public String getNombreUsuario() {
        return _NombreUsuario;
    }

    public void setNombreUsuario(String _NombreUsuario) {
        this._NombreUsuario = _NombreUsuario;
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
     * @return the _mensaje
     */
    public String getMensaje() {
        return _mensaje;
    }

    /**
     * @param _mensaje the _mensaje to set
     */
    public void setMensaje(String _mensaje) {
        this._mensaje = _mensaje;
    }    
}


