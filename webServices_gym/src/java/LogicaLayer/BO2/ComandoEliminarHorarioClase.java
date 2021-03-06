/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.BO2;

import AccesoDatosLayer.BO2.IDaoHorarioClase;
import AccesoDatosLayer.FabricaAbstracta;
import Comun.Dominio.Entidad;
import LogicaLayer.Comando;

/**
 *
 * @author marvian
 */
public class ComandoEliminarHorarioClase extends Comando {
    private Entidad _horarioClase;
    
    /**
     * Constructor de clase.
     * @param horarioClase Recibe un objeto Entidad con los datos del horarioclase
     * a insertar.
 
     */
    public ComandoEliminarHorarioClase( Entidad horarioClase ){
        this._horarioClase = horarioClase;
    }
    /**
     * Metodo para obtener el mensaje que indica el estatus de la peticion.
     * @return Devuelve un objeto Entidad en el cual se encuentra encapsulado
     * el mensaje dele estatus.
     */
    public Entidad getMensaje(){
        return _horarioClase;
    }
    /**
     * Metodo que es llamado para realizar la insercion del horarioclase.
     */
    
    public void ejecutar() {
        FabricaAbstracta fab = FabricaAbstracta.getFabrica(1);
        IDaoHorarioClase dao = fab.instaciaDaoHorarioClase();
        _horarioClase = dao.eliminar(_horarioClase );
    }
    
}
