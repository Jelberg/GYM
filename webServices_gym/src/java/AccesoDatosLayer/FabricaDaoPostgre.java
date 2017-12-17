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
import AccesoDatosLayer.FOM04Postgre.DaoComentario;
import AccesoDatosLayer.FOM04Postgre.DaoMedida;
import AccesoDatosLayer.BO2.IDaoEntrenador;

import AccesoDatosLayer.FO3.DaoRutina;

import AccesoDatosLayer.FOM04Postgre.DaoProgresoMedida;
import AccesoDatosLayer.FOM04Postgre.DaoProgresoPeso;
import AccesoDatosLayer.FOM04Postgre.IDaoComentario;
import AccesoDatosLayer.FOM04Postgre.IDaoMedida;
import AccesoDatosLayer.FOM04Postgre.IDaoProgresoPeso;


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
    
    
    public DaoClasePostgre instanciaDaoClase(){
        return new DaoClasePostgre();
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
    @Override
    public DaoProgresoPeso getDaoProgresoPeso(){
        return new DaoProgresoPeso();
    }


   /* @Override
    public IDaoComentario getDaoComentario() {
        return new DaoComentario();
    }
    */
    @Override
     public IDaoProgresoPeso instanciaDaoProgresoPeso() {
         return new DaoProgresoPeso();
     }

     
    @Override
    public IDaoMedida instanciaDaoProgresoMedida() {
        return new DaoMedida();
    }
    
    @Override
    public DaoProgresoMedida getDaoProgresoMedida(){
        return new DaoProgresoMedida();
    }
    //FIN FO4

    public DaoRutina getDaoRutina() {
        return new DaoRutina();
    }

    

    

    
}
