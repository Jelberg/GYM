/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun.Dominio;

//import java.sql.Date;
import java.sql.Time;
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
	
	static public Entidad InstanciaEjercicio( int id, String nombre, String grupoMusc){
        return new Ejercicio(id, nombre, grupoMusc);
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
    static public Entidad instanciaClase (int id, String nombre, 
            String descripcion, String Instructor,Date fecha, Date horaInicio, 
            Date horaFin, int capacidad){
        return new Clase (nombre, descripcion, Instructor,
      fecha, horaInicio, horaFin, capacidad);
    
    }
    
    static public Entidad instanciaInsertarClase(String nombre, String descripcion){
            return new Clase(nombre, descripcion);
    }
    
    static public Entidad instanciaEliminaClase(String nombre){
            return new Clase(nombre);
    }
    
    static public Entidad instanciaModificarClase(String nombre, String descripcion){
            return new Clase(nombre, descripcion);
    }
    
    static public Entidad instanciaConsultarHorarioClase(Date fecha, String dia, int capacidad,
                    Time hora_inicio, Time hora_fin, char status, int duracion,
                    int nombreclase,int instructor){
            return new HorarioClase(fecha, dia, capacidad,
                    hora_inicio,hora_fin,status,duracion,nombreclase,instructor);         
    }
    
    public static Entidad instanciaEliminarClase(int nombreclase, int instructor, java.sql.Date fecha, 
            String dia, int capacidad, Time hora_inicio, Time hora_fin) {
        return new HorarioClase(nombreclase, instructor, fecha, dia, capacidad,
        hora_inicio, hora_fin);
    }
    
    public static Entidad instanciaModificarClase(int nombreclase, int instructor, java.sql.Date fecha, String dia, int capacidad, Time hora_inicio, Time hora_fin) {
        return new HorarioClase(nombreclase, instructor, fecha, dia, capacidad,
        hora_inicio, hora_fin);
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
    /**
     * Intancia de la clase Progreso_Peso
     * @param id
     * @param peso
     * @param fechaP
     * @param sobrenombre
     * @return 
     */
    static public Entidad InstaciaProgresoPeso(int id, int peso, Date fechaP, String sobrenombre){
    return new Progreso_Peso(id, peso, (java.sql.Date) fechaP,sobrenombre);
    }
    
    /**
     * Instancia del progreso del peso que solo recibe id y peso
     * @param id
     * @param peso
     * @return 
     */
    static public Entidad InstaciaProgresoPeso(int id, int peso){
    return new Progreso_Peso(id, peso);
    }
    
    /**
     * instancia del progreso del peso que solo recivçbe id
     * @param id
     * @return 
     */
    static public Entidad InstaciaProgresoPeso(int id){
    return new Progreso_Peso(id);
    }
    
    
    /**
     * Instancia del progreso medida con solo el id
     * @param id
     * @return 
     */
    static public Entidad InstanciaProgresoMedida(int id){
        return new Progreso_Medida(id);
    }
    
    /**
     * instancia del progreso medida con id, tipo y medida
     * @param id
     * @param medida
     * @param tipo
     * @return 
     */
    static public Entidad InstanciaProgresoMedida(int id, int medida, String tipo){
        return new Progreso_Medida(id,medida,tipo);
    }

    /**
     * Instancia del comentario
     * @param idUsuario
     * @param mensaje
     * @return 
     */
    static public Entidad InstaciaInsertarComentario(int idUsuario, 
            String mensaje){
    return new Comentario(idUsuario, mensaje);
    }
    
    /**
     * Instancia del Progreso de Medida
     * @param id
     * @param medida
     * @param tipo
     * @param fechaM
     * @param sobreNombre
     * @return 
     */
    static public Entidad InstanciaProgresoMedida(int id, int medida, 
            String tipo, Date fechaM, String sobreNombre){
        return new Progreso_Medida(id, medida, tipo, (java.sql.Date) fechaM, sobreNombre);
    }
    
    /**
     * Instancia del Progreso peso a Actualizar
     * @param idUsuario
     * @param peso
     * @return 
     */
    static public Progreso_Peso InstanciaActualizarPeso(int idUsuario, int peso){
         return new Progreso_Peso(idUsuario, peso);
    }   
    
    /**
     * Instancia del Progreso Medida a actualizar
     * @param idUsuario
     * @param medida
     * @param tipo_medida
     * @return 
     */
    static public Progreso_Medida InstanciaActualizarMedida(int idUsuario, int medida, String tipo_medida){
        return new Progreso_Medida(idUsuario, medida, tipo_medida);
    }
    
    /**
     * Instancia del Progreso Medida a Eliminar
     * @param idUsuario
     * @param tipo_medida
     * @return 
     */
    static public Progreso_Medida InstanciaEliminarMedida(int idUsuario, String tipo_medida){
        return new Progreso_Medida(idUsuario, tipo_medida);
    }
    
    /**
     * Instancia del Progresi Medida para consultar medidas anuales
     * @param sobrenombre
     * @return 
     */
    static public Progreso_Medida InstanciaConsultarMedidasAnuales(String sobrenombre){
        return new Progreso_Medida(sobrenombre);
    } 
    
    // Fin de M04        

    

    
}
