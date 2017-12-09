/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer;

import Comun.Dominio.Instructor;
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
    
}
