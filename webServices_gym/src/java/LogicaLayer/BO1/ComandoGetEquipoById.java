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
import Comun.Dominio.Equipo;
import LogicaLayer.Comando;
import java.util.ArrayList;

/**
 *
 * @author Daniel Goncalves
 */
public class ComandoGetEquipoById extends Comando{
    private Entidad _equipo;
    
    /**
     * Builder
     */
    public ComandoGetEquipoById() {}
    
        /**
     * Builder
     */
    public ComandoGetEquipoById(Entidad ent) {
        _equipo.setId(ent.getId());
        _equipo.setMensaje(ent.getMensaje());
    }
    
        public Entidad ComandoGetEquipoById(int id) {
        _equipo.setId(id);
        return _equipo;
    }
        
    public  ComandoGetEquipoById(int id) {
        _equipo.setId(id);

    }
    
    
    /**
     * Comando para traer equipo por ID
     * @return equipo
     */
    public Entidad getEquipos(){
        return _equipo;
    }
    
    /**
     * Metodo Ejecucion Comando
     */
    @Override
    public void ejecutar() {
        FabricaDaoPostgre fab = (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1);
        IDaoEquipo dao = fab.getDaoEquipo();
        _equipo = dao.consultarEquipoPorId(_equipo.getId());
    }
    
}
