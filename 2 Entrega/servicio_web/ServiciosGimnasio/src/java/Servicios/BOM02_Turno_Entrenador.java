/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.Turno_Entrenador;
import Dominio.Sql;
import Excepciones.ParameterNullException;
import Validaciones.ValidationWS;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author YESIMAR
 */
@Path("/BOM02_Turno_Entrenador")
public class BOM02_Turno_Entrenador {
    
    private Connection conn = Sql.getConInstance();
    //Atributo que se utiliza para transformar a formado JSON las consultas.
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Turno_Entrenador> jsonArray;
    
    /**
     * Funcion que recibe como parámetro el correo de un entrenador
     * para consultarlo y saber sus turnos en el gimnasio.
     * @param correo Correo del entrenador.
     * @return Devuelve los datos en formato json
     */
    @GET
    @Path("/getTurno_Entrenador")
    @Produces("application/json")
    public String getTurno_Entrenador(@QueryParam("correo") String correo){
        
        try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("correo", correo);
            }});
            String query = "SELECT * FROM bo_m02_get_Turno_Entrenador('"+correo+"')";
            jsonArray = new ArrayList<>();
            System.out.println (query);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                jsonArray.add(new Turno_Entrenador());
                jsonArray.get(jsonArray.size() - 1).setEntrenador(rs.getString("correo"));
                jsonArray.get(jsonArray.size() - 1).setTurno(rs.getString("dia"));
                jsonArray.get(jsonArray.size() - 1).setHoraInicio(rs.getTime("hora_inicio"));
                jsonArray.get(jsonArray.size() - 1).setHoraFin(rs.getTime("hora_fin"));
                jsonArray.get(jsonArray.size() - 1).setTurno(rs.getString("turno"));
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
     * @return Devuelve todos los datos de los turnos de los entrenadores
     */
    @GET
    @Path("/getListTurno_Entrenador")
    @Produces("application/json")
    public String getListaTurno_Entrenador(){
         try{
            
            String query = "SELECT * FROM turno_entrenador;";
            jsonArray = new ArrayList<>();
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                jsonArray.add(new Turno_Entrenador());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("TE_ID"));
                jsonArray.get(jsonArray.size() - 1).setFecha(rs.getDate("TE_FECHA"));
                jsonArray.get(jsonArray.size() - 1).setTanda(rs.getString("TE_TANDA"));
                jsonArray.get(jsonArray.size() - 1).setHoraInicio(rs.getTime("TE_HORA_INICIO"));
                jsonArray.get(jsonArray.size() - 1).setHoraFin(rs.getTime("TE_HORA_FIN"));
                jsonArray.get(jsonArray.size() - 1).setTurno(rs.getString("fk_turno"));         
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
     * Funcion que es llamada cuando el admin desea insertar un turno de un entrenador.
     * @param fecha Fecha del turno.
     * @param tanda Tanda del entrenador (día, tarde, noche).
     * @param hora_inicio Hora que inicia la tanda.
     * @param hora_fin Hora que finaliza la tanda.
     * @param turno fk del turno.
     * @param entrenador fk del entrenador.
     * @return Devuelve un json con mensaje del estatus de la peticion.
     */
    @POST
    @Path("/insertaTurno_Entrenador")
    @Produces("application/json")
    public String insertaTurno_Entrenador(@QueryParam("fecha") Date fecha,
                                 @QueryParam("tanda") String tanda,
                                 @QueryParam("hora_inicio") Time hora_inicio,
                                 @QueryParam("hora_fin") Time hora_fin,
                                 @QueryParam("turno") String turno,
                                 @QueryParam("entrenador") String entrenador){

        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("fecha", fecha );
                put("tanda", tanda );
                put("hora_inicio", hora_inicio );
                put("hora_fin", hora_fin );
                put("turno", turno );
                put("entrenador", entrenador );
            }});

            String query = "select * from bo_m02_inserta_turno_entrenador(?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            java.lang.reflect.Type type = new TypeToken<Turno_Entrenador[]>(){}.getType();
                st.setDate(1, fecha);
                st.setString(2, tanda);
                st.setTime(3, hora_inicio);
                st.setTime(4, hora_fin);
                st.setString(5, turno);
                st.setString(6, entrenador);
                st.executeQuery();
            response.put("data", "Se insertó el turno del entrenador");
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
     * para eliminar el turno del entrenador
     * @param fecha Fecha del turno.
     * @param tanda Tanda del entrenador (día, tarde, noche).
     * @param hora_inicio Hora que inicia la tanda.
     * @param hora_fin Hora que finaliza la tanda.
     * @param turno fk del turno.
     * @param entrenador fk del entrenador.
     * @return Devuelve un json con elemento llamado data, 
     * contiene el mensaje de la peticion
     */
    @DELETE
    @Path("/eliminaTurno_Entrenador")
    @Produces("application/json")
    public String eliminaTurno_Entrenador(@QueryParam("fecha") Date fecha,
                                 @QueryParam("tanda") String tanda,
                                 @QueryParam("hora_inicio") Time hora_inicio,
                                 @QueryParam("hora_fin") Time hora_fin,
                                 @QueryParam("turno") String turno,
                                 @QueryParam("entrenador") String entrenador){

        Map<String, String> response = new HashMap<String, String>();
        try{

            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("fecha", fecha );
                put("tanda", tanda );
                put("hora_inicio", hora_inicio );
                put("hora_fin", hora_fin );
                put("turno", turno );
                put("entrenador", entrenador );
            }});
                String query = "SELECT bo_m02_elimina_turno_entrenador(?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
                st.setDate(1, fecha);
                st.setString(2, tanda);
                st.setTime(3, hora_inicio);
                st.setTime(4, hora_fin);
                st.setString(5, turno);
                st.setString(6, entrenador);
            ResultSet rs = st.executeQuery();
            response.put("data", "Se elimino el turno del entrenador");
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
     * Funcion que modifica el turno de un entrenador.
     * @param fecha Fecha del turno.
     * @param tanda Tanda del entrenador (día, tarde, noche).
     * @param hora_inicio Hora que inicia la tanda.
     * @param hora_fin Hora que finaliza la tanda.
     * @param turno fk del turno.
     * @param entrenador fk del entrenador.
     * @return Devuelve un json con un mensaje al usuario sobre el estatus
     * de la petición.
     */
    @POST
    @Path("/modificaTurno_Entrenador")
    @Produces("application/json")
    public String modificaTurno_Entrenador( @QueryParam("fecha") Date fecha,
                                 @QueryParam("tanda") String tanda,
                                 @QueryParam("hora_inicio") Time hora_inicio,
                                 @QueryParam("hora_fin") Time hora_fin,
                                 @QueryParam("turno") String turno,
                                 @QueryParam("entrenador") String entrenador){
        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("fecha", fecha );
                put("tanda", tanda );
                put("hora_inicio", hora_inicio );
                put("hora_fin", hora_fin );
                put("turno", turno );
                put("entrenador", entrenador );
            }});
            String query = "select * from bo_m02_modifica_horario_clase(?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
                st.setDate(1, fecha);
                st.setString(2, tanda);
                st.setTime(3, hora_inicio);
                st.setTime(4, hora_fin);
                st.setString(5, turno);
                st.setString(6, entrenador);
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
