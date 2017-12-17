/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun.Dominio;

/**
 *
 * @author Leonardo
 */
public class Comentario extends Entidad {
    
    private int _idUsuario;
    private String _sobreNombre;
    private String _mensaje;
    private String _fecha;

    public Comentario(){

    }

    public Comentario(int idUsuario, String mensaje){
        this._idUsuario = idUsuario;
        this._mensaje = mensaje;
    }

    public Comentario(int _idUsuario, String _sobreNombre, String _mensaje, String _fecha, int id) {
        super(id);
        this._idUsuario = _idUsuario;
        this._sobreNombre = _sobreNombre;
        this._mensaje = _mensaje;
        this._fecha = _fecha;
    }

    public Comentario(int _idUsuario, String _sobreNombre, String _mensaje, String _fecha) {
        this._idUsuario = _idUsuario;
        this._sobreNombre = _sobreNombre;
        this._mensaje = _mensaje;
        this._fecha = _fecha;
    }

   

    public int getIdUsuario() {
        return _idUsuario;
    }

    public void setIdUsuario(int _idUsuario) {
        this._idUsuario = _idUsuario;
    }

    public String getSobreNombre() {
        return _sobreNombre;
    }

    public void setSobreNombre(String _sobreNombre) {
        this._sobreNombre = _sobreNombre;
    }

    public String getMensaje() {
        return _mensaje;
    }

    public void setMensaje(String _mensaje) {
        this._mensaje = _mensaje;
    }

    public String getFecha() {
        return _fecha;
    }

    public void setFecha(String _fecha) {
        this._fecha = _fecha;
    }
    
    
    
}