/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;
 
import Dominio.Equipo;
import Dominio.Maquina;
import Dominio.Sql;
import Excepciones.ParameterNullException;
import Validaciones.ValidationWS;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.Image;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Juan Zozaya
 */
@Path("Equipamiento")
public class BOM01_Equipamiento {
private Connection conn = Sql.getConInstance();
    //Atributo que se utiliza para transformar a formado JSON las consultas.
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Equipo> jsonArray; 
    private ArrayList<Maquina> jsonArray2; 
    
   @GET
    @Path("/getListEquipo")
    @Produces("application/json")
    public String getListEquipo(){
         try{
            
            String query = "SELECT * FROM equipo;";
            jsonArray = new ArrayList<>();
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){ 
                jsonArray.add(new Equipo());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("EQU_ID"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("EQU_NOMBRE")); 
                        
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
    @Path("/getListMaquina")
    @Produces("application/json")
    public String getListMaquina(){
         try{
            
            String query = "SELECT * FROM maquina;";
            jsonArray2 = new ArrayList<>();
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){ 
                jsonArray2.add(new Maquina());
                jsonArray2.get(jsonArray2.size() - 1).setId(rs.getInt("MAQ_ID"));
                jsonArray2.get(jsonArray2.size() - 1).setNombre(rs.getString("MAQ_NOMBRE")); 
                        
            }
            response = gson.toJson(jsonArray2);
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
    
    
    @POST
    @Path("/insertaEquipo")
    @Produces("application/json")
    public String insertaEquipo(@QueryParam("nombre") String nombre) {

        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                
                put("nombre", nombre ); 
            }});

            String query = "select * from bo_m01_insertar_equipo(?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            java.lang.reflect.Type type = new TypeToken<Equipo[]>(){}.getType();
                
                st.setString(2, nombre); 
                
                st.executeQuery();
            

            response.put("data", "Se insertó el equipo");
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
