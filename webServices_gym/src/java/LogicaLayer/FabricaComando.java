package LogicaLayer;

import Comun.Dominio.Entidad;
import Comun.Dominio.Instructor;
import Comun.Dominio.Usuario;
import LogicaLayer.BO2.ComandoGetEntrenadores;
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
    public static Comando CrearRegUsuario (Usuario usuario){
        return new IngresarUsuario(usuario);
    }
    
}
