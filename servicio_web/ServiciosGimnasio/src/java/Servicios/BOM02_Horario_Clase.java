/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;
import Dominio.*;
import Dominio.Horario_Clase;
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
import Validaciones.ValidationWS;
import Excepciones.ParameterNullException;
import com.google.gson.reflect.TypeToken;
import java.lang.ProcessBuilder.Redirect.Type;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Map;
import javax.ws.rs.DELETE;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;

/**
 *
 * @author YESIMAR
 */
@Path("/BOM02_Horario_Clase")
public class BOM02_Horario_Clase {
    
    private Connection conn = Sql.getConInstance();
    //Atributo que se utiliza para transformar a formado JSON las consultas.
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Horario_Clase> jsonArray;
    
    /**
     * Funcion que recibe como parámetro el nombre de la clase,
     * para consultarla y saber su descripción.
     * @param nombreclaseconsulta Nombre de la clase.
     * @return Devuelve la clase y su descripción en formato json
     */
    @GET
    @Path("/getHorario_Clase")
    @Produces("application/json")
    public String getHorario_Clase(@QueryParam("nombreclaseconsulta") String nombreclaseconsulta){
        
        try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("nombreclaseconsulta", nombreclaseconsulta);
            }});
            String query = "SELECT * FROM bo_m02_get_horario_clase(?)";
            jsonArray = new ArrayList<>();
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, nombreclaseconsulta);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                jsonArray.add(new Horario_Clase());
                jsonArray.get(jsonArray.size() - 1).setClase(rs.getString("nombreclase"));
                jsonArray.get(jsonArray.size() - 1).setInstructor(rs.getString("instructor"));
                jsonArray.get(jsonArray.size() - 1).setFecha(rs.getDate("fecha"));
                jsonArray.get(jsonArray.size() - 1).setDia(rs.getString("dia"));
                jsonArray.get(jsonArray.size() - 1).setCapacidad(rs.getInt("capacidad"));
                jsonArray.get(jsonArray.size() - 1).setHoraInicio(rs.getTime("hora_inicio"));
                jsonArray.get(jsonArray.size() - 1).setHoraFin(rs.getTime("hora_fin"));
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
}
