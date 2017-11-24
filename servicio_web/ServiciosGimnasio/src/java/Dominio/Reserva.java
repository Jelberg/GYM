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

    public Reserva() {
    }

    
    public Reserva(int _res_Id, Date _fecha_Ini, Date _fecha_Fin, int _usuario, int _entrenador) {
        this._res_Id = _res_Id;
        this._fecha_Ini = _fecha_Ini;
        this._fecha_Fin = _fecha_Fin;
        this._usuario = _usuario;
        this._entrenador = _entrenador;
    }

    public int getRes_Id() {
        return _res_Id;
    }

    public void setRes_Id(int _res_Id) {
        this._res_Id = _res_Id;
    }

    public Date getFecha_Ini() {
        return _fecha_Ini;
    }

    public void setFecha_Ini(Date _fecha_Ini) {
        this._fecha_Ini = _fecha_Ini;
    }

    public Date getFecha_Fin() {
        return _fecha_Fin;
    }

    public void setFecha_Fin(Date _fecha_Fin) {
        this._fecha_Fin = _fecha_Fin;
    }

    public int getUsuario() {
        return _usuario;
    }

    public void setUsuario(int _usuario) {
        this._usuario = _usuario;
    }

    public int getEntrenador() {
        return _entrenador;
    }

    public void setEntrenador(int _entrenador) {
        this._entrenador = _entrenador;
    }
    
    
}