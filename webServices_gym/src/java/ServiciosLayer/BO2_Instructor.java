package ServiciosLayer;

import Comun.Dominio.FabricaEntidad;
import Comun.Dominio.Instructor;
import LogicaLayer.BO2.ComandoGetInstructores;
import LogicaLayer.Comando;
import LogicaLayer.FabricaComando;
import com.google.gson.Gson;
import java.sql.Date;
import java.util.ArrayList;
import javax.ws.rs.GET;

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

    private Gson _gson = new Gson();
    private String _response;
    private ArrayList<Instructor> _listaInstructores;
    
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
    
    @GET
    @Path("/getListInstructores")
    @Produces("application/json")
    public String getListInstructor(){
        ComandoGetInstructores cmd = FabricaComando.instanciaGetInstructores();
        cmd.ejecutar();
        _listaInstructores = cmd.getInstructores();
        _response = _gson.toJson( _listaInstructores );
        return _response;
    }
}
