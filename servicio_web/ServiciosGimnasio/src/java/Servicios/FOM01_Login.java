/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Connection.FOM01_Login_Conn;
import Dominio.Sql;
import Excepciones.ParameterNullException;
import Validaciones.ValidationWS;
import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


/**
 *
 * @author Miguel
 */

@Path("/Login")
public class FOM01_Login {
private String response;


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
    public String iniciarSesion(@QueryParam("id") int id) {
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
}
