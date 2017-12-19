/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosLayer;

import Comun.Dominio.Entidad;
import Comun.Dominio.Entrenador;
import Comun.Dominio.FabricaEntidad;
import Comun.Excepciones.ParameterNullException;
import Comun.Validaciones.ValidationWS;
import LogicaLayer.BO2.ComandoConsultaEntrenadorCorreo;
import LogicaLayer.BO2.ComandoConsultaEntrenadores;
import LogicaLayer.BO2.ComandoEliminaEntrenador;
import LogicaLayer.BO2.ComandoInsertarEntrenador;
import LogicaLayer.BO2.ComandoModificarEntrenador;
import LogicaLayer.FabricaComando;
import com.google.gson.Gson;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
 * @author gilbert
 */
@Path("/BOM02_Entrenador")
public class BOm02_Entrenador {
    private Gson _gson = new Gson();
    private String _response;
    private ArrayList<Entrenador> _listaEntrenadores;
    private Entidad _entrenador;
    
    /**
     * Metodo que es llamado cuando se desea obtener a todos los entrenadores.
     * @return devuelve la lista de todos los entrenadores y sus atributos.
     */
    @GET
    @Path("/getListEntrenador")
    @Produces("application/json")
    public String getListaEntrenador(){
        ComandoConsultaEntrenadores cmd = FabricaComando.instanciaCmdConsultaEntrenadores();
        cmd.ejecutar();
        _listaEntrenadores = cmd.getEntrenadores();
        _response = _gson.toJson( _listaEntrenadores );
        return _response;
    }
    /**
     * Metodo que busca a un entrenador por su correo y devuelve sus datos
     * @param correo El correo personal del entrenador.
     * @return devuelve un JSON con los datos del entrenador.
     */
    @GET
    @Path("/getEntrenador")
    @Produces("application/json")
    public String getEntrenadorCorreo( @QueryParam("correo") String correo ){
        Entidad entrenador = FabricaEntidad.instanciaEntrenadorCorreo( correo );
        ComandoConsultaEntrenadorCorreo cmd = FabricaComando.instanciaCmdConsultaEntCorreo( entrenador );
        cmd.ejecutar();
        _entrenador = cmd.getEntrenador();
        Entrenador ent = ( Entrenador ) _entrenador;
        _response = _gson.toJson( ent );
        return _response;
    }
    /**
     * Metodo que es llamado cuando se va a realizar la insercion de un nuevo
     * entrenador en la base de datos.
     * @param nombre Nombre del entrenador.
     * @param apellido Apellido del entrenador.
     * @param fecha Fecha de naciminto del entrenador.
     * @param sexo Sexo del entrenador
     * @param correo Correo personal del entrenador.
     * @param historial Historial del entrenador.
     * @return Devuelve un mensaje que indiva si fue realizada la insercion.
     */
    @POST
    @Path("/insertarEntrenador")
    @Produces("application/json")
    public String insertarEntrenador(@QueryParam("nombre") String nombre,
                                    @QueryParam("apellido") String apellido,
                                    @QueryParam("fechanac") String fecha,
                                    @QueryParam("sexo") String sexo,
                                    @QueryParam("correo") String correo,
                                    @QueryParam("historial") String historial
                                    ){
        
        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("nombre", nombre );
                put("apellido", apellido );
                put("fechanac", fecha);
                put("sexo", sexo );
                put("correo", correo );
                put("historial", historial );
            }});
            Entidad entrenador = FabricaEntidad.instanciaEntrenador(nombre, apellido,
                                    Date.valueOf(fecha), sexo, correo, historial);
            ComandoInsertarEntrenador cmd = FabricaComando.instanciaCmdInsertarEntrenador(entrenador);
            cmd.ejecutar();
            entrenador = cmd.getMensaje();
            response.put ( "data", entrenador.getMensaje() );
        }
        catch (ParameterNullException e) {
            response.put("data", e.getMessage());
        }
        finally {
            return _gson.toJson(response);
        }
    }
    /**
     * Metodo que recibe como parametros el correo del entrenador
     * para modificarlo ademas de sus atributos a modificar.
     * @param nombre Nombre del entrenador,
     * @param apellido Apellido del entrenador.
     * @param fecha Fecha de nacimiento del entrenador.
     * @param sexo Sexo del entrenador.
     * @param correo Correo del entrenador.
     * @param historial Historial del entrenador.
     * @return Devuelve un json con elemento llamado data, 
     * contiene el mensaje de la peticion
     */
    @POST
    @Path("/modificarEntrenador")
    @Produces("application/json")
    public String actualizaInstruct( @QueryParam("nombre") String nombre,
                                    @QueryParam("apellido") String apellido,
                                    @QueryParam("fechanac") String fecha,
                                    @QueryParam("sexo") String sexo,
                                    @QueryParam("correo") String correo,
                                    @QueryParam("historial") String historial ){
        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("nombre", nombre );
                put("apellido", apellido );
                put("fechanac", fecha);
                put("sexo", sexo );
                put("correo", correo );
                put("historial", historial );
            }});
            Entidad entrenador = FabricaEntidad.instanciaEntrenador(nombre, apellido,
                                    Date.valueOf(fecha), sexo, correo, historial);
            ComandoModificarEntrenador cmd = FabricaComando.instanciaCmdModificarEntrenador( entrenador );
            cmd.ejecutar();
            entrenador = cmd.getMensaje();
            response.put ( "data", entrenador.getMensaje() );
        }
        catch (ParameterNullException e) {
            response.put("data", e.getMessage());
        }
        finally {
            return _gson.toJson( response );
        }
    }
    /**
     * Metodo que recibe como parametros el correo del entrenador
     * para eliminarlo.
     * @param correo correo del entrenador.
     * @return Devuelve un json con elemento llamado data que contiene el mensaje de la peticion
     */
   @DELETE
    @Path("/eliminarEntrenador")
    @Produces("application/json")
    public String eliminarEntrenador(@QueryParam("correo") String correo){

        Map<String, String> response = new HashMap<String, String>();
        try{

            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("correo", correo);
            }});
            _entrenador = FabricaEntidad.instanciaEntrenadorCorreo(correo);
            ComandoEliminaEntrenador cmd = FabricaComando.instanciaCmdEliminaEntrenador( _entrenador );
            cmd.ejecutar();
            _entrenador =  cmd.getMensaje();
            response.put("data", _entrenador.getMensaje());
        }
        catch (ParameterNullException e) {
            response.put("data", e.getMessage());
        }
        finally {
            return _gson.toJson( response );
        }
    }
    
    
}
