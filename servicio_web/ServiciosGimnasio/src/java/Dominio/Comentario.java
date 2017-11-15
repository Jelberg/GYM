/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;

/**
 *
 * @author marvian
 */
public class Comentario implements Serializable {
    private int _id;
    private String _mensaje;
    private String _NombreUsuario;
    private String _fecha;
    
    public Comentario(){
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
        
    public Comentario(int id, String mensaje ){
        this._id = id;
        this._mensaje = mensaje;
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


