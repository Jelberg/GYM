/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.*;
import Dominio.Progreso_Medida;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;



/**
 *
 * @author gilbert
 */
@Path("/F0M04_Progreso_Medida")
public class FOM04_Progreso_Medida {
    
    private Connection conn = Sql.getConInstance();
    //Atributo que se utiliza para transformar a formado JSON las consultas.
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Progreso_Medida> jsonArray;
    
    /**@GET
    @Path("/getProgresoM")
    @Produces("aplicacion/json")
    public String getProgresoM(@QueryParam("fecha") String fecha,
                                @QueryParam("sobrenombre") String sobrenombre){
    
        try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("sobrenombre", sobrenombre);
                put("fecha", fecha);
            }});

            String query = "SELECT * FROM m11_get_calorias_fecha(?, ?)";
            jsonArray = new ArrayList<>();
            PreparedStatement st = conn.prepareStatement(query);
            st.setDate(1, Date.valueOf(fecha));
            st.setString(2, sobrenombre);
            ResultSet rs = st.executeQuery();
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                jsonArray.add(new Progreso_Medida());
                jsonArray.get(jsonArray.size() - 1).setMedida(rs.getInt("medida"));
            }
            response = gson.toJson(jsonArray);
        }
        catch(SQLException e) {
            response = e.getMessage();
        }
        catch (ParameterNullException e) {
            response = e.getMessage();
        }
        finally {
            Sql.bdClose(conn);
            return response;
        }
    
    }
    **/
    
    
    
}
