/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author Luis L
 */
public class Mensaje {
    private int _Mes_Id;
    private String _Mes_Mensaje;
    private int _usuario;
    private int _entrenador;
//return _MES_Id id del mensaje
    public int getMes_Id() {
        return _Mes_Id;
    }
//param _Mes_Id mensaje id to set
    public void setMes_Id(int _Mes_Id) {
        this._Mes_Id = _Mes_Id;
    }
// return _Mes_Mensaje texto del mensaje
    public String getMes_Mensaje() {
        return _Mes_Mensaje;
    }
// param _Mes_Mnesaje mensaje to set
    public void setMes_Mensaje(String _Mes_Mensaje) {
        this._Mes_Mensaje = _Mes_Mensaje;
    }
// @return the _usuario
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
