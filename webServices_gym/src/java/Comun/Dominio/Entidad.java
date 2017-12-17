/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun.Dominio;

/**
 *
 * @author Elberg
 */
public class Entidad {
    private int _id;
    private String _mensaje;
    
    public Entidad ( int id ){
        _id = id;
    }
    public Entidad ( int id, String mensaje ){
        _id = id;
        _mensaje = mensaje;
    }
    public Entidad(){}
    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
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
