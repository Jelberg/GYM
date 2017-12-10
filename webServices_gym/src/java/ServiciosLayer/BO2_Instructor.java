package ServiciosLayer;

import Comun.Dominio.FabricaEntidad;
import Comun.Dominio.Instructor;
import LogicaLayer.Comando;
import LogicaLayer.FabricaComando;
import java.sql.Date;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author simon
 */
@Path("/instructor")
public class BO2_Instructor {

    @POST
    @Path( "/RegistrarInstructor" )
    @Produces( "application/json" )
    public void RegistrarInstructor( @QueryParam( "nombre" ) String nombre,
        @QueryParam( "apellido" ) String apellido, 
        @QueryParam( "fechanac" ) Date fechanac, 
        @QueryParam( "sexo" ) String sexo,
        @QueryParam( "correo" ) String correo){
        
        Instructor instructor = (Instructor) FabricaEntidad.InstanciaInstructor
        (1, nombre, apellido, fechanac, sexo, correo);
        
        FabricaComando fab = new FabricaComando();
        Comando c = fab.CrearRegInstructor(instructor);
        c.ejecutar();
    }
    
    /*@GET
    @Path("/getListInstructor")
    @Produces("application/json")
    public String getListInstructor(){
        ComandoGetEntrenadores cmd = FabricaComando.instanciaCmdGetEntrenadores();
        cmd.ejecutar();
        _listaEntrenadores = cmd.getEntrenadores();
        _response = _gson.toJson( _listaEntrenadores );
        return _response;
    }*/
}
