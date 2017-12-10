package AccesoDatosLayer.BO2;

import Comun.Dominio.Entidad;
import Comun.Dominio.Instructor;
import java.util.ArrayList;

/**
 *
 * @author simon
 */
public interface IDaoInstructor {
    
    public ArrayList<Instructor> getInstructores();
    public Entidad eliminar( Entidad ent );
    public Entidad modificar( Entidad ent );
    public Entidad actualizar( Entidad ent );
}
