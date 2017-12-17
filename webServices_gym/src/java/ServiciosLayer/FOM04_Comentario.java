/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosLayer;

import Comun.Dominio.Comentario;
import Comun.Dominio.FabricaEntidad;

import LogicaLayer.FO4.Comentarios.AgregarComentarioComando;

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
    @POST
    @Path("/insertarComentario")
    @Produces("aplicacion/json")
    public String insertarComentario(@QueryParam("id_usuariocomentario") int idUsuario, 
                                @QueryParam("mensaje") String mensaje){
        Comentario _comentario = (Comentario) FabricaEntidad.InstaciaInsertarComentario(idUsuario,mensaje);
        AgregarComentarioComando _comando = FabricaComando.insertarComentarioComando(_comentario);
        _comando.ejecutar();
        _response = _comando.obtenerRespuesta();
        
        return _response;
    }
    
     
   }