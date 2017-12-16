/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosLayer;

import Comun.Dominio.FabricaEntidad;
import Comun.Dominio.Progreso_Medida;
import LogicaLayer.Comando;
import LogicaLayer.FOM04.ComandoConsultarMedidasAnual;
import LogicaLayer.FOM04.ComandoEliminarMedida;
import LogicaLayer.FOM04.ComandoObtenerMedidas;
import LogicaLayer.FabricaComando;
import com.google.gson.Gson;
import java.sql.Connection;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Leonardo
 */
@Path("/F0M04_Progreso_Medida")
public class FO_M04_Medida {
    
    private Connection _connection;
    private Gson _gson = new Gson();
    private String _response;
    private ArrayList<Progreso_Medida> _jsonArray;
    
    @POST
    @Path("/actualizarMedida")
    @Produces("application/json")
    public void actualizarMedida(@QueryParam ( "id_usuario" ) int idUsuario,
                                   @QueryParam ( "tipo_medida" ) String tipo_medida,
                                   @QueryParam ( "medida" ) int medida){
        Progreso_Medida _progresoMedida = (Progreso_Medida) 
                FabricaEntidad.InstanciaActualizarMedida(idUsuario, medida, tipo_medida);
        Comando _comando = FabricaComando.actualizarMedidaComando(_progresoMedida);
        _comando.ejecutar();
    }
    
    @GET
    @Path("/getProgresoM")
    @Produces("application/json")
    public String getProgresoMedida(@QueryParam("id_usuario") int idUsuario){
        
        ComandoObtenerMedidas _comando = FabricaComando.instanciaObtenerMedidas
                                            (idUsuario);
        
        _comando.ejecutar();
        
        _jsonArray = _comando.obtenerComentario();
        
        _response = _gson.toJson(_jsonArray);
        
        return _response;
        
    }
    
    @DELETE
    @Path("/eliminarMedidas")
    @Produces("aplication/json")
    public void eliminarMedida(@QueryParam("id_usuario") int id_usuario,
                                @QueryParam("tipo_medida") String tipo_medida){
        Progreso_Medida progreso_Medida = FabricaEntidad.InstanciaEliminarMedida
                                            (id_usuario, tipo_medida);
        ComandoEliminarMedida _comando = FabricaComando.instanciaEliminarMedida
                                        (progreso_Medida);
        _comando.ejecutar();
    }
    
    @GET
    @Path("/getMedidasDelAno")
    @Produces("aplication/json")
    public String obtenerMedidasDelAno(@QueryParam("sobrenombre") String sobrenombre){
        Progreso_Medida _progreso_medida = 
                FabricaEntidad.InstanciaConsultarMedidasAnuales(sobrenombre);
        ComandoConsultarMedidasAnual _comando = 
                FabricaComando.instanciaObtenerMedidasAnual(_progreso_medida);
        
        _comando.ejecutar();
        
        _jsonArray = _comando.obtenerMedidasAnuales();
        
        _response = _gson.toJson(_jsonArray);
        
        return _response;
        
    }
    
}
