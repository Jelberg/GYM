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
import java.sql.Time;
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
     * para consultarla y saber varios datos.
     * @param nombreclaseconsulta Nombre de la clase.
     * @return Devuelve los datos de la clase y su horario en formato json
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
                jsonArray.get(jsonArray.size() - 1).setNombreclase(rs.getString("nombreclase"));
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
    
    /**
     * Funcion que es llamada cuando el admin desea insertar un horario de una clase.
     * @param id_horario_clase Identificador de la clase.
     * @param fecha Fecha de la clase (dd/mm/aaaa).
     * @param dia Día de la clase (lunes, martes, ... ).
     * @param capacidad Capacidad de alumnos en la clase.
     * @param hora_inicio Hora que inicia la clase.
     * @param hora_fin Hora que finaliza la clase.
     * @param status status de la clase A(Activa) I (Inactiva).
     * @param duracion duración de la clase (calculada con una función).
     * @param nombreclase Nombre de la clase.
     * @param instructor Día de la clase (lunes, martes, ... ).
     * @return Devuelve un json con mensaje del estatus de la peticion.
     */
    @POST
    @Path("/insertaHorario_Clase")
    @Produces("application/json")
    public String insertaHorario_Clase(@QueryParam("id_horario_clase") int id_horario_clase,
                                 @QueryParam("fecha") Date fecha,
                                 @QueryParam("dia") String dia,
                                 @QueryParam("capacidad") int capacidad,
                                 @QueryParam("hora_inicio") Time hora_inicio,
                                 @QueryParam("hora_fin") Time hora_fin,
                                 @QueryParam("status") int status,
                                 @QueryParam("duracion") int duracion,
                                 @QueryParam("nombreclase") int nombreclase,
                                 @QueryParam("instructor") int instructor){

        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("id_horario_clase", id_horario_clase );
                put("fecha", fecha );
                put("dia", dia );
                put("capacidad", capacidad );
                put("hora_inicio", hora_inicio );
                put("hora_fin", hora_fin );
                put("status", status );
                put("duracion", duracion );
                put("nombreclase", nombreclase );
                put("instructor", instructor );
            }});

            String query = "select * from bo_m02_inserta_horario_clase(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            java.lang.reflect.Type type = new TypeToken<Horario_Clase[]>(){}.getType();
                st.setInt(1, id_horario_clase);
                st.setDate(2, fecha);
                st.setString(3, dia);
                st.setInt(4, capacidad);
                st.setTime(5, hora_inicio);
                st.setTime(6, hora_fin);
                st.setInt(7, status);
                st.setInt(8, duracion);
                st.setInt(10, nombreclase);
                st.setInt(11, instructor);
                st.executeQuery();
            response.put("data", "Se insertó el horario");
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
    
    /**
     * Metodo que recibe como parametros los siguientes campos
     * para eliminar el horario de esa clase con ese instructor ese día y a esa hora.
     * @param nombreclase Nombre de la clase.
     * @param instructor Identificador del instructor.
     * @param fecha Fecha de la clase (dd/mm/aaaa).
     * @param dia Día de la clase (lunes, martes, ... ).
     * @param capacidad Capacidad de alumnos en la clase.
     * @param hora_inicio Hora que inicia la clase.
     * @param hora_fin Hora que finaliza la clase.
     * @return Devuelve un json con elemento llamado data, 
     * contiene el mensaje de la peticion
     */
    @DELETE
    @Path("/eliminaHorario_Clase")
    @Produces("application/json")
    public String eliminaClase(@QueryParam("nombreclase") int nombreclase,
                                 @QueryParam("instructor") int instructor,
                                 @QueryParam("fecha") Date fecha,
                                 @QueryParam("dia") String dia,
                                 @QueryParam("capacidad") int capacidad,
                                 @QueryParam("hora_inicio") Time hora_inicio,
                                 @QueryParam("hora_fin") Time hora_fin){

        Map<String, String> response = new HashMap<String, String>();
        try{

            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("nombreclase", nombreclase);
                put("instructor", instructor);
                put("fecha", fecha );
                put("dia", dia );
                put("capacidad", capacidad );
                put("hora_inicio", hora_inicio );
                put("hora_fin", hora_fin );
            }});
                String query = "SELECT bo_m02_elimina_horario_clase(?,?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, nombreclase);
                st.setInt(2, instructor);
                st.setDate(3, fecha);
                st.setString(4, dia);
                st.setInt(5, capacidad);
                st.setTime(6, hora_inicio);
                st.setTime(7, hora_fin);
            ResultSet rs = st.executeQuery();
            response.put("data", "Se elimino el horario");
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
     * Funcion que modifica un horario.
     * @param nombreclase Nombre de la clase.
     * @param instructor Identificador del instructor.
     * @param fecha Fecha de la clase (dd/mm/aaaa).
     * @param dia Día de la clase (lunes, martes, ... ).
     * @param capacidad Capacidad de alumnos en la clase.
     * @param hora_inicio Hora que inicia la clase.
     * @param hora_fin Hora que finaliza la clase.
     * @return Devuelve un json con un mensaje al usuario sobre el estatus
     * de la petición.
     */
    @POST
    @Path("/modificaHorario_Clase")
    @Produces("application/json")
    public String modificaClase( @QueryParam ( "nombreclase" ) int nombreclase,
                                 @QueryParam("instructor") int instructor,
                                 @QueryParam("fecha") Date fecha,
                                 @QueryParam("dia") String dia,
                                 @QueryParam("capacidad") int capacidad,
                                 @QueryParam("hora_inicio") Time hora_inicio,
                                 @QueryParam("hora_fin") Time hora_fin){
        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("nombreclase", nombreclase);
                put("instructor", instructor);
                put("fecha", fecha );
                put("dia", dia );
                put("capacidad", capacidad );
                put("hora_inicio", hora_inicio );
                put("hora_fin", hora_fin );
            }});
            String query = "select * from bo_m02_modifica_horario_clase(?,?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, nombreclase);
                st.setInt(2, instructor);
                st.setDate(3, fecha);
                st.setString(4, dia);
                st.setInt(5, capacidad);
                st.setTime(6, hora_inicio);
                st.setTime(7, hora_fin);
            st.executeQuery();
            response.put("data", "Se modificó con éxito");
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
