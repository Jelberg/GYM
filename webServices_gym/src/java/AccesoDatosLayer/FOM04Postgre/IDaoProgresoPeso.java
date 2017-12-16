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
            
}
