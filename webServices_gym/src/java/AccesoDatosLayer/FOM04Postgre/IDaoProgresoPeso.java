/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.FOM04Postgre;

import AccesoDatosLayer.IDao;
import Comun.Dominio.Entidad;


/**
 *
 * @author Elberg
 */
public interface IDaoProgresoPeso extends IDao{
    
    /**
     * Metod que retorna una lista de entidades que seran del tipo progreso peso
     * @param idusuario
     * @return 
     */
    public String consultarProgresoPeso(int idusuario);
    
    /**
     * Metodo para agregar el peso
     * @param pp
     * @return 
     */
    public String agregarPeso(Entidad pp);
            
    /**
     * Firma de metodo para eliminar el peso del usuario en base al id del mismo
     * @param id_usuario
     * @return 
     */
    public String eliminarPeso (int id_usuario);
    
    /**
     * Firma de metodo para actualizar el peso
     * @param en
     * @return 
     */
    public String actualizarPeso(Entidad en);
}
