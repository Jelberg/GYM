/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;


import Dominio.Comentario;
import Dominio.Ejercicio;
import Dominio.Equipo;
import Dominio.Maquina;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import Dominio.Rutina;
import Dominio.Sql;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import Excepciones.ParameterNullException;
import Validaciones.ValidationWS;


/**
 *
 * @author MinervaMorales
 */
@Path("/FOM03_Rutina")
public class FOM03_Rutina {
    
    private Connection conn = Sql.getConInstance();
   
    private Gson gson = new Gson();
    private ArrayList<Rutina> jsonArray;
    private String response;
    
    /**
     * Funcion que retorna una lista de rutinas dado el nombre del usuario.
     * @param idUsuario se recibe el id del usuario a consultar
     * @return Devuelve las rutinas de un usuario en formato JSON
     */
        @GET
        @Path("/getRutina")
        @Produces("application/json")
         public String getRutina( @QueryParam( "idUsuario" ) int idUsuario )
         {
            try{
                ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("idUsuario", idUsuario);
                 }});
                String query = "Select * from FO_M03_get_rutina('"+idUsuario+"')";
                this.jsonArray = new ArrayList<>();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                
                ArrayList<Rutina> listaRutinas = new ArrayList<Rutina>();
                
                while( rs.next() )
                {
                    Rutina result = new Rutina();
                    result.setId(rs.getInt("idRutina"));
                    result.setDia(rs.getString("dia"));
                    result.setNombre(rs.getString( "nombre" ));
                    result.setCantidadEjercicios(rs.getInt("numEjerc"));
                    listaRutinas.add( result );        
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
    /*
     * Funcion que agrega una nueva rutina.
     * @param idUsuario se recibe el id del usuario a consultar
     * @return retorna un string de confirmacion 
     */
        @GET
        @Path("/setRutina")
        @Produces("application/json")
         public String setRutina( @QueryParam( "idUsuario" ) int idUsuario, 
                                  @QueryParam ( "nombre" ) String nombre,
                                  @QueryParam ( "dia" ) String dia)
         {
         try{
                      
                String query = "Select * from FO_M03_set_rutina('"+idUsuario+"','"+nombre+"','"+dia+"')";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
              
                return gson.toJson("La rutina fue Agregada");
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
     * Funcion que modifica una rutina.
     * @param idUsuario se recibe el id del usuario a consultar
     * @param nombre se recibe el nombre de la rutina a eliminar 
     * @param dia se recibe el dia de la rutina a eliminar
     * @return retorna un string de confirmacion 
     */
        @GET
        @Path("/modificarRutina")
        @Produces("application/json")
         public String modificarRutina( @QueryParam( "idUsuario" ) int idUsuario, 
                                  @QueryParam ( "nombre" ) String nombre,
                                  @QueryParam ( "dia" ) String dia,
                                  @QueryParam ("nombreModif") String nombreModif,
                                  @QueryParam ("diaModif") String diaModif)
         {
         try{
                      
                String query = "Select * from FO_M03_modificar_rutina('"+idUsuario+"','"+nombre+"',"
                                                                    + "'"+dia+"', '"+nombreModif+"','"+diaModif+"')";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
              
                return gson.toJson("La rutina fue Modificada");
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
     * Funcion que modifica una rutina.
     * @param idUsuario se recibe el id del usuario a consultar
     * @param nombre se recibe el nombre de la rutina a eliminar 
     * @param dia se recibe el dia de la rutina a eliminar
     * @return retorna un string de confirmacion 
     */
        @GET
        @Path("/eliminarRutina")
        @Produces("application/json")
         public String eliminarRutina( @QueryParam( "idUsuario" ) int idUsuario, 
                                  @QueryParam ( "nombre" ) String nombre,
                                  @QueryParam ( "dia" ) String dia)
         {
         try{
                      
                String query = "Select * from FO_M03_eliminar_rutina('"+idUsuario+"','"+nombre+"',"
                                                                    + "'"+dia+"')";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
              
                return gson.toJson("La rutina fue Eliminada");
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
         
              
         
         
         
         /*****************************************FUNCIONES PARA EL MODULO 4*********************************/
        
         
         /**
          * Funcion que retorna una lista de ejercicios realizados dado el id de un usuario.
          * @param idUsuario, 
          * @return Devuelve strings en formato Json 
          */
        @GET
        @Path("/getEjerciciosRealizados")
        @Produces("application/json")
         public String getEjercicios( @QueryParam( "idUsuario" ) int idUsuario )
         {
            try{
                               
                String query = "Select * from FO_M03_get_ejerciciosRealizados('"+idUsuario+"')";
                this.jsonArray = new ArrayList<>();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                
                ArrayList<String> listaEjercicios = new ArrayList<String>();
                
                while( rs.next() )
                {
                    listaEjercicios.add( rs.getString("nombre") );                
                }
                return gson.toJson( listaEjercicios );
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
          * Funcion que retorna las repeticiones, series, y peso realizadas de un 
          * ejercicio los ultimos 6 meses.
          * @param idUsuario 
          * @param ejercicio
          * @return Devuelve strings de los ejercicios en formato Json 
          */         
        @GET
        @Path("/getEjercicios6meses")
        @Produces("application/json")
         public String getEjercicios6meses( @QueryParam( "idUsuario" ) int idUsuario,
                                            @QueryParam( "ejercicio" ) String ejercicio)
         {
             String response;
                try{

                    String query = "select * from FO_M03_get_Ejercicios6meses('"+idUsuario+"','"+ejercicio+"')";
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    ArrayList listaEjercicios = new ArrayList();
                    listaEjercicios= resultSetToArrayList(rs); //Metodo que transforma un resultset a un ArrayList
                    return gson.toJson( listaEjercicios );
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
          * Funcion que retorna las repeticiones, series, y peso realizadas de un 
          * ejercicio los ultimos 6 meses.
          * @param idUsuario 
          * @param ejercicio
          * @return Devuelve strings de los ejercicios en formato Json 
          */         
        @GET
        @Path("/getEjercicios5anios")
        @Produces("application/json")
         public String getEjercicios5anios( @QueryParam( "idUsuario" ) int idUsuario,
                                            @QueryParam( "ejercicio" ) String ejercicio)
         {
             String response;
                try{

                    String query = "select * from FO_M03_get_Ejercicios5anios('"+idUsuario+"','"+ejercicio+"')";
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    ArrayList listaEjercicios = new ArrayList();
                    listaEjercicios= resultSetToArrayList(rs); //Metodo que transforma un resultset a un ArrayList
                    return gson.toJson( listaEjercicios );
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
         
         /**Funcion que se encarga de convertir un ResulSet a un ArrayList 
          *@param rs 
          * @return Devuelve un ArrayList
          */
         public ArrayList resultSetToArrayList(ResultSet rs) throws SQLException
         {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            ArrayList results = new ArrayList();

            while (rs.next()) 
            {
                HashMap row = new HashMap();
                results.add(row);

                for(int i=1; i<=columns; i++)
                {
                  row.put(md.getColumnName(i),rs.getObject(i));
                }
            }
            return results;
        }

         
      
    }


