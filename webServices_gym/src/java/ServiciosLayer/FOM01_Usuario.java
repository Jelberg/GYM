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
import LogicaLayer.FO1.ComandoEliminaUsuario;
import LogicaLayer.FO1.ComandoGetUsuario;
import LogicaLayer.FO1.ComandoGetUsuarioNomApe;
import LogicaLayer.FO1.ComandoListaUsuario;
import LogicaLayer.FO1.ComandoModificaUsuario;
import LogicaLayer.FabricaComando;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author YESIMAR
 */
@Path("/Registrar_Usuario")
public class FOM01_Usuario {
    
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Usuario> listaUsuario;
    ConfigurarLogger cl = new ConfigurarLogger();
    Logger logr = cl.getLogr();
    

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public ArrayList<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(ArrayList<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
    
    /**
     * Funcion que recibe como parámetro el ID del Usuario,
     * para consultarlo y saber sus datos.
     * @param idUsuario ID del Usuario.
     * @return Devuelve los datos del usuario.
     */
    @GET
    @Path("/getUsuario")
    @Produces("application/json")
    public String getUsuario(@QueryParam("idUsuario") int idUsuario){
        
        try{
            logr.log(Level.WARNING, "Error");
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("idUsuario", idUsuario);
            }});
            Usuario usuario = FabricaEntidad.InstanciaUsuarioId
            (idUsuario,"","","","","", null,"", 0, "", false, 0);
            ComandoGetUsuario c = FabricaComando.getUsuario(usuario);
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
     * Funcion que recibe como parámetro el nombre y apellido del Usuario,
     * para consultarlo y saber sus datos.
     * @param nombre del Usuario.
     * @param apellido del Usuario.
     * @return Devuelve los datos del usuario.
     */
    @GET
    @Path("/getUsuarioNomApe")
    @Produces("application/json")
    public String getUsuarioNomApe(@QueryParam("nombre") String nombre, 
                                    @QueryParam("apellido") String apellido){
        try{
            logr.log(Level.WARNING, "Error");
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("nombre", nombre);
                put("apellido", apellido);
            }});
            Usuario usuario = FabricaEntidad.InstanciaUsuarioNomApe
            (0, "", nombre, apellido);        
            ComandoGetUsuarioNomApe c = FabricaComando.getUsuarioNomApe(usuario);
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
     * @return Devuelve una lista de usuarios.
     */
    @GET
    @Path("/getListUsuario")
    @Produces("application/json")
    public String getListUsuario(){
        ComandoListaUsuario c = FabricaComando.getListUsuario();
        c.ejecutar();
        listaUsuario = c.getListUsuario();
        response = gson.toJson( listaUsuario );
        return response;
    }
    
    /**
     * Metodo que recibe como parametros el correo del Usuario
     * para eliminar su cuenta.
     * @param correo correo del Usuario.
     * @return Devuelve el mensaje de la peticion.
     */
    @DELETE
    @Path("/eliminaUsuario")
    @Produces("application/json")
    public String eliminaUsuario(@QueryParam("correo") String correo){

        Map<String, String> response = new HashMap<String, String>();
        try{
            logr.log(Level.WARNING, "Error");
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("correo", correo);
            }});        
            ComandoEliminaUsuario c = FabricaComando.eliminaUsuario(correo);
            c.ejecutar();
            response.put("correo",c.getResultado());
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
     * Metodo que recibe como parametros los datos del usuario
     * para modificarlo.
     * @return Devuelve el mensaje de la petición.
     */
    @POST
    @Path("/modificaUsuario")
    @Produces("application/json")
    public String modificaUsuario(  @QueryParam("id") int id,
                                    @QueryParam("usuario") String usuar,
                                    @QueryParam("password") String password,
                                    @QueryParam("nombre") String nombre,
                                    @QueryParam("apellido") String apellido,
                                    @QueryParam("sexo") String sexo,
                                    @QueryParam("telefono") String telefono,
                                    @QueryParam("estatura") int estatura,
                                    @QueryParam("correo") String correo,
                                    @QueryParam("entrenador") Boolean entrenador,
                                    @QueryParam("codigo") int codigo) {
        Map<String, String> response = new HashMap<String, String>();
        try {
            logr.log(Level.WARNING, "Error");
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("id", id);
                put("usuario", usuar );
                put("password", password );
                put("nombre", nombre );
                put("apellido", apellido );
                put("sexo", sexo );
                put("telefono", telefono );
                put("estatura", estatura );
                put("correo", correo );
                put("entrenador", entrenador );
                put("codigo", codigo );
            }});
            Usuario usuario = FabricaEntidad.InstanciaModificaUsuario
            (id, usuar, password, nombre, apellido, sexo, telefono,
                    estatura, correo, entrenador, codigo);   
            ComandoModificaUsuario c = FabricaComando.modificaUsuario(usuario);
            c.ejecutar();
            response.put("id",c.getResultado());
        }
        catch (ParameterNullException e) {
            response.put("id", e.getMessage());
            logr.log(Level.WARNING, e.getMessage());
        }
        catch (Exception e) {
            response.put("id", e.getMessage());
            logr.log(Level.WARNING, e.getMessage());
        }
        finally {
            return gson.toJson(response);
        }
    }
}
