/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.BO2;

import Comun.Dominio.Entidad;
import LogicaLayer.Comando;

/**
 *
 * @author simon
 */
public class RegistrarInstructor extends Comando {

    Entidad instructor;
        
    public RegistrarInstructor (Entidad instructor){
        this.instructor = instructor;
    }
    
    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
