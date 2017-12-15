/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FOM01;
import Comun.Dominio.FabricaEntidad;
import Comun.Dominio.Usuario;
import LogicaLayer.FO1.ComandoEliminaUsuario;
import LogicaLayer.FO1.IngresarUsuario;
import LogicaLayer.FabricaComando;
import ServiciosLayer.FO1_Servicios;
import ServiciosLayer.FOM01_Usuario;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author Laura
 */
public class TestLogin {
    ResultSet _rs;
    FO1_Servicios _loginServicios;
    FOM01_Usuario _usu;
    Usuario _usuarioDominio;
    ArrayList<Usuario> _arrayUsu;

    
    @Before
    public void comenzarPrueba() {
        
        _loginServicios = new FO1_Servicios();
        _arrayUsu = new ArrayList<>();
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(_loginServicios.insertaUsuario("Miguel", "Pinto", parseFecha("10/10/1995"), "M", "prueba@gma.vom", "Prueba", "123456mp", 0, "02129756419", false)).getAsJsonObject();

      
    }
    
    //Prueba de Inicio de Sesión
    @Test
    public void pruebaIniciarSesion(){
        Gson gson = new Gson();
        _loginServicios = new FO1_Servicios();
        _arrayUsu = new ArrayList<>();
        _arrayUsu = gson.fromJson(_loginServicios.iniciarSesion("Prueba", "123456mp"), new TypeToken<List<Usuario>>(){}.getType());
        assertNotEquals(0, _arrayUsu.get(0).getId());
    }
    
    @Test
    public void pruebaIniciarSesionFallida(){
        Gson gson = new Gson();
        _loginServicios = new FO1_Servicios();
        _arrayUsu = new ArrayList<>();
        _arrayUsu = gson.fromJson(_loginServicios.iniciarSesion("PruebaFallida", "123456mp"), new TypeToken<List<Usuario>>(){}.getType());
        assertTrue( _arrayUsu.isEmpty());
    }
    
    public java.sql.Date parseFecha(String target)  {
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
    
    @Test
    public void pruebaIngresarUsuario(){
        _loginServicios = new FO1_Servicios();
        _arrayUsu = new ArrayList<>();
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(_loginServicios.insertaUsuario("Miguel", "Pinto", parseFecha("10/10/1995"), "M", "migue@gmail.com", "miguejeje", "123456mp", 0, "02129756419", false)).getAsJsonObject();
        assertEquals("Se inserto el usuario", obj.get("id").getAsString());
    }
    
    @Test
    public void pruebaEliminarUsuario(){
        _usu = new FOM01_Usuario();
        _arrayUsu = new ArrayList<>();
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(_usu.eliminaUsuario("migue@gmail.com")).getAsJsonObject();
        assertEquals("Se eliminó el usuario", obj.get("correo").getAsString());
    }
    
    @Test
    public void pruebaIngresarUsuarioExistente(){
        _loginServicios = new FO1_Servicios();
        _arrayUsu = new ArrayList<>();
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(_loginServicios.insertaUsuario("Miguel", "Pinto", parseFecha("10/10/1995"), "M", "lepe", "Prueba", "123456mp", 0, "02129756419", false)).getAsJsonObject();
        assertEquals("usuario duplicado", obj.get("id").getAsString());
    }
    
      @After
    public void terminarPrueba(){

        
        try {      
        _usu = new FOM01_Usuario();
        _arrayUsu = new ArrayList<>();
        JsonParser parser = new JsonParser();
        JsonObject obj = parser.parse(_usu.eliminaUsuario("prueba@gma.vom")).getAsJsonObject();
        assertEquals("Se eliminó el usuario", obj.get("correo").getAsString());
      
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (Exception e){}   
    }
      
    
}
