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
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Elberg
 */
public class TestDaoPeso extends TestCase {
    private DaoProgresoPeso _pp = new DaoProgresoPeso();
    private Entidad en;
    private String _resp;
    ResultSet _rs;
    Gson _gson = new Gson();
    
    public TestDaoPeso(String method){
        super(method);
    }
    
    @Before
    public void setup() throws SQLException{
        _resp = null;
        Connection _conn = _pp.getConexion();
    
    }
    
    @After
    public void terdown() throws SQLException{
        _resp = null;
        _pp.eliminarPeso(1);
    }
       
    @Test
    public void agregarPesoTest(){
        en = FabricaEntidad.InstaciaProgresoPeso(9999, 12345);
        _resp  = _pp.agregarPeso(en);
        assertNotNull(_resp);
    }
}
