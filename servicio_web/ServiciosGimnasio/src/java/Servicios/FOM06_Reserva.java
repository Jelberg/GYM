/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;
import Dominio.Reserva;
import Dominio.Sql;
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
 * @author Luis L
 */
@Path("/FOM06_Reserva")
public class FOM06_Reserva {
    private Connection conn = Sql.getConInstance();
    //Atributo que se utiliza para transformar a formado JSON las consultas.
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Reserva> jsonArray;
    
    /*
     * Funcion que consulta las reservas que se han hecho por un usuario
     * @param id_usuario del usuario que realiza las consultas 
     *return devuele las reservas
    */
     @GET
    @Path("/getReservas")
    @Produces("application/json")
    public String getReservas(@QueryParam("id") int id_usuario){
    
        try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("id", id_usuario);
            }});

            String query = "SELECT * FROM fo_m06_get_reserva(?)";
            jsonArray = new ArrayList<>();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id_usuario);
            ResultSet rs = st.executeQuery();
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                jsonArray.add(new Reserva());
                jsonArray.get(jsonArray.size() - 1).setEntrenador(rs.getInt("Entrenador"));
                jsonArray.get(jsonArray.size() - 1).setFecha_Ini(rs.getDate("Fecha Inicial"));
                jsonArray.get(jsonArray.size() - 1).setFecha_Fin(rs.getDate("Fecha Final"));
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
        /*
     * Funcion que permite agregar las reservas que un usuario desee
     * @param id_reserva,fecha inicial,fecha final,id usuario e id entrenador 
     *
    */

    
 @POST
    @Path("/insertaReservas")
    @Produces("application/json")
    public String insertaReservas(@QueryParam("id") int id_res,
                                  @QueryParam ("fecha_inicial") Date fecha_ini,
                                  @QueryParam ("fecha_final") Date fecha_fin,
                                  @QueryParam ("id_usu") int id_usu,
                                  @QueryParam ("id_ent")int id_ent){
    
        try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("id", id_res);
                put("fecha_inicial", fecha_ini);
                put("fecha_final", fecha_fin);
                put("id_usu", id_usu);
                put("id_ent", id_ent);
                
            }});

            String query = "SELECT * FROM fo_m06_agregar_reserva(?)";
            jsonArray = new ArrayList<>();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id_res);
            st.setDate(2,fecha_ini);
            st.setDate(3,fecha_fin);
            st.setInt(4,id_usu);
            st.setInt(4,id_ent);
            st.executeQuery();
            
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
    /*
     * Funcion que permite eliminar una reserva hecha por un usuario
     * @param id_reserva a eliminar
     *
    */
    @DELETE
    @Path("/eliminaReserva")
    @Produces("application/json")
    public String eliminaReservas(@QueryParam("id") int id_rest){
        
        Map<String, String> response = new HashMap<String, String>();
        try{

            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("id", id_rest);
            }});
                String query = "SELECT * FROM fo_m06_elimina_reserva(?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id_rest);
            ResultSet rs = st.executeQuery();
            response.put("data", "Se elimino la reserva");
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
    
}
    


