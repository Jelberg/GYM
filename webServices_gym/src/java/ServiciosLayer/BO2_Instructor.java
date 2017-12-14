package ServiciosLayer;

import Comun.Dominio.FabricaEntidad;
import Comun.Dominio.Instructor;
import Comun.Validaciones.ValidationWS;
import LogicaLayer.BO2.ComandoGetInstructorPorCorreo;
import LogicaLayer.BO2.ComandoGetInstructores;
import LogicaLayer.Comando;
import LogicaLayer.FabricaComando;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author simon
 */
@Path("/instructor")
public class BO2_Instructor {

    private Gson _gson = new Gson();
    private String _response;
    private ArrayList<Instructor> _listaInstructores;
    private ArrayList<Instructor> _instructor;
    
    /**
     * Registra un instructor en la BDD
     * 
     * @param nombre nombre del instructor
     * @param apellido apellido del instructor
     * @param fechanac fecha de nacimiento del instructor (yyyy-MM-dd)
     * @param sexo sexo del instructor (M, F)
     * @param correo correo electronico del instructor
     */
    @POST
    @Path( "/RegistrarInstructor" )
    public void RegistrarInstructor( @QueryParam( "nombre" ) String nombre,
        @QueryParam( "apellido" ) String apellido, 
        @QueryParam( "fecha" ) String fechanac, 
        @QueryParam( "sexo" ) String sexo,
        @QueryParam( "correo" ) String correo){
     
        try{
        Instructor instructor = (Instructor) FabricaEntidad.InstanciaInstructor
        (1, nombre, apellido, java.sql.Date.valueOf(fechanac), sexo, correo);
        Comando c = FabricaComando.CrearRegInstructor(instructor);
        c.ejecutar();
        }
        catch(IllegalArgumentException e){
            System.out.println("Formato de fecha invalido. Debe ser yyyy-MM-dd ");
        }
    }
    
    /**
     * 
     * @return json con los instructores del gimaniso
     */
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
    
    /**
     *  
     * @param correo correo electronico
     * @return toda la informacion del instructor asociado al correo
     */
    @GET
    @Path("/getInstructorPorCorreo")
    @Produces("application/json")
    public String getInstructor(@QueryParam("correo") String correo){
         
        ComandoGetInstructorPorCorreo cmd;
        cmd = FabricaComando.instanciaInstructorPorCorreo(correo);
        cmd.ejecutar();
        _instructor = cmd.getInstructor();
        _response = _gson.toJson( _instructor );
        return _response;
        
    }
    
    /**
     * Actualizar los datos de un instructor en la BDD
     * 
     * @param nombre nombre del instructor
     * @param apellido apellido del instructor
     * @param fechanac fecha de nacimiento del instructor (dd-mm-aaaa)
     * @param sexo sexo del instructor (M, F)
     * @param correo correo electronico del instructor
     */
    @POST
    @Path( "/ActualizarInstructor" )
    public void ActualizarInstructor( @QueryParam( "nombre" ) String nombre,
        @QueryParam( "apellido" ) String apellido, 
        @QueryParam( "fecha" ) String fechanac, 
        @QueryParam( "sexo" ) String sexo,
        @QueryParam( "correo" ) String correo){
     
        Comando c = FabricaComando.instanciaActualizarInstructor(nombre, apellido, fechanac, sexo, correo);
        c.ejecutar();
    }
}
