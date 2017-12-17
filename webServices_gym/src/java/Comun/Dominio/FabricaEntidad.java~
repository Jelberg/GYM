/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun.Dominio;

//import java.sql.Date;
import java.util.Date;

/**
 *
 * @author Elberg
 */
public class FabricaEntidad {
	
	// Inicia Fabricas de BO1
	
	static public Entidad InstanciaEquipo( int id, String nombre){
        return new Equipo(id, nombre);
    }
	
	static public Entidad InstanciaMaquina( int id, String nombre){
        return new Maquina(id, nombre);
    }
	
	static public Entidad InstanciaEjercicio( int id, String nombre, String grupoMusc, String equipo, String maquina){
        return new Ejercicio(id, nombre, grupoMusc, equipo, maquina);
    }
	
	
	// Fin de BO1
    
    // Inicia Fabricas de BO2
    static public Entidad InstanciaInstructor( int id, String nombre, String apellido,
                                    Date fecha_nac, String sexo, String correo){
        return new Instructor(id, nombre, apellido, fecha_nac, sexo, correo);
    }
    static public Entidad instanciaEntrenadorCorreo( String correo ){
        return new Entrenador( correo );
    }
    static public Entidad instanciaEntrenador( String nombre, String apellido, 
                                                Date fecha, String sexo, String correo,
                                                String historial){
        return new Entrenador( nombre, apellido, fecha, sexo, correo, historial );
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
    
    //Fábrica para consultar un usuario por id.
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
    
    //Fábrica para consultar un usuario por nombre y apellido.
    static public Usuario InstanciaUsuarioNomApe(int id, String usuario, 
                                            String nombre, String apellido)
    {
        return new Usuario(id, usuario, nombre, apellido);
    }
    
    //Fábrica para modificar un usuario.
    static public Usuario InstanciaModificaUsuario(int id,String usuario, String password,
                                            String nombre, String apellido,
                                            String sexo, 
                                            String telefono, int estatura, 
                                            String correo, boolean entrenador, int codigo)
    {
        return new Usuario(password, usuario, estatura, telefono, codigo, 
                            entrenador, id, nombre, apellido, null, 
                            sexo, correo);
    }
    
    //Fábrica para eliminar un usuario.
    static public String InstanciaEliminaUsuario(int id,String usuario, String password,
                                            String nombre, String apellido,
                                            String sexo, Date fecha_nac,
                                            String telefono, int estatura, 
                                            String correo, boolean entrenador, int codigo)
    {
        return ("Se eliminó con éxito");
    }
    
    //Fábrica para consultar un usuario por id.
    static public Usuario_Amigo InstanciaUsuario_Amigo(int ami_usuario, int ami_amigo)
    {
        return new Usuario_Amigo( ami_usuario, ami_amigo);
    }
    
    //Fábrica para agregar un amigo.
    static public Usuario_Amigo InstanciaInsertaUsuario_Amigo(int ami_usuario, int ami_amigo)
    {
        return new Usuario_Amigo( ami_usuario, ami_amigo);
    }
    
    //Fábrica para eliminar un amigo.
    static public Usuario_Amigo InstanciaEliminaUsuario_Amigo(int ami_usuario, int ami_amigo)
    {
        return new Usuario_Amigo( ami_usuario, ami_amigo);
    }
    
    // Fin de FOM01
    
    // Inicia Fabricas de M04
    /*static public Entidad InstaciaProgresoPeso(int id, int peso, Date fechaP, String sobrenombre){
    return new Progreso_Peso(id, peso, fechaP,sobrenombre);
    }*/
    // Fin de M04        
    
}
