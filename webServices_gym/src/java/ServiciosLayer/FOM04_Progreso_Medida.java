/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosLayer;

import Comun.Dominio.Entidad;
import Comun.Dominio.FabricaEntidad;
import Comun.Dominio.Progreso_Medida;
import LogicaLayer.Comando;
import LogicaLayer.FO4.ProgresoMedida.ActualizarMedidaComando;
import LogicaLayer.FO4.ProgresoMedida.AgregarMedidaComando;
import LogicaLayer.FO4.ProgresoMedida.ComandoConsultarMedidasAnual;
import LogicaLayer.FO4.ProgresoMedida.ComandoEliminarMedida;
import LogicaLayer.FO4.ProgresoMedida.ConsultarProgesoMedidasComando;
import LogicaLayer.FabricaComando;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Elberg
 */
@Path("/F0M04_Progreso_Medida")
public class FOM04_Progreso_Medida {
    private String _response;
    private ArrayList<Progreso_Medida> _jsonArray;
    Gson _gson = new Gson();
    
    /**
     * Servicio que recibe y responde la consulta para obtener el 
     * progreso de las medidas del usuario
     * @param id_usuario
     * @return 
     */
    @GET
    @Path("/getProgresoM")
    @Produces("application/json")
    public String getProgresoM (@QueryParam("id_usuario") Integer id_usuario){
        Comando comando = 
                FabricaComando.instanciaCmdConsutaProgresoMedidas(id_usuario);
        ConsultarProgesoMedidasComando cmd = 
                (ConsultarProgesoMedidasComando) comando;
        cmd.ejecutar();
        _response = cmd.getResultadoConsultaMedidas();
        return  _response ;
    }
    
    /**
     * Metodo para agregar medidas del usuario
     * @param id_usuario
     * @param medida
     * @param tipo_medida
     * @return 
     */
    @GET
    @Path("/insertaMedidas") //Revisar logica para hacer el bucle en el servicio
    @Produces("application/json")
    public String insertaMedidas(@QueryParam("id_usuario") int id_usuario,
                                 @QueryParam("medida") int medida,
                                 @QueryParam("tipo_medida") int tipo_medida){
        Entidad en = 
                FabricaEntidad.InstanciaProgresoMedida
                                (id_usuario, medida, tipo_medida);
        Comando comando = FabricaComando.instanciaCmdAgregarMedida(en);
        AgregarMedidaComando cmd = (AgregarMedidaComando) comando;
        cmd.ejecutar();
        _response = cmd.getRespuestaAgregarMedida();
        return _gson.toJson(_response);
    }
    
    /**
     * Servicio que actualiza el progreso de medidas del usuario
     * @param idUsuario
     * @param tipo_medida
     * @param medida
     * @return 
     */
    @GET
    @Path("/actualizaMedida")
    @Produces("application/json")
    public String actualizarMedida(@QueryParam ( "id_usuario" ) int idUsuario,
                            @QueryParam ( "tipo_medida" ) String tipo_medida,
                            @QueryParam ( "medida" ) int medida){
        Progreso_Medida _progresoMedida = (Progreso_Medida) 
                FabricaEntidad.InstanciaActualizarMedida
                                    (idUsuario, medida, tipo_medida);
        ActualizarMedidaComando _comando = 
                FabricaComando.instanciaCmdActualizarMedidas(_progresoMedida);
        _comando.ejecutar();
        
        _response = _comando.getRespuesta();
        
        return _gson.toJson(_response);
    }
    
    /**
     * Servicio que elimina las medidas del usuario
     * @param id_usuario
     * @param tipo_medida
     * @return 
     */
    @GET
    @Path("/eliminarMedidas")
    @Produces("application/json")
    public String eliminarMedida(@QueryParam("id_usuario") int id_usuario,
                                @QueryParam("tipo_medida") String tipo_medida){
        Progreso_Medida progreso_Medida = FabricaEntidad.InstanciaEliminarMedida
                                             (id_usuario, tipo_medida);
         ComandoEliminarMedida _comando = FabricaComando.instanciaEliminarMedida
                                         (progreso_Medida);
         _comando.ejecutar();
         
         _response = _comando.obtenerRespuesta();
         
         return _gson.toJson(_response);
    }
    
    /**
     * Servicio que consulta las medidas anuales del usuario por su sobrenombre
     * @param sobrenombre
     * @return 
     */
    @GET
    @Path("/getMedidasDelAno")
    @Produces("aplication/json")
    public String obtenerMedidasDelAno(@QueryParam("sobrenombre") 
                                        String sobrenombre){
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
