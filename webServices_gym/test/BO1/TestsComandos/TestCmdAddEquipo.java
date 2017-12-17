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
import LogicaLayer.FabricaComando;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase Pruebas Comando Agregar Equipo
 * @author Daniel Goncalves
 */
public class TestCmdAddEquipo {
    Entidad _equipo;
    ComandoAddEquipo _cmd;
    DaoEquipoPostgre _dao = new DaoEquipoPostgre();
    Connection _conn = _dao.getInstancia();
    ResultSet _rs;
    Statement _st;
    @Before
    public void iniciarPrueba(){
        _equipo = FabricaEntidad.InstanciaEquipo(9999, "Prueba Equipo");
    }
    @Test
    public void pruebaCmdInsert(){
        _cmd = FabricaComando.instanciaAddEquipo(_equipo);
        _cmd.ejecutar();
        _equipo = _cmd.getMensaje();
        assertEquals( "Se ha insertado correctamente.", _equipo.getMensaje() );
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
