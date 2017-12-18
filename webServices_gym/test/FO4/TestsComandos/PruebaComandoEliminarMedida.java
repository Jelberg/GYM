/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FO4.TestsComandos;

import AccesoDatosLayer.FOM04Postgre.DaoProgresoMedida;
import Comun.Dominio.Progreso_Medida;
import LogicaLayer.FO4.ProgresoMedida.AgregarMedidaComando;
import LogicaLayer.FO4.ProgresoMedida.ComandoEliminarMedida;
import LogicaLayer.FO4.ProgresoPeso.EliminarPesoComando;
import LogicaLayer.FabricaComando;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Leonardo
 */
public class PruebaComandoEliminarMedida {
    
    ComandoEliminarMedida _comando;
    Progreso_Medida _progreso_medida;
    String _respuesta;
    Connection _conn;
    DaoProgresoMedida _dao = new DaoProgresoMedida();
    ResultSet _rs;
    Statement _st;
    
    @Before
    public void iniciarPrueba() throws SQLException{
        String _insertarMedida = "insert into progreso_medida "
                + "(pm_id, pm_medida, pm_fecha,fk_usuario,fk_medida)"
                + "values (9999,1234,'12/12/1830',1,1)";
        _conn = _dao.getInstancia();
        _st = _conn.createStatement();
        _st.executeQuery( _insertarMedida );
        _dao.cerrarConexion( _conn );
    }
    
    @Ignore
    @Test
    public void pruebaEliminarMedida(){
        _progreso_medida = new Progreso_Medida(9999,"Biceps");
        _comando = FabricaComando.instanciaEliminarMedida(_progreso_medida);
        _comando.ejecutar();
        _respuesta = _comando.obtenerRespuesta();
        Assert.assertEquals(_respuesta,"Medida Eliminar");
    }
    
    
    @After
    public void finalizarPrueba() throws SQLException{
        String _eliminarMedida = "delete from progreso_medida where pm_id=9999";
        _conn = _dao.getInstancia();
        _st = _conn.createStatement();
        _st.executeQuery( _eliminarMedida );
        _dao.cerrarConexion( _conn );
    }
    
}
