package LogicaLayer;

import Comun.Dominio.Instructor;
import Comun.Dominio.Usuario;
import LogicaLayer.BO2.ComandoGetEntrenadores;
import LogicaLayer.FO1.ComandoActualizarCodigo;
import LogicaLayer.FO1.ComandoActualizarPassword;
import LogicaLayer.FO1.ComandoGetCorreo;
import LogicaLayer.FO1.ComandoIniciarSesion;
import LogicaLayer.BO2.ComandoGetInstructores;
import LogicaLayer.BO2.ComandoRegistrarInstructor;
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
    
    
    // comandos FO1
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
}
