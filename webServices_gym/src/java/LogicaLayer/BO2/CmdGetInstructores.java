package LogicaLayer.BO2;

import AccesoDatosLayer.BO2.IDaoInstructor;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import Comun.Dominio.Instructor;
import LogicaLayer.Comando;
import java.util.ArrayList;

/**
 *
 * @author simon
 */
public class CmdGetInstructores extends Comando {
    
    private ArrayList<Instructor> _listaInstructores;
    
    public CmdGetInstructores(){}
    
    public ArrayList<Instructor> getInstructores(){
        return _listaInstructores;
    }
    
    @Override
    public void ejecutar() {
        FabricaDaoPostgre fab = (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1);
        IDaoInstructor dao = fab.getDaoInstructor();
        _listaInstructores = dao.getInstructores();
    }

}
