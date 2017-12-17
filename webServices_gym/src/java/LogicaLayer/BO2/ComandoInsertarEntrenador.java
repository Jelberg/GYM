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
 * Clase a traves de la cual se realizan las inserciones de entrenadores.
 * @author gilbert
 */
public class ComandoInsertarEntrenador extends Comando{
    private Entidad _entrenador;
    
    /**
     * Constructor de clase.
     * @param entrenador Recibe un objeto Entidad con los datos del entrenador
     * a insertar.
     * @see Entidad.
     */
    public ComandoInsertarEntrenador( Entidad entrenador ){
        this._entrenador = entrenador;
    }
    /**
     * Metodo para obtener el mensaje que indica el estatus de la peticion.
     * @return Devuelve un objeto Entidad en el cual se encuentra encapsulado
     * el mensaje dele estatus.
     */
    public Entidad getMensaje(){
        return _entrenador;
    }
    /**
     * Metodo que es llamado para realizar la insercion del entrenador.
     */
    @Override
    public void ejecutar() {
        FabricaAbstracta fab = FabricaAbstracta.getFabrica(1);
        IDaoEntrenador dao = fab.instanciaDaoEntrenador();
        _entrenador = dao.insertar( _entrenador );
    }
    
}
