/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FOM01;

import AccesoDatosLayer.FO1.DaoUsuarioPostgre;
import AccesoDatosLayer.FO1.DaoUsuarioAmigoPostgre;
import Comun.Dominio.Usuario;
import Comun.Dominio.Usuario_Amigo;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Laura
 */
public class Test_Dao {
      private Connection _conn;
    private final DaoUsuarioPostgre _daousuario = new DaoUsuarioPostgre();
    private final DaoUsuarioAmigoPostgre _daoamigo = new DaoUsuarioAmigoPostgre();
    private Usuario _usuario;
    private Usuario _usuario1;
     private Usuario_Amigo _usuarioamigo;
    private ArrayList<Usuario> _listar = new ArrayList<>();
    String _respuesta;
    
    
          //Función para el Date
    public java.sql.Date parseFecha(String target){
        try{    
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date result =  df.parse(target);  
            java.sql.Date sqlDate = new java.sql.Date(result.getTime());
            return sqlDate;
        } 
        catch(ParseException e)
        {
            return null;
        }
    }
    
    @Before
    public void PrepararPrueba(){
        try{
            _conn = _daousuario.getConexion();
            _usuario = new Usuario("amarillo","laliq",64,"04245689190",2334,false,123,"Laura", "Quinones",parseFecha("14/09/1993"),"F", "lvqp.93@gmail.com");
            _usuario1 = new Usuario("amarillo","laliq",64,"04245689190",2334,false,111,"Laura", "Quinones",parseFecha("14/09/1993"),"F", "lvqp.93@gmail.com");
           _usuarioamigo = new Usuario_Amigo(123,111);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void TestGetListaUsuarios(){
         _daousuario.Insertar(_usuario);
       _listar = _daousuario.getListUsuario();
        assertNotNull(_listar);
    }
    
     @Test
    public void TestGetUsuario(){
   
        _daousuario.Insertar(_usuario);
        _respuesta = _daousuario.get_Usuariocorreo(_usuario);
        assertNotEquals(_respuesta, 0);
 
    }
    
      @Test
      public void TestInsertarUsuario(){
        
        _respuesta = _daousuario.Insertar(_usuario);
        assertEquals(_respuesta, "Se inserto el usuario");
    }
      
      @Test
      public void TestUsuarioDuplicado(){
        
        _respuesta = _daousuario.Insertar(_usuario);
        String _respuesta2 = _daousuario.Insertar(_usuario);
        assertEquals(_respuesta2, "usuario duplicado");
    }
      
      @Test
            public void TestCorreoDuplicado(){
        
        _respuesta = _daousuario.Insertar(_usuario);
        String _respuesta2 = _daousuario.Insertar(_usuario);
        assertEquals(_respuesta2, "correo duplicado");
    }
            
         @Test
      public void TestIniciarSesion(){
          _respuesta =  _daousuario.IniciarSesion(_usuario);
          assertNotEquals(_respuesta, 0);
       
    }
      
             @Test
      public void TestUsuarioCorreo(){
          _daousuario.Insertar(_usuario);
          _respuesta =  _daousuario.get_Usuariocorreo(_usuario);
          assertNotEquals(_respuesta, 0);
       
    }
                 @Test
      public void TestUpdateCodigo(){
            _usuario = new Usuario("amarillo","laliq",64,"04245689190",2334,false,123,"Laura", "Quinones",parseFecha("14/09/1993"),"F", "lvqp.93@gmail.com");
          _respuesta =  _daousuario.updateCodigo(_usuario);
          assertEquals(_respuesta,"Se actualizo el codigo");
       
    }
      
             @Test
      public void TestUpdatePassword(){
           _usuario = new Usuario("amarillo.123","laliq",64,"04245689190",2334,false,123,"Laura", "Quinones",parseFecha("14/09/1993"),"F", "lvqp.93@gmail.com");
          _respuesta =  _daousuario.updatePassword(_usuario);
          assertEquals(_respuesta,"Se actualizo la contrasena");
       
    }
      
         @Test
      public void TestModificaUsuario(){
           _usuario = new Usuario("amarillo","laliq",64,"04245689190",2334,false,123,"Vanessa", "Quinones",parseFecha("14/09/1993"),"F", "lvqp.93@gmail.com");
          _respuesta =  _daousuario.modificaUsuario(_usuario);
          assertEquals(_respuesta,"Se actualizo el usuario");
       
    }
      
           @Test
      public void TestModificaUsuarioDuplicado(){
            _usuario1 = new Usuario("amarillo","laliq",64,"04245689190",2334,false,123,"Laura", "Quinones",parseFecha("14/09/1993"),"F", "lvqp.93@gmail.com");
           _daousuario.Insertar(_usuario1);
           _usuario = new Usuario("amarillo","laliq",64,"04245689190",2334,false,123,"Vanessa", "Quinones",parseFecha("14/09/1993"),"F", "lvq.93@gmail.com");
          _respuesta =  _daousuario.modificaUsuario(_usuario);
          assertEquals(_respuesta,"usuario duplicado");
       
    }
                 @Test
      public void TestModificaUsuarioDuplicadoCorreo(){
            _usuario1 = new Usuario("amarillo","laliq",64,"04245689190",2334,false,123,"Laura", "Quinones",parseFecha("14/09/1993"),"F", "lvqp.93@gmail.com");
           _daousuario.Insertar(_usuario1);
           _usuario = new Usuario("amarillo","laliqui",64,"04245689190",2334,false,123,"Vanessa", "Quinones",parseFecha("14/09/1993"),"F", "lvqp.93@gmail.com");
          _respuesta =  _daousuario.modificaUsuario(_usuario);
          assertEquals(_respuesta,"correo duplicado");
       
    }
      
         @Test
      public void TestGetNombreApe(){
           _daousuario.Insertar(_usuario);
          _respuesta =  _daousuario.getUsuarioNomApe(_usuario);
          assertNotEquals(_respuesta,0);
       
    }
        @Test
      public void TestEliminaUsuario(){
           _daousuario.Insertar(_usuario);
           _respuesta = _daousuario.eliminaUsuario("lvqp.93@gmail.com");
        assertEquals(_respuesta, "Se eliminó el usuario");
    
    }
          //terminan las pruebas de Usuario
    
    //Comienzan las pruebas de Usuario_Amigo
      
        @Test
      public void TestInsertarAmigo(){
          _usuarioamigo = new Usuario_Amigo(123,111);
          _respuesta =  _daoamigo.insertaUsuario_Amigo(_usuarioamigo);
          assertEquals(_respuesta,"Se agregó el amigo");
       
    }
         @Test
      public void TestGetAmigo(){
          
           _usuarioamigo = new Usuario_Amigo(123,111);
          _respuesta =  _daoamigo.getUsuario_Amigo(_usuarioamigo);
          assertNotEquals(_respuesta,0);
       
    }
        @Test
      public void TestEliminaAmigo(){
            _usuarioamigo = new Usuario_Amigo(123,111);
          _respuesta =  _daoamigo.eliminaUsuario_Amigo(_usuarioamigo);
          assertEquals(_respuesta, "Se eliminó el amigo");
       
    }
        @Test
      public void TestListarAmigos(){
          _listar =  _daoamigo.getListUsuario_Amigo(123);
          assertNotEquals(_respuesta, 0);
            assertNotNull(_listar);
       
    }
         @After
    public void terminarPrueba(){
        try {
            _daousuario.Insertar(_usuario);
           _respuesta = _daousuario.eliminaUsuario("lvqp.93@gmail.com");
           
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (Exception e){}   
    }
}
