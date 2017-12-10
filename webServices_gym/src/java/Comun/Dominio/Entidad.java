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
    int _id;
    public Entidad ( int id ){
        _id = id;
    }
    public Entidad(){}
    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }
    
}
