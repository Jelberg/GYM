/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;
 
import Dominio.Equipo;
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
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
    
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
}
