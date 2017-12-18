/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FO4.TestAccesoDatos;

import AccesoDatosLayer.FOM04Postgre.DaoProgresoMedida;
import Comun.Dominio.Entidad;
import Comun.Dominio.FabricaEntidad;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Elberg
 */
public class TestDaoMedida {
    private DaoProgresoMedida _pp = new DaoProgresoMedida();
    private Entidad en;
    
    
    @Test
    public void agregarPesoTest(){
        en = FabricaEntidad.InstanciaProgresoMedida(1, 12,1);
        String _resp  = _pp.agregarMedida(en); 
        assertEquals("MEDIDA AGREGADA",_resp);
    }
    
    @Test
    public void actualizarPesoTest(){
        en = FabricaEntidad.InstanciaProgresoMedida(1, 12,"Abdomen");
        String _resp  = _pp.actualizarMedida(en); 
        assertEquals("Medida Cambiada",_resp);
    }
    
    
    @Test
    public void eliminarPesoTest(){
        en = FabricaEntidad.InstanciaEliminarMedida(1,"Abdomen");
        String _resp  = _pp.eliminarMedida(en); 
        assertEquals("Medida Eliminar",_resp);
    }
}
