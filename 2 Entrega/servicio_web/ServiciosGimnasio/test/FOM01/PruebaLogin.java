/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FOM01;

import Dominio.Usuario;
import Dominio.Sql;
import Servicios.FOM01_Login;
import com.google.gson.Gson;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.junit.After;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author YESIMAR
 */
public class PruebaLogin {
    Sql _conn;
    ResultSet _rs;
    FOM01_Login _loginServicios;
    Usuario _usuarioDominio;
    ArrayList<Usuario> _arrayUsuario;
    
    @Before
    public void comenzarPrueba() {
        _conn = new Sql();
        String insertUsuario = "INSERT INTO USUARIO ( usu_id, usu_usuario, usu_password,"
                + " usu_nombre, usu_apellido, usu_sexo, usu_fecha_nac, usu_telefono,"
                + " usu_estatura, usu_foto, usu_correo, usu_entrenador, usu_codigo) "
                + "VALUES (9999, 'Yesi', 'hola', 'Yesimar', 'Hernández', 'f', '01-02-1994',"
                + "'04265121963', 173, null, 'yyhernandez.13@gmail.com', 'false', null)";
        
        try {
            _rs = _conn.sql ( insertUsuario );  
            _conn = new Sql();
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (Exception e){}
    }
    
    //Prueba de Inicio de Sesión
    @Test
    public void pruebaConsultaUsuario(){
        Gson gson = new Gson();
        _loginServicios = new FOM01_Login();
        String respuesta = _loginServicios.iniciarSesion("Yesi", "hola");
        assertNotNull( respuesta );
    }
    
    @After
    public void terminarPrueba(){
        String query = "SELECT fo_m01_elimina_usuario('Yesi')";
        
        try {
            _rs = _conn.sql( query );
            _conn = new Sql();
            query = "DELETE FROM USUARIO where usu_usuario = 'Yesi'";
            _rs = _conn.sql( query );
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (Exception e){}   
    }
    
}
