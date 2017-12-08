/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.BO2;

import LogicaLayer.Comando;

/**
 *
 * @author simon
 */
public class RegistrarInstructor extends Comando {

    String nombre, apellido, fechanac, sexo, correo;
    
    public RegistrarInstructor (String nombre, String apellido,
                                String fechanac, String sexo,
                                String correo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechanac = fechanac;
        this.sexo = sexo;
        this.correo = correo;
    }
    
    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
