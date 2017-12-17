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
public interface IDaoProgresoMedida extends IDao {
    
    /**
     * Metodo para consultar medidas del usuario
     * @param id
     * @return String convertido en json
     */
    public String consultarMedidas (int id);
    
    
    /**
     * Firma de metodo para agregar la medida del usuario
     * @param ent
     * @return 
     */
    public String agregarMedida(Entidad ent);
}
