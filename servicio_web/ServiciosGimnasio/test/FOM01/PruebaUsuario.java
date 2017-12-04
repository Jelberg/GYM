/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FOM01;

import Dominio.Sql;
import Dominio.Usuario;
import Servicios.FOM01_Login;
import Servicios.FOM01_Usuario;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author YESIMAR
 */
public class PruebaUsuario {
    Sql _conn;
    ResultSet _rs;
    FOM01_Usuario _usuarioServicios;
    FOM01_Login _usuarioServicios2;
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
    
    //Prueba de Consulta
    @Test
    public void pruebaConsultaUsuario(){
        Gson gson = new Gson();
        _usuarioServicios = new FOM01_Usuario();
        String respuesta = _usuarioServicios.getUsuario( 9999 );
        _arrayUsuario = new ArrayList<>();
        _arrayUsuario = gson.fromJson( respuesta, new TypeToken<List<Usuario>>(){}.getType());
        assertEquals( 9999 , _arrayUsuario.get(0).getId() );
    }
    
    //Prueba de Inserción
//    @Test
//    public void pruebaInsertaUsuario(){
//        Gson gson = new Gson();
//        _usuarioServicios2 = new FOM01_Login();
//        String respuesta = _usuarioServicios2.insertaUsuario("Yesi", "hola",
//                "Yesimar", "Hernández", "f", "01-02-1994", "04265121963", 173, null,
//                "yyhernandez.13@gmail.com", "false", null);
//        assertNotNull( respuesta );
//    }
    
    //Prueba de Modificación
    @Test
    public void pruebaModificaUsuario(){
        Gson gson = new Gson();
        _usuarioServicios = new FOM01_Usuario();
        String respuesta = _usuarioServicios.modificaUsuario("Yesi", "hola","Yesimar",
                "Hernández", "f", "01-02-1994","04265121963", 173, "yyhernandez.13@gmail.com", false, 9999 );
        assertNotNull( respuesta );
    }
    
    //Prueba de Eliminación
    @Test
    public void pruebaEliminaClase(){
        Gson gson = new Gson();
        _usuarioServicios = new FOM01_Usuario();
        String respuesta = _usuarioServicios.eliminaUsuario( 9999 );
        assertNotNull( respuesta );
    }
    
    @After
    public void terminarPrueba(){
        String query = "SELECT fo_m01_elimina_usuario( 9999 )";
        
        try {
            _rs = _conn.sql( query );
            _conn = new Sql();
            query = "DELETE FROM USUARIO where usu_id = 9999 ";
            _rs = _conn.sql( query );
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (Exception e){}   
    }
}
