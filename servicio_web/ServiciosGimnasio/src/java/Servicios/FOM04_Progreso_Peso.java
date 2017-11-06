/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.Progreso_Peso;
import Dominio.Sql;
import Excepciones.ParameterNullException;
import Validaciones.ValidationWS;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author marvian
 */
@Path("/F0M04_Progreso_Peso")
public class FOM04_Progreso_Peso {
    
    private Connection conn = Sql.getConInstance();
    //Atributo que se utiliza para transformar a formado JSON las consultas.
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Progreso_Peso> jsonArray;
    
    
    /**
     * Funcion que recibe como parametros la fecha y el sobrenombre del usuario
     * para hacer la consulta del peso registrado por el usuario en esa fecha.
     * @param fecha Fecha del mes en que se quiere obtener el peso.
     * Debe ser en formato yyyy-mm-dd
     * @param sobrenombre Indica el nombre del usuario
     * @return Devuelve el peso ingresado en formato json
     */
    @GET
    @Path("/getProgresoP")
    @Produces("aplicacion/json")
    public String getProgresoM(@QueryParam("fecha") String fecha,
                                @QueryParam("sobrenombre") String sobrenombre){
    
        try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("sobrenombre", sobrenombre);
                put("fecha", fecha);
            }});

            String query = "SELECT * FROM fo_m04_get_progresoP(?, ?)";
            jsonArray = new ArrayList<>();
            PreparedStatement st = conn.prepareStatement(query);
            st.setDate(1, Date.valueOf(fecha));
            st.setString(2, sobrenombre);
            ResultSet rs = st.executeQuery();
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                jsonArray.add(new Progreso_Peso());
                jsonArray.get(jsonArray.size() - 1).setPeso(rs.getInt("peso"));
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
     * correspondiente al peso a eliminar y el nombre correspondiente
     * al usuario
     * @param fecha Indica la fecha correspondiente al peso.
     * @param sobrenombre Indica el nombre del usuario.
     * @return Devuelve un json con elemento llamado data, 
     * contiene el mensaje de la peticion
     */
    @DELETE
    @Path("/eliminarPeso")
    @Produces("aplicacion/json")
    public String eliminaPeso(@QueryParam("fecha") String fecha,
                              @QueryParam("sobrenombre") String sobrenombre) {

        Map<String, String> response = new HashMap<String, String>();
        try{

            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("sobrenombre", sobrenombre);
                put("fecha", fecha);
            }});
            String query = "SELECT fo_m04_elimina_peso(?, ?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, fecha);
            st.setString(2, sobrenombre);
            ResultSet rs = st.executeQuery();
            response.put("data", "Se elimino el peso");

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
     * Funcion obtiene el peso de un usuario correspondiente a cada 
     * semana del mes.
     * @param sobrenombre Indica el nombre del usuario.
     * @return Devuelve un json con la informacion del peso
     * relacionada con el mes correspondiente
     */
    @GET
    @Path("/getPesoDelMes")
    @Produces("application/json")
    public String getPesoDelMes(@QueryParam("sobrenombre") String sobrenombre){
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("sobrenombre", sobrenombre);
            }});

            String query = "select * from fo_m04_get_peso_mes(?, ?, ?)";
            jsonArray = new ArrayList<>();
            ResultSet rs;
            LocalDate fecha = LocalDate.now();
            Date day;
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, sobrenombre);

            for (int i=0; i<=3; i++){
                day = Date.valueOf(fecha);
                st.setDate(2,day);
                st.setDate(3,day);
                rs = st.executeQuery();
                jsonArray.add(new Progreso_Peso());
                jsonArray.get(jsonArray.size() - 1).setFechaP(fecha);
                if (rs.wasNull()){
                    jsonArray.get(jsonArray.size() - 1).setPeso(0);
                }
                while (rs.next()){
                    jsonArray.get(jsonArray.size() - 1).setPeso(rs.getInt("peso"));
                }

                if (i < 6) {
                    fecha = fecha.minusWeeks(1);
                }
            }
            response = gson.toJson(jsonArray);
        }
        catch (SQLException e) {
            response = e.getMessage();
        }
        catch (ParameterNullException e){
            response = e.getMessage();
        }
        finally {
            Sql.bdClose(conn);
            return response;
        }
    }

    
    /**
     * Funcion obtiene el peso de un usuario en los ultimos 12 meses.
     * @param sobrenombre Indica el nombre del usuario.
     * @return Devuelve un json con la informacion del peso
     * relacionada con el mes correspondiente
     */
    @GET
    @Path("/getPesoDelAno")
    @Produces("aplicacion/json")
    public String getPesodelMes(@QueryParam("sobrenombre") String sobrenombre){

        try {

            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("sobrenombre", sobrenombre);
            }});

            String query = "select * from m04_get_peso_ano(?, ?, ?)";
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
                jsonArray.add(new Progreso_Peso());
                if (rs.wasNull()) {
                    jsonArray.get(jsonArray.size() - 1).setPeso(0);
                    jsonArray.get(jsonArray.size() - 1).setFechaP(fechaInicio.toLocalDate());
                }
                else {

                    while (rs.next()) {
                        jsonArray.get(jsonArray.size() - 1).setPeso(rs.getInt("peso"));
                        jsonArray.get(jsonArray.size() - 1).setFechaP(fechaInicio.toLocalDate());
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
    
    
    
}
