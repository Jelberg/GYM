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
import LogicaLayer.BO1.ComandoEliminarEquipo;
import LogicaLayer.FabricaComando;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase Pruebas Comando Eliminar Equipo
 * @author Daniel Goncalves
 */
public class TestCmdEliminarEquipo {
    Entidad _equipo;
    ComandoEliminarEquipo _cmdEli;
    ComandoAddEquipo _cmdAdd;
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
    public void pruebaCmdEliminar(){
		_cmdEli = FabricaComando.instanciaEliminarEquipo(_equipo);
        _equipo = _cmdEli.getMensaje();
        assertEquals( "Se ha eliminado correctamente.", _equipo.getMensaje() );
    }    
}
