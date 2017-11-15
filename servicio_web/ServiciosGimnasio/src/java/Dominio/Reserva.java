/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dominio;
import java.sql.Date;

/**
 *
 * @author Luis L
 */
public class Reserva {
    private int _res_Id;
    private Date _fecha_Ini;
    private Date _fecha_Fin;
    private int _usuario;
    private int _entrenador;
//@return the reserva id
    public int getRes_Id() {
        return _res_Id;
    }
//param set _res_Id reserva id to set
    public void setRes_Id(int _res_Id) {
        this._res_Id = _res_Id;
    }
//@return the fecha inicial de la reserva
    public Date getFecha_Ini() {
        return _fecha_Ini;
    }
//param set _fecha_ini fecha inicial to set 
    public void setFecha_Ini(Date _fecha_Ini) {
        this._fecha_Ini = _fecha_Ini;
    }
//@return the fecha final de la reserva
    public Date getFecha_Fin() {
        return _fecha_Fin;
    }
//param set _fecha_ini fecha final to set 
    public void setFecha_Fin(Date _fecha_Fin) {
        this._fecha_Fin = _fecha_Fin;
    }
//@return the _usuario de la reserva
    public int getUsuario() {
        return _usuario;
    }
//param set _usuario id usuario to set
    public void setUsuario(int _usuario) {
        this._usuario = _usuario;
    }
//@return the _entrenador de la reserva
    public int getEntrenador() {
        return _entrenador;
    }
//param set _entrenador id entrenador to set
    public void setEntrenador(int _entrenador) {
        this._entrenador = _entrenador;
    }
    
    
}
