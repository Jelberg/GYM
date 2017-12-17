/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosLayer;


import LogicaLayer.Comando;
import LogicaLayer.F03.ConsultarEjerciciosRealizadosComando;
import LogicaLayer.FabricaComando;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Elberg
 */
@Path("/FOM03_Rutina")
public class FOM03_Rutina {
    String _resp;
    
     /**
          * Funcion que retorna una lista de ejercicios realizados dado el id de un usuario.
          * @param idUsuario, 
          * @return Devuelve strings en formato Json 
          */
        @GET
        @Path("/getEjerciciosRealizados")
        @Produces("application/json")
         public String getEjercicios( @QueryParam( "idUsuario" ) int idUsuario )
         {
        Comando comando = FabricaComando.instanciaCmdConsultaEjerciciosH(idUsuario);
        ConsultarEjerciciosRealizadosComando cmd = (ConsultarEjerciciosRealizadosComando) comando;
        cmd.ejecutar();
        _resp = cmd.getResultado();
        return  _resp ;
          
        }
}
