/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO2.TestsComandos;

import AccesoDatosLayer.BO2.DaoEntrenadorPostgre;
import Comun.Dominio.Entidad;
import Comun.Dominio.FabricaEntidad;
import LogicaLayer.BO2.ComandoInsertarEntrenador;
import LogicaLayer.FabricaComando;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase a traves de la cual se realizaran las pruebas inherentes al comando
 * para insertar un nuevo entrenador
 * @author gilbert
 */
public class PruebaCmdInsertaEntrenador {
    Entidad _entrenador;
    ComandoInsertarEntrenador _cmd;
    DaoEntrenadorPostgre _dao = new DaoEntrenadorPostgre();
    Connection _conn = _dao.getInstancia();
    ResultSet _rs;
    Statement _st;
    @Before
    public void iniciarPrueba(){
        _entrenador = FabricaEntidad.instanciaEntrenador("PRUEBA1", "PRUEBA1", Date.valueOf("2017-12-12"), "M", "PRUEBA1@GMAIL.COM", "PUEBA1HIST");
    }
    @Test
    public void pruebaCmdInsert(){
        _cmd = FabricaComando.instanciaCmdInsertarEntrenador( _entrenador );
        _cmd.ejecutar();
        _entrenador = _cmd.getMensaje();
        assertEquals( "Se ha insertado correctamente.", _entrenador.getMensaje() );
    }
    @After
    public void terminarPrueba() throws SQLException{
        String eliminarEnt = "select * from bo_m02_eliminar_entrenador('PRUEBA1@GMAIL.COM')";
        _conn = _dao.getInstancia();
        _st = _conn.createStatement();
        _rs = _st.executeQuery( eliminarEnt );
        _dao.cerrarConexion( _conn );
    }
    
}
