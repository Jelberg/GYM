/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FO4.TestsComandos;

import AccesoDatosLayer.FOM04Postgre.DaoProgresoMedida;
import Comun.Dominio.Progreso_Medida;
import LogicaLayer.FO4.ProgresoMedida.AgregarMedidaComando;
import LogicaLayer.FabricaComando;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Leonardo
 */
public class PruebaComandoAgregarMedida {
    
    AgregarMedidaComando _comando;
    Progreso_Medida _progreso_medida;
    String _respuesta;
    Connection _conn;
    DaoProgresoMedida _dao = new DaoProgresoMedida();
    ResultSet _rs;
    Statement _st;
    
    @Test
    public void pruebaInsertarMedida(){
        _progreso_medida = new Progreso_Medida(1,23,1);
        _comando = FabricaComando.instanciaCmdAgregarMedida(_progreso_medida);
        _comando.ejecutar();
        _respuesta = _comando.getRespuestaAgregarMedida();
        Assert.assertEquals(_respuesta,"MEDIDA AGREGADA");
    }
    
    @Ignore
    @Test
    public void pruebaUsuarioInexistente(){
        _progreso_medida = new Progreso_Medida(0, 1324,"Biceps");
        _comando = FabricaComando.instanciaCmdAgregarMedida(_progreso_medida);
        _comando.ejecutar();
        _respuesta = _comando.getRespuestaAgregarMedida();
        Assert.assertNull(_respuesta);
    }
    
    @Ignore
    @Test
    public void pruebaMedidaNegativa(){
        _progreso_medida = new Progreso_Medida(1, -50,"Biceps");
        _comando = FabricaComando.instanciaCmdAgregarMedida(_progreso_medida);
        _comando.ejecutar();
        _respuesta = _comando.getRespuestaAgregarMedida();
        Assert.assertNull(_respuesta);
    }
    
    @Ignore
    @Test
    public void pruebaTipoErroneo(){
        _progreso_medida = new Progreso_Medida(1, 1324,"Carro");
        _comando = FabricaComando.instanciaCmdAgregarMedida(_progreso_medida);
        _comando.ejecutar();
        _respuesta = _comando.getRespuestaAgregarMedida();
        Assert.assertNull(_respuesta);
    }
    
    
}
