/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FOM01;
import Comun.Dominio.Usuario;
import ServiciosLayer.FOM01_Login;
import ServiciosLayer.FOM01_Usuario;
import ServiciosLayer.FOM01_Usuario_Amigo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Laura
 */
public class Test_Servicios {
    ResultSet _rs;
    FOM01_Login _loginServicios;
    FOM01_Usuario _usuarioServicios;
    FOM01_Usuario_Amigo _usuario_AmigoServicios;
    Usuario _usuarioDominio;
    ArrayList<Usuario> _arrayUsu;

    
    @Before
    public void comenzarPrueba() {
        _loginServicios = new FOM01_Login();
        _arrayUsu = new ArrayList<>();
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(_loginServicios.insertaUsuario("Miguel", 
                "Pinto", parseFecha("10/10/1995"), "M", "prueba@gma.vom", "Prueba",
                "123456mp", 0, "02129756419", false)).getAsJsonObject();
    }
    
    //Inicio Pruebas Login
    //Prueba de Inicio de Sesión
    @Test
    public void pruebaIniciarSesion(){
        Gson gson = new Gson();
        _loginServicios = new FOM01_Login();
        _arrayUsu = new ArrayList<>();
        _arrayUsu = gson.fromJson(_loginServicios.iniciarSesion("Prueba", "123456mp"),
                    new TypeToken<List<Usuario>>(){}.getType());
        assertNotEquals(0, _arrayUsu.get(0).getId());
    }
    
    //Prueba de Inicio de Sesión Fallida
    @Test
    public void pruebaIniciarSesionFallida(){
        Gson gson = new Gson();
        _loginServicios = new FOM01_Login();
        _arrayUsu = new ArrayList<>();
        _arrayUsu = gson.fromJson(_loginServicios.iniciarSesion("PruebaFallida",
                    "123456mp"), new TypeToken<List<Usuario>>(){}.getType());
        assertTrue( _arrayUsu.isEmpty());
    }
    
    //Función para el Date
    public java.sql.Date parseFecha(String target){
        try{    
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date result =  df.parse(target);  
            java.sql.Date sqlDate = new java.sql.Date(result.getTime());
            return sqlDate;
        } 
        catch(Exception e)
        {
            return null;
        }
    }
    
    //Prueba Insertar Usuario
    @Test
    public void pruebaInsertarUsuario(){
        _loginServicios = new FOM01_Login();
        _arrayUsu = new ArrayList<>();
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(_loginServicios.insertaUsuario("Miguel", 
                "Pinto", parseFecha("10/10/1995"), "M", "migue@gmail.com", 
                "miguejeje", "123456mp", 0, "02129756419", false)).getAsJsonObject();
        assertEquals("Se inserto el usuario", obj.get("id").getAsString());
    }
    
    //Prueba Insertar Usuario que ya existe
    @Test
    public void pruebaInsertarUsuarioExistente(){
        _loginServicios = new FOM01_Login();
        _arrayUsu = new ArrayList<>();
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(_loginServicios.insertaUsuario("Miguel", 
                "Pinto", parseFecha("10/10/1995"), "M", "lepe", "Prueba", 
                "123456mp", 0, "02129756419", false)).getAsJsonObject();
        assertEquals("usuario duplicado", obj.get("id").getAsString());
    }
    
    //Prueba para para actualizar el codigo de recuperar contraseña. HABILITARRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
    @Test
    public void pruebaUpdateCod(){
        _loginServicios = new FOM01_Login();
        _arrayUsu = new ArrayList<>();
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(_loginServicios.updateCod("yyhernandez.13@gmail.com"))
                                     .getAsJsonObject();
        assertNotEquals(0, obj.get("id").getAsInt());
    }

    //Prueba para actualizar la contraseña
    @Test
    public void pruebaUpdatePass(){
        _loginServicios = new FOM01_Login();
        _arrayUsu = new ArrayList<>();
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(_loginServicios.updatePass("yyhernandez.13@gmail.com"
                                      ,"hola")).getAsJsonObject();
        assertEquals("Se actualizo la contrasena", obj.get("id").getAsString());
    }
    
    //Prueba para consultar un usuario por correo
    @Test
    public void pruebaGetUsuarioCorreo(){
        _loginServicios = new FOM01_Login();
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(_loginServicios.getUsuarioCorreo("yyhernandez.13@gmail.com"))
                                     .getAsJsonObject();
        assertNotEquals(0, obj.get("id").getAsString());
    }
    //Fin Pruebas Login
    
    //Inicio Pruebas Usuario
    //Prueba para consultar un usuario por id
    @Test 
    public void pruebaGetUsuario(){
        _usuarioServicios = new FOM01_Usuario();
        JsonParser parser = new JsonParser();
        JsonArray obj = parser.parse(_usuarioServicios.getUsuario(1))
                                     .getAsJsonArray();
        assertNotNull( obj );
    }
    
    //Prueba para consultar un usuario por nombre y apellido
    @Test 
    public void pruebaGetUsuarioNomApe(){
        _usuarioServicios = new FOM01_Usuario();
        JsonParser parser = new JsonParser();
        JsonArray obj = parser.parse(_usuarioServicios.getUsuarioNomApe("Yesimar","Hernández")).getAsJsonArray();
        assertNotNull( obj );
    }
    
    //Prueba para la lista de Usuarios
    @Test 
    public void pruebaGetListUsuario(){
        _usuarioServicios = new FOM01_Usuario();
        JsonParser parser = new JsonParser();
        JsonArray obj = parser.parse(_usuarioServicios.getListUsuario()).getAsJsonArray();
        assertNotNull(obj);
    }
    
    //Prueba Eliminar Usuario
    @Test
    public void pruebaEliminaUsuario(){
        _usuarioServicios = new FOM01_Usuario();
        _arrayUsu = new ArrayList<>();
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(_usuarioServicios.eliminaUsuario("migue@gmail.com"))
                                     .getAsJsonObject();
        assertEquals("Se eliminó el usuario", obj.get("correo").getAsString());
    }
    
    //Prueba para modificar un usuario
    @Test 
    public void pruebaModificaUsuario(){
        _usuarioServicios = new FOM01_Usuario();
        _arrayUsu = new ArrayList<>();
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(_usuarioServicios.modificaUsuario(1, "YessyHeer",
                "hola", "Yesimar", "Hernández", "F", "04265121963", 173,
                "yyhernandez.13@gmail.com", false, 0)).getAsJsonObject();
        assertEquals("Se actualizo el usuario", obj.get("id").getAsString());
    }
    //Fin Pruebas Usuario
    
    //Inicio Pruebas Usuario_Amigo
    //Prueba para consultar Amigos
    @Test
    public void pruebaGetUsuario_Amigo(){
        _usuario_AmigoServicios = new FOM01_Usuario_Amigo();
        JsonParser parser = new JsonParser();
        JsonArray obj = parser.parse(_usuario_AmigoServicios.getUsuario_Amigo(1))
                                    .getAsJsonArray();
        assertNotNull( obj );
    }
    
    //Prueba para listar los amigos
    @Test
    public void pruebaGetListUsuario_Amigo(){
        _usuario_AmigoServicios = new FOM01_Usuario_Amigo();
        JsonParser parser = new JsonParser();
        JsonArray obj = parser.parse(_usuario_AmigoServicios.getListUsuario_Amigo(1)).getAsJsonArray();
        assertNotNull(obj);
    }
    
    //Prueba para agregar un amigo
    public void pruebaInsertaUsuario_Amigo(){
        _usuario_AmigoServicios = new FOM01_Usuario_Amigo();
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(_usuario_AmigoServicios.insertaUsuario_Amigo(1, 2))
                                     .getAsJsonObject();
        assertEquals("Se agregó el amigo", obj.get("idAmigo").getAsString());
    }
    
    //Prueba
    public void pruebaEliminaUsuario_Amigo(){
        _usuario_AmigoServicios = new FOM01_Usuario_Amigo();
        _arrayUsu = new ArrayList<>();
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(_usuario_AmigoServicios.eliminaUsuario_Amigo(1, 2))
                                    .getAsJsonObject();
        assertEquals("Se eliminó el amigo", obj.get("idAmigo").getAsString());
    }
    //Fin Pruebas Usuario_Amigo
    
    @After
    public void terminarPrueba(){
        try {      
            _usuarioServicios = new FOM01_Usuario();
            _arrayUsu = new ArrayList<>();
            JsonParser parser = new JsonParser();
            JsonObject obj = parser.parse(_usuarioServicios.eliminaUsuario("prueba@gma.vom")).getAsJsonObject();
            assertEquals("Se eliminó el usuario", obj.get("correo").getAsString());
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (Exception e){}   
    }
       
}