package LogicaLayer.BO2;

import AccesoDatosLayer.BO2.IDaoInstructor;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import LogicaLayer.Comando;

/**
 *
 * @author simon
 */
public class CmdInactivarInstructor extends Comando {
    
    String _correo;
    
    public CmdInactivarInstructor (String correo){
        _correo = correo;
    }
    
    @Override
    public void ejecutar() {
        FabricaDaoPostgre fab = (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1);
        IDaoInstructor dao = fab.getDaoInstructor();
        dao.inactivar(_correo);
    }
}
