/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FO4.TestsComandos;

import AccesoDatosLayer.BO2.DaoEntrenadorPostgre;
import AccesoDatosLayer.FOM04Postgre.DaoProgresoMedida;
import Comun.Dominio.Comentario;
import Comun.Dominio.Progreso_Medida;
import LogicaLayer.FO4.Comentarios.AgregarComentarioComando;
import LogicaLayer.FO4.ProgresoMedida.ActualizarMedidaComando;
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
public class PruebaComandoActualizarMedida {
    
    ActualizarMedidaComando _comando;
    Progreso_Medida _progreso_medida;
    String _respuesta;
    Connection _conn;
    DaoProgresoMedida _dao = new DaoProgresoMedida();;
    ResultSet _rs;
    Statement _st;
    
    
    @Test
    public void pruebaActualizarMedida(){
        _progreso_medida = new Progreso_Medida(1, 4321, "Biceps");
        _comando = FabricaComando.instanciaCmdActualizarMedidas(_progreso_medida);
        _comando.ejecutar();
        _respuesta = _comando.getRespuesta();
        Assert.assertEquals(_respuesta,"Medida Cambiada");
    }
    
    @Test
    public void pruebaUsuarioInexistente(){
        _progreso_medida = new Progreso_Medida(0, 4321,"Biceps");
        _comando = FabricaComando.instanciaCmdActualizarMedidas(_progreso_medida);
        _comando.ejecutar();
        _respuesta = _comando.getRespuesta();
        Assert.assertNull(_respuesta);
    }
    
    @Test
    public void pruebaMedidaNegativa(){
        _progreso_medida = new Progreso_Medida(1, -20,"Biceps");
        _comando = FabricaComando.instanciaCmdActualizarMedidas(_progreso_medida);
        _comando.ejecutar();
        _respuesta = _comando.getRespuesta();
        Assert.assertNull(_respuesta);
    }
    
    @Test
    public void pruebaTipoMedidaErroneo(){
        _progreso_medida = new Progreso_Medida(1, 123,"Carro");
        _comando = FabricaComando.instanciaCmdActualizarMedidas(_progreso_medida);
        _comando.ejecutar();
        _respuesta = _comando.getRespuesta();
        Assert.assertNull(_respuesta);
    }

    
}
