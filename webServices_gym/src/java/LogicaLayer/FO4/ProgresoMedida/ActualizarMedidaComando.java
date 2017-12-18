/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FO4.ProgresoMedida;

import AccesoDatosLayer.FOM04Postgre.IDaoProgresoMedida;
import AccesoDatosLayer.FOM04Postgre.IDaoProgresoPeso;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import Comun.Dominio.Progreso_Medida;
import LogicaLayer.Comando;

/**
 *
 * @author Leonardo
 */
public class ActualizarMedidaComando extends Comando {
    
    Progreso_Medida _progreso_medida;
    String _response;
    
    /**
     * Constructor del Progreso Medida a ser modificado
     * @param progreso_Medida 
     */
    public ActualizarMedidaComando(Progreso_Medida progreso_Medida){
        this._progreso_medida = progreso_Medida;
    }
    
    /**
     * Metedo que obtiene la respuesta recibida por la BD
     * @return La respuesta de la BD
     */
    public String getRespuesta(){
        return _response;
    }
    
    @Override
    public void ejecutar(){
        FabricaDaoPostgre _fab = 
                (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1);
        IDaoProgresoMedida _dao = _fab.getDaoProgresoMedida();
        _response = _dao.actualizarMedida(_progreso_medida);
    }
    
}