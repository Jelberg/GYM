/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO2.TestsComandos;

import AccesoDatosLayer.BO2.DaoEntrenadorPostgre;
import Comun.Dominio.Entidad;
import Comun.Dominio.FabricaEntidad;
import LogicaLayer.BO2.ComandoEliminaEntrenador;
import LogicaLayer.FabricaComando;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Clase a traves de la cual se realizan las pruebas para eliminar un entrenador.
 * @author gilbert
 */
public class PruebaCmdEliminaEntrenador {
    Entidad _entrenador;
    ComandoEliminaEntrenador _cmd;
    DaoEntrenadorPostgre _dao = new DaoEntrenadorPostgre();
    Connection _conn = _dao.getInstancia();
    ResultSet _rs;
    Statement _st;
    @Before
    public void iniciarPrueba() throws SQLException{
        _conn = _dao.getConexion();
        String insertaEntrenador = "select * from bo_m02_insertar_entrenador(?,?,?,?,?,?)";
        PreparedStatement st = _conn.prepareStatement( insertaEntrenador ); 
        st.setString( 1, "PRUEBA1" );
        st.setString( 2, "PRUEBA1" );
        st.setString( 3, "2017-12-12" );
        st.setString( 4, "M" );
        st.setString( 5, "PRUEBA1@GMAIL.COM" );
        st.setString( 6, "PRUEBA1HIST" );
        st.executeQuery();
        _entrenador = FabricaEntidad.instanciaEntrenador("PRUEBA1", "PRUEBA1", Date.valueOf("2017-12-12"), "M", "PRUEBA1@GMAIL.COM", "PUEBA1HIST");
    }
    @Test
    public void pruebaCmdInsert(){
        _cmd = FabricaComando.instanciaCmdEliminaEntrenador( _entrenador );
        _cmd.ejecutar();
        _entrenador = _cmd.getMensaje();
        assertEquals( "Entrenador eliminado correctamente.", _entrenador.getMensaje() );
    }
    @After
    public void terminarPrueba() throws SQLException{
        _dao.cerrarConexion( _conn );
    }
    
}
