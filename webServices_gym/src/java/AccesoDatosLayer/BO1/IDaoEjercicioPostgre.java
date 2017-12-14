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
 * @author Luis L
 */
public interface IDaoEjercicioPostgre {
    public ArrayList<Ejercicio> verEjercicios();
    public Entidad Agregar (Entidad ent);
    public Entidad Modificar (Entidad ent);
    public Entidad Eliminar (Entidad ent);
}
