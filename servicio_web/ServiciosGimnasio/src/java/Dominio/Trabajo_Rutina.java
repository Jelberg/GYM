/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.sql.Date;

/**
 *
 * @author MinervaMorales
 */
public class Trabajo_Rutina {
    private Date _fecha;

    public Trabajo_Rutina(Date _fecha) {
        this._fecha = _fecha;
    }

    public Date getFecha() {
        return _fecha;
    }

    public void setFecha(Date _fecha) {
        this._fecha = _fecha;
    }
    
       
}
