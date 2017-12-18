package LogicaLayer;


import Comun.Dominio.Comentario;
import Comun.Dominio.Entidad;
import Comun.Dominio.Equipo;
import Comun.Dominio.Instructor;
import Comun.Dominio.Progreso_Medida;
import Comun.Dominio.Progreso_Peso;
import Comun.Dominio.Usuario;
import Comun.Dominio.Usuario_Amigo;
import LogicaLayer.BO1.ComandoAddEquipo;
import LogicaLayer.BO1.ComandoAgregarEjercicio;
import LogicaLayer.BO1.ComandoEliminarEjercicio;
import LogicaLayer.BO1.ComandoEliminarEquipo;
import LogicaLayer.BO1.ComandoGetEjercicios;
import LogicaLayer.BO1.ComandoGetEquipoById;
import LogicaLayer.BO1.ComandoGetEquipos;
import LogicaLayer.BO1.ComandoModificarEjercicio;
import LogicaLayer.BO1.ComandoUpdateEquipo;
import LogicaLayer.BO2.CmdActivarInstructor;
import LogicaLayer.BO2.CmdActualizarInstructor;
import LogicaLayer.BO2.CmdGetInstructorPorCorreo;
import LogicaLayer.BO2.CmdGetInstructores;
import LogicaLayer.BO2.CmdInactivarInstructor;
import LogicaLayer.BO2.CmdRegistrarInstructor;
import LogicaLayer.BO2.ComandoBuscaClasePorId;
import LogicaLayer.BO2.ComandoClaseConsultaDescripcion;
import LogicaLayer.BO2.ComandoConsultaEntrenadorCorreo;
import LogicaLayer.BO2.ComandoConsultaEntrenadores;
import LogicaLayer.BO2.ComandoConsultarClase;
import LogicaLayer.BO2.ComandoEliminaEntrenador;
import LogicaLayer.BO2.ComandoInsertarClase;
import LogicaLayer.BO2.ComandoInsertarEntrenador;
import LogicaLayer.BO2.ComandoModificarClase;
import LogicaLayer.BO2.ComandoModificarEntrenador;
import LogicaLayer.F03.ConsultarEjerciciosRealizadosComando;
import LogicaLayer.F03.ConsultarEjerciciosRealizadosComando;
import LogicaLayer.FO1.ComandoActualizarCodigo;
import LogicaLayer.FO1.ComandoActualizarPassword;
import LogicaLayer.FO1.ComandoEliminaUsuario;
import LogicaLayer.FO1.ComandoEliminaUsuario_Amigo;
import LogicaLayer.FO1.ComandoGetCorreo;
import LogicaLayer.FO1.ComandoGetUsuario;
import LogicaLayer.FO1.ComandoGetUsuarioNomApe;
import LogicaLayer.FO1.ComandoIniciarSesion;
import LogicaLayer.FO1.ComandoInsertaUsuario_Amigo;
import LogicaLayer.FO1.ComandoListaUsuario;
import LogicaLayer.FO1.ComandoListaUsuario_Amigo;
import LogicaLayer.FO1.ComandoModificaUsuario;
import LogicaLayer.FO1.IngresarUsuario;
import LogicaLayer.FO4.*;
import LogicaLayer.FO4.Comentarios.AgregarComentarioComando;
import LogicaLayer.FO4.Comentarios.ComandoObtenerComentariosProgMedidas;
import LogicaLayer.FO4.Comentarios.CompartirProgresoComando;
import LogicaLayer.FO4.Comentarios.ConsultarComentarioProgresosComando;
import LogicaLayer.FO4.ProgresoMedida.ActualizarMedidaComando;
import LogicaLayer.FO4.ProgresoMedida.AgregarMedidaComando;
import LogicaLayer.FO4.ProgresoMedida.ComandoConsultarMedidasAnual;
import LogicaLayer.FO4.ProgresoMedida.ComandoEliminarMedida;
import LogicaLayer.FO4.ProgresoMedida.ConsultarProgesoMedidasComando;
import LogicaLayer.FO4.ProgresoPeso.ActualizarPesoComando;
import LogicaLayer.FO4.ProgresoPeso.AgregarPesoComando;
import LogicaLayer.FO4.ProgresoPeso.ConsultarProgresoPesoComando;
import LogicaLayer.FO4.ProgresoPeso.EliminarPesoComando;

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

    // Crear comando para agregar un equipo.
    public static ComandoAddEquipo instanciaAddEquipo ( Entidad ent ){
        return new ComandoAddEquipo( ent );
    }
    
    // Crear comando para eliminar un equipo.
    public static ComandoEliminarEquipo instanciaEliminarEquipo (Entidad ent){
        return new ComandoEliminarEquipo(ent);
    }
    
    // Crear comando para buscar un equipo dado su id.
    public static ComandoGetEquipoById instanciaGetEquipoById(int id){
        return new ComandoGetEquipoById(id);
    }
    
    // Crear comando para actualizar un equipo.
    public static ComandoUpdateEquipo instanciaUpdateEquipo(int id,
    String nombre){
        return new ComandoUpdateEquipo(id, nombre);
    }


    // Crear comando para leer lista de ejercicio.
    public static ComandoGetEjercicios instanciaGetEjercicios(){
        return new ComandoGetEjercicios();
    }
    
    // Crear comando para agregar un ejercicio

    public static ComandoAgregarEjercicio AgregarEjercicio (Entidad ent){
        return new ComandoAgregarEjercicio(ent);
    }
    
    //Crear comando para eliminar un ejercicio
    
    public static ComandoEliminarEjercicio EliminarEjercicio (Entidad ent){
        return new ComandoEliminarEjercicio(ent);
    }
    
    public static ComandoModificarEjercicio ModificarEjercicio (Entidad ent){
        return new ComandoModificarEjercicio(ent);        
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
    
    public static CmdActivarInstructor instanciaActivarInstructor(String correo){
        return new CmdActivarInstructor(correo);
    }
    
    public static CmdInactivarInstructor instanciaInactivarInstructor(String correo){
        return new CmdInactivarInstructor(correo);
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
     * Metodo llamado para realizar la modificacion de una clase.
     * @return Devuelve un comando para realizar la accion.
     */
    public static ComandoBuscaClasePorId instanciaCmdBuscaClasePorId(){
        return new ComandoBuscaClasePorId();
    }
    
    /**
     * Metodo llamado para realizar la modificacion de una clase.
     * @return Devuelve un comando para realizar la accion.
     */    
    public static ComandoClaseConsultaDescripcion instanciaCmdClaseConsultaDescripcion(){
        return new ComandoClaseConsultaDescripcion();
    }
    
    /**
     * Metodo llamado para realizar la consulta de todos los entrenadores.
     * @return Devuelve un comando para realizar la accion.
     */
    public static ComandoConsultaEntrenadores instanciaCmdConsultaEntrenadores(){
        return new ComandoConsultaEntrenadores();
    }
    public static ComandoEliminaEntrenador instanciaCmdEliminaEntrenador( Entidad ent){
        return new ComandoEliminaEntrenador( ent );
    }
    /**
     * Metodo que es llamado cuando se necesita una instancia del comando para
     * realizar actualizaciones a un entrenador.
     * @param entrenador Recibe un objeto Entidad en el cual estan encapsulados
     * los datos del entrenador.
     * @return Devuelve el comando con los datos necesarios para realizar los llamados.
     * @see Entidad
     * @see ComandoModificarEntrenador
     */
    public static ComandoModificarEntrenador instanciaCmdModificarEntrenador( Entidad entrenador){
        return new ComandoModificarEntrenador( entrenador );
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
     

     /**
      * Instancia del comando Consultar progreso de medidas
      * @param id
      * @return 
      */
     public static ConsultarProgesoMedidasComando instanciaCmdConsutaProgresoMedidas (int id){
         return new ConsultarProgesoMedidasComando(id);
     }
     
     /**
      * Instancia Comando agregar media
      * @param en
      * @return 
      */
     public static AgregarMedidaComando instanciaCmdAgregarMedida (Entidad en){
         return new AgregarMedidaComando(en);
     }

     /**
      * Instancia del comando para los comentarios
      * @param comentario
      * @return 
      */
     public static AgregarComentarioComando insertarComentarioComando(Comentario comentario){
         return new AgregarComentarioComando(comentario);
     }
     

    /**
     * Instancia del Comando Agregar Medida

     * @param progreso_Medida
     * @return 
     */
    public static AgregarMedidaComando instanciaCmdAgregarMedida (Progreso_Medida progreso_Medida){
        return new AgregarMedidaComando(progreso_Medida);
    }
    
    /**
     * Instncia del Comando Compartir Progreso
     * @return 
     */
    public static CompartirProgresoComando instanciaCmdCompartirProgreso (){
        return new CompartirProgresoComando();
    }
    
    /**
     * Instancia del Comando Consultar Progreso Medidas
     * @param id
     * @return 
     */
    public static ConsultarProgesoMedidasComando instanciaCmdConsultarProgresoMedidas (int id){
        return new ConsultarProgesoMedidasComando(id);
    }
    
    /**
     * Instancia del Comando Actualizar Medidas
     * @param progreso_Medida
     * @return 
     */
    public static ActualizarMedidaComando instanciaCmdActualizarMedidas (Progreso_Medida progreso_Medida){
        return new ActualizarMedidaComando(progreso_Medida);
    }
    
    /**
     * Instancia de la consulta comentario Progresos comenado 
     * @param id
     * @return 
     */
    public static ConsultarComentarioProgresosComando instanciaCmdGetComentarioProgresos(int id){
        return new ConsultarComentarioProgresosComando(id);
    }

    /** Instancia del Comando Obtener Comentarios Progreso medida
     * @param idUsuario
     * @param idProgresoMedida
     * @return 
     */
    public static ComandoObtenerComentariosProgMedidas instanciaObtenerComentariosProgMedida
        (int idUsuario, int idProgresoMedida){
        return new ComandoObtenerComentariosProgMedidas(idUsuario, idProgresoMedida);
    }
        
    /**
     * Instancia del Comando para Eliminar Medida
     * @param progreso_Medida
     * @return 
     */    
    public static ComandoEliminarMedida instanciaEliminarMedida(Progreso_Medida progreso_Medida){
      return new ComandoEliminarMedida(progreso_Medida);
    }
    
    /**
     * Instancia del Comando Consultar Medidas Anuales
     * @param progreso_Medida
     * @return 
     */
    public static ComandoConsultarMedidasAnual instanciaObtenerMedidasAnual
        (Progreso_Medida progreso_Medida){
        return new ComandoConsultarMedidasAnual(progreso_Medida);
    }

    //FIN F04

   

   
    
}
