package AccesoDatosLayer;

import AccesoDatosLayer.BO2.DaoEntrenadorPostgre;
import AccesoDatosLayer.BO2.DaoInstructorPostgre;
import AccesoDatosLayer.BO2.IDaoInstructor;
import AccesoDatosLayer.FO1.DaoUsuarioAmigoPostgre;
import AccesoDatosLayer.FO1.DaoUsuarioPostgre;
import AccesoDatosLayer.FO1.IDaoUsuario;
import AccesoDatosLayer.FO1.IDaoUsuarioAmigo;

/**
 *
 * @author Elberg
 */
public class FabricaDaoPostgre extends FabricaAbstracta {
    public FabricaDaoPostgre(){}
    // Inicio Daos BO2
    @Override
    public IDaoInstructor getDaoInstructor(){
        return new DaoInstructorPostgre();
    }
    /**
     * 
     * @return Retorna objeto del tipo DaoEntrenador.
     */
    public DaoEntrenadorPostgre instanciaDaoEntrenador(){
        return new DaoEntrenadorPostgre();
    }
    // Fin Daos BO2
    
    // Inicio Daos FO1
    @Override
    public IDaoUsuario getDaoUsuario(){
        return new DaoUsuarioPostgre();
    }
    
    @Override
    public IDaoUsuarioAmigo getDaoUsuarioAmigo() {
        return new DaoUsuarioAmigoPostgre();
    }
    // Fin Daos F01

    
}
