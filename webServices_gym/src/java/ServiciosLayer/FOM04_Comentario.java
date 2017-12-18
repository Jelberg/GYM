/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosLayer;

import Comun.Dominio.Comentario;
import Comun.Dominio.Entidad;
import Comun.Dominio.FabricaEntidad;
import LogicaLayer.Comando;


import LogicaLayer.FO4.Comentarios.AgregarComentarioComando;
import LogicaLayer.FO4.Comentarios.ConsultarComentarioProgresosComando;


import LogicaLayer.FO4.Comentarios.ComandoObtenerComentariosProgMedidas;
import LogicaLayer.FabricaComando;


import com.google.gson.Gson;

import java.util.ArrayList;
import javax.ws.rs.GET;



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
     * Funcion que permite ingresar comentarios a un progreso
     * @param id_usuariocomentario
     * @param mensaje
     * @param jsonMedida 
     * @return Devuelve un json con elemento llamado data, el cual 
     * contiene el mensaje de la peticion
     */
    @GET
    @Path("/insertaComentario")
    @Produces("aplicacion/json")
    public String insertaComentario
        (@QueryParam("id_usuariocomentario") int id_usuariocomentario,
                                    @QueryParam("mensaje") String mensaje){
        Entidad en = 
                FabricaEntidad.InstaciaInsertarComentario
                                        (id_usuariocomentario,mensaje);
        Comentario comentario = (Comentario) en;
        AgregarComentarioComando _comando = 
                FabricaComando.insertarComentarioComando(comentario);
        _comando.ejecutar();
        
        _response = _comando.obtenerRespuesta();
        
        return _gson.toJson(_response);

    }
     
    /**
     * Funcion que recibe como parametro el id del progreso 
     * correspondiente a medidas
     * y el id usuario
     * @param usuario_id
     * @return Devuelve los comentarios correspondientes a ese 
     * progreso de medidas
     */
    @GET
    @Path("/getProgresos")
    @Produces("application/json")
    public String getProgresos(@QueryParam("usuario_id") int usuario_id){
        Comando comando = 
                FabricaComando.instanciaCmdGetComentarioProgresos(usuario_id);
        ConsultarComentarioProgresosComando cmd = 
                (ConsultarComentarioProgresosComando) comando;
        cmd.ejecutar();
        _response = cmd.getResultadoComentarioProgresos();
        
        return _response;
    }
 
    /**
     * Servicio que obtiene los comentarios hechos a un progrso 
     * de medida particular
     * @param idusuario
     * @param idprogresom
     * @return 
     */
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

