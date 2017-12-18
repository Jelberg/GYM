/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun.Dominio;

import java.util.Date;

/**
 *
 * @author gilbert
 */
public class Entrenador extends Persona{
    private String _historial;
    public Entrenador( int id, String nombre, String apellido, Date fecha_nac, String sexo, String correo, String historial) {
        super( id, nombre, apellido, fecha_nac, sexo, correo);
        _historial = historial;
    }
    public Entrenador(){}
    
    
    public Entrenador( String correo ){
        super( correo );
    }

    Entrenador(String nombre, String apellido, Date fecha, String sexo, String correo, String historial) {
        super( nombre, apellido, fecha, sexo, correo );
        _historial = historial;
    }
    public String getHistorial() {
        return _historial;
    }

    /**
     * @param historial the historial to set
     */
    public void setHistorial(String historial) {
        this._historial = historial;
    }
    
    
}
