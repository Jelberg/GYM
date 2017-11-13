/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;
import Dominio.*;
import Dominio.Clase;
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
@Path("/BOM02_Clase")
public class BOM02_Clase {
    
    private Connection conn = Sql.getConInstance();
    //Atributo que se utiliza para transformar a formado JSON las consultas.
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Clase> jsonArray;
    
    /**
     * Funcion que recibe como parámetro el nombre de la clase,
     * para consultarla y saber su descripción.
     * @param nombre Nombre de la clase.
     * @return Devuelve la clase y su descripción en formato json
     */
    @GET
    @Path("/getClase")
    @Produces("application/json")
    public String getClase(@QueryParam("nombre") String nombre){
        
        try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("nombre", nombre);
            }});
            String query = "SELECT * FROM bo_m02_get_clase('"+nombre+"')";
            jsonArray = new ArrayList<>();
            System.out.println (query);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                jsonArray.add(new Clase());
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("nombre"));
                jsonArray.get(jsonArray.size() - 1).setDescripcion(rs.getString("descripcion"));
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
     * Funcion que es llamada cuando el admin desea insertar una clase.
     * @param id_clase Identificador de la clase.
     * @param nombre Nombre de la clase.
     * @param descripcion Descripción de la clase.
     * @return Devuelve un json con mensaje del estatus de la peticion.
     */
    @POST
    @Path("/insertaClase")
    @Produces("application/json")
    public String insertaClases(@QueryParam("id_clase") int id_clase,
                                 @QueryParam("nombre") String nombre,
                                 @QueryParam("descripcion") String descripcion){

        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("id_clase", id_clase );
                put("nombre", nombre );
                put("descripcion", descripcion );
            }});

            String query = "select * from bo_m02_inserta_clase(?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            java.lang.reflect.Type type = new TypeToken<Clase[]>(){}.getType();
                st.setInt(1, id_clase);
                st.setString(2, nombre);
                st.setString(3, descripcion);
                
                st.executeQuery();
            

            response.put("data", "Se insertaron las clases");
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
     * Metodo que recibe como parametros el nombre de la clase
     * para eliminarla.
     * @param nombre Nombre de la clase.
     * @return Devuelve un json con elemento llamado data, 
     * contiene el mensaje de la peticion
     */
    @DELETE
    @Path("/eliminaClase")
    @Produces("application/json")
    public String eliminaClase(@QueryParam("nombre") String nombre){

        Map<String, String> response = new HashMap<String, String>();
        try{

            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("nombre", nombre);
            }});
                String query = "SELECT bo_m02_elimina_clase(?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, nombre);
            ResultSet rs = st.executeQuery();
            response.put("data", "Se elimino la clase");
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
     * Funcion que modifica alguna clase.
     * @param nombre Nombre de la clase.
     * @param descripcion Descripción de la clase.
     * @return Devuelve un json con un mensaje al usuario sobre el estatus
     * de la petición.
     */
    @POST
    @Path("/modificaClase")
    @Produces("application/json")
    public String modificaClase( @QueryParam ( "nombre" ) String nombre,
                                   @QueryParam ( "descripcion" ) String descripcion){
        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put ( "nombre" , nombre );
                put( "descripcion" , descripcion );
            }});
            String query = "select * from bo_m02_modifica_clase(?,?);";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, nombre);
            st.setDate(2,Date.valueOf(descripcion));
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
