/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.Clase;
import Dominio.Sql;
import Dominio.Horario_Clase;
import Excepciones.ParameterNullException;
import Validaciones.ValidationWS;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Mario
 */
@Path("/FOM05_Clase_Fecha")
public class FOM05_Clase_Fecha {
    private Connection _conn = Sql.getConInstance();
    private Gson _gson = new Gson();
    private String result;
    private ArrayList<Clase> jsonArray;
    private ArrayList<Horario_Clase> jsonA;
  
    
    
    @GET  
    @Produces("application/json")
    public String prueba ()
    {
        return "PRUEBA CLASES POR FECHA";
    }
    
    /**
     * 
     * @return Consulta que devuelve todas las clases por fecha
     * @throws SQLException 
     */
    
    @GET
    
    @Path("/consultarClase")
    
    @Produces("application/json")
    
    public String consultarClase(@QueryParam("fecha") String fecha) throws SQLException
    {
        try
        {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("fecha", fecha);
            }});
            
            String query = "Select * from FOM05_CLASES_FECHA('"+fecha+"')";
            jsonArray = new ArrayList<>();
            Statement st = _conn.createStatement();
            ResultSet rs = st.executeQuery(query);  
    
            while (rs.next())
            {    
                jsonArray.add(new Clase());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("id"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("nombre"));
                jsonArray.get(jsonArray.size() - 1).setDescripcion(rs.getString("descripcion"));
         
            }
             result = _gson.toJson(jsonArray);
             
        }
        catch (SQLException e)
        {
            return e.getMessage();
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
        finally
        {
            Sql.bdClose(_conn);
            return result; 
        }
    } 

    /**
     * Metodo que lista todas las clases
     * @return
     * @throws SQLException 
     */
    
        @GET
    
         @Path("/listaClases")
        
        @Produces("application/json")
    
        public String listaClases() throws SQLException
    {
        try
        {
            String query = "Select * from m05_lista_clases()";
            jsonArray = new ArrayList<>();
            Statement st = _conn.createStatement();
            ResultSet rs = st.executeQuery(query);  
    
            while (rs.next())
            {    
                jsonArray.add(new Clase());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("id"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("clase"));
                jsonArray.get(jsonArray.size() - 1).setDescripcion(rs.getString("descripcion"));
                jsonArray.get(jsonArray.size() - 1).setFecha(rs.getDate("fecha"));
                jsonArray.get(jsonArray.size() - 1).setInstructor(rs.getString("instructor"));
                jsonArray.get(jsonArray.size() - 1).setCapacidad(rs.getInt("capacidad"));
         
            }
             result = _gson.toJson(jsonArray);
             return result; 
        }
        catch (SQLException e)
        {
            return e.getMessage();
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
        finally
        {
            Sql.bdClose(_conn);
        }
    }
        
        /**
         * 
         * @param id 
         * @return datos de la clase en base al id de horario clase
         */
        
        @GET
        @Path("/getClaseP")
        @Produces("application/json")
        public String getHorario_Clase(@QueryParam("id") int id){    
        try{     
            
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("id", id);
            }});
            
            String query = "SELECT * FROM m05_get_horario_clase(?)";
            jsonA = new ArrayList<>();
            PreparedStatement st = _conn.prepareStatement(query);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                jsonA.add(new Horario_Clase());
                jsonA.get(jsonA.size() - 1).setNombreclase(rs.getString("nombreclase"));
                jsonA.get(jsonA.size() - 1).setInstructor(rs.getString("instructor"));
                jsonA.get(jsonA.size() - 1).setFecha(rs.getDate("fecha"));
                jsonA.get(jsonA.size() - 1).setDia(rs.getString("dia"));
                jsonA.get(jsonA.size() - 1).setCapacidad(rs.getInt("capacidad"));
                jsonA.get(jsonA.size() - 1).setHoraInicio(rs.getTime("hora_inicio"));
                jsonA.get(jsonA.size() - 1).setHoraFin(rs.getTime("hora_fin"));
                jsonA.get(jsonA.size() - 1).setDescripcion(rs.getString("descripcion"));
            }
                result = _gson.toJson(jsonA);
                return result;
            }
             catch(SQLException e) {
                 result = e.getMessage();
        }
            catch (ParameterNullException e) {
             result = e.getMessage();
        }   
             finally {
             Sql.bdClose(_conn);
           
        }
        return null;
     }

    
}
