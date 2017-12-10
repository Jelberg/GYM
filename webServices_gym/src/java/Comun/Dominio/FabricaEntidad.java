/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun.Dominio;

import java.sql.Date;

/**
 *
 * @author Elberg
 */
public class FabricaEntidad {
    
    // Inicia Fabricas de BO2
    static public Entidad InstanciaInstructor( int id, String nombre, String apellido,
                                    Date fecha_nac, String sexo, String correo){
        return new Instructor(id, nombre, apellido, fecha_nac, sexo, correo);
    }
    static public Entidad instanciaEntrenador ( int id, String nombre, String apellido,
                                    Date fecha_nac, String sexo, String correo, String historial ){
        return new Entrenador( id, nombre, apellido, fecha_nac, sexo, correo, historial );
    }
    // Fin de BO2
    
        // Inicia Fabricas de FO1
    static public Usuario InstanciaUsuario(String usuario, String password, String nombre, String apellido,
                                    Date fecha_nac, String sexo, String correo, int estatura, 
                                    String telefono, boolean entrenador)
    {
        return new Usuario(password, usuario, estatura, telefono, entrenador, nombre, apellido, fecha_nac, sexo, correo);
    }
    // Fin de FO1
    
    // Inicia Fabricas de M04
    /*static public Entidad InstaciaProgresoPeso(int id, int peso, Date fechaP, String sobrenombre){
    return new Progreso_Peso(id, peso, fechaP,sobrenombre);
    }*/
    // Fin de M04        
    
}
