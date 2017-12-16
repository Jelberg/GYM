/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosLayer;

import Comun.Dominio.Progreso_Peso;
import com.google.gson.Gson;
import java.sql.Connection;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author elberg
 */
@Path("/F0M04_Progreso_Peso")
public class FOM04_Progreso_Peso {
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Progreso_Peso> jsonArray;
    
    @GET
    @Path( "/getProgresoP" )
    @Produces( "application/json" )
    public String getProgresoP( @QueryParam( "id_usuario" ) int id_usuario ){
        
        return null;
        
    }
    
}
