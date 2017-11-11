/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.Comentario;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.google.gson.Gson;

/**
 *
 * @author simon
 */
@Path("/FOM04_Progreso_Ejercicio")
public class FOM04_Progreso_Ejercicio {
    
    @GET
    @Path("/getDatoPrueba")
    @Produces("application/json")
    public String getDatoPrueba(){
        Gson gson = new Gson();
        Comentario c = new Comentario(1, "hola");
        return gson.toJson(c);
    }
}
