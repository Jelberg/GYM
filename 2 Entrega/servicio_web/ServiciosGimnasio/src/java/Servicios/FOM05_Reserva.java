/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.Horario_Clase;
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
 * Servicion para la reserva de las clases 
 * 
 */
@Path("/FOM05_Reserva")
public class FOM05_Reserva {
    private Connection _conn = Sql.getConInstance();
    private Gson _gson = new Gson();
    private String result;
    private ArrayList<Horario_Clase> jsonArray;
  
    
    
    @GET  
    @Produces("application/json")
    public String prueba ()
    {
        return "PRUEBA RESERVA";
    }
    
    
    
    /**
     * Servicio para la consulta de las reservas 
     * @param id del usuario
     * @return
     * @throws SQLException 
     */
    @GET
    
    @Path("/consultaReservas")
    
    @Produces("application/json")
    
    public String consultaReserva(@QueryParam("id") int id) throws SQLException
    {
        try
        {
             
            String query = "Select * from M05_LISTAR_RESERVAS("+id+")";
            jsonArray = new ArrayList<>();
            Statement st = _conn.createStatement();
            ResultSet rs = st.executeQuery(query);  
           
    
            while (rs.next())
            {    
               jsonArray.add(new Horario_Clase());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("id_hc"));
                jsonArray.get(jsonArray.size() - 1).setNombreclase(rs.getString("nombre"));
                jsonArray.get(jsonArray.size() - 1).setInstructor(rs.getString("instructor"));
                jsonArray.get(jsonArray.size() - 1).setFecha(rs.getDate("fecha"));
                jsonArray.get(jsonArray.size() - 1).setDia(rs.getString("dia"));                              
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
     * Servicio para la agreagacion de la participacion del usuario en la clase
     * @param usuario id del usuario
     * @param horario id del entrenador
     * @return 
     * @throws SQLException 
     */

     @GET
    
    @Path("/addReserva")
    
    @Produces("application/json")
    
    public String insertarReserva(@QueryParam("usuario") int usuario,
                                  @QueryParam("horario") int horario) throws SQLException
    {
        try
        {
            String query = "Select * from M05_AGREGAR_PARTICIPACION("+usuario+","+horario+")";
            
            Statement st = _conn.createStatement();
            ResultSet rs = st.executeQuery(query);  

             return "AGREGADO A LA CLASE"; 
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
 
    
    
    
    /***
     * Eliminacion de la participacion del usuario en la clase
     * @param usuario id
     * @param horario id
     * @return
     * @throws SQLException 
     */
     @GET
    
    @Path("/deleteReserva")
    
    @Produces("application/json")
    
    public String eliminarReserva(@QueryParam("usuario") int usuario,
                                  @QueryParam("horario") int horario) throws SQLException
    {
        try
        {
            String query = "Select * from M05_ELIMINAR_PARTICIPACION("+usuario+","+horario+")";
          
            Statement st = _conn.createStatement();
            ResultSet rs = st.executeQuery(query);  

             return "ELIMINADO LA PARTICIPACION"; 
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