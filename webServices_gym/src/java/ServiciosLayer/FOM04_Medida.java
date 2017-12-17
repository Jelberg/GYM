/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosLayer;

import Comun.Dominio.FabricaEntidad;
import Comun.Dominio.Progreso_Medida;
import LogicaLayer.Comando;
import LogicaLayer.FO4.ActualizarMedidaComando;
import LogicaLayer.FabricaComando;
import com.google.gson.Gson;
import java.sql.Connection;
import java.util.ArrayList;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Leonardo
 */
@Path("/F0M04_Progreso_Medida")
public class FOM04_Medida {
    
    private Connection _connection;
    private Gson _gson = new Gson();
    private String _response;
    private ArrayList<Progreso_Medida> jsonArray;
    
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