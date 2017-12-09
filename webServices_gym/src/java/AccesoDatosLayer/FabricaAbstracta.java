package AccesoDatosLayer;

import AccesoDatosLayer.BO2.IDaoInstructor;

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
    
    // Gets BO2
    public abstract IDaoInstructor getDaoInstructor();
}
