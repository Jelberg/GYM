/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FO4;

import LogicaLayer.Comando;



/**
 *
 * @author Leonardo
 */
public class ConsultarProgresoMedidasComando extends Comando {
     
     int _idUsuario;
     
     public ConsultarProgresoMedidasComando(int idUsuario){
         _idUsuario = idUsuario;
     }
    
    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
