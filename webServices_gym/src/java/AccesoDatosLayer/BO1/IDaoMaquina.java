/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.BO1;

import Comun.Dominio.Entidad;
import Comun.Dominio.Maquina;
import java.util.ArrayList;

/**
 *
 * @author Daniel Goncalves
 */
public interface IDaoMaquina {
    public ArrayList<Maquina> getMaquinas();
    public Entidad eliminar( Entidad ent );
    public Entidad modificar( Entidad ent );
    public Entidad actualizar( Entidad ent );
    
}
