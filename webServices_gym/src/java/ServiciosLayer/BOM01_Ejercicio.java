/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosLayer;

import Comun.Dominio.FabricaEntidad;
import Comun.Dominio.Ejercicio;
import Comun.Dominio.Entidad;
import Comun.Validaciones.ValidationWS;
import LogicaLayer.BO1.ComandoGetEjercicios;
import LogicaLayer.Comando;
import LogicaLayer.FabricaComando;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Luis L
 */
@Path("/ejercicio")
public class BOM01_Ejercicio {
    
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Ejercicio> listaEjercicio;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
    
    public ArrayList<Ejercicio> getListaEjercicio() {
        return listaEjercicio;
    }

    public void setListaEquipo(ArrayList<Ejercicio> listaEquipo) {
        this.listaEjercicio = listaEquipo;
    }
    
    /**
     * @return Devuelve una lista de ejercicios
    */
    @GET
    @Path("/getListEquipos")
    @Produces("application/json")
    public String getListEquipo(){
        ComandoGetEjercicios c = FabricaComando.instanciaGetEjercicios();
        c.ejecutar();
        listaEjercicio = c.getEjercicios();
        response = gson.toJson( listaEjercicio );
        return response;
    }
    @POST
    @Path("/AgregarEjercicio")
    public void AgregarEjercicio (@QueryParam ("id_ejer") int _id , @QueryParam ("nombre")   String _nombre, @QueryParam("grupo,") String _grupom){
                Entidad ejercicio = FabricaEntidad.InstanciaEjercicio (_id,_nombre,_grupom);
                Comando c = FabricaComando.AgregarEjercicio(ejercicio);
                c.ejecutar();
    }
    
    @DELETE
    @Path("/EliminarEjercicio")
    public void EliminarEjercicio (@QueryParam ("id_ejer") int _id) {
           Entidad ejercicio = FabricaEntidad.InstanciaEjercicio(_id,null,null);
           Comando c = FabricaComando.EliminarEjercicio(ejercicio);
           c.ejecutar();
    }
    @POST
    @Path("/ModificarEjercicio")
    public void ModificarEjercicio (@QueryParam ("id_ejer") int _id , @QueryParam ("nombre")   String _nombre, @QueryParam("grupo,") String _grupom){
                Entidad ejercicio = FabricaEntidad.InstanciaEjercicio (_id,_nombre,_grupom);
                Comando c = FabricaComando.AgregarEjercicio(ejercicio);
                c.ejecutar();
    }
    
    
    
    
    
}
