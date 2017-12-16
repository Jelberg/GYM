/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosLayer;

import Comun.Dominio.FabricaEntidad;
import Comun.Dominio.Usuario;
import Comun.Dominio.Usuario_Amigo;
import Comun.Excepciones.ParameterNullException;
import Comun.Validaciones.ValidationWS;
import LogicaLayer.FO1.ComandoEliminaUsuario_Amigo;
import LogicaLayer.FO1.ComandoGetUsuario;
import LogicaLayer.FO1.ComandoInsertaUsuario_Amigo;
import LogicaLayer.FO1.ComandoListaUsuario_Amigo;
import LogicaLayer.FabricaComando;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
@Path("/Usuario_Amigo")
public class FOM01_Usuario_Amigo {
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Usuario> listaUsuario;
    
    /**
     * Funcion que recibe como parámetro el ID del Usuario,
     * para consultarlo.
     * @param idUsuario ID del Usuario.
     * @return Devuelve los datos en formato json
     */
    @GET
    @Path("/getUsuario_Amigo")
    @Produces("application/json")
    public String getUsuario_Amigo(@QueryParam("idUsuario") int idUsuario){
        
        try{
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
        }
        catch (Exception e) {
            response = e.getMessage();
        }
        finally {
            return response;
        }
    }
    
    /**
     * Funcion que recibe como parámetro el ID del Usuario,
     * para consultar sus amigos.
     * @param idUsuario ID del Usuario.
     * @return Devuelve una lista de amigos.
    */
    @GET
    @Path("/getListUsuario_Amigo")
    @Produces("application/json")
    public String getListUsuario_Amigo(@QueryParam("idUsuario") int idUsuario){
        
        try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("idUsuario", idUsuario);
            }});
        Usuario usuario = FabricaEntidad.InstanciaUsuarioId
        (idUsuario,"","","","","", null,"", 0, "", false, 0);  
        ComandoListaUsuario_Amigo c = FabricaComando.getListUsuario_Amigo(usuario);
        c.ejecutar();
        listaUsuario = c.getListUsuario_Amigo();
        response = gson.toJson( listaUsuario );
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
     * Funcion que es llamada cuando el usuario quiere agregar a un amigo.
     * @param idUsuario ID del Usuario.
     * @param idAmigo ID del Amigo.
     * @return Devuelve un json con mensaje del estatus de la peticion.
     */
    @POST
    @Path("/insertaUsuario_Amigo")
    @Produces("application/json")
    public String insertaUsuario_Amigo(  @QueryParam("idUsuario") int idUsuario,
            @QueryParam("idAmigo") int idAmigo){

        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("idUsuario", idUsuario );
                put("idAmigo", idAmigo );
            }});
            Usuario_Amigo usuarioamigo = FabricaEntidad.InstanciaUsuario_Amigo(idUsuario, idAmigo);        
            ComandoInsertaUsuario_Amigo c = FabricaComando.insertaUsuario_Amigo(usuarioamigo);
            c.ejecutar();
            response.put("data", c.getResultado());
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
     * Metodo que recibe como parametros el ID del Usuario
     * para eliminar un amigo.
     * @param idUsuario ID del Usuario.
     * @param idAmigo ID del Amigo.
     * @return Devuelve un json con elemento llamado data, 
     * contiene el mensaje de la peticion
     */
    @DELETE
    @Path("/eliminaUsuario_Amigo")
    @Produces("application/json")
    public String eliminaUsuario_Amigo(@QueryParam("idUsuario") int idUsuario,
                                       @QueryParam("idAmigo") int idAmigo){

        Map<String, String> response = new HashMap<String, String>();
        try{

            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("idUsuario", idUsuario);
                put("idAmigo", idAmigo);
            }});
            Usuario_Amigo usuarioamigo = FabricaEntidad.InstanciaEliminaUsuario_Amigo
                                                        (idUsuario, idAmigo);        
            ComandoEliminaUsuario_Amigo c = FabricaComando.eliminaUsuario_Amigo(usuarioamigo);
            c.ejecutar();
            response.put("data",c.getResultado());
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
