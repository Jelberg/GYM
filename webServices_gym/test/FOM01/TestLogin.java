/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FOM01;
import Comun.Dominio.FabricaEntidad;
import Comun.Dominio.Usuario;
import LogicaLayer.FO1.IngresarUsuario;
import LogicaLayer.FabricaComando;
import ServiciosLayer.FO1_Servicios;
import com.google.gson.Gson;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.junit.After;
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
    ArrayList<Usuario> _arrayUsuario;
    
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
        String respuesta = _loginServicios.iniciarSesion("Yesi", "hola");
        assertNotNull( respuesta );
    }
    
    
    
}
