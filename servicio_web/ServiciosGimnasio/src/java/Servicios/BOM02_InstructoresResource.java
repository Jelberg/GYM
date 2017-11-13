/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.Instructor;
import Dominio.Progreso_Medida;
import Dominio.Sql;
import Excepciones.ParameterNullException;
import Validaciones.ValidationWS;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.Image;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Miguel
 */
@Path("/FOM03_Rutina")
public class BOM02_InstructoresResource {
    private Connection conn = Sql.getConInstance();
    //Atributo que se utiliza para transformar a formado JSON las consultas.
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Instructor> jsonArray;

    /**
     * Funcion que recibe como parametro el correo del instructor 
     * @param correo del cual se quiere 
     * @return Devuelve todos los datos del instructor
     */
    @GET
    @Path("/getInstructor")
    @Produces("application/json")
    public String getInstructor(@QueryParam("correo") String correo){
         try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("correo", correo);
            }});

            String query = "SELECT * FROM bo_m02_get_instructor("+correo+");";
            jsonArray = new ArrayList<>();
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, correo);
            ResultSet rs = st.executeQuery();
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                jsonArray.add(new Instructor());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("INS_ID"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("INS_NOMBRE"));
                jsonArray.get(jsonArray.size() - 1).setApellido(rs.getString("INS_APELLIDO"));
                jsonArray.get(jsonArray.size() - 1).setFecha_nac(rs.getDate("INS_FECHA_NAC"));
                jsonArray.get(jsonArray.size() - 1).setSexo(rs.getInt("INS_SEXO"));
                jsonArray.get(jsonArray.size() - 1).setCorreo(rs.getString("INS_CORREO"));
                byte[] img = rs.getBytes("INS_FOTO");
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                jsonArray.get(jsonArray.size() - 1).setFoto(im);
                          
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
     * Funcion que permite ingresar instructor
     * @param jsonMedida 
     * @return Devuelve un json con elemento llamado data, el cual contiene el mensaje de la peticion
     */
    @POST
    @Path("/insertaInstructor")
    @Produces("application/json")
    public String insertaInstructor(@QueryParam("nombre") String nombre,
                                    @QueryParam("apellido") String apellido,
                                    @QueryParam("fecha_nac") Date fecha_nac,
                                    @QueryParam("sexo") int sexo,
                                    @QueryParam("correo") String correo,
                                    @QueryParam("foto") Image foto){

        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("nombre", nombre );
                put("apellido", apellido );
                put("fecha_nac", fecha_nac );
                put("sexo", sexo );
                put("correo", correo );
            }});

            String query = "select * from bo_m02_inserta_instructor(?, ?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(query);
            java.lang.reflect.Type type = new TypeToken<Progreso_Medida[]>(){}.getType();
                st.setString(1, nombre);
                st.setString(2, apellido);
                st.setDate(3, fecha_nac);
                st.setInt(4, sexo);
                st.setString(5, correo);
                
                st.executeQuery();
            
            response.put("data", "Se inserto el comentario");
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
     * Funcion que permite modificar instructor
     * @param jsonMedida 
     * @return Devuelve un json con elemento llamado data, el cual contiene el mensaje de la peticion
     */
    @POST
    @Path("/modificaInstructor")
    @Produces("application/json")
    public String modificarInstructor(@QueryParam("id") int id,
                                    @QueryParam("nombre") String nombre,
                                    @QueryParam("apellido") String apellido,
                                    @QueryParam("fecha_nac") Date fecha_nac,
                                    @QueryParam("sexo") int sexo,
                                    @QueryParam("correo") String correo,
                                    @QueryParam("foto") Image foto){

        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("id", id );
                put("nombre", nombre );
                put("apellido", apellido );
                put("fecha_nac", fecha_nac );
                put("sexo", sexo );
                put("correo", correo );
            }});

            String query = "select * from bo_m02_modifica_instructor(?, ?, ?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(query);
            java.lang.reflect.Type type = new TypeToken<Progreso_Medida[]>(){}.getType();
                st.setInt(1, id);
                st.setString(2, nombre);
                st.setString(3, apellido);
                st.setDate(4, fecha_nac);
                st.setInt(5, sexo);
                st.setString(6, correo);
                
                st.executeQuery();
            
            response.put("data", "Se inserto el comentario");
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
}
