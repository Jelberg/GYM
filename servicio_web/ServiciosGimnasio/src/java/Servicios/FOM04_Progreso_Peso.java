/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.Progreso_Peso;
import Dominio.Sql;
import Excepciones.ParameterNullException;
import Util.CompararProgreso;
import Validaciones.ValidationWS;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import javax.ws.rs.Path;

/**
 *
 * @author Gilbert
 */
@Path("/F0M04_Progreso_Peso")
public class FOM04_Progreso_Peso {
    private Connection conn = Sql.getConInstance();
    //Atributo que se utiliza para transformar a formado JSON las consultas.
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Progreso_Peso> jsonArray;
    /**
     * Funcion que recibe como parametro el id del usuario
     * para hacer la consulta del progreso de peso registrado.
     * @param id_usuario Indica el identificador del usuario
     * @return Devuelve un json con los ultimos registros de peso del usuario.
     */
    @GET
    @Path( "/getProgresoP" )
    @Produces( "application/json" )
    public String getProgresoP( @QueryParam( "id_usuario" ) int id_usuario ){
        try{
            ValidationWS.validarParametrosNotNull( new HashMap<String, Object>(){ {
                put( "id_usuario" , id_usuario );
            }});
            String query = "SELECT * FROM fo_m04_get_progresop(?)";
            jsonArray = new ArrayList<>();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt( 1 , id_usuario );
            ResultSet rs = st.executeQuery();
            //La variable donde se almacena el resultado de la consulta.
            while( rs.next() ){
                jsonArray.add( new Progreso_Peso() );
                jsonArray.get( jsonArray.size() - 1 ).setPeso( rs.getInt( "peso" ) );
                jsonArray.get( jsonArray.size() - 1 ).setFechaP(rs.getDate( "fecha" ) );
                jsonArray.get( jsonArray.size() - 1 ).setId( rs.getInt( "id" ) );
            }
            ArrayList<Progreso_Peso> aux;
            aux = CompararProgreso.compararProgresoPeso( jsonArray );
            response = gson.toJson( aux );
        }
        catch ( SQLException e ) {
            response = e.getMessage();
        }
        catch ( ParameterNullException e ) {
            response = e.getMessage();
        }
        finally {
            Sql.bdClose( conn );
            return response;
        }
    }
    /**
     * Metodo que recibe como parametros la fecha del mes 
     * correspondiente al peso a eliminar y el id correspondiente
     * al usuario
     * @param fecha Indica la fecha correspondiente al peso.
     * @param id_usuario Identificador del usuario.
     * @return Devuelve un json con elemento llamado data, 
     * contiene el mensaje de la peticion
     */
    @DELETE
    @Path( "/eliminarPeso" )
    @Produces( "application/json" )
    public String eliminaPeso(@QueryParam( "id_usuario" ) int id_usuario) {
        Map<String, String> response = new HashMap<String, String>();
        try{
            ValidationWS.validarParametrosNotNull( new HashMap<String, Object>(){ {
                put( "id_usuario" , id_usuario );
            }});
            String query = "SELECT fo_m04_elimina_progresop(?)";
            PreparedStatement st = conn.prepareStatement( query );
            st.setInt( 1 , id_usuario);
            ResultSet rs = st.executeQuery();
            response.put( "data" , "Se elimino el peso correctamente" );
        }
        catch ( SQLException e ) {
            response.put( "error" , e.getMessage() );
        }
        catch ( ParameterNullException e ) {
            response.put( "error" , e.getMessage() );
        }
        finally {
            Sql.bdClose( conn );
            return gson.toJson( response );
        }
    }
    /**
     * Funcion que se llama cuando el usuario desea agregar un nuevo registro
     * de su peso. Recibe el id del usuario y el peso a registrar
     * @param id_usuario identificador del usuario.
     * @param peso peso a registrar por el usuario
     * @return Mensaje sobre estatus de la peticion.
     */
    @POST
    @Path( "/insertaProgresoPeso" )
    @Produces( "application/json" )
    public String insertaPeso( @QueryParam ( "id_usuario" ) int id_usuario,
                               @QueryParam ( "peso" ) int peso ){
        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put ( "id_usuario" , id_usuario );
                put( "peso" , peso );
            }});
            boolean verificacion = comprobarInsercion( id_usuario );
            if ( verificacion == true ){
                
                response.put( "data", "Error. Ya ha agregado un peso esta semana." );
            }
            else{
                conn = Sql.getConInstance();
                String query = "select * from fo_m04_insert_progresop(?,?);";
                PreparedStatement st = conn.prepareStatement( query );
                st.setInt( 1 , id_usuario );
                st.setInt( 2 , peso );
                st.executeQuery();
                response.put( "data", "Se agrego correctamente el peso." );
                
            }
        }
        catch (SQLException e){
            response.put( "error", e.getMessage() );
        }
        catch ( ParameterNullException e ) {
            response.put( "error" , e.getMessage() );
        }
        finally {
            Sql.bdClose( conn );
            return gson.toJson( response );
        }
    }
    /**
     * Funcion que es llamada cuando el usuario desea actualizar un registro
     * de su peso.
     * @param id_usuario Identificador del usuario.
     * @param fecha Fecha en la que se inserto el registro.
     * @param peso Nuevo peso a actualizar.
     * @return Devuelve un mensaje con el estatus de la peticion.
     */
    @POST
    @Path( "/actualizaProgresoPeso" )
    @Produces( "application/json" )
    public String actualizarPeso ( @QueryParam ( "id_usuario" ) int id_usuario,
                                   @QueryParam ( "peso" ) int peso){
        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put ( "id_usuario" , id_usuario );
                put( "peso" , peso );
            }});
            String query = "select * from fo_m04_act_progresop(?,?);";
            PreparedStatement st = conn.prepareStatement( query );
            st.setInt( 1 , id_usuario );
            st.setInt( 2 , peso );
            st.executeQuery();
            response.put( "data", "Se actualizo correctamente." );
        }
        catch (SQLException e){
            response.put( "error", e.getMessage() );
        }
        catch ( ParameterNullException e ) {
            response.put( "error" , e.getMessage() );
        }
        finally {
            Sql.bdClose( conn );
            return gson.toJson( response );
        }
    }
    /**
     * Funcion que se llama para comprobar que el usuario no tenga ningun
     * registro de pesos en el dia actual, retorna verdadero si el usuario
     * ya posee un registro, falso de lo contrario.
     * @param idUsuario identificador del usuario
     * @return 
     */
    public boolean comprobarInsercion( int idUsuario){
        ArrayList<Progreso_Peso> progresoPeso = new ArrayList<Progreso_Peso>();
        Gson gson = new Gson();
        String respuesta = getProgresoP( idUsuario );
        progresoPeso = gson.fromJson( respuesta, new TypeToken<List<Progreso_Peso>>(){}.getType());
        SimpleDateFormat sdft = new SimpleDateFormat( "yyyy-MM-dd" );
        java.util.Date fecha = new java.util.Date();
        String fechaActual = sdft.format( fecha );
        int tamanoArreglo = progresoPeso.size();
        java.util.Date ultimoProgreso = progresoPeso.get( tamanoArreglo - 1).getFechaP();
        if ( fechaActual.equals( String.valueOf( ultimoProgreso ) ) ){
            return true;
        }
        else{
            return false;
        }
    }
            
}
