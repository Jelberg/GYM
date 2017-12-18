/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FO4.TestsComandos;

import AccesoDatosLayer.FOM04Postgre.DaoProgresoMedida;
import Comun.Dominio.Progreso_Medida;
import Comun.Dominio.Progreso_Peso;
import LogicaLayer.FO4.ProgresoMedida.ComandoEliminarMedida;
import LogicaLayer.FO4.ProgresoPeso.EliminarPesoComando;
import LogicaLayer.FabricaComando;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Leonardo
 */
public class PruebaComandoEliminarPeso {
    
    EliminarPesoComando _comando;
    String _respuesta;
    Connection _conn;
    DaoProgresoMedida _dao = new DaoProgresoMedida();
    ResultSet _rs;
    Statement _st;
    
    @Ignore
    @Before
    public void iniciarPrueba() throws SQLException{
        String _eliminarMedida = "insert into progreso_peso "
                + "(pp_id, pp_peso, pp_fecha, fk_usuario)"
                + "values (9999,1234,'12/12/1830',1)";
        _conn = _dao.getInstancia();
        _st = _conn.createStatement();
        _st.executeQuery( _eliminarMedida );
        _dao.cerrarConexion( _conn );
    }
    
    @Test
    public void pruebaEliminarMedida(){
        _comando = FabricaComando.instanciaCmdEliminarProgresoPeso(9999);
        _comando.ejecutar();
        _respuesta = _comando.getRespuestaEliminarPeso();
        Assert.assertEquals(_respuesta,"Medida Eliminar");
    }
    
}
