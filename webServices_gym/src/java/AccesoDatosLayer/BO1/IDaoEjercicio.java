/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.BO1;

import Comun.Dominio.Entidad;
import Comun.Dominio.Ejercicio;
import java.util.ArrayList;

/**
 *
 * @author  Luis L
 */
public interface IDaoEjercicio {
    public ArrayList<Ejercicio> consultarEjercicios();
    public Entidad eliminar( Entidad ent );
    public Entidad modificar( Entidad ent );
    public Entidad agregar( Entidad ent );
    public Entidad consultarID (int id);
    
    
}
