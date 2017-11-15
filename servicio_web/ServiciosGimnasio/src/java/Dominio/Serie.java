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
public class Serie {
        
    private int _numRepeticiones;
    private float _peso;
    private int _tiempoDescanso;

    public Serie(int _numRepeticiones, float _peso, int _tiempoDescanso) {
        this._numRepeticiones = _numRepeticiones;
        this._peso = _peso;
        this._tiempoDescanso = _tiempoDescanso;
    }

    public int getNumRepeticiones() {
        return _numRepeticiones;
    }

    public void setNumRepeticiones(int _numRepeticiones) {
        this._numRepeticiones = _numRepeticiones;
    }

    public float getPeso() {
        return _peso;
    }

    public void setPeso(float _peso) {
        this._peso = _peso;
    }

    public int getTiempoDescanso() {
        return _tiempoDescanso;
    }

    public void setTiempoDescanso(int _tiempoDescanso) {
        this._tiempoDescanso = _tiempoDescanso;
    }
    
    
}
