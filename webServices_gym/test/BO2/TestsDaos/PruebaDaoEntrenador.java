/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO2.TestsDaos;

import AccesoDatosLayer.BO2.DaoEntrenadorPostgre;
import Comun.Dominio.Entidad;
import Comun.Dominio.Entrenador;
import Comun.Dominio.FabricaEntidad;
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
 * Clase utilizadas para realizar las pruebas correspondientes a DaoEntrenador.
 * @author gilbert
 */
public class PruebaDaoEntrenador {
    DaoEntrenadorPostgre _dao = new DaoEntrenadorPostgre();
    Connection _conn = _dao.getInstancia();
    ArrayList<Entrenador> _arregloEntrenador;
    ResultSet _rs;
    Statement _st;
    Entidad _entrenador;
    Entidad _entCorreo;
    @Before
    public void iniciarPruebas() throws SQLException{
        _conn = _dao.getConexion();
        String insertaEntrenador = "select * from bo_m02_insertar_entrenador(?,?,?,?,?,?)";
        String insertaEntrenadorDos = "select * from bo_m02_insertar_entrenador(?,?,?,?,?,?)";
        PreparedStatement st = _conn.prepareStatement(insertaEntrenador); 
        st.setString( 1, "PRUEBA1" );
        st.setString( 2, "PRUEBA1" );
        st.setString( 3, "2017-12-12" );
        st.setString( 4, "M" );
        st.setString( 5, "PRUEBA1@GMAIL.COM" );
        st.setString( 6, "PRUEBA1HIST" );
        st.executeQuery();
        _conn = _dao.getConexion();
        st = _conn.prepareStatement(insertaEntrenadorDos); 
        st.setString( 1, "PRUEBA2" );
        st.setString( 2, "PRUEBA2" );
        st.setString( 3, "2017-12-12" );
        st.setString( 4, "F" );
        st.setString( 5, "PRUEBA2@GMAIL.COM" );
        st.setString( 6, "PRUEBA2HIST" );
        st.executeQuery();
        _entCorreo = FabricaEntidad.instanciaEntrenador("PRUEBA1", "PRUEBA1", Date.valueOf("2017-12-12"), "M", "PRUEBA1@GMAIL.COM", "PUEBA1HIST");
        _entrenador = FabricaEntidad.instanciaEntrenador("PRUEBAENT", "PRUEBAENT", Date.valueOf("2017-12-12"), "M", "PRUEBAENT@GMIAL.COM", "PRUEBANEHHIST");
        
    }
    @Test
    public void pruebaConsultaTodos(){
        _arregloEntrenador = new ArrayList<>();
        _arregloEntrenador = _dao.consultarEntrenadores();
        assertNotNull( _arregloEntrenador.get(1) );
    }
    @Test
    public void pruebaInsertar(){
        _entrenador = _dao.insertar( _entrenador );
        assertNotNull( _entrenador.getMensaje() );
    }
    @Test
    public void pruebaConsultaPorCorreo(){
        _entCorreo = _dao.consultar( _entCorreo );
        Entrenador ent = (Entrenador) _entCorreo;
        assertEquals( "PRUEBA1@GMAIL.COM", ent.getCorreo() );
    }
    @After
    public void terminarPruebas() throws SQLException{
        String eliminarEnt = "select * from bo_m02_eliminar_entrenador('PRUEBA1@GMAIL.COM')";
        String eliminarEntDos = "select * from bo_m02_eliminar_entrenador('PRUEBA2@GMAIL.COM')";
        String eliminarEntTres = "select * from bo_m02_eliminar_entrenador('PRUEBAENT@GMIAL.COM')";
        _conn = _dao.getInstancia();
        _st = _conn.createStatement();
        _rs = _st.executeQuery( eliminarEnt );
        _conn = _dao.getInstancia();
        _st = _conn.createStatement();
        _rs = _st.executeQuery( eliminarEntDos );
        _conn = _dao.getInstancia();
        _st = _conn.createStatement();
        _rs = _st.executeQuery( eliminarEntTres );
        _dao.cerrarConexion( _conn );
    }
    
}
