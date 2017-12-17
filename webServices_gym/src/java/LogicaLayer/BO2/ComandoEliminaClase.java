/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.BO2;

import AccesoDatosLayer.BO2.IDaoClase;
import AccesoDatosLayer.FabricaAbstracta;
import Comun.Dominio.Entidad;
import LogicaLayer.Comando;

/**
 *
 * @author marvian
 */
public class ComandoEliminaClase extends Comando {
    private Entidad _clase;
    
    /**
     * Constructor de clase.
     * @param classe Recibe un objeto Entidad con los datos de la clase
     * a eliminar.
     * @see Entidad.
     */
    public ComandoEliminaClase( Entidad clase ){
        this._clase = clase;
    }
    /**
     * Metodo para obtener el mensaje que indica el estatus de la peticion.
     * @return Devuelve un objeto Entidad en el cual se encuentra encapsulado
     * el mensaje dele estatus.
     */
    public Entidad getMensaje(){
        return _clase;
    }
    /**
     * Metodo que es llamado para realizar la eliminacion de la clase.
     */
    
    public void ejecutar() {
        FabricaAbstracta fab = FabricaAbstracta.getFabrica(1);
        IDaoClase dao = fab.instanciaDaoClase();
        _clase = dao.insertar( _clase );
    }
    
}
