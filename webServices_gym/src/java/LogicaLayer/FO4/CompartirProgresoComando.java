/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FO4;

import Comun.Util.ConfigurarLogger;
import LogicaLayer.Comando;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Leonardo
 */
public class CompartirProgresoComando extends Comando {
    
    ConfigurarLogger _cl;
    Logger _logger;
    
    public CompartirProgresoComando(){
         _cl = new ConfigurarLogger();
         _logger = _cl.getLogr();
     }
    
    @Override
    public void ejecutar() {
        _logger.log(Level.INFO, "Comando aun no Funcional");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}