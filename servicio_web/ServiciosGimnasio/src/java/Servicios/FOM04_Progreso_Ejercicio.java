/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author simon
 */
@Path("/FOM04_Progreso_Ejercicio")
public class FOM04_Progreso_Ejercicio {
    
    @GET
    @Path("/getDatoPrueba")
    public String getDatoPrueba(){
        return "1";
    }
    
}
