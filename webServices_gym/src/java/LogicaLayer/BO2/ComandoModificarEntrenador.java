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
 * Clase a traves de la cual se realizan los llamados para modificar a un 
 * entrenador.
 * @author gilbert
 */
public class ComandoModificarEntrenador extends Comando{
    private Entidad _entrenador;
    /**
     * Constructor de clase que recibe un objeto Entidad, a traves del cual
     * se realizara la actualizacion de los datos.
     * @param entrenador Objeto que posee los datos encapsulados.
     * @see Entidad
     */
    public ComandoModificarEntrenador( Entidad entrenador ){
        this._entrenador = entrenador;
    }
    public ComandoModificarEntrenador(){}
    public Entidad getMensaje(){
        return _entrenador;
    }
    /**
     * Metodo mediante el cual se realizan los llamaos para realizar la accion.
     */
    @Override
    public void ejecutar() {
        FabricaAbstracta fab = FabricaAbstracta.getFabrica(1);
        IDaoEntrenador dao = fab.instanciaDaoEntrenador();
        _entrenador = dao.modificar( _entrenador );
    }
}
