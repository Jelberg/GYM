/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FO4.TestsComandos;

import AccesoDatosLayer.FOM04Postgre.DaoProgresoPeso;
import Comun.Dominio.Progreso_Peso;
import LogicaLayer.FO4.ProgresoPeso.ActualizarPesoComando;
import LogicaLayer.FO4.ProgresoPeso.AgregarPesoComando;
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
public class PruebaComandoAgregarPeso {
    
    AgregarPesoComando _comando;
    Progreso_Peso _progreso_peso;
    String _respuesta;
    Connection _conn;
    DaoProgresoPeso _dao = new DaoProgresoPeso();;
    ResultSet _rs;
    Statement _st;
    
    
    @Test
    public void pruebaActualizarPeso(){
        _progreso_peso = new Progreso_Peso(1,12);
        _comando = FabricaComando.instanciaCmdAgregarPeso(_progreso_peso);
        _comando.ejecutar();
        _respuesta = _comando.getResultado();
        Assert.assertEquals(_respuesta,"PESO AGREGADO");
    }
    
    @Ignore
    @Test
    public void pruebaUsuarioInexistente(){
        _progreso_peso = new Progreso_Peso(0,12);
        _comando = FabricaComando.instanciaCmdAgregarPeso(_progreso_peso);
        _comando.ejecutar();
        _respuesta = _comando.getResultado();
        Assert.assertNull(_respuesta);
    }
    
    @Ignore
    @Test
    public void pruebaPesoNegativo(){
        _progreso_peso = new Progreso_Peso(1,-1);
        _comando = FabricaComando.instanciaCmdAgregarPeso(_progreso_peso);
        _comando.ejecutar();
        _respuesta = _comando.getResultado();
        Assert.assertNull(_respuesta);
    }
    
}
