package AccesoDatosLayer;

import AccesoDatosLayer.BO2.DaoClasePostgre;
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
import AccesoDatosLayer.BO2.DaoHorarioClasePostgre;
import AccesoDatosLayer.BO2.IDaoClase;
import AccesoDatosLayer.BO2.IDaoEntrenador;
import AccesoDatosLayer.FOM04Postgre.DaoProgresoPeso;
import AccesoDatosLayer.FOM04Postgre.IDaoProgresoPeso;
import AccesoDatosLayer.BO2.IDaoHorarioClase;


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
    @Override
    public IDaoEntrenador instanciaDaoEntrenador(){
        return new DaoEntrenadorPostgre();
    }
    
    /**
     * 
     * @return Retorna objeto del tipo DaoClase.
     */
    public IDaoClase instanciaDaoClase(){
        return new DaoClasePostgre();
    }
    
    /**
     * 
     * @return Retorna objeto del tipo DaoHorarioClase.
     */
    @Override
    public IDaoHorarioClase instaciaDaoHorarioClase(){
        return new DaoHorarioClasePostgre();
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

    //INICIO FO4
    public DaoProgresoPeso getDaoProgresoPeso(){
        return new DaoProgresoPeso();
    }

    
    //FIN FO4

    

    
}
