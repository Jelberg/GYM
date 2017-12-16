package AccesoDatosLayer.BO2;

import AccesoDatosLayer.IDao;
import Comun.Dominio.Entidad;
import Comun.Dominio.Instructor;
import java.util.ArrayList;

/**
 *
 * @author simon
 */
public interface IDaoInstructor extends IDao {
    
    public ArrayList<Instructor> getInstructores();
    public ArrayList<Instructor> getInstructorPorCorreo(String correo);
    public void insertar (Instructor i);
    public void eliminar( String correo );
    public void actualizar(String nombre, String apellido, String fecha, String sexo, String correo);
}
