/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FOM01;

import Comun.Dominio.FabricaEntidad;
import Comun.Dominio.Usuario;
import LogicaLayer.FO1.ComandoActualizarCodigo;
import LogicaLayer.FO1.ComandoActualizarPassword;
import LogicaLayer.FO1.ComandoEliminaUsuario;
import LogicaLayer.FO1.ComandoEliminaUsuario_Amigo;
import LogicaLayer.FO1.ComandoGetCorreo;
import LogicaLayer.FO1.ComandoGetUsuario;
import LogicaLayer.FO1.ComandoGetUsuarioNomApe;
import LogicaLayer.FO1.ComandoIniciarSesion;
import LogicaLayer.FO1.ComandoInsertaUsuario_Amigo;
import LogicaLayer.FO1.ComandoListaUsuario;
import LogicaLayer.FO1.ComandoListaUsuario_Amigo;
import LogicaLayer.FO1.ComandoModificaUsuario;
import LogicaLayer.FO1.IngresarUsuario;
import LogicaLayer.FabricaComando;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author YESIMAR
 */
public class Test_Comandos {
    ResultSet _rs;
    ComandoActualizarCodigo _comandoAC;
    ComandoActualizarPassword _comandoAP;
    ComandoEliminaUsuario _comandoEU;
    ComandoEliminaUsuario_Amigo _comandoEUA;
    ComandoGetCorreo _comandoGC;
    ComandoGetUsuario _comandoGU;
    ComandoGetUsuarioNomApe _comandoGUNA;
    ComandoIniciarSesion _comandoIS;
    ComandoInsertaUsuario_Amigo _comandoIUA;
    ComandoListaUsuario _comandoLU;
    ComandoListaUsuario_Amigo _comandoLUA;
    ComandoModificaUsuario _comandoMU;
    IngresarUsuario _ingesarU;
    Usuario _usuarioDominio;
    ArrayList<Usuario> _arrayUsu;
    
    @Before
    public void comenzarPrueba() {
        Usuario usuario = FabricaEntidad.InstanciaUsuario
        ("Yesi","hola","Yesimar", "Hernandez",null,"F", "yyhernandez.13@gmail.com", 173,"04265121963",false);        
        IngresarUsuario c = FabricaComando.CrearRegUsuario(usuario);
        c.ejecutar();
    }
    
    //Prueba ComandoActualizarCodigo
    //Función: recuperarContrasena
    @Test
    public void puebaRecuperarContrasena(){
        Gson gson = new Gson();
        _comandoAC = new ComandoActualizarCodigo(_usuarioDominio);
        _arrayUsu = new ArrayList<>();
        //_arrayUsu = gson.fromJson(_comandoAC.recuperarContrasena("yyhernandez.13@gmail.com"), new TypeToken<List<Usuario>>(){}.getType());
    }
    
    //Prueba ComandoActualizarCodigo
    //Función: sendEmail
    @Test
    public void pruebaSendEmail(){
        
    }
    
    //Prueba ComandoActualizarCodigo
    //Función: randInt
    @Test
    public void pruebaRandInt(){
        
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
