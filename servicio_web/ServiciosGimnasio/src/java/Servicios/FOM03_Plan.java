/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import static javax.ws.rs.HttpMethod.POST;
import Dominio.Aerobico;
import Dominio.Anaerobico;
import Dominio.Comentario;
import Dominio.Ejercicio;
import Dominio.Plan;
import Dominio.Rutina;
import Dominio.Usuario;
import Dominio.Sql;
import Dominio.Trabajo_Rutina;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import Validaciones.ValidationWS;
import Excepciones.ParameterNullException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.DataOutput;
import java.util.Map;

/**
 *
 * @author JavierCabrera
 */

@Path("/FOM03_Plan")
public class FOM03_Plan {
    private Connection conn = Sql.getConInstance();
   
    private Gson gson = new Gson();
    private ArrayList<Plan> jsonArray;
    private String response;
    
    /**
     * Funcion que retorna una lista de planes dado el nombre del usuario.
     * @param idUsuario se recibe el id del usuario a consultar
     * @return Devuelve las rutinas de un usuario en formato JSON
     */
    
        @GET
        @Path("/getPlan")
        @Produces("application/json")
         public String getPlan( @QueryParam( "idUsuario" ) int idUsuario )
         {
            try{
                      
                String query = "Select * from FO_M03_get_plan('"+idUsuario+"')";
                this.jsonArray = new ArrayList<>();
                System.out.println (query);
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                
                ArrayList<Plan> listaPlanes = new ArrayList<Plan>();
                
                while( rs.next() )
                {
                    ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                        put("idUsuario", idUsuario);
                    }});
                    Plan result = new Plan();
                    result.setId(rs.getInt("idPlan"));
                    result.setNombre(rs.getString("nombre"));
                    result.setDescripcion(rs.getString("descrip"));
                    listaPlanes.add(result);
                }
                return gson.toJson( listaPlanes );
            }
            catch( SQLException e )
            {
                return e.getMessage();
            }
            catch ( ParameterNullException e ) 
            {
                return e.getMessage();
            }
            catch ( NullPointerException e)
            {
            
                return e.getMessage();
            }
            finally 
            {
                Sql.bdClose(conn);
            }
        }
        
         
        /**
          * Funcion que retorna una lista de rutinas de un plan dado el id de un usuario.
          * @param idUsuario, 
          * @return Devuelve strings en formato Json 
        */
         
        @GET
        @Path("/getRutinaPlan")
        @Produces("application/json")
        public String getRutinaPlan( @QueryParam( "idUsuario" ) int idUsuario )
         {
            try{
                      
                String query = "Select * from FO_M03_get_rutinaplan('"+idUsuario+"')";
                this.jsonArray = new ArrayList<>();
                System.out.println (query);
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                
                ArrayList<String> listaRutinas = new ArrayList<String>();
                
                while( rs.next() )
                {
                    /*Rutina result = new Rutina();
                    result.setDia(rs.getString("dia"));
                    result.setNombre(rs.getString( "nombreR" ));
                    listaRutinas.add( result ); */
                    listaRutinas.add(rs.getString("nombreR"));
                    listaRutinas.add(rs.getString("dia"));
                }
                return gson.toJson( listaRutinas );
            }
            catch( SQLException e )
            {
                return e.getMessage();
            }
            catch ( ParameterNullException e ) 
            {
                return e.getMessage();
            }
            catch ( NullPointerException e)
            {
            
                return e.getMessage();
            }
            finally 
            {
                Sql.bdClose(conn);
            }
        }
        
        
        /** Funcion que inserta un nuevo plan a un usuario
         * @param idUsuario se ingresa el id del usuario
         * @param nombre se indica el nombre del plan
         * @param descripcion se especifica la descripcion del plan
         * @return Retorna un string de confirmacion de plan agregado
         */
        @GET
        @Path("/setPlan")
        @Produces("application/json")
         public String setPlan( @QueryParam( "idUsuario" ) int idUsuario, 
                                  @QueryParam ( "nombre" ) String nombre,
                                  @QueryParam ( "descrip" ) String descrip)
         {
         try{
                      
                String query = "Select * from FO_M03_set_plan('"+idUsuario+"','"+nombre+"','"+descrip+"')";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
              
                return gson.toJson("El Plan fue agregado");
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
        
 
        /**
     * Funcion que modifica un plan.
     * @param idUsuario se recibe el id del usuario a consultar
     * @param nombre se recibe el nombre del plan a eliminar 
     * @param descrip se recibe la descripcion del plan a eliminar
     * @param nombreModif se recibe el nuevo nombre del plan
     * @param descripModif se ingresa la nueva descripcion del plan
     * @param idPlan se ingresa el id del plan a modificar
     * @return retorna un string de confirmacion de modificacion
     */
        @GET
        @Path("/modificarPlan")
        @Produces("application/json")
         public String modificarPlan( @QueryParam( "idUsuario" ) int idUsuario, 
                                  @QueryParam ( "nombre" ) String nombre,
                                  @QueryParam ( "descrip" ) String descrip,
                                  @QueryParam ("nombreModif") String nombreModif,
                                  @QueryParam ("descripModif") String descripModif,
                                  @QueryParam ("idPlan") String idPlan)
         {
         try{
                      
                String query = "Select * from FO_M03_modificar_plan('"+idUsuario+"','"+nombre+"',"
                                                                    + "'"+descrip+"', '"+nombreModif+"','"+descripModif+"',"
                                                                    + "'"+idPlan+"')";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
              
                return gson.toJson("El Plan fue modificado");
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
        
         
         
         
        
        /**
         * Funcion que recibe los parametros de usuario id y nombre del plan,
         * para eliminar un plan correspondiente a un usuario.
         * @param idUsuario indica el id del usuario
         * @param nombre indica el nombre del plan a eliminar
         * @return Devuelve strings en formato Json
         */
        
        @GET
        @Path("/eliminaPlan")
        @Produces("application/json")
        public String eliminaPlan (@QueryParam("idUsuario") int idUsuario,
                                   @QueryParam("nombre") String nombre){
                try{
                    String query = "Select * from FO_M03_eliminaplan('"+idUsuario+"','"+nombre+"')";
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    return gson.toJson("El plan fue Eliminado");
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
