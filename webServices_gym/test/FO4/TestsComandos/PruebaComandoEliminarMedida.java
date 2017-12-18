/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FO4.TestsComandos;

import AccesoDatosLayer.FOM04Postgre.DaoProgresoMedida;
import Comun.Dominio.Progreso_Medida;
import LogicaLayer.FO4.ProgresoMedida.ComandoEliminarMedida;
import LogicaLayer.FabricaComando;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.Assert;
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
    PreparedStatement _st;
    
    @Test
    public void pruebaEliminarMedida(){
        _progreso_medida = new Progreso_Medida(1,"Biceps");
        _comando = FabricaComando.instanciaEliminarMedida(_progreso_medida);
        _comando.ejecutar();
        _respuesta = _comando.obtenerRespuesta();
        Assert.assertEquals(_respuesta,"Medida Eliminar");
    }
    
    
}
