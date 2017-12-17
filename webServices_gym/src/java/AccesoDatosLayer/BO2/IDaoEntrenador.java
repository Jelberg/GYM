/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.BO2;

import AccesoDatosLayer.IDao;
import Comun.Dominio.Entidad;
import Comun.Dominio.Entrenador;
import java.util.ArrayList;

/**
 *
 * @author gilbert
 */
public interface IDaoEntrenador extends IDao{
    public ArrayList<Entrenador> consultarEntrenadores();
    public Entidad eliminar( Entidad ent );
    public Entidad modificar( Entidad ent );
    public Entidad insertar( Entidad ent );
    
}
