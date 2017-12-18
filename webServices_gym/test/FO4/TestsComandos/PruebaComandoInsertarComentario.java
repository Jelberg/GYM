/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FO4.TestsComandos;

import AccesoDatosLayer.FOM04Postgre.DaoComentario;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import Comun.Dominio.Comentario;
import LogicaLayer.FO4.Comentarios.AgregarComentarioComando;
import LogicaLayer.FabricaComando;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Leonardo
 */
public class PruebaComandoInsertarComentario {
    
    AgregarComentarioComando _comando;
    Comentario _comentario;
    String _respuesta;
    Connection _conn;
    DaoComentario _dao = new DaoComentario();
    ResultSet _rs;
    Statement _st;
    
    
    @Test
    public void pruebaInsertarComentario(){
        _comentario = new Comentario(1, "COMENTARIO AÑADIDO");
        _comando = FabricaComando.insertarComentarioComando(_comentario);
        _comando.ejecutar();
        _respuesta = _comando.obtenerRespuesta();
        Assert.assertEquals(_respuesta,"Comentario Agregado");
    }
    
    @Test
    public void pruebaUsuarioInexistente(){
        _comentario = new Comentario(0, "COMENTARIO AÑADIDO");
        _comando = FabricaComando.insertarComentarioComando(_comentario);
        _comando.ejecutar();
        _respuesta = _comando.obtenerRespuesta();
        Assert.assertNull(_respuesta);
    }
    
    @After
    public void finalizarPrueba() throws SQLException{
        
        String _eliminarComentario = "delete from comentario where fk_usuario=1 and com_mensaje='COMENTARIO AÑADIDO'";
        _conn = _dao.getInstancia();
        _st = _conn.createStatement();
        _rs = _st.executeQuery( _eliminarComentario );
        _dao.cerrarConexion( _conn );
        
    }
    
}
