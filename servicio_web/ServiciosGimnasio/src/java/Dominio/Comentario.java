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
    private int _UsuarioProgreso;
    private int _UsuarioComentario;
    
    public Comentario(){
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

    /**
     * @return the _UsuarioProgreso
     */
    public int getUsuarioProgreso() {
        return _UsuarioProgreso;
    }

    /**
     * @param _UsuarioProgreso the _UsuarioProgreso to set
     */
    public void setUsuarioProgreso(int _UsuarioProgreso) {
        this._UsuarioProgreso = _UsuarioProgreso;
    }

    /**
     * @return the _UsuarioComentario
     */
    public int getUsuarioComentario() {
        return _UsuarioComentario;
    }

    /**
     * @param _UsuarioComentario the _UsuarioComentario to set
     */
    public void setUsuarioComentario(int _UsuarioComentario) {
        this._UsuarioComentario = _UsuarioComentario;
    }
    
    
}


