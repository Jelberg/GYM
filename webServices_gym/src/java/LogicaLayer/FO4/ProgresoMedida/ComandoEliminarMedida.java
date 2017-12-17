/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FO4.ProgresoMedida;

import AccesoDatosLayer.FOM04Postgre.IDaoProgresoMedida;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import Comun.Dominio.Progreso_Medida;
import LogicaLayer.Comando;

/**
 *
 * @author Leonardo
 */
public class ComandoEliminarMedida extends Comando {

    Progreso_Medida _progreso_medida;
    String _respuesta;
    
    /**
     * Constructor de Comando Progreso Elimianr Medida
     * @param progreso_medida 
     */
    public ComandoEliminarMedida(Progreso_Medida progreso_medida){
     this._progreso_medida = progreso_medida;
    }
    
    /**
     * Obtener la repuesta al eliminar la medida de la base de datos
     * @return 
     */
    public String obtenerRespuesta(){
        return _respuesta;
    }
    
    @Override
    public void ejecutar() {
        FabricaDaoPostgre _fab = (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1);
        IDaoProgresoMedida _dao = _fab.getDaoProgresoMedida();
        _respuesta = _dao.eliminarMedida(_progreso_medida);
    }
    
}