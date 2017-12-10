package LogicaLayer;

import Comun.Dominio.Entidad;
import Comun.Dominio.Instructor;
import LogicaLayer.BO2.ComandoGetEntrenadores;
import LogicaLayer.BO2.RegistrarInstructor;

/**
 *
 * @author Elberg
 */
public class FabricaComando {
    
    //Crear comando para registrar un instructor
    public Comando CrearRegInstructor (Instructor instructor){
        return new RegistrarInstructor(instructor);
    }
    public static ComandoGetEntrenadores instanciaCmdGetEntrenadores(){
        return new ComandoGetEntrenadores();
    }
    
}
