/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.Reserva;
import Dominio.Sql;
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
@Path("/FOM05_Reserva")
public class FOM05_Reserva {
    private Connection _conn = Sql.getConInstance();
    private Gson _gson = new Gson();
    private String result;
    private ArrayList<Reserva> jsonArray;
  
    
    
    @GET  
    @Produces("application/json")
    public String prueba ()
    {
        return "PRUEBA RESERVA";
    }
    
    /**
     * 
     * @return Consulta que devuelve todas las clases por fecha
     * @throws SQLException 
     */
    
    @GET
    
    @Path("/consultaReserva")
    
    @Produces("application/json")
    
    public String consultaReserva(@QueryParam("id") int id) throws SQLException
    {
        try
        {
             
            String query = "Select * from FOM05_CONSULTAR_RESERVA("+id+")";
            jsonArray = new ArrayList<>();
            Statement st = _conn.createStatement();
            ResultSet rs = st.executeQuery(query);  
           
    
            while (rs.next())
            {    
               jsonArray.add(new Reserva());
                jsonArray.get(jsonArray.size() - 1).setRes_Id(rs.getInt("id"));
                jsonArray.get(jsonArray.size() - 1).setFecha_Ini(rs.getDate("fechainicio"));
                jsonArray.get(jsonArray.size() - 1).setFecha_Fin(rs.getDate("fechafin"));
                jsonArray.get(jsonArray.size() - 1).setUsuario(rs.getInt("username"));
                jsonArray.get(jsonArray.size() - 1).setEntrenador(rs.getInt("entrenador"));                              
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

     @GET
    
    @Path("/insertarReserva")
    
    @Produces("application/json")
    
    public String insertarReserva(@QueryParam("fechainicio") String fechainicio,
                                  @QueryParam("fechafin") String fechafin,
                                  @QueryParam("usuario") int usuario,
                                  @QueryParam("entrenador") int entrenador) throws SQLException
    {
        try
        {
            String query = "Select * from M05_AGREGAR_RESERVA('"+fechainicio+"','"+fechafin+"', "+usuario+","+entrenador+")";
            
            Statement st = _conn.createStatement();
            ResultSet rs = st.executeQuery(query);  

             return "AGREGADO"; 
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
 
     @GET
    
    @Path("/eliminarReserva")
    
    @Produces("application/json")
    
    public String eliminarReserva(@QueryParam("id") int id) throws SQLException
    {
        try
        {
            String query = "Select * from M05_ELIMINAR_RESERVA("+id+")";
          
            Statement st = _conn.createStatement();
            ResultSet rs = st.executeQuery(query);  

             return "ELIMINADO"; 
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
    
}