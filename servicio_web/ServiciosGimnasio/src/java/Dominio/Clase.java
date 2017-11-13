/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author YESIMAR
 */
public class Clase {
    private int _id;
    private String _nombre;
    private String _descripcion;

    public int getId() {
        return _id;
    }

    public String getNombre() {
        return _nombre;
    }

    public String getDescripcion() {
        return _descripcion;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }
    
}
