/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.FOM04Postgre;

import AccesoDatosLayer.IDao;
import Comun.Dominio.Entidad;
import Comun.Dominio.Progreso_Medida;
import java.util.ArrayList;

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
    
    /**
     * Firma de Metodo para actualizar medida
     * @param ent
     * @return 
     */
    public String actualizarMedida(Entidad ent);
    
    /**
     * Fima de Metodo para eliminar medida
     * @param ent
     * @return 
     */
    public String eliminarMedida(Entidad ent);
    
    /**
     * Firma de Metodo para consultar medidas anuales
     * @param progreso_Medida
     * @param fechaini
     * @param fechafin
     * @return 
     */
    public ArrayList<Progreso_Medida> getMedidasAnuales
        (Progreso_Medida progreso_Medida, String fechaini, String fechafin);
}
