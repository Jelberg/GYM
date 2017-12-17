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
public class ComandoGetEquipoById extends Comando{
    private Entidad _equipo;
    private int _id;
   
    /**
     * Builder
     */
    public ComandoGetEquipoById() {}
    
    /**
     * Builder
     * @param id
     * @param nombre 
     */
    public ComandoGetEquipoById(int id){
        _equipo.setId(id);
    }
    
    /**
     * Metodo Ejecucion Comando
     */
    @Override
    public void ejecutar() {
        FabricaDaoPostgre fab = (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1);
        IDaoEquipo dao = fab.getDaoEquipo();
        _equipo = dao.consultarEquipoPorId(_id);
    }   
}
