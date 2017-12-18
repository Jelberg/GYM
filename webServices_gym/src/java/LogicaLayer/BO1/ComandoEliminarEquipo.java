/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.BO1;

import AccesoDatosLayer.BO1.IDaoEquipo;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import Comun.Dominio.Entidad;
import LogicaLayer.Comando;

/**
 *
 * @author Daniel Goncalves
 */
public class ComandoEliminarEquipo extends Comando{
    private Entidad _equipo;
   
    /**
     * Builder
     */
    public ComandoEliminarEquipo() {}
    
    public ComandoEliminarEquipo (int id, String nombre){
        _equipo.setId(id);
        _equipo.setMensaje(nombre);
    }
    
        public Entidad getMensaje(){
        return _equipo;
    }
        
    public ComandoEliminarEquipo (Entidad ent){
        _equipo.setId(ent.getId());
        _equipo.setMensaje(ent.getMensaje());
    }
    
    /**
     * Comando para eliminar equipos
     * @return equipo eliminado
     */
    public Entidad eliminarEquipo(int id, String nombre){
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
        _equipo = dao.eliminar(_equipo);
    }

}
