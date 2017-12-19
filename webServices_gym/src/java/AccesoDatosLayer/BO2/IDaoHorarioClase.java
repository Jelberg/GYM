/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.BO2;

import AccesoDatosLayer.IDao;
import Comun.Dominio.HorarioClase;
import Comun.Dominio.Entidad;
import java.util.ArrayList;

/**
 *
 * @author marvian
 */
public interface IDaoHorarioClase extends IDao {
    public ArrayList <HorarioClase> consultarHorarioClase();
    public Entidad insertar (Entidad ent);
    public Entidad modificar (Entidad ent);
    public Entidad eliminar (Entidad ent);
}
