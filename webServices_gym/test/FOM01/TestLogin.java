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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author Laura
 */
public class TestLogin {
    ResultSet _rs;
    FO1_Servicios _loginServicios;
    Usuario _usuarioDominio;
    ArrayList<Usuario> _arrayUsu;

    
    @Before
    public void comenzarPrueba() {
        
        Usuario usuario = FabricaEntidad.InstanciaUsuario
        ("Yesi","hola","Yesimar", "Hernandez",null,"F", "yyhernandez.13@gmail.com", 173,"04265121963",false);        
        IngresarUsuario c = FabricaComando.CrearRegUsuario(usuario);
        c.ejecutar();
      
    }
    
    //Prueba de Inicio de Sesión
    @Test
    public void pruebaIniciarSesion(){
        Gson gson = new Gson();
        _loginServicios = new FO1_Servicios();
        _arrayUsu = new ArrayList<>();
        _arrayUsu = gson.fromJson(_loginServicios.iniciarSesion("jorgepm", "123456jp"), new TypeToken<List<Usuario>>(){}.getType());
        assertNotEquals(0, _arrayUsu.get(0).getId());
    }
    
    @Test
    public void pruebaIngresarUsuario(){
        _loginServicios = new FO1_Servicios();
        String respuesta = _loginServicios.iniciarSesion("Yesi", "hola");
        assertNotNull( respuesta );
    }
    
      @After
    public void terminarPrueba(){

        
        try {
            Usuario usuario = FabricaEntidad.InstanciaUsuario
            ("Yesi","hola","Yesimar", "Hernandez",null,"F", "yyhernandez.13@gmail.com", 173,"04265121963",false);        
            ComandoEliminaUsuario c = FabricaComando.eliminaUsuario("yyhernandez.13@gmail.com");
            c.ejecutar();
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (Exception e){}   
    }
      
    
}
