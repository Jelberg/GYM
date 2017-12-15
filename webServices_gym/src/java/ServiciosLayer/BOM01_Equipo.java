/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ServiciosLayer;

import Comun.Dominio.FabricaEntidad;
import Comun.Dominio.Equipo;
import Comun.Excepciones.ParameterNullException;
import Comun.Validaciones.ValidationWS;
import LogicaLayer.BO1.ComandoGetEquipos;
import LogicaLayer.FabricaComando;
import com.google.gson.Gson;
import java.sql.Date;
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
 * @author Daniel Goncalves
 */
@Path("/Equipo")
public class BOM01_Equipo {
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Equipo> listaEquipo;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
    
    public ArrayList<Equipo> getListaEquipo() {
        return listaEquipo;
    }

    public void setListaEquipo(ArrayList<Equipo> listaEquipo) {
        this.listaEquipo = listaEquipo;
    }
    
    /**
     * @return Devuelve una lista de equipos
    */
    @GET
    @Path("/getListEquipos")
    @Produces("application/json")
    public String getListEquipo(){
        ComandoGetEquipos c = FabricaComando.instanciaGetEquipos();
        c.ejecutar();
        listaEquipo = c.getEquipos();
        response = gson.toJson( listaEquipo );
        return response;
    }
}
