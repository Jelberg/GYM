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
    private ArrayList<Critica> _listaCriticas;
    private String result;
    
    
    @GET  
    @Produces("application/json")
    public String holaCriticas ()
    {
        System.err.println("    este es en mensaje por consola  ");
        return "CRITICA FO-M05";
    }
    
    
    @GET
    
    @Path("/consultarCritica")
    
    @Produces("application/json")
    
    public String consultarCritica() throws SQLException
    {
        String query = "Select * from CRITICA";
        
        try
        {
            Statement st = _conn.createStatement();           
            ResultSet rs = st.executeQuery(query);
            Critica resultado = new Critica();
         
            while (rs.next())
            {    
               
                resultado.setId(rs.getInt("id"));
                resultado.setFecha(rs.getDate("fecha"));
                resultado.setComentario(rs.getString("comentario"));
                resultado.setValoracion(rs.getInt("valoracion"));
                resultado.setReferenciaHc(rs.getInt("referancia"));
                
                //  _listaCriticas.add(resultado);
            }
            //result = _gson.toJson(_listaCriticas);
            return _gson.toJson(resultado);
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
