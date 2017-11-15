/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.Ejercicio;
import Dominio.Rutina;
import Dominio.Sql;
import Dominio.Trabajo_Rutina;
import Excepciones.ParameterNullException;
import Validaciones.ValidationWS;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
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
 * @author MinervaMorales
 */
@Path("FOM03_TrabajoRutina")
public class FOM03_TrabajoRutina {
        
    private Connection conn = Sql.getConInstance();
   
    private Gson gson = new Gson();
    private ArrayList<Ejercicio> jsonArray;
    private String response;
    
    /**
     * Funcion que retorna una lista de ejercicios dado el nombre de la rutina
     * el dia y el id del usuario.
     * @param idUsuario se recibe el id del usuario a consultar
     * @param nombre se recibe el nombre de la rutina
     * @param dia se recibe el nombre de la rutina
     * @return Devuelve los ejercicios de una rutina de un usuario en formato JSON
     */
        @GET
        @Path("/getEjerciciosRutina")
        @Produces("application/json")
         public String getEjericiosRutina( @QueryParam( "idUsuario" ) int idUsuario, 
                                           @QueryParam ( "nombre" ) String nombre,
                                           @QueryParam ( "dia" ) String dia)
         {
            try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("idUsuario", idUsuario);
                put("nombre", nombre);
                put("dia", dia);
            }});

            String query = "SELECT * FROM FO_M03_ejercicios_rutina(?, ?, ?)";
            jsonArray = new ArrayList<>();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, idUsuario);
            st.setString(2, nombre);
            st.setString(3, dia);
            ResultSet rs = st.executeQuery();
            
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                jsonArray.add(new Ejercicio());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("idEjercicio"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("nombre"));
                jsonArray.get(jsonArray.size() - 1).setGrupomuscular(rs.getString("grupoMuscular"));
                jsonArray.get(jsonArray.size() - 1).setMaquina(rs.getString("maquina"));
                jsonArray.get(jsonArray.size() - 1).setEquipo(rs.getString("equipo"));
                          
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
