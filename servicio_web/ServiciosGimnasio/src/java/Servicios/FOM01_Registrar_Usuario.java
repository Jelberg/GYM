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
import java.sql.ResultSet;
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
 * @author YESIMAR
 */
@Path("/Registrar_Usuario")
public class FOM01_Registrar_Usuario {
        
    private Connection conn = Sql.getConInstance();
    //Atributo que se utiliza para transformar a formado JSON las consultas.
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Usuario> jsonArray;
    
    /**
     * Funcion que recibe como parámetro el nombre de usuario del Usuario,
     * para consultarlo y saber sus datos.
     * @param usuario Nombre de usuario del Usuario.
     * @return Devuelve los datos del cliente en formato json
     */
//    @GET
//    @Path("/getUsuario")
//    @Produces("application/json")
//    public String getUsuario(@QueryParam("nombreUsuario") String nombreUsuario){
//        
//        try{
//            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
//                put("nombre", nombreUsuario);
//            }});
//            String query = "SELECT * FROM fo_m01_get_usuario('"+nombreUsuario+"')";
//            jsonArray = new ArrayList<>();
//            System.out.println (query);
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery(query);
//            while(rs.next()){
//                jsonArray.add(new Usuario());
//                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("nombre"));
//                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("nombre"));
//                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("nombre"));
//                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("nombre"));
//                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("nombre"));
//                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("nombre"));
//                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("nombre"));
//                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("nombre"));
//                jsonArray.get(jsonArray.size() - 1).setDescripcion(rs.getString("descripcion"));
//            }
//            response = gson.toJson(jsonArray);
//        }
//        catch(SQLException e) {
//            response = e.getMessage();
//        }
//        catch (ParameterNullException e) {
//            response = e.getMessage();
//        }
//        catch (Exception e) {
//            response = e.getMessage();
//        }
//        finally {
//            Sql.bdClose(conn);
//            return response;
//        }
//    }
}
