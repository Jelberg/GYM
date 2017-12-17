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
 * Clase a traves de la cual se realizan los llamados necesarios para eliminar
 * a un entrenador.
 * @author gilbert
 */
public class ComandoEliminaEntrenador extends Comando{
    private Entidad _entrenador;
    /**
     * Constructor de clase con objeto entidad.
     * @param entrenador Objeto de tipo entidad en el cual se encuentran 
     * encapsulados los datos necesarios para eliminar a un entrenador.
     */
    public ComandoEliminaEntrenador( Entidad entrenador ){
        this._entrenador = entrenador;
    }
    public Entidad getMensaje(){
        return _entrenador;
    }

    @Override
    public void ejecutar() {
        FabricaAbstracta fab = FabricaAbstracta.getFabrica(1);
        IDaoEntrenador dao = fab.instanciaDaoEntrenador();
        _entrenador = dao.eliminar( _entrenador );
    }
    
    
}
