/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosLayer;

import Comun.Dominio.Entidad;
import Comun.Dominio.FabricaEntidad;
import Comun.Dominio.Progreso_Peso;
import LogicaLayer.Comando;
import LogicaLayer.FO4.AgregarPesoComando;
import LogicaLayer.FO4.ConsultarProgresoPesoComando;
import LogicaLayer.FabricaComando;
import com.google.gson.Gson;
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
    private Gson _gson = new Gson();
    private String _response;
    private ArrayList<Progreso_Peso> jsonArray;
    
    
    /**
     * Servicio que recibe y responde a la solicitud de consulta del progreso del peso
     * @param id_usuario
     * @return 
     */
    @GET
    @Path( "/getProgresoP" )
    @Produces( "application/json" )
    public String getProgresoP( @QueryParam( "id_usuario" ) int id_usuario ){
        Comando comando = FabricaComando.instanciaCmdConsultarProgresoPeso(id_usuario);
        ConsultarProgresoPesoComando cmd = (ConsultarProgresoPesoComando) comando;
        cmd.ejecutar();
        _response = cmd.getResultadoConsultaProgresoPeso();
        return  _response ;
        
    }
    
    /**
     * Servicio que recibe y responde a la solicitud de insercion del peso del usuario
     * @param id_usuario
     * @param peso
     * @return 
     */
    
    @GET
    @Path( "/insertaProgresoPeso" )
    @Produces( "application/json" )
    public String insertaPeso( @QueryParam ( "id_usuario" ) int id_usuario,
                               @QueryParam ( "peso" ) int peso ){
        Entidad progresoPeso = FabricaEntidad.InstaciaProgresoPeso(id_usuario, peso);
        Comando comando = FabricaComando.instanciaCmdAgregarPeso(progresoPeso);
        AgregarPesoComando cmd = (AgregarPesoComando) comando;
        cmd.ejecutar();
        _response = cmd.getResultado();
        return _gson.toJson( _response );
    }
}
