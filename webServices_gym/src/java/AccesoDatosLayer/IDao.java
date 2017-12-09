package AccesoDatosLayer;

import Comun.Dominio.Entidad;

/**
 *
 * @author Elberg
 */
public interface IDao {
    public Entidad eliminar(Entidad ent);
    public Entidad modificar(Entidad ent);
    public Entidad consultar(Entidad ent);
    public Entidad actualizar(Entidad ent);
}
