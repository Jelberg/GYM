/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosLayer;

import Comun.Dominio.Clase;
import Comun.Dominio.Entidad;
import LogicaLayer.BO2.ComandoConsultarClase;
import LogicaLayer.FabricaComando;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author marvian
 */
public class BO2_Clase {
    private Gson _gson = new Gson();
    private String _response;
    private ArrayList<Clase> _listaClases;
    private Entidad _Clase;
    
    
    @GET
    @Path("/getListEntrenador")
    @Produces("application/json")
    public String getListaEntrenador(){
        ComandoConsultarClase cmd = FabricaComando.instanciaCmdConsultaClase();
        cmd.ejecutar();
        _listaClases = cmd.consultarClase();
        _response = _gson.toJson( _listaClases);
        return _response;
    }
    
}
