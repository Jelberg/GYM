/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
