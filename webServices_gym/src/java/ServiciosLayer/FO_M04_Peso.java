/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosLayer;

import Comun.Dominio.FabricaEntidad;
import Comun.Dominio.Progreso_Peso;
import LogicaLayer.Comando;
import LogicaLayer.FabricaComando;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Leonardo
 */
@Path("/F0M04_Progreso_Peso")
public class FO_M04_Peso {
    
    private Gson _gson = new Gson();
    private String _response;
    private ArrayList<Progreso_Peso> _listaProgresoPeso 
                    = new ArrayList<Progreso_Peso>();
    
    @POST
    @Path("/actualizaProgresoPeso")
    @Produces( "application/json" )
    public void actualizarPeso(@QueryParam ( "id_usuario" ) int id_usuario,
                                   @QueryParam ( "peso" ) int peso){
        
        Progreso_Peso _progresoPeso = (Progreso_Peso)
                FabricaEntidad.InstanciaActualizarPeso(id_usuario, peso);
        
        Comando _comando = FabricaComando.actualizarPesoComando(_progresoPeso);
        _comando.ejecutar();
        
    }
    
    
}
