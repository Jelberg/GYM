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
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;
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
    public String eliminaPeso(@QueryParam( "fecha" ) String fecha,
                              @QueryParam( "id_usuario" ) int id_usuario) {
        Map<String, String> response = new HashMap<String, String>();
        try{
            ValidationWS.validarParametrosNotNull( new HashMap<String, Object>(){ {
                put( "id_usuario" , id_usuario );
                put( "fecha" , fecha );
            }});
            String query = "SELECT fo_m04_elimina_progresop(?, ?)";
            PreparedStatement st = conn.prepareStatement( query );
            st.setInt( 1 , id_usuario);
            st.setDate( 2 , Date.valueOf( fecha ) );
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
     * Funcion obtiene el peso de un usuario correspondiente a cada 
     * semana del mes.
     * @param sobrenombre Indica el nombre del usuario.
     * @return Devuelve un json con la informacion del peso
     * relacionada con el mes correspondiente
     */
    /*
    @GET
    @Path("/getPesoDelMes")
    @Produces("application/json")
    public String getPesoDelMes(@QueryParam("sobrenombre") String sobrenombre){
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("sobrenombre", sobrenombre);
            }});

            String query = "select * from fo_m04_get_peso_mes(?, ?, ?)";
            jsonArray = new ArrayList<>();
            ResultSet rs;
            LocalDate fecha = LocalDate.now();
            Date day;
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, sobrenombre);

            for (int i=0; i<=3; i++){
                day = Date.valueOf(fecha);
                st.setDate(2,day);
                st.setDate(3,day);
                rs = st.executeQuery();
                jsonArray.add(new Progreso_Peso());
                jsonArray.get(jsonArray.size() - 1).setFechaP(fecha);
                if (rs.wasNull()){
                    jsonArray.get(jsonArray.size() - 1).setPeso(0);
                }
                while (rs.next()){
                    jsonArray.get(jsonArray.size() - 1).setPeso(rs.getInt("peso"));
                }

                if (i < 6) {
                    fecha = fecha.minusWeeks(1);
                }
            }
            response = gson.toJson(jsonArray);
        }
        catch (SQLException e) {
            response = e.getMessage();
        }
        catch (ParameterNullException e){
            response = e.getMessage();
        }
        finally {
            Sql.bdClose(conn);
            return response;
        }
    }
*/
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
            String query = "select * from fo_m04_insert_progresop(?,?);";
            PreparedStatement st = conn.prepareStatement( query );
            st.setInt( 1 , id_usuario );
            st.setInt( 2 , peso );
            st.executeQuery();
            response.put( "data", "Se inserto correctamente." );
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
    @Path( "actualizaProgresoPeso" )
    @Produces( "application/json" )
    public String actualizarPeso ( @QueryParam ( "id_usuario" ) int id_usuario,
                                   @QueryParam ( "fecha" ) String fecha,
                                   @QueryParam ( "peso" ) int peso){
        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put ( "id_usuario" , id_usuario );
                put( "fecha" , fecha );
                put( "peso" , peso );
            }});
            String query = "select * from fo_m04_act_progresop(?,?,?);";
            PreparedStatement st = conn.prepareStatement( query );
            st.setInt( 1 , id_usuario );
            st.setDate( 2 , Date.valueOf( fecha ) );
            st.setInt( 3 , peso );
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
}
