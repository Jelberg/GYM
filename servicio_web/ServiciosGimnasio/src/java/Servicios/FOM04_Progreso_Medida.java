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
import Validaciones.ValidationWS;
import Excepciones.ParameterNullException;
import com.google.gson.reflect.TypeToken;
import java.lang.ProcessBuilder.Redirect.Type;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Map;
import javax.ws.rs.DELETE;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;


/**
 *
 * @author marvian
 */
@Path("/F0M04_Progreso_Medida")
public class FOM04_Progreso_Medida {
    
    private Connection conn = Sql.getConInstance();
    //Atributo que se utiliza para transformar a formado JSON las consultas.
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Progreso_Medida> jsonArray;
    
    /**
     * Funcion que recibe como parametros la fecha y el sobrenombre del usuario
     * para hacer la consulta de las medidas registradas por el usuario durante
     * esa fecha.
     * @param fecha Fecha del mes en que se quiere obtener las medidas.
     * Debe ser en formato yyyy-mm-dd
     * @param sobrenombre Indica el nombre del usuario
     * @return Devuelve las medidas en formato json
     */
    @GET
    @Path("/getProgresoM")
    @Produces("aplicacion/json")
    public String getProgresoM(@QueryParam("fecha") String fecha,
                                @QueryParam("sobrenombre") String sobrenombre){
    
        try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("sobrenombre", sobrenombre);
                put("fecha", fecha);
            }});

            String query = "SELECT * FROM fo_m04_get_progresoM(?, ?)";
            jsonArray = new ArrayList<>();
            PreparedStatement st = conn.prepareStatement(query);
            st.setDate(1, Date.valueOf(fecha));
            st.setString(2, sobrenombre);
            ResultSet rs = st.executeQuery();
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                jsonArray.add(new Progreso_Medida());
                jsonArray.get(jsonArray.size() - 1).setMedida(rs.getInt("medida"));
                jsonArray.get(jsonArray.size() - 1).setTipo(rs.getString("tipo"));
            
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
    
    /**
     * Metodo que recibe como parametros la fecha del mes 
     * correspondiente a la fecha a eliminar y el nombre del usuario 
     * para eliminar las medidas de ese mes.
     * @param fecha Indica la fecha correspondiente a las medidas.
     * @param sobrenombre Indica el nombre del usuario.
     * @return Devuelve un json con elemento llamado data, 
     * contiene el mensaje de la peticion
     */
    @DELETE
    @Path("/eliminarMedidas")
    @Produces("aplicacion/json")
    public String eliminaMedidas(@QueryParam("fecha") String fecha,
                             @QueryParam("sobrenombre") String sobrenombre) {

        Map<String, String> response = new HashMap<String, String>();
        try{

            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("sobrenombre", sobrenombre);
                put("fecha", fecha);
            }});
            String query = "SELECT fo_m04_elimina_medidas(?, ?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, fecha);
            st.setString(2, sobrenombre);
            ResultSet rs = st.executeQuery();
            response.put("data", "Se elimino las medidas");

        }
        catch(SQLException e) {
            response.put("error", e.getMessage());
        }
        catch (ParameterNullException e) {
            response.put("error", e.getMessage());
        }
        finally {
            Sql.bdClose(conn);
            return gson.toJson(response);

        }
        
        
    }
    
    /**
     * Funcion obtiene las medidas por un usuario en los ultimos 12 meses.
     * @param sobrenombre Indica el nombre del usuario.
     * @return Devuelve un json con la informacion de las medidas
     * relacionada con el mes correspondiente
     */
    @GET
    @Path("/getMedidasDelAno")
    @Produces("aplicacion/json")
    public String getMedidasDelAno(@QueryParam("sobrenombre") String sobrenombre){

        try {

            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("sobrenombre", sobrenombre);
            }});

            String query = "select * from m04_get_medidas_ano(?, ?, ?)";
            ResultSet rs;
            jsonArray = new ArrayList<>();
            LocalDate fecha = LocalDate.now();
            fecha = fecha.with(TemporalAdjusters.firstDayOfMonth());
            Date fechaInicio = Date.valueOf(fecha);
            Date fechafin = Date.valueOf(fecha.with(TemporalAdjusters.lastDayOfMonth()));
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, sobrenombre);
            st.setDate(2, fechaInicio);
            st.setDate(3, fechafin);
            for (int i = 0; i <= 11; i++) {
                if (i > 0) {
                    fecha = fecha.minusMonths(1);
                    fechaInicio = Date.valueOf(fecha);
                    fechafin = Date.valueOf(fecha.with(TemporalAdjusters.lastDayOfMonth()));
                    st.setDate(2, fechaInicio);
                    st.setDate(3, fechafin);
                }

                rs = st.executeQuery();
                jsonArray.add(new Progreso_Medida());
                if (rs.wasNull()) {
                    jsonArray.get(jsonArray.size() - 1).setMedida(0);
                    jsonArray.get(jsonArray.size() - 1).setFechaM(fechaInicio.toLocalDate());
                }
                else {

                    while (rs.next()) {
                        jsonArray.get(jsonArray.size() - 1).setMedida(rs.getInt("medida"));
                        jsonArray.get(jsonArray.size() - 1).setFechaM(fechaInicio.toLocalDate());
                    }
                }
            }
            response = gson.toJson(jsonArray);
        }
        catch (SQLException e) {
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
    
    
    /**
     * Funcion que perimite ingresar varios alimentos que consumio el usuario
     * @param jsonDiet Indica los alimentos que se insertaran en formato json, el json debe tener la estructura
     *                  de un arreglo de un objeto Diet(_calorie, _food, _moment, _username) convertido en  json
     * @return Devuelve un json con elemento llamado data, el cual contiene el mensaje de la peticion
     */
    @POST
    @Path("/insertaMedidas")
    @Produces("aplicacion/json")
    public String insertaMedidas(@QueryParam("Progreso_Medida") String jsonDiet){

        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("Progreso_Medida", jsonDiet);
            }});

            String query = "select * from fo_m04_inserta_medidas(?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(query);
            java.lang.reflect.Type type = new TypeToken<Progreso_Medida[]>(){}.getType();
            
            Progreso_Medida[] medida  = gson.fromJson(jsonDiet, type);

            for (int i = 0; i < medida.length; i++) {
                st.setInt(1, medida[i].getMedida());
                st.setString(2, medida[i].getTipo());
                /*st.setLocalDate(3, medida[i].getFechaM());*/
                st.setString(4, medida[i].getSobrenombre());
                st.executeQuery();
            }

            response.put("data", "Se insertaron las medidas");
        }
        catch (SQLException e){
            response.put("error", e.getMessage());
        }
        catch (ParameterNullException e) {
            response.put("error", e.getMessage());
        }
        finally {
            Sql.bdClose(conn);
            return gson.toJson(response);
        }

    }
    
}
