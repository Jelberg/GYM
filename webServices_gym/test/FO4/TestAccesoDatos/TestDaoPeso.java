/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FO4.TestAccesoDatos;

import AccesoDatosLayer.DaoPostgre;
import AccesoDatosLayer.FOM04Postgre.DaoProgresoPeso;
import Comun.Dominio.Entidad;
import Comun.Dominio.FabricaEntidad;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Elberg
 */
public class TestDaoPeso  {
    private DaoProgresoPeso _pp = new DaoProgresoPeso();
    private Entidad en;
   

 
       
    @Test
    public void agregarPesoTest(){
        en = FabricaEntidad.InstaciaProgresoPeso(1, 12);
        String _resp  = _pp.agregarPeso(en);
        
        assertEquals("PESO AGREGADO",_resp);
    }
    
    @Test
    public void actualizarPesoTest(){
        en = FabricaEntidad.InstaciaProgresoPeso(1, 13);
        String _resp = _pp.actualizarPeso(en);
        assertEquals("PESO ACTUALIZADO",_resp);
    }
    
    @Test
    public void eliminarPesoTest(){
        String _resp = _pp.eliminarPeso(1);
        assertEquals("PESO ELIMINADO",_resp);
    }
}
