/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer;

import AccesoDatosLayer.FOM04Postgre.IDaoMedida;
import AccesoDatosLayer.FOM04Postgre.IDaoProgresoPeso;
import AccesoDatosLayer.FabricaAbstracta;
import Comun.Dominio.Progreso_Medida;

/**
 *
 * @author Leonardo
 */
class ActualizarMedidaComando extends Comando {
    
    Progreso_Medida _progreso_medida;
    
    public ActualizarMedidaComando(Progreso_Medida progreso_Medida){
        this._progreso_medida = progreso_Medida;
    }
    
    @Override
    public void ejecutar(){
        FabricaAbstracta _fab = FabricaAbstracta.getFabrica(1);
        IDaoMedida _dao = _fab.instanciaDaoProgresoMedida();
        _dao.actualizar(_progreso_medida);
    }
    
}