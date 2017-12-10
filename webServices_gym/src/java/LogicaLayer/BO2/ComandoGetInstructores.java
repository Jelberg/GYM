package LogicaLayer.BO2;

import Comun.Dominio.Entidad;
import Comun.Dominio.Instructor;
import LogicaLayer.Comando;
import java.util.ArrayList;

/**
 *
 * @author simon
 */
public class ComandoGetInstructores extends Comando {
    
    private Entidad _instructores;
    private ArrayList<Instructor> _listaInstructores;
    
    public ArrayList<Instructor> getInstructores(){
        return _listaInstructores;
    }
    
    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
