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
  
    private String _mensaje;
    private String _NombreUsuario;
    private String _fecha;
    
    public Comentario(){
    }

    public Comentario(int _id, String _mensaje) {
        super(_id);
        this._mensaje = _mensaje;
    }

    public Comentario(String _mensaje) {
        this._mensaje = _mensaje;
    }
    
    public Comentario(int _id, String _mensaje, String _NombreUsuario, String _fecha) {
        super(_id);
        this._mensaje = _mensaje;
        this._NombreUsuario = _NombreUsuario;
        this._fecha = _fecha;
    }


    public String getMensaje() {
        return _mensaje;
    }

    /**
     * Modificar mensaje del comentario
     * @param _mensaje 
     */
    public void setMensaje(String _mensaje) {
        this._mensaje = _mensaje;
    }

    /**
     * Obtener nombre del usuario al que le pertenece el comentario
     * @return 
     */
    public String getNombreUsuario() {
        return _NombreUsuario;
    }

    /**
     * Modificar nombre del usuario al que le pertence el comentario
     * @param _NombreUsuario 
     */
    public void setNombreUsuario(String _NombreUsuario) {
        this._NombreUsuario = _NombreUsuario;
    }

    /**
     * Obtener fecha en al que se hizo el comnetario
     * @return 
     */
    public String getFecha() {
        return _fecha;
    }

    /**
     * Modificar fecha en la que se hizo el comentario
     * @param _fecha 
     */
    public void setFecha(String _fecha) {
        this._fecha = _fecha;
    }

    
     
}