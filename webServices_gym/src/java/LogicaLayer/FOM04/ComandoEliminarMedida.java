/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FOM04;

import AccesoDatosLayer.FOM04Postgre.IDaoMedida;
import AccesoDatosLayer.FabricaAbstracta;
import Comun.Dominio.Progreso_Medida;
import LogicaLayer.Comando;

/**
 *
 * @author Leonardo
 */
public class ComandoEliminarMedida extends Comando {

    Progreso_Medida _progreso_medida;
    
    public ComandoEliminarMedida(Progreso_Medida progreso_medida){
     this._progreso_medida = progreso_medida;
    }
    
    @Override
    public void ejecutar() {
        FabricaAbstracta _fab = FabricaAbstracta.getFabrica(1);
        IDaoMedida _dao = _fab.instanciaDaoProgresoMedida();
        _dao.eliminar(_progreso_medida);
    }
    
}
