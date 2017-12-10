/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosLayer;

import Comun.Dominio.Entidad;
import Comun.Dominio.Entrenador;
import Comun.Dominio.FabricaEntidad;
import LogicaLayer.BO2.ComandoGetEntrenadores;
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
    
    /**
     * 
     * @return 
     */
    @GET
    @Path("/getListEntrenador")
    @Produces("application/json")
    public String getListaEntrenador(){
        ComandoGetEntrenadores cmd = FabricaComando.instanciaCmdGetEntrenadores();
        cmd.ejecutar();
        _listaEntrenadores = cmd.getEntrenadores();
        _response = _gson.toJson( _listaEntrenadores );
        return _response;
    }
    
}
