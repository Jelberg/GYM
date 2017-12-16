/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FO_M05;

import AccesoDatosLayer.FOM04Postgre.IDaoProgresoPeso;
import AccesoDatosLayer.FabricaAbstracta;
import Comun.Dominio.FabricaEntidad;
import Comun.Dominio.Progreso_Peso;
import Comun.Excepciones.ParameterNullException;
import LogicaLayer.FOM04.ActualizarPesoComando;
import LogicaLayer.FabricaComando;
import java.sql.SQLException;
import java.util.ArrayList;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Leonardo
 */
public class PruebaModificarPeso extends TestCase {
    
    Progreso_Peso _progreso_Peso;
    int _pesoReal;
    ArrayList<Progreso_Peso> _listaPesos;
    ActualizarPesoComando _comando;
    FabricaAbstracta _fab;
    IDaoProgresoPeso _dao;
    
    public PruebaModificarPeso(String metodo){
        super(metodo);
    }
    
    @Before
    public void instanciarPrueba(){
         _fab = FabricaAbstracta.getFabrica(1);
         _dao = _fab.instanciaDaoProgresoPeso();
    }
    
    @Ignore
    @Test
    public void pruebaModificarPeso(){
        
         
        _listaPesos = _dao.getPesos();
        
        _progreso_Peso = FabricaEntidad.InstanciaActualizarPeso
            (_listaPesos.get(1).getIdUsuario(), _listaPesos.get(1).getPeso());
        
        _pesoReal = _progreso_Peso.getPeso();
        _progreso_Peso.setPeso(123);
        
        _comando = FabricaComando.actualizarPesoComando(_progreso_Peso);
        _comando.ejecutar();
        
        _listaPesos = _dao.getPesos();
        
        for (Progreso_Peso _listaPeso : _listaPesos) {
            if (_listaPeso.getIdUsuario()==1) {
                Assert.assertEquals(123,_listaPeso.getPeso());
                break;
            }
        }
        
    }
    
    @Test (expected = ParameterNullException.class)
    public void pruebaModificarPesoNull(){
        
        try {
            _dao.actualizar(null);
            Assert.fail("ParameterNullException lanzada");
        } catch (ParameterNullException e) {
        }

    }
    
    @Ignore
    @Test (expected = SQLException.class)
    public void pruebaModificarPesoUsuarioInexistente(){
        Progreso_Peso _progreso_peso = new Progreso_Peso(0, 50);
        _dao.actualizar(_progreso_peso);
        Assert.fail("SQLException lanzada");
    }
    
    @After
    public void limpiarPrueba(){
    }
    
    public static Test suite(){
        TestSuite _suite = new TestSuite();
        _suite.addTest(new PruebaModificarPeso("pruebaModificarPeso"));
        _suite.addTest(new PruebaModificarPeso("pruebaModificarPesoNull"));
        _suite.addTest(new PruebaModificarPeso("pruebaModificarPesoUsuarioInexistente"));
        return (Test) _suite;
    }
    
}
