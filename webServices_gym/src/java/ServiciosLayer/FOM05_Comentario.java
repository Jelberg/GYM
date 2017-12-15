/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosLayer;

import Comun.Dominio.Comentario;
import Comun.Dominio.FabricaEntidad;
import LogicaLayer.Comando;
import LogicaLayer.FabricaComando;
import javax.ws.rs.Path;
import com.google.gson.Gson;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Leonardo
 */
@Path("/FOM04_Comentario")
public class FOM05_Comentario {
    
    private Gson _gson = new Gson();
    private String _response;
    
    @POST
    @Path( "/insertaComentario" )
    public void insertaComentario( @QueryParam("id_usuariocomentario") 
                                    int id_usuariocomentario,
                                    @QueryParam("mensaje") String mensaje){
        
        Comentario _comentario = (Comentario) FabricaEntidad.InstanciaComentario
                                    (id_usuariocomentario, mensaje);
        Comando _comando = FabricaComando.instanciaCmdAgregarComentario
                            (_comentario);
        _comando.ejecutar();
        
    }
    
}
