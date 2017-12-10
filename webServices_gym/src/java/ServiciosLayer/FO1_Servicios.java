/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosLayer;

import Comun.Dominio.FabricaEntidad;
import Comun.Dominio.Usuario;
import Comun.Excepciones.ParameterNullException;
import Comun.Validaciones.ValidationWS;
import LogicaLayer.Comando;
import LogicaLayer.FO1.ComandoIniciarSesion;
import LogicaLayer.FO1.IngresarUsuario;
import LogicaLayer.FabricaComando;
import com.google.gson.Gson;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
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
public class FO1_Servicios {
    private Gson gson = new Gson();
    private String response;
    
    
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
        }
        catch (Exception e) {
            response.put("error", e.getMessage());
        }
        finally {
            return gson.toJson(response);
        }
    }
    
    
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
    public String iniciarSesion(@QueryParam("usuario") String usuar,
                                @QueryParam("password") String password) {
    try
    {
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
        }
        catch (Exception e) {
            response = e.getMessage();
        }
        finally {
            return response;
        }
    }
}
