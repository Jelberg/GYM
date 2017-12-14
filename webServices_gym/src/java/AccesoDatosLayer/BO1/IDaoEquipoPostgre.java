/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.BO1;

import Comun.Dominio.Entidad;
import Comun.Dominio.Equipo;
import java.util.ArrayList;

/**
 *
 * @author Luis L
 */
public interface IDaoEquipoPostgre {
    public ArrayList<Equipo> consultarEquipos();
    public Entidad Eliminar (Entidad ent);
    public Entidad Agregar (Entidad ent);
    public Entidad Actualizar (Entidad ent);
    
}
