package AccesoDatosLayer;

import AccesoDatosLayer.BO2.DaoEntrenadorPostgre;
import AccesoDatosLayer.BO2.DaoInstructorPostgre;
import AccesoDatosLayer.BO2.IDaoInstructor;
import AccesoDatosLayer.FO1.DaoUsuarioAmigoPostgre;
import AccesoDatosLayer.FO1.DaoUsuarioPostgre;
import AccesoDatosLayer.FO1.IDaoUsuario;
import AccesoDatosLayer.FO1.IDaoUsuarioAmigo;
import AccesoDatosLayer.BO1.DaoEquipoPostgre;
import AccesoDatosLayer.BO1.DaoEjercicioPostgre;
import AccesoDatosLayer.BO1.DaoMaquinaPostgre;
import AccesoDatosLayer.BO1.IDaoEquipo;
import AccesoDatosLayer.BO1.IDaoEjercicio;
import AccesoDatosLayer.BO1.IDaoMaquina;

/**
 *
 * @author Elberg
 */
public class FabricaDaoPostgre extends FabricaAbstracta {
    public FabricaDaoPostgre(){}
	
	// Inicio Daos BO1
	@Override
	public IDaoEquipo getDaoEquipo(){
        return new DaoEquipoPostgre();
        }
	public IDaoEjercicio getDaoEjercicio(){
		return new DaoEjercicioPostgre();
	}
	public IDaoMaquina getDaoMaquina(){
		return new DaoMaquinaPostgre();
	}
	// Fin Daos BO1
    
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
