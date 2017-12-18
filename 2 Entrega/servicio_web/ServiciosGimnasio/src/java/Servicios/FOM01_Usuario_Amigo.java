/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.Sql;
import Dominio.Usuario;
import Dominio.Usuario_Amigo;
import Excepciones.ParameterNullException;
import Validaciones.ValidationWS;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
@Path("/Usuario_Amigo")
public class FOM01_Usuario_Amigo {
    
    private Connection conn = Sql.getConInstance();
    //Atributo que se utiliza para transformar a formado JSON las consultas.
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Usuario_Amigo> jsonArray;
    private ArrayList<Usuario> jsonArray2;
    
    /**
     * Funcion que recibe como parámetro el ID del Usuario,
     * para consultarlo y saber sus amigos.
     * @param idUsuario ID del Usuario.
     * @return Devuelve los datos en formato json
     */
    @GET
    @Path("/getUsuario_Amigo")
    @Produces("application/json")
    public String getUsuario_Amigo(@QueryParam("idUsuario") int idUsuario){
        
        try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("idUsuario", idUsuario);
            }});
            String query = "SELECT * FROM fo_m01_get_usuario_amigo("+idUsuario+")";
            jsonArray2 = new ArrayList<>();
            System.out.println (query);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                jsonArray2.add(new Usuario());
                jsonArray2.get(jsonArray2.size() - 1).setNombre(rs.getString("nombre"));
                jsonArray2.get(jsonArray2.size() - 1).setApellido(rs.getString("apellido"));
                jsonArray2.get(jsonArray2.size() - 1).setUsuario(rs.getString("usuario"));
                jsonArray2.get(jsonArray2.size() - 1).setCorreo(rs.getString("correo"));
            }
            response = gson.toJson(jsonArray2);
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
     * Funcion que es llamada cuando el usuario quiere agregar a un amigo.
     * @param idUsuario ID del Usuario.
     * @param idAmigo ID del Amigo.
     * @return Devuelve un json con mensaje del estatus de la peticion.
     */
    @POST
    @Path("/insertaUsuario_Amigo")
    @Produces("application/json")
    public String insertaUsuario_Amigo(  @QueryParam("idUsuario") int idUsuario,
                                 @QueryParam("idAmigo") int idAmigo){

        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("idUsuario", idUsuario );
                put("idAmigo", idAmigo );
            }});

            String query = "select * from fo_m01_inserta_usuario_amigo(?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            java.lang.reflect.Type type = new TypeToken<Usuario_Amigo[]>(){}.getType();
                st.setInt(1, idUsuario);
                st.setInt(2, idAmigo);
                st.executeQuery();
            
            response.put("data", "Se agregó el amigo");
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
    
    /**
     * Metodo que recibe como parametros el ID del Usuario
     * para eliminar un amigo.
     * @param idUsuario ID del Usuario.
     * @param idAmigo ID del Amigo.
     * @return Devuelve un json con elemento llamado data, 
     * contiene el mensaje de la peticion
     */
    @DELETE
    @Path("/eliminaUsuario_Amigo")
    @Produces("application/json")
    public String eliminaUsuario_Amigo(@QueryParam("idUsuario") int idUsuario,
                                       @QueryParam("idAmigo") int idAmigo){

        Map<String, String> response = new HashMap<String, String>();
        try{

            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("idUsuario", idUsuario);
                put("idAmigo", idAmigo);
            }});
                String query = "SELECT fo_m01_elimina_usuario_amigo(?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, idUsuario);
            ResultSet rs = st.executeQuery();
            response.put("data", "Se eliminó el amigo");
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
}
