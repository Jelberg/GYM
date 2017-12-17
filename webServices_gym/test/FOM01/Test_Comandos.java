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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
    ArrayList<Usuario_Amigo> _arrayUsuAmi;
    String _s;
    
    @Before
    public void comenzarPrueba() {
        _usuarioDominio = FabricaEntidad.InstanciaUsuario
        ("Yesi","hola","Yesimar", "Hernandez",null,"F", "yyhernandez@gmail.com", 173,"04265121963",false);        
        ("Yesi","hola","Yesimar", "Hernandez",parseFecha("10/10/1999"),"F", "yyhernandez.13@gmail.com", 173,"04265121963",false);        
        IngresarUsuario c = FabricaComando.CrearRegUsuario(_usuarioDominio);
        c.ejecutar();
    }
    
    //Prueba IngresarUsuario
    //Función: ejecutar
    @Test
    public void pruebaEjecutarIngresarUsuario(){
        
        Usuario usuarioDominio = FabricaEntidad.InstanciaUsuario
        ("PRUEBA","holaaa","Yesimar", "Hernandez",parseFecha("10/10/1999"),"F", "yyhernandez@gmail.com", 173,"04265121963",false);        
        _ingresarU = new IngresarUsuario(usuarioDominio);
        _ingresarU.ejecutar();
        String mensaje = (_ingresarU.getUsuario().getNombre());
        assertEquals(mensaje, "Se inserto el usuario");
        
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
    
    //Prueba ComandoActualizarCodigo
    //Función: recuperarContrasena
    @Test
    public void pruebaRecuperarContrasena(){
        _comandoAC = new ComandoActualizarCodigo(_usuarioDominio);
        int codigo = (_comandoAC.recuperarContrasena("yyhernandez@gmail.com"));
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
    @Test
   public void pruebaEjecutarComandoActualizarCodigo(){
        _comandoAC = new ComandoActualizarCodigo(_usuarioDominio);
        _comandoAC.ejecutar();
        String mensaje = (_comandoAC.getResultado());
        assertEquals(mensaje, "Se actualizo el codigo");
    }
    
    //Prueba ComandoActualizarPassword
    //Función: ejecutar
    //QUIIIIIIIIII
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
        assertEquals(mensaje, "Se actualizo la contrasena");
    }
    
    //Prueba ComandoInsertaUsuario_Amigo
    //Función: ejecutar
    @Test
    public void pruebaEjecutarComandoInsertaUsuario_Amigo(){
        _usuario_AmigoDominio= new Usuario_Amigo(1,1);
        _comandoIUA = new ComandoInsertaUsuario_Amigo(_usuario_AmigoDominio);
        _comandoIUA.ejecutar();
        String mensaje = (_comandoIUA.getResultado());
        assertEquals(mensaje, "Se agregó el amigo");
    }
    
    //Prueba ComandoEliminaUsuario_Amigo
    //Función: ejecutar
    @Test
    public void pruebaEjecutarComandoEliminaUsuario_Amigo(){
        _comandoEUA = new ComandoEliminaUsuario_Amigo(_usuario_AmigoDominio);
        _comandoEUA.ejecutar();
        String mensaje = (_comandoEUA.getResultado());

        _usuario_AmigoDominio= new Usuario_Amigo(1,1);
        _comandoEUA = new ComandoEliminaUsuario_Amigo(_usuario_AmigoDominio);
        _comandoEUA.ejecutar();
        String mensaje = (_comandoEUA.getResultado());
        assertEquals(mensaje, "Se eliminó el amigo");
    }
    
    //Prueba ComandoGetCorreo
    //Función: ejecutar
    @Test
    public void pruebaEjecutarComandoGetCorreo(){
        _comandoGC = new ComandoGetCorreo(_usuarioDominio);
        _comandoGC.ejecutar();
        String mensaje = (_comandoGC.getResultado());
<<<<<<< HEAD
=======
        assertNotEquals(mensaje, "0");
>>>>>>> f132f001bcd08984c5ab97592f3c00b76ad3affc
    }
    
    //Prueba ComandoGetUsuario
    //Función: ejecutar
    @Test
    public void pruebaEjecutarComandoGetUsuario(){
        _comandoGU = new ComandoGetUsuario(_usuarioDominio);
        _comandoGU.ejecutar();
<<<<<<< HEAD
        String mensaje = (_comandoGU.getResultado());
=======
        assertFalse(_comandoGU.getResultado().isEmpty());
>>>>>>> f132f001bcd08984c5ab97592f3c00b76ad3affc
    }
    
    //Prueba ComandoGetUsuarioNomApe
    //Función: ejecutar
    @Test
    public void pruebaEjecutarComandoGetUsuarioNomApe(){
        _comandoGUNA = new ComandoGetUsuarioNomApe(_usuarioDominio);
        _comandoGUNA.ejecutar();
<<<<<<< HEAD
        String mensaje = (_comandoGUNA.getResultado());
=======
        assertFalse(_comandoGUNA.getResultado().isEmpty());
>>>>>>> f132f001bcd08984c5ab97592f3c00b76ad3affc
    }
    
    //Prueba ComandoIniciarSesion
    //Función: ejecutar
    @Test
    public void pruebaEjecutarComandoIniciarSesion(){
<<<<<<< HEAD
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
=======
        
        _comandoIS = new ComandoIniciarSesion(_usuarioDominio);
        _comandoIS.ejecutar();
        String mensaje = (_comandoIS.getResultado());
        assertFalse(_comandoIS.getResultado().isEmpty());
    }
    
    
>>>>>>> f132f001bcd08984c5ab97592f3c00b76ad3affc
    
    //Prueba ComandoListaUsuario
    //Función: ejecutar
    @Test
    public void pruebaEjecutarComandoListaUsuario(){
        _comandoLU = new ComandoListaUsuario(_usuarioDominio);
        _comandoLU.ejecutar();
<<<<<<< HEAD
        String mensaje = (_comandoLU.getResultado());
=======
        _arrayUsu = new ArrayList<Usuario>();
        _arrayUsu = (_comandoLU.getListUsuario());
        assertFalse(_arrayUsu.isEmpty());
>>>>>>> f132f001bcd08984c5ab97592f3c00b76ad3affc
    }
    
    //Prueba ComandoListaUsuario_Amigo
    //Función: ejecutar
    @Test
    public void pruebaEjecutarComandoListaUsuario_Amigo(){
<<<<<<< HEAD
        _comandoLUA = new ComandoListaUsuario_Amigo(_usuarioDominio);
        _comandoLUA.ejecutar();
        String mensaje = (_comandoLUA.getResultado());
=======
        Usuario usuarioDominio = new Usuario(1, "", "", "");
        _comandoLUA = new ComandoListaUsuario_Amigo(usuarioDominio);
        _comandoLUA.ejecutar();
        _arrayUsuAmi = new ArrayList<Usuario_Amigo>();
        _arrayUsu = (_comandoLUA.getListUsuario_Amigo());
        assertFalse(_arrayUsu.isEmpty());
>>>>>>> f132f001bcd08984c5ab97592f3c00b76ad3affc
    }
    
    //Prueba ComandoModificaUsuario
    //Función: ejecutar
    @Test
    public void pruebaEjecutarComandoModificaUsuario(){
        _comandoMU = new ComandoModificaUsuario(_usuarioDominio);
        _comandoMU.ejecutar();
        String mensaje = (_comandoMU.getResultado());
    }
    
<<<<<<< HEAD
    //Prueba IngresarUsuario
    //Función: ejecutar
    @Test
    public void pruebaEjecutarIngresarUsuario(){
        _ingresarU = new IngresarUsuario(_usuarioDominio);
        _ingresarU.ejecutar();
//        String mensaje = (_ingresarU.getResultado());
=======
    
    
    //Prueba ComandoEliminaUsuario
    //Función: ejecutar
    @Test
    public void pruebaEjecutarComandoEliminaUsuario(){
        _comandoEU = new ComandoEliminaUsuario("yyhernandez@gmail.com");
        _comandoEU.ejecutar();
        String mensaje = (_comandoEU.getResultado());
        assertEquals(mensaje, "Se eliminó el usuario");
>>>>>>> f132f001bcd08984c5ab97592f3c00b76ad3affc
    }
    
    @After
    public void terminarPrueba(){
        try {
<<<<<<< HEAD
            Usuario usuario = FabricaEntidad.InstanciaUsuario
            ("Yesi","hola","Yesimar", "Hernandez",null,"F", "yyhernandez.13@gmail.com", 173,"04265121963",false);        
            ComandoEliminaUsuario c = FabricaComando.eliminaUsuario("yyhernandez.13@gmail.com");
            c.ejecutar();
=======
        _comandoEU = new ComandoEliminaUsuario("yyhernandez.13@gmail.com");
        _comandoEU.ejecutar();
>>>>>>> f132f001bcd08984c5ab97592f3c00b76ad3affc
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (Exception e){}   
    }
}
