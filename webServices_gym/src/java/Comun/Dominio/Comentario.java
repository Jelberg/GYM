/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun.Dominio;

import java.io.Serializable;


public class Comentario extends Entidad implements Serializable {
    private int _idU;
    private String _mensajeC;
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
        
    public Comentario(int idU, String mensaje ){
        this._idU = idU;
        this._mensajeC = mensaje;
    }

    /**
     * @return the _id
     */
    public int getIdU() {
        return _idU;
    }

    /**
     * @param _id the _id to set
     */
    public void setIdU(int _id) {
        this._idU = _id;
    }

    /**
     * @return the _mensaje
     */
    public String getMensajeC() {
        return _mensajeC;
    }

    /**
     * @param _mensaje the _mensaje to set
     */
    public void setMensajeC(String _mensaje) {
        this._mensajeC = _mensaje;
    }    
}


