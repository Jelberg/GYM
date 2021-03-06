package AccesoDatosLayer;

import AccesoDatosLayer.BO1.IDaoEjercicio;
import AccesoDatosLayer.BO1.IDaoEquipo;
import AccesoDatosLayer.BO1.IDaoMaquina;
import AccesoDatosLayer.BO2.IDaoClase;
import AccesoDatosLayer.BO2.IDaoEntrenador;
import AccesoDatosLayer.BO2.IDaoInstructor;
import AccesoDatosLayer.FO1.IDaoUsuario;
import AccesoDatosLayer.FO1.IDaoUsuarioAmigo;
import AccesoDatosLayer.BO2.IDaoHorarioClase;
import AccesoDatosLayer.FOM04Postgre.DaoComentario;
import AccesoDatosLayer.FOM04Postgre.IDaoComentario;
import AccesoDatosLayer.FOM04Postgre.DaoProgresoMedida;
import AccesoDatosLayer.FOM04Postgre.DaoProgresoPeso;
import AccesoDatosLayer.FOM04Postgre.IDaoProgresoPeso;


/**
 *
 * @author Elberg
 */
public abstract class FabricaAbstracta {
  
    public static FabricaAbstracta getFabrica(int tipo){
        
        switch(tipo){
            case 1: return new FabricaDaoPostgre(); 
          //case 2: return new FabricaDaoOracle();
          //case 3: return new FabricaDaoMySql();
        }
        return new FabricaDaoPostgre();
    }
    //Gets BO1
    public abstract IDaoEjercicio getDaoEjercicio();
    public abstract IDaoEquipo getDaoEquipo();
    public abstract IDaoMaquina getDaoMaquina();
    // Gets BO2
    public abstract IDaoInstructor getDaoInstructor();
    public abstract IDaoEntrenador instanciaDaoEntrenador();
    public abstract IDaoClase instanciaDaoClase();
    public abstract IDaoHorarioClase instaciaDaoHorarioClase(); 
    // gets FO1
    public abstract IDaoUsuario getDaoUsuario();
    public abstract IDaoUsuarioAmigo getDaoUsuarioAmigo();
    
    //Gets F04
   public abstract  DaoProgresoPeso getDaoProgresoPeso();
    public abstract DaoProgresoMedida getDaoProgresoMedida();
    public abstract DaoComentario instanciaDaoComentario();
    public abstract IDaoComentario getDaoComentario();
    public abstract IDaoProgresoPeso instanciaDaoProgresoPeso();
    public abstract DaoProgresoMedida instanciaDaoProgresoMedida();
}
