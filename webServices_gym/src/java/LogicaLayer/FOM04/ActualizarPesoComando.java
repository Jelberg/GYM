/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FOM04;

import AccesoDatosLayer.FOM04Postgre.IDaoProgresoPeso;
import AccesoDatosLayer.FabricaAbstracta;
import Comun.Dominio.Comentario;
import Comun.Dominio.Progreso_Peso;
import LogicaLayer.Comando;

/**
 *
 * @author Leonardo
 */
public class ActualizarPesoComando extends Comando {

    Progreso_Peso _progresoPeso;
    
    public ActualizarPesoComando(Progreso_Peso progresoPeso){
        this._progresoPeso = progresoPeso;
    }
    
    @Override
    public void ejecutar() {
        FabricaAbstracta _fab = FabricaAbstracta.getFabrica(1);
        IDaoProgresoPeso _dao = _fab.instanciaDaoProgresoPeso();
        _dao.actualizar(_progresoPeso);
    }
    
}
