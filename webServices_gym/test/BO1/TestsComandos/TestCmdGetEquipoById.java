/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO1.TestsComandos;

import AccesoDatosLayer.BO1.DaoEquipoPostgre;
import Comun.Dominio.Entidad;
import Comun.Dominio.FabricaEntidad;
import LogicaLayer.BO1.ComandoAddEquipo;
import LogicaLayer.BO1.ComandoGetEquipoById;
import LogicaLayer.FabricaComando;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase Pruebas Comando Get Equipo By ID
 * @author Daniel Goncalves
 */
public class TestCmdGetEquipoById {
    Entidad _equipo;
    ComandoAddEquipo _cmdAdd;
    ComandoGetEquipoById _cmdGet;
    DaoEquipoPostgre _dao = new DaoEquipoPostgre();
    Connection _conn = _dao.getInstancia();
    ResultSet _rs;
    Statement _st;
    @Before
    public void iniciarPrueba(){
        _equipo = FabricaEntidad.InstanciaEquipo(9999, "Prueba Equipo");
        _cmdAdd = FabricaComando.instanciaAddEquipo(_equipo);
        _cmdAdd.ejecutar();
    }
    @Test
    public void pruebaCmdInsert(){
        _cmdGet = FabricaComando.instanciaGetEquipoById(9999) ;
        _cmdGet.ejecutar();
        _equipo = _cmdGet.ComandoGetEquipoById(9999);
        assertNotNull ( _equipo );
    }
    @After
    public void terminarPrueba() throws SQLException{
        String eliminarEnt = "select * from bo_m01_eliminar_equipo(9999)";
        _conn = _dao.getInstancia();
        _st = _conn.createStatement();
        _rs = _st.executeQuery( eliminarEnt );
        _dao.cerrarConexion( _conn );
    }
    
}
