/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.Clase;
import Dominio.ClasesParticipadas;
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
import javax.ws.rs.QueryParam;

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
    private ArrayList<ClasesParticipadas> _cpArray;
    private ArrayList<Clase> jsonA;
    
    
    @GET  
    @Produces("application/json")
    public String holaCriticas ()
    {
        return "CRITICA FO-M05";
    }
    
    /**
     * 
     * @return Consulta que devuelve todas las criticas hechas por el usuario
     * @throws SQLException 
     */
    
    @GET
    
    @Path("/consultarCriticas")
    
    @Produces("application/json")
    
    public String consultarCritica(@QueryParam("referencia") int referencia) throws SQLException
    {
        try
        {
            String query = "Select * from FOM05_LISTA_CRITICAS_USUARIO("+referencia+")";
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
                jsonArray.get(jsonArray.size() - 1).setReferenciaHc(referencia);
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
     * @param referencia  ID de la tabla horarario de clase
     * @param idu  id del usuario
     * @param comentario   comentario de la critica
     * @param valoracion  valoracion del 0 al 10
     * @return AGREGADO si la critica fue agregada
     * @throws SQLException 
     */
    
    @GET
    
    @Path("/insertarCritica")
    
    @Produces("application/json")
    
    public String insertarCritica(@QueryParam("referencia") int referencia,
                                 @QueryParam("idu") int idu,
                                  @QueryParam("comentario") String comentario,
                                  @QueryParam("valoracion") int valoracion) throws SQLException
    {
        try
        {
            String query = "Select * from m05_agregar_critica('"+comentario+"', "+valoracion+","+referencia+","+idu+")";
            
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
    
    /**
     * Metodo para eliminar critica
     * @param id de la critica
     * @return ELIMINADO si se elimino la critica
     * @throws SQLException 
     */
    
    @GET
    
    @Path("/eliminarCritica")
    
    @Produces("application/json")
    
    public String eliminarCritica(@QueryParam("id") int id) throws SQLException
    {
        try
        {
            String query = "Select * from m05_eliminar_critica("+id+")";
          
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
    
    /**
     * 
     * @param id Del usuario
     * @return lista de clases que se han participado en los ultimos 30 dias y no se han agregado comentarios
     * @throws SQLException 
     */
    
    @GET
    
    @Path("/sinCritica")
    
    @Produces("application/json")
    
    public String clasesSinCriticas(@QueryParam("id") int id) throws SQLException
    {
        try
        {
            String query = "select * from M05_LISTA_CLASES_PARTICIPADAS("+id+")";
            _cpArray = new ArrayList<>();
            Statement st = _conn.createStatement();
            ResultSet rs = st.executeQuery(query);  
    
            while (rs.next())
            {    
                _cpArray.add(new ClasesParticipadas());
                
                _cpArray.get(_cpArray.size() - 1).setFecha(rs.getDate("fecha"));
                _cpArray.get(_cpArray.size() - 1).setNombreClase(rs.getString("clase"));
                _cpArray.get(_cpArray.size() - 1).setNombreIns(rs.getString("instructor_nombre"));
                _cpArray.get(_cpArray.size() - 1).setNombreIns(rs.getString("instructor_apellido"));
                _cpArray.get(_cpArray.size() - 1).setIdHc(rs.getInt("id_hc"));
                
            }
             result = _gson.toJson(_cpArray);
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
    
    
}
