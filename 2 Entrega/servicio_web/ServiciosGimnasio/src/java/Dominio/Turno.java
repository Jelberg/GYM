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
public class Turno {
    
    private int _id;
    private String _dia;

    public Turno(int _id, String _dia) {
        this._id = _id;
        this._dia = _dia;
    }

    public Turno() {
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getDia() {
        return _dia;
    }

    public void setDia(String _dia) {
        this._dia = _dia;
    }
    
}
