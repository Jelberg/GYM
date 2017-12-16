package LogicaLayer.BO2;

import AccesoDatosLayer.BO2.IDaoInstructor;
import AccesoDatosLayer.FabricaAbstracta;
import Comun.Dominio.Instructor;
import LogicaLayer.Comando;

/**
 *
 * @author simon
 */
public class CmdRegistrarInstructor extends Comando {

    Instructor instructor;
        
    public CmdRegistrarInstructor (Instructor instructor){
        this.instructor = instructor;
    }
    
    @Override
    public void ejecutar() {
        FabricaAbstracta fab = FabricaAbstracta.getFabrica(1);
        IDaoInstructor dao = fab.getDaoInstructor();
        dao.insertar(instructor);
    }

}
