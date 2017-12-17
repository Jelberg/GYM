/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosLayer;

import Comun.Dominio.FabricaEntidad;
import Comun.Dominio.Usuario;
import Comun.Excepciones.ParameterNullException;
import Comun.Util.ConfigurarLogger;
import Comun.Validaciones.ValidationWS;
import LogicaLayer.FO1.ComandoActualizarCodigo;
import LogicaLayer.FO1.ComandoActualizarPassword;
import LogicaLayer.FO1.ComandoGetCorreo;
import LogicaLayer.FO1.ComandoIniciarSesion;
import LogicaLayer.FO1.IngresarUsuario;
import LogicaLayer.FabricaComando;
import com.google.gson.Gson;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Miguel
 */
@Path("/Login")
public class FOM01_Login {
    
    private Gson gson = new Gson();
    private String response;
    ConfigurarLogger cl = new ConfigurarLogger();
    Logger logr = cl.getLogr();
    
    /**
     * Metodo que recibe como parametros los datos del usuario
     * para registrarlo.
     * @param nombre
     * @param apellido
     * @param fecha
     * @param sexo
     * @param correo
     * @param usuar
     * @param password
     * @param estatura
     * @param telefono
     * @param entrenador
     * @return Devuelve el mensaje de la petición.
     */
    @POST
    @Path("/insertausuario")
    @Produces("application/json")
    public String insertaUsuario(@QueryParam("nombre") String nombre,
                                    @QueryParam("apellido") String apellido,
                                    @QueryParam("fechanac") Date fecha,
                                    @QueryParam("sexo") String sexo,
                                    @QueryParam("correo") String correo,
                                    @QueryParam("usuario") String usuar,
                                    @QueryParam("password") String password,
                                    @QueryParam("estatura") int estatura,
                                    @QueryParam("telefono") String telefono,
                                    @QueryParam("entrenador") boolean entrenador){
        Map<String, String> response = new HashMap<String, String>();
        try{
            logr.log(Level.WARNING, "Error");
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
            put("nombre", nombre);
            put("apellido", apellido);
            put("fechanac", fecha);
            put("sexo", sexo);
            put("correo", correo);
            put("usuario", usuar);
            put("password", password);
            put("estatura", estatura);
            put("telefono", telefono); 
            put("entrenador", entrenador);
            }});              
            Usuario usuario = FabricaEntidad.InstanciaUsuario
            (usuar, password, nombre, apellido, fecha, sexo, correo, estatura, telefono, entrenador);        
            IngresarUsuario c = FabricaComando.CrearRegUsuario(usuario);
            c.ejecutar();
            response.put("id", c.getUsuario().getNombre());
        }
        catch (ParameterNullException e) {
            response.put("error", e.getMessage());
            logr.log(Level.WARNING, e.getMessage());
        }
        catch (Exception e) {
            response.put("error", e.getMessage());
            logr.log(Level.WARNING, e.getMessage());
        }
        finally {
            return gson.toJson(response);
        }
    }
    
    
    /**
     * Funcion que recibe como parámetro el usuario y contraseña del cliente,
     * para iniciar sesión.
     * @param usuar
     * @param password
     * @return Devuelve el usuario.
     */
    @GET
    @Path("/IniciarSesion")
    @Produces("application/json")
    public String iniciarSesion(@QueryParam("usuario") String usuar,
                                @QueryParam("password") String password) {
        try
        { 
            logr.log(Level.WARNING, "Error");
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
            put("usuario", usuar);
            put("password", password);
            }});
            Usuario usuario = FabricaEntidad.InstanciaUsuario
            (usuar, password, "", "", null, "", "", 0, "", false);        
            ComandoIniciarSesion c = FabricaComando.IniciarUsuario(usuario);
            c.ejecutar();
            response = c.getResultado();
        }
        catch (ParameterNullException e) {
            response = e.getMessage();
            logr.log(Level.WARNING, e.getMessage());
        }
        catch (Exception e) {
            response = e.getMessage();
            logr.log(Level.WARNING, e.getMessage());    
        }
        finally {
            return response;
        }
    }
    
    /**
     * Funcion que recibe como parámetro el correo,
     * para actualizar el código de recuperar contraseña.
     * @param correo
     * @return Devuelve el código.
     */
    @POST
    @Path("/updateCodigo")
    @Produces("application/json")
    public String updateCod(@QueryParam("correo") String correo){
        
        Map<String, String> response = new HashMap<String, String>();
        try{
            logr.log(Level.WARNING, "Error");
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
            put("correo", correo);
            }});   
            Usuario usuario = FabricaEntidad.InstanciaUsuario
            ("", "", "", "", null, "", correo, 0, "", false);        
            ComandoActualizarCodigo c = FabricaComando.actualizarCodigo(usuario);
            c.ejecutar();
            String d = c.getResultado();
            if ( d == "Se actualizo el codigo")
            {
                response.put("id",String.valueOf(c.getUsuario().getCodigo()));
            }
            else response.put("error", d);           
        }
        catch (ParameterNullException e) {
            response.put("error", e.getMessage());
            logr.log(Level.WARNING, e.getMessage());
        }
        catch (Exception e) {
            response.put("error", e.getMessage());
            logr.log(Level.WARNING, e.getMessage());
        }
        finally {
            return gson.toJson(response);
        }  
    }
    
    /**
     * Funcion que recibe como parámetro el correo y contraseña,
     * para actualizar la contraseña.
     * @param correo
     * @param password
     * @return Devuelve el resultado.
     */
    @POST
    @Path("/updatePass")
    @Produces("application/json")
    public String updatePass(@QueryParam("correo") String correo, 
                             @QueryParam("password") String password){
        Map<String, String> response = new HashMap<String, String>();
        try{
            logr.log(Level.WARNING, "Error");
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
            put("correo", correo);
            put("password", password);
            }});
            Usuario usuario = FabricaEntidad.InstanciaUsuario
            ("", password, "", "", null, "", correo, 0, "", false);        
            ComandoActualizarPassword c = FabricaComando.actualizarPassword(usuario);
            c.ejecutar();
            response.put("id",c.getResultado());  
        }
        catch (ParameterNullException e) {
            response.put("id","");
            logr.log(Level.WARNING, e.getMessage());
        }
        catch (Exception e) {
            response.put("id","");
            logr.log(Level.WARNING, e.getMessage());
        }
        finally {
            return gson.toJson(response);
        }
    }
    
    /**
     * Funcion que recibe como parámetro el correo del usuario,
     * para consultarlo y saber sus datos.
     * @param correo
     * @return Devuelve el usuario .
     */
    @GET
    @Path("/getUsuarioCorreo")
    @Produces("application/json")
    public String getUsuarioCorreo(@QueryParam("correo") String correo) {
        Map<String, String> response = new HashMap<String, String>();
        try
        {
            logr.log(Level.WARNING, "Error");
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
            put("correo", correo);
            }});
            Usuario usuario = FabricaEntidad.InstanciaUsuario
            ("", "", "", "", null, "", correo, 0, "", false);        
            ComandoGetCorreo c = FabricaComando.getCorreo(usuario);
            c.ejecutar();
            response.put("id",c.getResultado());
        }
        catch (ParameterNullException e) {
            response.put("error",e.getMessage());
            logr.log(Level.WARNING, e.getMessage());
        }
        catch (Exception e) {
            response.put("error",e.getMessage());
            logr.log(Level.WARNING, e.getMessage());;
        }
        finally {
            return gson.toJson(response);
        }
    }
    
}
