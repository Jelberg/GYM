/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.Critica;
import Dominio.Sql;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Elberg
 */
@Path("/FOM05_Critica")
public class FOM05_Critica {
    private Connection _conn = Sql.getConInstance();
    private Gson _gson = new Gson();
    private String result;
    private ArrayList<Critica> jsonArray;
    
    
    @GET  
    @Produces("application/json")
    public String holaCriticas ()
    {
        return "CRITICA FO-M05";
    }
    
    
    @GET
    
    @Path("/consultarCritica")
    
    @Produces("application/json")
    
    public String consultarCritica() throws SQLException
    {
        try
        {
            String query = "Select * from FOM05_LISTA_CRITICAS";
            jsonArray = new ArrayList<>();
            Statement st = _conn.createStatement();
            ResultSet rs = st.executeQuery(query);  
    
            while (rs.next())
            {    
                jsonArray.add(new Critica());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("id"));
                jsonArray.get(jsonArray.size() - 1).setFecha(rs.getDate("fecha"));
                jsonArray.get(jsonArray.size() - 1).setComentario(rs.getString("comentario"));
                jsonArray.get(jsonArray.size() - 1).setValoracion(rs.getInt("valoracion"));
                jsonArray.get(jsonArray.size() - 1).setReferenciaHc(rs.getInt("referencia"));
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
            return result; //no deberia estar aqui
        }
    } 

    
}
