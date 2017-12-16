/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosLayer;

import Comun.Dominio.Comentario;
import Comun.Dominio.FabricaEntidad;
import LogicaLayer.Comando;
import LogicaLayer.FOM04.ComandoObtenerComentariosProgMedidas;
import LogicaLayer.FabricaComando;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Leonardo
 */
@Path("/FO_M05_Comentario")
public class FO_M04_Comentario{
    private Gson _gson = new Gson();
    private String _response;
    private ArrayList<Comentario> _listaComentarios = 
            new ArrayList<Comentario>();

    @POST
    @Path("/insertarComentario")
    @Produces("aplicacion/json")
    public void insertarComentario(@QueryParam("id_usuariocomentario") int idUsuario, 
                                @QueryParam("mensaje") String mensaje){
        Comentario _comentario = (Comentario) FabricaEntidad.InstaciaInsertarComentario(idUsuario,mensaje);
        Comando _comando = FabricaComando.insertarComentarioComando(_comentario);
        _comando.ejecutar();
    }
    
    @GET
    @Path("/getComentarioProM")
    @Produces("aplication/json")
    public String obtenerComentariosProgresoMedidas(
                                    @QueryParam("idUsuario") int idusuario,
                                    @QueryParam("idprogresom") int idprogresom){
        ComandoObtenerComentariosProgMedidas _comando =
                FabricaComando.instanciaObtenerComentariosProgMedida
                (idusuario, idprogresom);
        _comando.ejecutar();
        
        _listaComentarios = _comando.ObtenerComentarioProgMedidas();
        
        _response = _gson.toJson(_listaComentarios);
        
        return _response;
    }
    
    
}
