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
import LogicaLayer.BO2.ComandoInsertarEntrenador;
import LogicaLayer.FabricaComando;
import com.google.gson.Gson;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
     * 
     * @return 
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
    @GET
    @Path("/getEntrenador")
    @Produces("application/json")
    public String getEntrenadorCorreo( @QueryParam("correo") String correo ){
        Entidad entrenador = FabricaEntidad.instanciaEntrenadorCorreo( correo );
        ComandoConsultaEntrenadorCorreo cmd = FabricaComando.instanciaCmdConsultaEntCorreo( entrenador );
        cmd.ejecutar();
        _entrenador = cmd.getEntrenador();
        _response = _gson.toJson( _entrenador );
        return _response;
    }
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
            response.put("error", e.getMessage());
        }
        finally {
            return _gson.toJson(response);
        }
    }
    
    
}
