/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosLayer;

import Comun.Dominio.FabricaEntidad;
import Comun.Dominio.Instructor;
import LogicaLayer.Comando;
import LogicaLayer.FabricaComando;
import java.sql.Date;

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
    public void RegistrarInstructor(String nombre, String apellido,
                                    Date fechanac, String sexo,
                                    String correo){
        
        Instructor instructor = (Instructor) FabricaEntidad.InstanciaInstructor(nombre,
                apellido, fechanac, sexo, correo);
        FabricaComando fab = new FabricaComando();
        Comando c = fab.CrearRegInstructor(instructor);
        c.ejecutar();
    }
}
