package AccesoDatosLayer;
import AccesoDatosLayer.BO1.IDaoEjercicio;
import AccesoDatosLayer.BO1.IDaoEquipo;
import AccesoDatosLayer.BO1.IDaoMaquina;
import AccesoDatosLayer.BO2.IDaoEntrenador;
import AccesoDatosLayer.BO2.IDaoInstructor;
import AccesoDatosLayer.FO1.IDaoUsuario;
import AccesoDatosLayer.FO1.IDaoUsuarioAmigo;

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
    // gets FO1
    public abstract IDaoUsuario getDaoUsuario();
    public abstract IDaoUsuarioAmigo getDaoUsuarioAmigo();
}
