/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosLayer;

import Comun.Dominio.Clase;
import Comun.Dominio.Entidad;
import Comun.Dominio.FabricaEntidad;
import Comun.Excepciones.ParameterNullException;
import Comun.Validaciones.ValidationWS;
import LogicaLayer.BO2.ComandoConsultarClase;
import LogicaLayer.FabricaComando;
import com.google.gson.Gson;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static javax.swing.UIManager.put;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

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
    
    @POST
    @Path("/insertaClase")
    @Produces("application/json")
    public String insertaClase(  @QueryParam("nombre") String nombre,
                                 @QueryParam("descripcion") String descripcion){

        Map<String, String> response = new HashMap<String, String>();
        try {
            
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("nombre", nombre );
                put("descripcion", descripcion );
            }});
            
            Entidad clase = FabricaEntidad.instanciaInsertarClase(nombre, descripcion);
            
           
            }
        
        catch (ParameterNullException e) {
            response.put("error", e.getMessage());
        }
        catch (Exception e) {
            response.put("error", e.getMessage());
        }
        finally {
            
            return _gson.toJson(response);
        }
    
    }
 
}
