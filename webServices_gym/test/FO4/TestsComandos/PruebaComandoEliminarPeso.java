/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FO4.TestsComandos;

import AccesoDatosLayer.FOM04Postgre.DaoProgresoMedida;
import LogicaLayer.FO4.ProgresoPeso.EliminarPesoComando;
import LogicaLayer.FabricaComando;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.Assert;
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
    
    
    @Test
    public void pruebaEliminarMedida(){
        _comando = FabricaComando.instanciaCmdEliminarProgresoPeso(9999);
        _comando.ejecutar();
        _respuesta = _comando.getRespuestaEliminarPeso();
        Assert.assertEquals(_respuesta,"Medida Eliminar");
    }
    
}
