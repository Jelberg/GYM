package LogicaLayer;

import Comun.Dominio.Instructor;
import Comun.Dominio.Usuario;
import LogicaLayer.BO2.RegistrarInstructor;
import LogicaLayer.FO1.IngresarUsuario;

/**
 *
 * @author Elberg
 */
public class FabricaComando {
    
    //Crear comando para registrar un instructor
    public Comando CrearRegInstructor (Instructor instructor){
        return new RegistrarInstructor(instructor);
    }
    
    
    // comandos FO1
    //Crear comando para registrar un usuario
    public Comando CrearRegUsuario (Usuario usuario){
        return new IngresarUsuario(usuario);
    }
    
}
