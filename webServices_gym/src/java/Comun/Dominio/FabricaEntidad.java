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
    
    // Inicia Fabricas de FOM01
    static public Usuario InstanciaUsuario(String usuario, String password, 
                                            String nombre, String apellido,
                                            Date fecha_nac, String sexo, 
                                            String correo, int estatura, 
                                            String telefono, boolean entrenador)
    {
        return new Usuario(password, usuario, estatura, telefono, entrenador, 
                            nombre, apellido, fecha_nac, sexo, correo);
    }
    
    static public Usuario InstanciaUsuarioId(int id, String usuario, String password,
                                            String nombre, String apellido,
                                            String sexo, Date fecha_nac,
                                            String telefono, int estatura, 
                                            String correo, boolean entrenador, int codigo)
    {
        return new Usuario(password, usuario, estatura, telefono, codigo, 
                            entrenador, id, nombre, apellido, fecha_nac, 
                            sexo, correo);
    }
    
    static public Usuario InstanciaUsuarioNomApe(int id, String usuario, 
                                            String nombre, String apellido)
    {
        return new Usuario(id, usuario, nombre, apellido);
    }
    
    static public Usuario InstanciaModificaUsuario(int id,String usuario, String password,
                                            String nombre, String apellido,
                                            String sexo, Date fecha_nac,
                                            String telefono, int estatura, 
                                            String correo, boolean entrenador, int codigo)
    {
        return new Usuario(password, usuario, estatura, telefono, codigo, 
                            entrenador, id, nombre, apellido, fecha_nac, 
                            sexo, correo);
    }
    
    // Fin de FOM01
    
    // Inicia Fabricas de M04
    /*static public Entidad InstaciaProgresoPeso(int id, int peso, Date fechaP, String sobrenombre){
    return new Progreso_Peso(id, peso, fechaP,sobrenombre);
    }*/
    // Fin de M04        
    
}
