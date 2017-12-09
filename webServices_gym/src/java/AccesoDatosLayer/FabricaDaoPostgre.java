package AccesoDatosLayer;

import AccesoDatosLayer.BO2.DaoInstructorPostgre;
import AccesoDatosLayer.BO2.IDaoInstructor;
import AccesoDatosLayer.FO1.DaoUsuarioPostgre;
import AccesoDatosLayer.FO1.IDaoUsuario;

/**
 *
 * @author Elberg
 */
public class FabricaDaoPostgre extends FabricaAbstracta {

    // Inicio Daos BO2
    @Override
    public IDaoInstructor getDaoInstructor(){
        return new DaoInstructorPostgre();
    }
    // Fin Daos BO2
    
    // Inicio Daos FO1
    @Override
    public IDaoUsuario getDaoUsuario(){
        return new DaoUsuarioPostgre();
    }
    // Fin Daos F01
}
