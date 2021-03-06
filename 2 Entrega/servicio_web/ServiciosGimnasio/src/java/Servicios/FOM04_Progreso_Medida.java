/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.*;
import Dominio.Progreso_Medida;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import Validaciones.ValidationWS;
import Excepciones.ParameterNullException;
import com.google.gson.reflect.TypeToken;
import java.lang.ProcessBuilder.Redirect.Type;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Map;
import javax.ws.rs.DELETE;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;


/**
 *
 * @author marvian
 */
@Path("/F0M04_Progreso_Medida")
public class FOM04_Progreso_Medida {
    
    private Connection conn = Sql.getConInstance();
    //Atributo que se utiliza para transformar a formado JSON las consultas.
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Progreso_Medida> jsonArray;
    
    /**
     * Funcion que recibe como parametros la fecha y el id del usuario
     * para hacer la consulta de las medidas registradas por el usuario durante
     * esa fecha.
     * 
     * Debe ser en formato yyyy-mm-dd
     * @param id_usuario Identificador del usuario
     * @return Devuelve las medidas en formato json
     */
    @GET
    @Path("/getProgresoM")
    @Produces("application/json")
    public String getProgresoM (@QueryParam("id_usuario") Integer id_usuario){
    
        try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("id_usuario", id_usuario);
               
            }});

            String query = "SELECT * FROM fo_m04_get_progresom(?)";
            jsonArray = new ArrayList<>();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id_usuario);
            ResultSet rs = st.executeQuery();
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                jsonArray.add(new Progreso_Medida());
                jsonArray.get(jsonArray.size() - 1).setMedida(rs.getInt("medida"));
                jsonArray.get(jsonArray.size() - 1).setTipo(rs.getString("tipo"));
                jsonArray.get(jsonArray.size() - 1).setFechaM(rs.getString("fecha"));
            
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
     * Metodo que recibe como parametros la fecha del mes 
     * correspondiente a la fecha a eliminar y el id del usuario 
     * para eliminar las medidas de ese mes.
     * 
     * @param id_usuario Identificador del usuario.
     * @return Devuelve un json con elemento llamado data, 
     * contiene el mensaje de la peticion
     */
    @DELETE
    @Path("/eliminarMedidas")
    @Produces("application/json")
    public String eliminaMedidas(@QueryParam("id_usuario") int id_usuario,
                                @QueryParam("tipo_medida") String tipo_medida) {

        Map<String, String> response = new HashMap<String, String>();
        try{

            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("id_usuario", id_usuario);
                put("tipo_medida", tipo_medida);
            }});
                String query = "SELECT fo_m04_elimina_medidas(?, ?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id_usuario);
            st.setString(2, tipo_medida);
            ResultSet rs = st.executeQuery();
            response.put("data", "Se elimino las medidas");

        }
        catch(SQLException e) {
            response.put("error", e.getMessage());
        }
        catch (ParameterNullException e) {
            response.put("error", e.getMessage());
        }
        finally {
            Sql.bdClose(conn);
            return gson.toJson(response);

        }
        
        
    }
    
    /**
     * Funcion obtiene las medidas por un usuario en los ultimos 12 meses.
     * @param sobrenombre Indica el nombre del usuario.
     * @return Devuelve un json con la informacion de las medidas
     * relacionada con el mes correspondiente
     */
    @GET
    @Path("/getMedidasDelAno")
    @Produces("application/json")
    public String getMedidasDelAno(@QueryParam("sobrenombre") String sobrenombre){
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {

            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("sobrenombre", sobrenombre);
            }});

            String query = "select * from m04_get_medidas_ano(?, ?, ?)";
            ResultSet rs;
            jsonArray = new ArrayList<>();
            LocalDate fecha = LocalDate.now();
            fecha = fecha.with(TemporalAdjusters.firstDayOfMonth());
            Date fechaInicio = Date.valueOf(fecha);
            Date fechafin = Date.valueOf(fecha.with(TemporalAdjusters.lastDayOfMonth()));
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, sobrenombre);
            st.setDate(2, fechaInicio);
            st.setDate(3, fechafin);
            for (int i = 0; i <= 11; i++) {
                if (i > 0) {
                    fecha = fecha.minusMonths(1);
                    fechaInicio = Date.valueOf(fecha);
                    fechafin = Date.valueOf(fecha.with(TemporalAdjusters.lastDayOfMonth()));
                    st.setString(2, sdf.format(fechaInicio));
                    st.setString(3, sdf.format(fechafin));
                }

                rs = st.executeQuery();
                jsonArray.add(new Progreso_Medida());
                if (rs.wasNull()) {
                    jsonArray.get(jsonArray.size() - 1).setMedida(0);
                    jsonArray.get(jsonArray.size() - 1).setFechaM(sdf.format(fechaInicio));
                }
                else {

                    while (rs.next()) {
                        jsonArray.get(jsonArray.size() - 1).setMedida(rs.getInt("medida"));
                        jsonArray.get(jsonArray.size() - 1).setFechaM(sdf.format(fechaInicio));
                    }
                }
            }
            response = gson.toJson(jsonArray);
        }
        catch (SQLException e) {
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
     * Funcion que es llamada cuando el usuario desea insertar un nuevo registro
     * de medidas.
     * @param id_usuario Identificador del usuario.
     * @param medida Canditdad de la medida a insertar.
     * @param tipo_medida Tipo de la medida que se va a registrar.
     * 
     * @return Devuelve un json con mensaje del estatus de la peticion.
     */
    @POST
        @Path("/insertaMedidas") //Revisar logica para hacer el bucle en el servicio
    @Produces("application/json")
    public String insertaMedidas(@QueryParam("id_usuario") int id_usuario,
                                 @QueryParam("medida") int medida,
                                 @QueryParam("tipo_medida") int tipo_medida){

        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("id_usuario", id_usuario );
                put("medida", medida );
                put("tipo_medida", tipo_medida );
            }});
            boolean verificacion = comprobarInsercion( id_usuario );
            if ( verificacion == true ){
                response.put( "data", "Error. Ya ha agregado sus medidas del mes." );
            }
            else{
                conn = Sql.getConInstance();
                String query = "select * from fo_m04_inserta_medidas(?, ?, ?)";
                PreparedStatement st = conn.prepareStatement(query);
                //java.lang.reflect.Type type = new TypeToken<Progreso_Medida[]>(){}.getType();
                st.setInt(1, id_usuario);
                st.setInt(2, medida);
                st.setInt(3, tipo_medida);
                
                st.executeQuery();
            

                response.put("data", "Se insertaron las medidas");
            }
                
        }
        catch (SQLException e){
            response.put("error", e.getMessage());
        }
        catch (ParameterNullException e) {
            response.put("error", e.getMessage());
        }
        finally {
            Sql.bdClose(conn);
            return gson.toJson(response);
        }

    }
    
    
    
    
    /**
     * Funcion que es llamada cuando el usuario desea actualizar algun registro
     * de medidas.
     * @param id_usuario identificador del usuario.
     * 
     * @param tipo_medida Tipo de medida a actualizar.
     * @param medida Cantidad de la medida a actualizar.
     * @return Devuelve un json con un mensaje al usuario sobre el estatus
     * de la peticion.
     */
    @POST
    @Path("/actualizaMedida")
    @Produces("application/json")
    public String actualizaMedida( @QueryParam ( "id_usuario" ) int id_usuario,
                                   @QueryParam ( "tipo_medida" ) String tipo_medida,
                                   @QueryParam ( "medida" ) int medida){
        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put ( "id_usuario" , id_usuario );
                put( "tipo_medida" , tipo_medida );
                put( "medida" , medida );
            }});
            String query = "select * from fo_m04_act_medida(?,?,?);";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, id_usuario);
            st.setString(2, tipo_medida);
            st.setInt(3, medida);
            st.executeQuery();
            response.put("data", "Se actualizo correctamente.");
        }
        catch (SQLException e){
            response.put("error", e.getMessage());
        }
        catch (ParameterNullException e) {
            response.put("error", e.getMessage());
        }
        finally {
            Sql.bdClose(conn);
            return gson.toJson(response);
        }
        
    }
    /**
     * Funcion que se llama para comprobar que el usuario no tenga ningun
     * registro de medidas en el mes actual, retorna verdadero si el usuario
     * ya posee un registro, falso de lo contrario.
     * @param idUsuario identificador del usuario
     * @return 
     */
    public boolean comprobarInsercion( int idUsuario){
        ArrayList<Progreso_Medida> progresoMedida = new ArrayList<Progreso_Medida>();
        Gson gson = new Gson();
        String respuesta = getProgresoM( idUsuario );
        progresoMedida = gson.fromJson( respuesta, new TypeToken<List<Progreso_Medida>>(){}.getType());
        SimpleDateFormat sdft = new SimpleDateFormat( "yyyy-MM-dd" );
        java.util.Date fecha = new java.util.Date();
        String fechaActual = sdft.format( fecha );
        String mesActual =  fechaActual.substring( 5, 7 ) ;
        int tamanoArreglo = progresoMedida.size();
        String ultimoProgreso = progresoMedida.get( 0 ).getFechaM();
        String mes =  ultimoProgreso.substring( 5, 7 );
        if ( mesActual.equals( mes ) ){
            return true;
        }
        else{
            return false;
        }
    }
    
}
