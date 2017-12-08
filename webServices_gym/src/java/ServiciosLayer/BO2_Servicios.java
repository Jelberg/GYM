/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosLayer;

import LogicaLayer.Comando;
import LogicaLayer.FabricaComando;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author simon
 */
@Path("/bo2servicios")
public class BO2_Servicios {
    
    @POST
    @Path( "/RegistrarInstructor" )
    @Produces( "application/json" )
    public void RegistrarInstructor(){
        FabricaComando fab = new FabricaComando();
        Comando c = fab.CrearRegInstructor();
        c.ejecutar();
    }
}
