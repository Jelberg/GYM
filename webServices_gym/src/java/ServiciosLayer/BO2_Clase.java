/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosLayer;

import Comun.Dominio.Clase;
import Comun.Dominio.Entidad;
import Comun.Dominio.FabricaEntidad;
import Comun.Excepciones.ParameterNullException;
import Comun.Validaciones.ValidationWS;
import LogicaLayer.BO2.ComandoBuscaClasePorId;
import LogicaLayer.BO2.ComandoClaseConsultaDescripcion;
import LogicaLayer.BO2.ComandoConsultarClase;
import LogicaLayer.FabricaComando;
import com.google.gson.Gson;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static javax.swing.UIManager.put;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author marvian
 */
public class BO2_Clase {
    private Gson _gson = new Gson();
    private String _response;
    private ArrayList<Clase> _listaClases;
    private Entidad _Clase;
    
    /**
     * Metodo que es llamado cuando se desea obtener a todas las clases.
     * @return devuelve la lista de todas las clases y sus atributos.
     */
    @GET
    @Path("/getListClase")
    @Produces("application/json")
    public String getListaClase(){
        ComandoConsultarClase cmd = FabricaComando.instanciaCmdConsultaClase();
        cmd.ejecutar();
        _listaClases = cmd.consultarClase();
        _response = _gson.toJson( _listaClases);
        return _response;
    }
    
    /**
     * Funcion que es llamada cuando el admin desea insertar una clase.
     * @param nombre Nombre de la clase.
     * @param descripcion Descripción de la clase.
     * @return Devuelve un json con mensaje del estatus de la peticion.
     */
    @POST
    @Path("/insertaClase")
    @Produces("application/json")
    public String insertaClase(  @QueryParam("nombre") String nombre,
                                 @QueryParam("descripcion") String descripcion){

        Map<String, String> response = new HashMap<String, String>();
        try {
            
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("nombre", nombre );
                put("descripcion", descripcion );
            }});
            
            Entidad clase = FabricaEntidad.instanciaInsertarClase(nombre, descripcion);
            
           
            }
        
        catch (ParameterNullException e) {
            response.put("error, parametro vacio", e.getMessage());
        }
        catch (Exception e) {
            response.put("error", e.getMessage());
        }
        finally {
            
            return _gson.toJson(response);
        }
    
    }
    
    /**
     * Metodo que recibe como parametros el nombre de la clase
     * para eliminarla.
     * @param nombre Nombre de la clase.
     * @return Devuelve un json con elemento llamado data, 
     * contiene el mensaje de la peticion
     */
    @DELETE
    @Path("/eliminaClase")
    @Produces("application/json")
    public String eliminaClase(@QueryParam("nombre") String nombre){

        Map<String, String> response = new HashMap<String, String>();
        try{

            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("nombre", nombre);
            }});
                
            Entidad clase = FabricaEntidad.instanciaEliminaClase(nombre);
            
           
            }
        
        catch (ParameterNullException e) {
            response.put("error", e.getMessage());
        }
        catch (Exception e) {
            response.put("error", e.getMessage());
        }
        finally {            
            return _gson.toJson(response);
        }
    }
    
    /**
     * Funcion que modifica alguna clase.
     * @param nombre Nombre de la clase.
     * @param descripcion Descripción de la clase.
     * @return Devuelve un json con un mensaje al usuario sobre el estatus
     * de la petición.
     */
    @POST
    @Path("/modificaClase")
    @Produces("application/json")
    public String modificaClase( @QueryParam ( "nombre" ) String nombre,
                                   @QueryParam ( "descripcion" ) String descripcion){
        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put ( "nombre" , nombre );
                put( "descripcion" , descripcion );
            }});
            
            Entidad clase = FabricaEntidad.instanciaModificarClase(nombre, descripcion);
        }
        catch (ParameterNullException e) {
            response.put("error", e.getMessage());
        }
        catch (Exception e) {
            response.put("error", e.getMessage());
        }
        finally {
            return _gson.toJson(response);
        }
    } 
    
    /**
     * Funcion que recibe como parámetro el nombre de la clase,
     * para consultarla y saber su descripción.
     * @param nombre Nombre de la clase.
     * @return Devuelve la clase y su descripción en formato json
     */
    @GET
    @Path("/getClase")
    @Produces("application/json")
    public String buscaDescripcion(@QueryParam("nombre") String nombre){
    
        ComandoClaseConsultaDescripcion cmd = FabricaComando.instanciaCmdClaseConsultaDescripcion();
        cmd.ejecutar();
        _listaClases = cmd.consultarDescripcionClase();
        _response = _gson.toJson( _listaClases);
        return _response;
    }
    
    @GET
    @Path("/getClaseId")
    @Produces("application/json")
    public String buscaPorId(@QueryParam("id") int id){
        ComandoBuscaClasePorId cmd = FabricaComando.instanciaCmdBuscaClasePorId();
        cmd.ejecutar();
        _listaClases = cmd.consultarBuscaClasePorId();
        _response = _gson.toJson( _listaClases);
        return _response;
        }
 
}
