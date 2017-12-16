/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.BO2;

import AccesoDatosLayer.IDao;
import java.util.ArrayList;
import Comun.Dominio.Clase;
import Comun.Dominio.Entidad;

/**
 *
 * @author marvian
 */
public interface IDaoClase extends IDao {
    
    public ArrayList <Clase> consultarClases();
    public Entidad insertar (Entidad ent);
    public Entidad modificar (Entidad ent);
    public Entidad eliminar (Entidad ent);
    
}
