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
import java.sql.Date;
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
    public String getUsuario(@QueryParam("idUsuario") int idUsuario){
        
        try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("idUsuario", idUsuario);
            }});
            String query = "SELECT * FROM fo_m01_get_usuario("+idUsuario+")";
            jsonArray = new ArrayList<>();
            System.out.println (query);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                jsonArray.add(new Usuario());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("idUsuario"));
                jsonArray.get(jsonArray.size() - 1).setUsuario(rs.getString("usuario"));
                jsonArray.get(jsonArray.size() - 1).setPassword(rs.getString("password"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("nombre"));
                jsonArray.get(jsonArray.size() - 1).setApellido(rs.getString("apellido"));
                jsonArray.get(jsonArray.size() - 1).setSexo(rs.getString("sexo"));
                jsonArray.get(jsonArray.size() - 1).setFecha_nac(rs.getDate("fecha_nac"));
                jsonArray.get(jsonArray.size() - 1).setTelefono(rs.getString("telefono"));
                jsonArray.get(jsonArray.size() - 1).setEstatura(rs.getInt("estatura"));
//                jsonArray.get(jsonArray.size() - 1).setFoto(rs.getString("foto"));
                jsonArray.get(jsonArray.size() - 1).setCorreo(rs.getString("correo"));
                jsonArray.get(jsonArray.size() - 1).setEntrenador(rs.getBoolean("entrenador"));
                jsonArray.get(jsonArray.size() - 1).setCodigo(rs.getInt("codigo"));
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
                jsonArray.get(jsonArray.size() - 1).setUsuario(rs.getString("usuario"));
                jsonArray.get(jsonArray.size() - 1).setPassword(rs.getString("password"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("nombre"));
                jsonArray.get(jsonArray.size() - 1).setApellido(rs.getString("apellido"));
                jsonArray.get(jsonArray.size() - 1).setSexo(rs.getString("sexo"));
                jsonArray.get(jsonArray.size() - 1).setFecha_nac(rs.getDate("fecha_nac"));
                jsonArray.get(jsonArray.size() - 1).setTelefono(rs.getString("telefono"));
                jsonArray.get(jsonArray.size() - 1).setEstatura(rs.getInt("estatura"));
//                jsonArray.get(jsonArray.size() - 1).setFoto(rs.getString("foto"));
                jsonArray.get(jsonArray.size() - 1).setCorreo(rs.getString("correo"));
                jsonArray.get(jsonArray.size() - 1).setEntrenador(rs.getBoolean("entrenador"));
                jsonArray.get(jsonArray.size() - 1).setCodigo(rs.getInt("codigo"));
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
    public String eliminaUsuario(@QueryParam("idUsuario") int idUsuario){

        Map<String, String> response = new HashMap<String, String>();
        try{

            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("idUsuario", idUsuario);
            }});
                String query = "SELECT fo_m01_elimina_usuario(?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, idUsuario);
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
     * Metodo que recibe como parametros los datos del usuario
     * para modificarlo.
     * @param usuario
     * @param password
     * @param nombre
     * @param apellido
     * @param sexo
     * @param fecha
     * @param telefono
     * @param estatura
     * @param correo
     * @param entrenador
     * @param codigo
     * @return Devuelve un json con elemento llamado data, 
     * contiene el mensaje de la peticion
     */
    @POST
    @Path("/modificaUsuario")
    @Produces("application/json")
    public String modificaUsuario(  @QueryParam("usuario") String usuario,
                                    @QueryParam("password") String password,
                                    @QueryParam("nombre") String nombre,
                                    @QueryParam("apellido") String apellido,
                                    @QueryParam("sexo") String sexo,
                                    @QueryParam("fechanac") String fecha_nac,
                                    @QueryParam("telefono") String telefono,
                                    @QueryParam("estatura") int estatura,
                                    @QueryParam("correo") String correo,
                                    @QueryParam("entrenador") Boolean entrenador,
                                    @QueryParam("codigo") int codigo) {
        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("usuario", usuario );
                put("password", password );
                put("nombre", nombre );
                put("apellido", apellido );
                put("sexo", sexo );
                put("fechanac", fecha_nac );
                put("telefono", telefono );
                put("estatura", estatura );
                put("correo", correo );
                put("entrenador", entrenador );
                put("codigo", codigo );
            }});
            String query = "select * from fo_m01_modifica_usuario(?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, usuario);
            st.setString(2, password);
            st.setString(3, nombre);
            st.setString(4, apellido);
            st.setString(5, sexo);
            st.setString(6, fecha_nac);
            st.setString(7, telefono);
            st.setInt(8, estatura);
            st.setString(9, correo);
            st.setBoolean(10, entrenador);
            st.setInt(11, codigo);
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
