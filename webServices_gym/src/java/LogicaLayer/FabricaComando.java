package LogicaLayer;

import Comun.Dominio.Entidad;
import Comun.Dominio.Instructor;
import Comun.Dominio.Usuario;
import Comun.Dominio.Usuario_Amigo;
import LogicaLayer.BO2.ComandoGetEntrenadores;
//import LogicaLayer.BO2.RegistrarInstructor;
import LogicaLayer.FO1.ComandoActualizarCodigo;
import LogicaLayer.FO1.ComandoActualizarPassword;
import LogicaLayer.FO1.ComandoGetCorreo;
import LogicaLayer.FO1.ComandoIniciarSesion;
import LogicaLayer.BO2.ComandoGetInstructores;
import LogicaLayer.BO2.ComandoRegistrarInstructor;
import LogicaLayer.FO1.ComandoEliminaUsuario;
import LogicaLayer.FO1.ComandoEliminaUsuario_Amigo;
import LogicaLayer.FO1.ComandoGetUsuario;
import LogicaLayer.FO1.ComandoGetUsuarioNomApe;
import LogicaLayer.FO1.ComandoInsertaUsuario_Amigo;
import LogicaLayer.FO1.ComandoListaUsuario;
import LogicaLayer.FO1.ComandoListaUsuario_Amigo;
import LogicaLayer.FO1.ComandoModificaUsuario;
import LogicaLayer.FO1.IngresarUsuario;

/**
 *
 * @author Elberg
 */
public class FabricaComando {
    
    // Comandos BO2
    
    //Crear comando para registrar un instructor
    public static Comando CrearRegInstructor (Instructor instructor){
        return new ComandoRegistrarInstructor(instructor);
    }
    
    public static ComandoGetInstructores instanciaGetInstructores(){
        return new ComandoGetInstructores();
    }
    
    public static ComandoGetEntrenadores instanciaCmdGetEntrenadores(){
        return new ComandoGetEntrenadores();
    }
    
    
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
    
}
