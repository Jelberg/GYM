/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Connection.FOM01_Login_Conn;
import com.google.gson.Gson;
import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import Validaciones.ValidationWS;
import Excepciones.ParameterNullException;
import java.util.Map;
import javax.ws.rs.POST;


/**
 *
 * @author Miguel
 */

@Path("/Login")
public class FOM01_Login {
private String response;
private Gson gson = new Gson();


/**
     * Funcion que recibe como parámetro el usuario y contrasena del cliente,
     * para consultarla y saber sus datos.
     * @param usuario
     * @param password
     * @return Devuelve el usuario 
     */
    @GET
    @Path("/IniciarSesion")
    @Produces("application/json")
    public String iniciarSesion(@QueryParam("usuario") String usuario,
                                @QueryParam("password") String password) {
    try
    {
        ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
        put("usuario", usuario);
        put("password", password);
        }});
        FOM01_Login_Conn conexion = new FOM01_Login_Conn();
        response= conexion.iniciarSesion(usuario, password);
    }
    catch (ParameterNullException e) {
            response = e.getMessage();
        }
        catch (Exception e) {
            response = e.getMessage();
        }
        finally {
            return response;
        }
    }
    
    
    /**
     * Funcion que recibe como parámetro el id del usuario,
     * para consultarla y saber sus datos.
     * @param id
     * @return Devuelve el usuario 
     */
    @GET
    @Path("/getUsuario")
    @Produces("application/json")
    public String getUsuario(@QueryParam("id") int id) {
    try
    {
        ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
        put("id", id);
        }});
        FOM01_Login_Conn conexion = new FOM01_Login_Conn();
        response= conexion.get_Usuario(id);
    }
    catch (ParameterNullException e) {
            response = e.getMessage();
        }
        catch (Exception e) {
            response = e.getMessage();
        }
        finally {
            return response;
        }
    }
    
    @POST
    @Path("/insertausuario")
    @Produces("application/json")
    public String insertaUsuario(@QueryParam("nombre") String nombre,
                                    @QueryParam("apellido") String apellido,
                                    @QueryParam("fechanac") String fecha,
                                    @QueryParam("sexo") String sexo,
                                    @QueryParam("correo") String correo,
                                    @QueryParam("usuario") String usuario,
                                    @QueryParam("password") String password,
                                    @QueryParam("estatura") int estatura,
                                    @QueryParam("telefono") String telefono,
                                    @QueryParam("entrenador") boolean entrenador
                                    )
    {
        Map<String, String> response = new HashMap<String, String>();
        try{    
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
            put("nombre", nombre);
            put("apellido", apellido);
            put("fechanac", fecha);
            put("sexo", sexo);
            put("correo", correo);
            put("usuario", usuario);
            put("password", password);
            put("estatura", estatura);
            put("telefono", telefono); 
            put("entrenador", entrenador);
            }});
            FOM01_Login_Conn conexion = new FOM01_Login_Conn();
            response.put("id",conexion.insertaInstruct(nombre,apellido,fecha,sexo,correo,usuario,password,estatura,telefono,entrenador));
        }
        catch (ParameterNullException e) {
            response.put("error", e.getMessage());
        }
        catch (Exception e) {
            response.put("error", e.getMessage());
        }
        finally {
            return gson.toJson(response);
        }
    }
}
