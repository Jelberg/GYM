/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author MinervaMorales
 */
public class Equipo {
    
    private String _nombre;

    public Equipo(String _nombre) {
        this._nombre = _nombre;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }
    
    
}
