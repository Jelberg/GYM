/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO2.TestsComandos;

import AccesoDatosLayer.BO2.DaoEntrenadorPostgre;
import Comun.Dominio.Entidad;
import Comun.Dominio.Entrenador;
import Comun.Dominio.FabricaEntidad;
import LogicaLayer.BO2.ComandoConsultaEntrenadorCorreo;
import LogicaLayer.BO2.ComandoConsultaEntrenadores;
import LogicaLayer.FabricaComando;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author gilbert
 */
public class PruebaCmdObtenerEntrenadores {
    ArrayList<Entrenador> _listaEntrenadores;
    Entidad _entrenador;
    Entidad _entCorreo;
    ComandoConsultaEntrenadores _cmd;
    ComandoConsultaEntrenadorCorreo _cmdCorreo;
    DaoEntrenadorPostgre _dao = new DaoEntrenadorPostgre();
    Connection _conn = _dao.getInstancia();
    ResultSet _rs;
    Statement _st;
    @Before
    public void iniciarPrueba() throws SQLException{
        _cmd = FabricaComando.instanciaCmdConsultaEntrenadores();
        String insertaEntrenador = "select * from bo_m02_insertar_entrenador(?,?,?,?,?,?)";
        PreparedStatement st = _conn.prepareStatement(insertaEntrenador); 
        st.setString( 1, "PRUEBA1" );
        st.setString( 2, "PRUEBA1" );
        st.setString( 3, "2017-12-12" );
        st.setString( 4, "M" );
        st.setString( 5, "PRUEBA1@GMAIL.COM" );
        st.setString( 6, "PRUEBA1HIST" );
        st.executeQuery();
        _entCorreo = FabricaEntidad.instanciaEntrenador("PRUEBA1", "PRUEBA1", Date.valueOf("2017-12-12"), "M", "PRUEBA1@GMAIL.COM", "PUEBA1HIST");
    }
    @Test
    public void pruebaCmdObtenerTodos(){
        _cmd.ejecutar();
        _listaEntrenadores = _cmd.getEntrenadores();
        assertNotNull( _listaEntrenadores );
    }
    @Test
    public void pruebaCmdObtenerCorreo(){
        _cmdCorreo = FabricaComando.instanciaCmdConsultaEntCorreo( _entCorreo );
        _cmdCorreo.ejecutar();
        _entrenador = _cmdCorreo.getEntrenador();
        Entrenador _ent = (Entrenador) _entrenador;
        assertEquals( "PRUEBA1", _ent.getNombre() );
        assertEquals( "PRUEBA1", _ent.getApellido() );
        assertEquals( "M", _ent.getSexo() );
        assertEquals( "PRUEBA1@GMAIL.COM", _ent.getCorreo() );
    }
    @After
    public void terminarPruebas() throws SQLException{
        String eliminarEnt = "select * from bo_m02_eliminar_entrenador('PRUEBA1@GMAIL.COM')";
        _conn = _dao.getInstancia();
        _st = _conn.createStatement();
        _rs = _st.executeQuery( eliminarEnt );
        _dao.cerrarConexion( _conn );
    }
}
