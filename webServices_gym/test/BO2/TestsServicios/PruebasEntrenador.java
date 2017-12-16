/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO2.TestsServicios;

import AccesoDatosLayer.BO2.DaoEntrenadorPostgre;
import Comun.Dominio.Entidad;
import Comun.Dominio.Entrenador;
import Comun.Dominio.FabricaEntidad;
import ServiciosLayer.BOm02_Entrenador;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Ignore;

/**
 * Clase que es utilizada para realiar las correspondientes pruebas unitarias
 * de entrenador.
 * @author gilbert
 */
public class PruebasEntrenador {
    DaoEntrenadorPostgre _dao = new DaoEntrenadorPostgre();
    Connection _conn = _dao.getInstancia();
    ArrayList<Entrenador> _listaEntrenadores;
    ResultSet _rs;
    Statement _st;
    Entidad _entrenador;
    Entidad _entCorreo;
    BOm02_Entrenador _serv;
    Gson _gson;
    
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
    @Ignore
    @Test
    public void pruebaObtenerTodos(){
        _gson = new Gson();
        Gson gson = new Gson();
        _serv = new BOm02_Entrenador();
        String respuesta = _serv.getListaEntrenador();
        _listaEntrenadores = new ArrayList<>();
        _listaEntrenadores = gson.fromJson( respuesta, new TypeToken<List<Entrenador>>(){}.getType());
        assertNotNull( _listaEntrenadores );
    }
    @Ignore
    @Test
    public void pruebaObtenerCorreo(){
        _gson = new Gson();
        _serv = new BOm02_Entrenador();
        String respuesta = _serv.getEntrenadorCorreo( "PRUEBA1@GMAIL.COM" );
        Entrenador ent;
        ent = _gson.fromJson(respuesta, new TypeToken<List<Entrenador>>(){}.getType());
        assertEquals( "PRUEBA1", ent.getNombre() );
    }
    @After
    public void finalizarPruebas() throws SQLException{
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
