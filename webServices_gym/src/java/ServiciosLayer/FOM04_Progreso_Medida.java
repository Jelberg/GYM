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
import LogicaLayer.FO4.ProgresoMedida.ConsultarProgesoMedidasComando;
import LogicaLayer.FabricaComando;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    
    /**
     * Servicio que recibe y responde la consulta para obtener el progreso de las medidas del usuario
     * @param id_usuario
     * @return 
     */
    @GET
    @Path("/getProgresoM")
    @Produces("application/json")
    public String getProgresoM (@QueryParam("id_usuario") Integer id_usuario){
        Comando comando = FabricaComando.instanciaCmdConsutaProgresoMedidas(id_usuario);
        ConsultarProgesoMedidasComando cmd = (ConsultarProgesoMedidasComando) comando;
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
                                 @QueryParam("tipo_medida") String tipo_medida){
        Entidad en = FabricaEntidad.InstanciaProgresoMedida(id_usuario, medida, tipo_medida);
        Comando comando = FabricaComando.instanciaCmdAgregarMedida(en);
        AgregarMedidaComando cmd = (AgregarMedidaComando) comando;
        cmd.ejecutar();
        _response = cmd.getRespuestaAgregarMedida();
        return _response;
    }
    
    @POST
    @Path("/actualizarMedida")
    @Produces("application/json")
    public String actualizarMedida(@QueryParam ( "id_usuario" ) int idUsuario,
                                   @QueryParam ( "tipo_medida" ) String tipo_medida,
                                   @QueryParam ( "medida" ) int medida){
        Progreso_Medida _progresoMedida = (Progreso_Medida) 
                FabricaEntidad.InstanciaActualizarMedida(idUsuario, medida, tipo_medida);
        ActualizarMedidaComando _comando = FabricaComando.instanciaCmdActualizarMedidas(_progresoMedida);
        _comando.ejecutar();
        
        _response = _comando.getRespuesta();
        
        return _response;
    }
}
