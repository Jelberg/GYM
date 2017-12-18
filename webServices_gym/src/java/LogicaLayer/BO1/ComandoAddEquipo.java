/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.BO1;

import AccesoDatosLayer.BO1.IDaoEquipo;
import AccesoDatosLayer.DaoPostgre;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import Comun.Dominio.Entidad;
import Comun.Dominio.Equipo;
import LogicaLayer.Comando;
import java.util.ArrayList;

/**
 *
 * @author Daniel Goncalves
 */
public class ComandoAddEquipo extends Comando{
    private Entidad _equipo;
   
    /**
     * Builder
     */
    public ComandoAddEquipo() {}

    public ComandoAddEquipo ( Entidad equipo ){
        this._equipo = equipo;
    }
    
    public ComandoAddEquipo (int id, String nombre){
        _equipo.setId(id);
        _equipo.setMensaje(nombre);
    }
    
    public Entidad getMensaje(){
        return _equipo;
    }
    
    /**
     * Comando para agregar equipos
     * @return entidad con msj resultado
     */
    public Entidad addEquipo(int id, String nombre){
        _equipo.setId(id);
        _equipo.setMensaje(nombre);
        return _equipo;
    }
    
    /**
     * Metodo Ejecucion Comando
     */
    @Override
    public void ejecutar() {
        FabricaDaoPostgre fab = (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1);
        IDaoEquipo dao = fab.getDaoEquipo();
        _equipo = dao.agregar(_equipo);
    }

}
