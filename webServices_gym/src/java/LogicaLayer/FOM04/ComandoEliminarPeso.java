/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FOM04;

import AccesoDatosLayer.FOM04Postgre.IDaoProgresoPeso;
import AccesoDatosLayer.FabricaAbstracta;
import LogicaLayer.Comando;

/**
 *
 * @author Leonardo
 */
public class ComandoEliminarPeso extends Comando {
    
    int _idUsuario;
    
    public ComandoEliminarPeso(int idUsuario){
        this._idUsuario = idUsuario;
    }

    @Override
    public void ejecutar() {
        FabricaAbstracta _fab = FabricaAbstracta.getFabrica(1);
        IDaoProgresoPeso _dao = _fab.instanciaDaoProgresoPeso();
        _dao.eliminar(_idUsuario);
    }
    
    
    
}
