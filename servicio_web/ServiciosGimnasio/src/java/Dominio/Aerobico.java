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
public class Aerobico extends Ejercicio{
    private int _id;
    private int _tiempo;
    private int _distancia;
    private int _nivel;

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public int getTiempo() {
        return _tiempo;
    }

    public void setTiempo(int _tiempo) {
        this._tiempo = _tiempo;
    }

    public int getDistancia() {
        return _distancia;
    }

    public void setDistancia(int _distancia) {
        this._distancia = _distancia;
    }

    public int getNivel() {
        return _nivel;
    }

    public void setNivel(int _nivel) {
        this._nivel = _nivel;
    }
    
    
}
