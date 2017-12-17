package LogicaLayer;

import Comun.Dominio.Entidad;
import Comun.Dominio.Instructor;
import Comun.Dominio.Progreso_Peso;
import Comun.Dominio.Usuario;
import LogicaLayer.FO4.*;
import LogicaLayer.BO2.CmdActualizarInstructor;
import Comun.Dominio.Usuario_Amigo;
import LogicaLayer.BO2.ComandoConsultaEntrenadorCorreo;
import LogicaLayer.BO2.ComandoConsultaEntrenadores;
import LogicaLayer.BO2.ComandoConsultarClase;
import LogicaLayer.BO2.CmdGetInstructorPorCorreo;
import LogicaLayer.FO1.ComandoActualizarCodigo;
import LogicaLayer.FO1.ComandoActualizarPassword;
import LogicaLayer.FO1.ComandoGetCorreo;
import LogicaLayer.FO1.ComandoIniciarSesion;
import LogicaLayer.BO2.CmdGetInstructores;
import LogicaLayer.BO2.CmdRegistrarInstructor;
import LogicaLayer.FO1.ComandoEliminaUsuario;
import LogicaLayer.FO1.ComandoEliminaUsuario_Amigo;
import LogicaLayer.FO1.ComandoGetUsuario;
import LogicaLayer.FO1.ComandoGetUsuarioNomApe;
import LogicaLayer.FO1.ComandoInsertaUsuario_Amigo;
import LogicaLayer.FO1.ComandoListaUsuario;
import LogicaLayer.FO1.ComandoListaUsuario_Amigo;
import LogicaLayer.FO1.ComandoModificaUsuario;
import LogicaLayer.FO1.IngresarUsuario;
import LogicaLayer.BO1.ComandoGetEquipos;
import LogicaLayer.BO2.ComandoInsertarClase;
import LogicaLayer.BO2.ComandoInsertarEntrenador;
import LogicaLayer.BO2.ComandoModificarClase;

/**
 *
 * @author Elberg
 */
public class FabricaComando {
	
    // Comandos BO1    
	
    // Crear comando para leer lista de todos los equipos.
    public static ComandoGetEquipos instanciaGetEquipos(){
        return new ComandoGetEquipos();
    }

    // Fin Comandos BO1
    
    // Comandos BO2
    
    // Crear comando para registrar un instructor.
    public static Comando CrearRegInstructor (Instructor instructor){
        return new CmdRegistrarInstructor(instructor);
    }
    // Crear comando para leer lista de todos los instructores.
    public static CmdGetInstructores instanciaGetInstructores(){
        return new CmdGetInstructores();
    }
    
    // Crear comando para buscar un instructor dado su correo.
    public static CmdGetInstructorPorCorreo instanciaInstructorPorCorreo(String correo){
        return new CmdGetInstructorPorCorreo(correo);
    }
    
    // Crear comando para actualizar los datos de un instructor.
    public static CmdActualizarInstructor instanciaActualizarInstructor(
    String nombre, String apellido, String fecha, String sexo, String correo){
        return new CmdActualizarInstructor(
            nombre, apellido, fecha, sexo, correo);
    }

    /**
     * Metodo llamado para realizar la consulta de todas las clases.
     * @return Devuelve un comando para realizar la accion.
     */
    public static ComandoConsultarClase instanciaCmdConsultaClase(){
        return new ComandoConsultarClase();
    }
    
    /**
     * Metodo llamado para realizar el insert de una clase.
     * @return Devuelve un comando para realizar la accion.
     */
    public static ComandoInsertarClase instanciaCmdInsertaClase( Entidad ent){
        return new ComandoInsertarClase( ent );
    }
    
    /**
     * Metodo llamado para realizar la eliminacion de una clase.
     * @return Devuelve un comando para realizar la accion.
     */
    public static ComandoInsertarClase instanciaCmdEliminaClase( Entidad ent){
        return new ComandoInsertarClase( ent );
    }
    
    /**
     * Metodo llamado para realizar la modificacion de una clase.
     * @return Devuelve un comando para realizar la accion.
     */
    public static ComandoModificarClase instanciaCmdModificarClase( Entidad ent){
        return new ComandoModificarClase( ent );
    }
    
    /**
     * Metodo llamado para realizar la consulta de todos los entrenadores.
     * @return Devuelve un comando para realizar la accion.
     */
    public static ComandoConsultaEntrenadores instanciaCmdConsultaEntrenadores(){
        return new ComandoConsultaEntrenadores();
    }
    
    /**
     * Metodo llamado para realizar la consulta de un entrenador a traves de
     * su correo
     * @param ent Objeto de tipo Entidad en el cual esta encapsulado el correo
     * del entrenador
     * @return devuelve un comando para realizar la accion.
     */
    public static ComandoConsultaEntrenadorCorreo instanciaCmdConsultaEntCorreo( Entidad ent ){
        return new ComandoConsultaEntrenadorCorreo( ent );
    }
    /**
     * Metodo que crea un comando para realizar la insercion a base de datos.
     * @param ent
     * @return 
     */
    public static ComandoInsertarEntrenador instanciaCmdInsertarEntrenador( Entidad ent ){
        return new ComandoInsertarEntrenador( ent );
    }
    // Fin Comandos BO2
    
    // comandos FOM01
    //Crear comando para registrar un usuario
    public static IngresarUsuario CrearRegUsuario (Usuario usuario){
        return new IngresarUsuario(usuario);
    }
    
    public static ComandoIniciarSesion IniciarUsuario (Usuario usuario){
        return new ComandoIniciarSesion(usuario);
    }
    
    public static ComandoActualizarCodigo actualizarCodigo (Usuario usuario){
        return new ComandoActualizarCodigo(usuario);
    }
    
    public static ComandoActualizarPassword actualizarPassword (Usuario usuario){
        return new ComandoActualizarPassword(usuario);
    }
    
    public static ComandoGetCorreo getCorreo (Usuario usuario){
        return new ComandoGetCorreo(usuario);
    }
    
    //Comando para consultar un usuario por id.
    public static ComandoGetUsuario getUsuario (Usuario usuario){
        return new ComandoGetUsuario(usuario);
    }
    
    //Comando para consultar un usuario por nombre y apellido.
    public static ComandoGetUsuarioNomApe getUsuarioNomApe (Usuario usuario){
        return new ComandoGetUsuarioNomApe(usuario);
    }
    
    //Comando para modificar los datos de un usuario.
    public static ComandoModificaUsuario modificaUsuario (Usuario usuario){
        return new ComandoModificaUsuario(usuario);
    }
    
    //Comando para listar los usuarios.
    public static ComandoListaUsuario getListUsuario (){
        return new ComandoListaUsuario();
    }
    
    //Comando para eliminar un usuario.
    public static ComandoEliminaUsuario eliminaUsuario (String s){
        return new ComandoEliminaUsuario(s);
    }
    
    //Comando para agregar amigos.
    public static ComandoInsertaUsuario_Amigo insertaUsuario_Amigo (Usuario_Amigo usuarioa){
        return new ComandoInsertaUsuario_Amigo(usuarioa);
    }
    
    //Comando para eliminar amigos.
    public static ComandoEliminaUsuario_Amigo eliminaUsuario_Amigo (Usuario_Amigo usuarioa){
        return new ComandoEliminaUsuario_Amigo(usuarioa);
    }
    
    //Comando para listar los amigos.
    public static ComandoListaUsuario_Amigo getListUsuario_Amigo (Usuario u){
        return new ComandoListaUsuario_Amigo(u);
    }
    
    //Fin Comandos FOM01
    
    //INICIO F04
 
    /**
     * instancia del comando para agregar peso
     * @return Agregar
     */
    public static AgregarPesoComando instanciaCmdAgregarPeso (Entidad pp){
        return new AgregarPesoComando(pp);
    }
    
    /**
     * instancia del comando para consultar el progreso del peso
     * @param pp
     * @return 
     */
     public static ConsultarProgresoPesoComando instanciaCmdConsultarProgresoPeso (int pp){
        return new ConsultarProgresoPesoComando(pp);
    }
    
     /**
      * Instancia del comando para eliminar el peso
      * @param id
      * @return 
      */
     public static EliminarPesoComando instanciaCmdEliminarProgresoPeso (int id){
        return new EliminarPesoComando(id);
    }
     
     /**
      * instancia del comando para la actualizacion del peso del usuario
      * @param pp
      * @return 
      */
     public static ActualizarPesoComando instanciaCmdActializarProgresoPeso (Entidad pp){
        return new ActualizarPesoComando(pp);
    }
    //FIN F04

   
    
}
