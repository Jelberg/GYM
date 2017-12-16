/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.BO2;

import AccesoDatosLayer.BO2.IDaoEntrenador;
import AccesoDatosLayer.FabricaAbstracta;
import Comun.Dominio.Entidad;
import LogicaLayer.Comando;

/**
 *
 * @author gilbert
 */
public class ComandoInsertarEntrenador extends Comando{
    private Entidad _entrenador;
    
    public ComandoInsertarEntrenador( Entidad entrenador ){
        this._entrenador = entrenador;
    }
    public Entidad getMensaje(){
        return _entrenador;
    }
    @Override
    public void ejecutar() {
        FabricaAbstracta fab = FabricaAbstracta.getFabrica(1);
        IDaoEntrenador dao = fab.instanciaDaoEntrenador();
        _entrenador = dao.insertar( _entrenador );
    }
    
}
