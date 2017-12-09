package AccesoDatosLayer;

import AccesoDatosLayer.BO2.DaoInstructorPostgre;
import AccesoDatosLayer.BO2.IDaoInstructor;

/**
 *
 * @author Elberg
 */
public class FabricaDaoPostgre extends FabricaAbstracta {

    // Inicio Daos BO2
    public IDaoInstructor getDaoInstructor(){
        return new DaoInstructorPostgre();
    }
    // Fin Daos BO2
}
