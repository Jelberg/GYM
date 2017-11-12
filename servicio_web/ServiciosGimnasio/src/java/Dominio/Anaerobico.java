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
public class Anaerobico extends Ejercicio{
    private int _id;
    private int _numSeries;
    private int _numRepeticiones;
    private int _tiempoDescanso;

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public int getNumSeries() {
        return _numSeries;
    }

    public void setNumSeries(int _numSeries) {
        this._numSeries = _numSeries;
    }

    public int getNumRepeticiones() {
        return _numRepeticiones;
    }

    public void setNumRepeticiones(int _numRepeticiones) {
        this._numRepeticiones = _numRepeticiones;
    }

    public int getTiempoDescanso() {
        return _tiempoDescanso;
    }

    public void setTiempoDescanso(int _tiempoDescanso) {
        this._tiempoDescanso = _tiempoDescanso;
    }
    
    
}
