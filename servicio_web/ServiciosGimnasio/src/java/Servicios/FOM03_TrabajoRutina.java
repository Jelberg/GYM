/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.Ejercicio;
import Dominio.Rutina;
import Dominio.Serie;
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
import javax.ws.rs.POST;

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
         public String getEjerciciosRutina( @QueryParam( "idUsuario" ) int idUsuario, 
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
                jsonArray.get(jsonArray.size() - 1).setMaquina(rs.getString("maqui"));
                jsonArray.get(jsonArray.size() - 1).setEquipo(rs.getString("equip"));
                          
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
         
         /***
          * Funcion que retorna las series de un ejercicio de la rutina
          * @param idUsuario recibe el id de usuario 
          * @param nombre recibe el nombre de la rutina
          * @param dia recibe el dia de trabajo de la rutina
          * @param ejercicio recibe el nombre del ejercicio a consultar
          * @return retorna la lista de series de un ejercicio en formato JSON
          */
        @GET
        @Path("/getSeriesEjercicio")
        @Produces("application/json")
         public String getSeriesEjercicios( @QueryParam( "idUsuario" ) int idUsuario, 
                                           @QueryParam ( "nombre" ) String nombre,
                                           @QueryParam ( "dia" ) String dia,
                                           @QueryParam ( "ejercicio" ) String ejercicio)
         {
            try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("idUsuario", idUsuario);
                put("nombre", nombre);
                put("dia", dia);
                put("ejercicio", ejercicio);
            }});

            String query = "SELECT * FROM FO_M03_series_ejercicio(?,?,?,?)";
            ArrayList<Serie> jsonArray = new ArrayList<Serie>();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, idUsuario);
            st.setString(2, nombre);
            st.setString(3, dia);
            st.setString(4, ejercicio);
            ResultSet rs = st.executeQuery();
            
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                jsonArray.add(new Serie());
                jsonArray.get(jsonArray.size() - 1).setNumRepeticiones(rs.getInt("numRep"));
                jsonArray.get(jsonArray.size() - 1).setPeso(rs.getFloat("peso"));
                jsonArray.get(jsonArray.size() - 1).setUnidad(rs.getString("unidad"));
                jsonArray.get(jsonArray.size() - 1).setTiempoDescanso(rs.getInt("tiempoDescan"));
                          
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
         *Funcion que retorna la lista de ejercicios asignados por maquina 
         * retorna un arreglo de ejercicios sin incluir los que ya estan asignados
         * en la rutina
         * @param idUsuario recibe el usuario de la rutina
         * @param nombre recibe el nombre de la rutina
         * @param dia recibe el dia de la rutina
         * @throws SQLException
         */   
        @GET
        @Path("/getEjerciciosMaquina")
        @Produces("application/json")
         public String getEjerciciosMaquina(@QueryParam( "idUsuario" ) int idUsuario, 
                                           @QueryParam ( "nombre" ) String nombre,
                                           @QueryParam ( "dia" ) String dia) throws SQLException
         {
           try
           {
                String query = "SELECT * FROM FO_M03_get_ejercicios_maquina(?,?,?)";
                jsonArray = new ArrayList<Ejercicio>();
                PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, idUsuario);
                st.setString(2, nombre);
                st.setString(3, dia);
                ResultSet rs = st.executeQuery();


                //La variable donde se almacena el resultado de la consulta.
                while(rs.next())
                {
                    jsonArray.add(new Ejercicio());
                    jsonArray.get(jsonArray.size() - 1).setMaquina(rs.getString("maquina"));
                    jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("ejercicio"));
                    jsonArray.get(jsonArray.size() - 1).setGrupomuscular(rs.getString("grupoMuscular"));           
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
    
         /**Funcion que retorna una lista de los ejercicios asignados por maquina 
          * sin incluir los que ya han sido asignados a la rutina
          * @param idUsuario
          * @param nombre
          * @param dia
          */
        @GET
        @Path("/getEjerciciosEquipo")
        @Produces("application/json")
         public String getEjerciciosEquipo(@QueryParam( "idUsuario" ) int idUsuario, 
                                           @QueryParam ( "nombre" ) String nombre,
                                           @QueryParam ( "dia" ) String dia) 
         {
           try
           {
                String query = "SELECT * FROM FO_M03_get_ejercicios_equipo(?,?,?)";
                jsonArray = new ArrayList<Ejercicio>();
                PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, idUsuario);
                st.setString(2, nombre);
                st.setString(3, dia);
                ResultSet rs = st.executeQuery();

                while(rs.next())
                {
                    jsonArray.add(new Ejercicio());
                    jsonArray.get(jsonArray.size() - 1).setMaquina(rs.getString("equipo"));
                    jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("ejercicio"));
                    jsonArray.get(jsonArray.size() - 1).setGrupomuscular(rs.getString("grupoMuscular"));           
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
         
        @POST 
        @Path("/setEjercicioRutina")
        @Produces("application/json")
         public String setEjerciciosRutina( @QueryParam( "idUsuario" ) int idUsuario, 
                                           @QueryParam ( "nombre" ) String nombre,
                                           @QueryParam ( "dia" ) String dia,
                                           @QueryParam ( "ejercicio" ) String ejercicio,
                                           @QueryParam ( "maquina" ) String maquina,
                                           @QueryParam ( "equipo" ) String equipo)
         {
            try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("idUsuario", idUsuario);
                put("nombre", nombre);
                put("dia", dia);
                put("ejercicio", ejercicio);
                put("maquina", maquina);
                put("equipo", equipo);
            }});

            String query = "SELECT * FROM FO_M03_set_ejercicio_rutina(?,?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, idUsuario);
            st.setString(2, nombre);
            st.setString(3, dia);
            st.setString(4, ejercicio);
            st.setString(5, maquina);
            st.setString(6, equipo);
            
            ResultSet rs = st.executeQuery();
             return gson.toJson("El ejercicio fue asignado a la rutina");
            }
            catch( SQLException e )
            {
                return e.getMessage();
            }
            catch ( ParameterNullException e ) 
            {
                return e.getMessage();
            }
            finally 
            {
                Sql.bdClose(conn);
            }
        }
         
        @GET
        @Path("/eliminarEjercicio")
        @Produces("application/json")
         public String eliminarEjercicio( @QueryParam( "idUsuario" ) int idUsuario, 
                                            @QueryParam ( "nombre" ) String nombre,
                                            @QueryParam ( "dia" ) String dia,
                                            @QueryParam ( "ejercicio" ) String ejercicio,
                                            @QueryParam ( "maquina" ) String maquina,
                                            @QueryParam ( "equipo" ) String equipo )

         {
         try{
                      
                String query = "Select * from FO_M03_eliminar_ejercicio(?,?,?,?,?,?)";
               PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, idUsuario);
                st.setString(2, nombre);
                st.setString(3, dia);
                st.setString(4, ejercicio);
                st.setString(5, maquina);
                st.setString(6, equipo);
                
                ResultSet rs = st.executeQuery();
                return gson.toJson("El ejercicio fue Eliminado");
            }
            catch( SQLException e )
            {
                return e.getMessage();
            }
            catch ( ParameterNullException e ) 
            {
                return e.getMessage();
            }
            finally 
            {
                Sql.bdClose(conn);
            }
        } 
         
         
}
