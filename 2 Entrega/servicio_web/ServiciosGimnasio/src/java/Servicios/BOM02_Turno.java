/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.Turno;
import Dominio.Sql;
import Excepciones.ParameterNullException;
import Validaciones.ValidationWS;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
@Path("/BOM02_Turno")
public class BOM02_Turno {
    
    private Connection conn = Sql.getConInstance();
    //Atributo que se utiliza para transformar a formado JSON las consultas.
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Turno> jsonArray;
    
    /**
     * Funcion que recibe como parámetro el dia del turno,
     * para consultarlo.
     * @param dia Dia del turno.
     * @return Devuelve el turno en formato json
     */
    @GET
    @Path("/getTurno")
    @Produces("application/json")
    public String getTurno(@QueryParam("dia") String dia){
        
        try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("dia", dia);
            }});
            String query = "SELECT * FROM bo_m02_get_turno('"+dia+"')";
            jsonArray = new ArrayList<>();
            System.out.println (query);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                jsonArray.add(new Turno());
                jsonArray.get(jsonArray.size() - 1).setDia(rs.getString("dia"));
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
    
    @GET
    @Path("/getListTurno")
    @Produces("application/json")
    public String getListTurno(){
        
        try{
            
            String query = "SELECT tur_dia FROM turno";
            jsonArray = new ArrayList<>();
            System.out.println (query);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                jsonArray.add(new Turno());
                jsonArray.get(jsonArray.size() - 1).setDia(rs.getString("tur_dia"));
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
     * Funcion que es llamada cuando el admin desea insertar un turno.
     * @param dia Día del turno.
     * @return Devuelve un json con mensaje del estatus de la peticion.
     */
    @POST
    @Path("/insertaTurno")
    @Produces("application/json")
    public String insertaTurno(  @QueryParam("dia") String dia){

        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("dia", dia );
            }});

            String query = "select * from bo_m02_inserta_turno(?)";
            PreparedStatement st = conn.prepareStatement(query);
            java.lang.reflect.Type type = new TypeToken<Turno[]>(){}.getType();
                st.setString(1, dia);
                st.executeQuery();

            response.put("data", "Se insertó el turno");
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
     * Metodo que recibe como parametros el día del turno
     * para eliminarlo.
     * @param dia Día del turno.
     * @return Devuelve un json con elemento llamado data, 
     * contiene el mensaje de la peticion.
     */
    @DELETE
    @Path("/eliminaTurno")
    @Produces("application/json")
    public String eliminaTurno(@QueryParam("dia") String dia){

        Map<String, String> response = new HashMap<String, String>();
        try{

            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("dia", dia);
            }});
                String query = "SELECT bo_m02_elimina_turno(?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, dia);
            ResultSet rs = st.executeQuery();
            response.put("data", "Se elimino el turno");
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
     * Funcion que modifica algún turno.
     * @param dia Día del turno.
     * @return Devuelve un json con un mensaje al usuario sobre el estatus
     * de la petición.
     */
    @POST
    @Path("/modificaTurno")
    @Produces("application/json")
    public String modificaTurno( @QueryParam ( "dia" ) String dia){
        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put ( "dia" , dia );
            }});
            String query = "select * from bo_m02_modifica_turno(?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, dia);
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
