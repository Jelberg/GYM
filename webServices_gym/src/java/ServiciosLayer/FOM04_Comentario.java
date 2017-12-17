/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosLayer;

import Comun.Dominio.Comentario;
import Comun.Dominio.FabricaEntidad;
import LogicaLayer.Comando;


import LogicaLayer.FO4.Comentarios.AgregarComentarioComando;
import LogicaLayer.FO4.Comentarios.ConsultarComentarioProgresosComando;


import LogicaLayer.FO4.ComandoObtenerComentariosProgMedidas;
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
@Path("/FOM04_Comentario")
public class FOM04_Comentario{
    private Gson _gson = new Gson();
    private String _response;
    private ArrayList<Comentario> _listaComentarios = 
            new ArrayList<Comentario>();

    /**
     * Servicio que recibe y responde las solicitudes de realizar comentario de los usuarios
     * @param idUsuario
     * @param mensaje
     * @return 
     */
    @GET
    @Path("/insertarComentario")
    @Produces("applicacion/json")
    public String insertarComentario(@QueryParam("id_usuariocomentario") int idUsuario, 
                                @QueryParam("mensaje") String mensaje){
        Comentario _comentario = (Comentario) FabricaEntidad.InstaciaInsertarComentario(idUsuario,mensaje);
        AgregarComentarioComando _comando = FabricaComando.insertarComentarioComando(_comentario);
        _comando.ejecutar();
        _response = _comando.obtenerRespuesta();
        
        return _response;
    }
    

     
    /**
     * Funcion que recibe como parametro el id del progreso correspondiente a medidas
     * y el id usuario
     * @param usuario_id
     * @return Devuelve los comentarios correspondientes a ese progreso de medidas
     */
    @GET
    @Path("/getProgresos")
    @Produces("application/json")
    public String getProgresos(@QueryParam("usuario_id") int usuario_id){
        Comando comando = FabricaComando.instanciaCmdGetComentarioProgresos(usuario_id);
        ConsultarComentarioProgresosComando cmd = (ConsultarComentarioProgresosComando) comando;
        cmd.ejecutar();
        _response = cmd.getResultadoComentarioProgresos();
        
        return _response;
    }
    

    @GET
    @Path("/getComentarioProM")
    @Produces("application/json")
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

