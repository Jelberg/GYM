/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosLayer;

import Comun.Dominio.Entidad;
import Comun.Dominio.Entrenador;
import Comun.Dominio.FabricaEntidad;
import LogicaLayer.BO2.ComandoConsultaEntrenadorCorreo;
import LogicaLayer.BO2.ComandoConsultaEntrenadores;
import LogicaLayer.FabricaComando;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.GET;
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
    
    
}
