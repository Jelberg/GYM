/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.*;
import Excepciones.ParameterNullException;
import Validaciones.ValidationWS;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author YESIMAR
 */
@Path("/Registrar_Usuario")
public class FOM01_Usuario {
        
    private Connection conn = Sql.getConInstance();
    //Atributo que se utiliza para transformar a formado JSON las consultas.
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Usuario> jsonArray;
    
    /**
     * Funcion que recibe como parámetro el ID del Usuario,
     * para consultarlo y saber sus datos.
     * @param idUsuario ID del Usuario.
     * @return Devuelve los datos del cliente en formato json
     */
    @GET
    @Path("/getUsuario")
    @Produces("application/json")
    public String getUsuario(@QueryParam("idUsuario") String idUsuario){
        
        try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("idUsuario", idUsuario);
            }});
            String query = "SELECT * FROM fo_m01_get_usuario('"+idUsuario+"')";
            jsonArray = new ArrayList<>();
            System.out.println (query);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                jsonArray.add(new Usuario());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("idUsuario"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("nombre"));
                jsonArray.get(jsonArray.size() - 1).setApellido(rs.getString("apellido"));
                jsonArray.get(jsonArray.size() - 1).setFecha_nac(rs.getDate("fecha_nac"));
                jsonArray.get(jsonArray.size() - 1).setSexo(rs.getString("sexo"));
                jsonArray.get(jsonArray.size() - 1).setCorreo(rs.getString("correo"));
                jsonArray.get(jsonArray.size() - 1).setUsuario(rs.getString("usuario"));
                jsonArray.get(jsonArray.size() - 1).setPassword(rs.getString("password"));
                jsonArray.get(jsonArray.size() - 1).setEstatura(rs.getInt("estatura"));
                jsonArray.get(jsonArray.size() - 1).setTelefono(rs.getString("telefono"));
            }
            response = gson.toJson(jsonArray);
        }
        catch(SQLException e) {
            response = e.getMessage();
        }
        catch (ParameterNullException e) {
            response = e.getMessage();
        }
        catch (Exception e) {
            response = e.getMessage();
        }
        finally {
            Sql.bdClose(conn);
            return response;
        }
    }
    
    /**
     * @return Devuelve una lista de usuarios
     */
    @GET
    @Path("/getListUsuario")
    @Produces("application/json")
    public String getListUsuario(){
        
        try{
            
            String query = "SELECT * FROM USUARIO";
            jsonArray = new ArrayList<>();
            System.out.println (query);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                jsonArray.add(new Usuario());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("idUsuario"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("nombre"));
                jsonArray.get(jsonArray.size() - 1).setApellido(rs.getString("apellido"));
                jsonArray.get(jsonArray.size() - 1).setFecha_nac(rs.getDate("fecha_nac"));
                jsonArray.get(jsonArray.size() - 1).setSexo(rs.getString("sexo"));
                jsonArray.get(jsonArray.size() - 1).setCorreo(rs.getString("correo"));
                jsonArray.get(jsonArray.size() - 1).setUsuario(rs.getString("usuario"));
                jsonArray.get(jsonArray.size() - 1).setPassword(rs.getString("password"));
                jsonArray.get(jsonArray.size() - 1).setEstatura(rs.getInt("estatura"));
                jsonArray.get(jsonArray.size() - 1).setTelefono(rs.getString("telefono"));
            }
            response = gson.toJson(jsonArray);
        }
        catch(SQLException e) {
            response = e.getMessage();
        }
        catch (ParameterNullException e) {
            response = e.getMessage();
        }
        catch (Exception e) {
            response = e.getMessage();
        }
        finally {
            Sql.bdClose(conn);
            return response;
        }
    }
    
    /**
     * Metodo que recibe como parametros el ID del Usuario
     * para eliminar su cuenta.
     * @param idUsuario ID del Usuario.
     * @return Devuelve un json con elemento llamado data, 
     * contiene el mensaje de la peticion
     */
    @DELETE
    @Path("/eliminaUsuario")
    @Produces("application/json")
    public String eliminaUsuario(@QueryParam("idUsuario") String idUsuario){

        Map<String, String> response = new HashMap<String, String>();
        try{

            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("idUsuario", idUsuario);
            }});
                String query = "SELECT fo_m01_elimina_usuario(?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, idUsuario);
            ResultSet rs = st.executeQuery();
            response.put("data", "Se eliminó el usuario");
        }
        catch(SQLException e) {
            response.put("error", e.getMessage());
        }
        catch (ParameterNullException e) {
            response.put("error", e.getMessage());
        }
        catch (Exception e) {
            response.put("error", e.getMessage());
        }
        finally {
            Sql.bdClose(conn);
            return gson.toJson(response);
        }
    }
    
    /**
     * Funcion que modifica los datos de un Usuario.
     * @param idUsuario ID del Usuario.
     * @return Devuelve un json con un mensaje al usuario sobre el estatus
     * de la petición.
     */
    @POST
    @Path("/modificaUsuario")
    @Produces("application/json")
    public String modificaUsuario( @QueryParam ( "idUsuario" ) String idUsuario){
        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put ( "idUsuario" , idUsuario );
            }});
            String query = "select * from fo_m01_modifica_usuario(?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, idUsuario);
            st.executeQuery();
            response.put("data", "Se modificaron los datos con éxito");
        }
        catch (SQLException e){
            response.put("error", e.getMessage());
        }
        catch (ParameterNullException e) {
            response.put("error", e.getMessage());
        }
        catch (Exception e) {
            response.put("error", e.getMessage());
        }
        finally {
            Sql.bdClose(conn);
            return gson.toJson(response);
        }
    }
}
