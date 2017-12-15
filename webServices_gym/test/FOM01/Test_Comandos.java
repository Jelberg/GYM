/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FOM01;

import Comun.Dominio.FabricaEntidad;
import Comun.Dominio.Usuario;
import Comun.Dominio.Usuario_Amigo;
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
import java.sql.ResultSet;
import java.util.ArrayList;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
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
    IngresarUsuario _ingresarU;
    Usuario _usuarioDominio;
    Usuario_Amigo _usuario_AmigoDominio;
    ArrayList<Usuario> _arrayUsu;
    String _s;
    
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
    public void pruebaRecuperarContrasena(){
        _comandoAC = new ComandoActualizarCodigo(_usuarioDominio);
        int codigo = (_comandoAC.recuperarContrasena("yyhernandez.13@gmail.com"));
        assertNotEquals(codigo, 0);
    }
    
    //Prueba ComandoActualizarCodigo
    //Función: sendEmail
    @Test
    public void pruebaSendEmail(){
        _comandoAC = new ComandoActualizarCodigo(_usuarioDominio);
        boolean codigo = (_comandoAC.sendEmail("yyhernandez.13@gmail.com",0));
        assertNotEquals(codigo, 0);
    }
    
    //Prueba ComandoActualizarCodigo
    //Función: randInt
    @Test
    public void pruebaRandInt(){
        _comandoAC = new ComandoActualizarCodigo(_usuarioDominio);
        int rango = (_comandoAC.randInt(100000,999999));
        assertNotEquals(rango,0);
    }
    
    //Prueba ComandoActualizarCodigo
    //Función: ejecutar
//    @Test
//    public void pruebaEjecutarComandoActualizarCodigo(){
//        _comandoAC = new ComandoActualizarCodigo(_usuarioDominio);
//        _comandoAC.ejecutar();
//        String mensaje = (_comandoAC.getResultado());
//    }
    
    //Prueba ComandoActualizarPassword
    //Función: ejecutar
    @Test
    public void pruebaEjecutarComandoActualizarPassword(){
        _comandoAP = new ComandoActualizarPassword(_usuarioDominio);
        _comandoAP.ejecutar();
        String mensaje = (_comandoAP.getResultado());
    }
    
    //Prueba ComandoEliminaUsuario
    //Función: ejecutar
    @Test
    public void pruebaEjecutarComandoEliminaUsuario(){
        _comandoEU = new ComandoEliminaUsuario(_s);
        _comandoEU.ejecutar();
        String mensaje = (_comandoEU.getResultado());
    }
    
    //Prueba ComandoEliminaUsuario_Amigo
    //Función: ejecutar
    @Test
    public void pruebaEjecutarComandoEliminaUsuario_Amigo(){
        _comandoEUA = new ComandoEliminaUsuario_Amigo(_usuario_AmigoDominio);
        _comandoEUA.ejecutar();
        String mensaje = (_comandoEUA.getResultado());
    }
    
    //Prueba ComandoGetCorreo
    //Función: ejecutar
    @Test
    public void pruebaEjecutarComandoGetCorreo(){
        _comandoGC = new ComandoGetCorreo(_usuarioDominio);
        _comandoGC.ejecutar();
        String mensaje = (_comandoGC.getResultado());
    }
    
    //Prueba ComandoGetUsuario
    //Función: ejecutar
    @Test
    public void pruebaEjecutarComandoGetUsuario(){
        _comandoGU = new ComandoGetUsuario(_usuarioDominio);
        _comandoGU.ejecutar();
        String mensaje = (_comandoGU.getResultado());
    }
    
    //Prueba ComandoGetUsuarioNomApe
    //Función: ejecutar
    @Test
    public void pruebaEjecutarComandoGetUsuarioNomApe(){
        _comandoGUNA = new ComandoGetUsuarioNomApe(_usuarioDominio);
        _comandoGUNA.ejecutar();
        String mensaje = (_comandoGUNA.getResultado());
    }
    
    //Prueba ComandoIniciarSesion
    //Función: ejecutar
    @Test
    public void pruebaEjecutarComandoIniciarSesion(){
        _comandoIS = new ComandoIniciarSesion(_usuarioDominio);
        _comandoIS.ejecutar();
        String mensaje = (_comandoIS.getResultado());
    }
    
    //Prueba ComandoInsertaUsuario_Amigo
    //Función: ejecutar
    @Test
    public void pruebaEjecutarComandoInsertaUsuario_Amigo(){
        _comandoIUA = new ComandoInsertaUsuario_Amigo(_usuario_AmigoDominio);
        _comandoIUA.ejecutar();
        String mensaje = (_comandoIUA.getResultado());
    }
    
    //Prueba ComandoListaUsuario
    //Función: ejecutar
    @Test
    public void pruebaEjecutarComandoListaUsuario(){
        _comandoLU = new ComandoListaUsuario(_usuarioDominio);
        _comandoLU.ejecutar();
        String mensaje = (_comandoLU.getResultado());
    }
    
    //Prueba ComandoListaUsuario_Amigo
    //Función: ejecutar
    @Test
    public void pruebaEjecutarComandoListaUsuario_Amigo(){
        _comandoLUA = new ComandoListaUsuario_Amigo(_usuarioDominio);
        _comandoLUA.ejecutar();
        String mensaje = (_comandoLUA.getResultado());
    }
    
    //Prueba ComandoModificaUsuario
    //Función: ejecutar
    @Test
    public void pruebaEjecutarComandoModificaUsuario(){
        _comandoMU = new ComandoModificaUsuario(_usuarioDominio);
        _comandoMU.ejecutar();
        String mensaje = (_comandoMU.getResultado());
    }
    
    //Prueba IngresarUsuario
    //Función: ejecutar
    @Test
    public void pruebaEjecutarIngresarUsuario(){
        _ingresarU = new IngresarUsuario(_usuarioDominio);
        _ingresarU.ejecutar();
//        String mensaje = (_ingresarU.getResultado());
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
