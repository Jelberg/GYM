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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
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
@Path("Instruct")
public class BOM02_Instruct {
private Connection conn = Sql.getConInstance();
    //Atributo que se utiliza para transformar a formado JSON las consultas.
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Instructor> jsonArray;
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    /**
     * Funcion que recibe como parametro el correo del instructor 
     * @param correo del cual se quiere 
     * @return Devuelve todos los datos del instructor
     */
    @GET
    @Path("/getInstruct")
    @Produces("application/json")
    public String getInstructor(@QueryParam("correo") String correo){
         try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("correo", correo);
            }});

            String query = "SELECT * FROM bo_m02_get_instructor( ? );";
            jsonArray = new ArrayList<>();
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, correo);
            ResultSet rs = st.executeQuery();
            
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                jsonArray.add(new Instructor());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("id"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("nombre"));
                jsonArray.get(jsonArray.size() - 1).setApellido(rs.getString("apellido"));
                jsonArray.get(jsonArray.size() - 1).setFecha_nac(rs.getDate("fechanac"));
                jsonArray.get(jsonArray.size() - 1).setSexo((rs.getString("sexo")));
                jsonArray.get(jsonArray.size() - 1).setCorreo(rs.getString("correo"));
                /*byte[] img = rs.getBytes("INS_FOTO");
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                jsonArray.get(jsonArray.size() - 1).setFoto(im);*/
                          
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
     * Funcion que recibe como parametro el correo del instructor 
     * @param correo del cual se quiere 
     * @return Devuelve todos los datos del instructor
     */
    @GET
    @Path("/getListInstruct")
    @Produces("application/json")
    public String getListInstructor(){
         try{
            
            String query = "SELECT * FROM instructor;";
            jsonArray = new ArrayList<>();
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                jsonArray.add(new Instructor());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("INS_ID"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("INS_NOMBRE"));
                jsonArray.get(jsonArray.size() - 1).setApellido(rs.getString("INS_APELLIDO"));
                jsonArray.get(jsonArray.size() - 1).setFecha_nac(rs.getDate("INS_FECHA_NAC"));
                jsonArray.get(jsonArray.size() - 1).setSexo((rs.getString("INS_SEXO")));
                jsonArray.get(jsonArray.size() - 1).setCorreo(rs.getString("INS_CORREO"));
                /*byte[] img = rs.getBytes("INS_FOTO");
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                jsonArray.get(jsonArray.size() - 1).setFoto(im);*/
                          
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
     * @param nombre
     * @param apellido
     * @param fecha_nac
     * @param sexo
     * @param correo
     * @param jsonMedida 
     * @return Devuelve un json con elemento llamado data, el cual contiene el mensaje de la peticion
     */
    @POST
    @Path("/insertaInstruct")
    @Produces("application/json")
    public String insertaInstruct(@QueryParam("nombre") String nombre,
                                    @QueryParam("apellido") String apellido,
                                    @QueryParam("fechanac") String fecha,
                                    @QueryParam("sexo") char sexo,
                                    @QueryParam("correo") String correo
                                    ){
        
        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("nombre", nombre );
                put("apellido", apellido );
                put("fechanac", fecha);
                put("sexo", sexo );
                put("correo", correo );
            }});
            
            String query = "select * from bo_m02_inserta_instructor('"+nombre+"', '"+apellido+"', '"+fecha+"', '"+Character.toString(sexo)+"', '"+correo+"')";
            PreparedStatement st = conn.prepareStatement(query); 
            java.lang.reflect.Type type = new TypeToken<Progreso_Medida[]>(){}.getType();

                st.executeQuery();
            
            response.put("data", "Se inserto el instructor");
        }
        catch (SQLException e){
            response.put("error1", e.getMessage());
        }
        catch (ParameterNullException e) {
            response.put("error2", e.getMessage());
        }
        finally {
            Sql.bdClose(conn);
            return gson.toJson(response);
        }
    }
    
    
    /**
     * Metodo que recibe como parametros el correo del instructor
     * para eliminarlo.
     * @param correo correo del instructor.
     * @return Devuelve un json con elemento llamado data, 
     * contiene el mensaje de la peticion
     */
    @DELETE
    @Path("/eliminaInstruct")
    @Produces("application/json")
    public String eliminaInstruct(@QueryParam("correo") String correo){

        Map<String, String> response = new HashMap<String, String>();
        try{

            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("correo", correo);
            }});
            
            String query = "SELECT * from bo_m02_elimina_instructor(?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, correo);
            ResultSet rs = st.executeQuery();
            response.put("data", "Se elimino el instructor");
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
     * Metodo que recibe como parametros el correo del instructor
     * para modificarlo ademas de sus atributos a modificar.
     * @param nombre
     * @param apellido
     * @param fecha
     * @param sexo
     * @param correo 
     * @return Devuelve un json con elemento llamado data, 
     * contiene el mensaje de la peticion
     */
    @POST
    @Path("/actualizaInstruct")
    @Produces("application/json")
    public String actualizaInstruct( @QueryParam("nombre") String nombre,
                                    @QueryParam("apellido") String apellido,
                                    @QueryParam("fechanac") String fecha,
                                    @QueryParam("sexo") char sexo,
                                    @QueryParam("correo") String correo){
        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("nombre", nombre );
                put("apellido", apellido );
                put("fechanac", fecha);
                put("sexo", sexo );
                put("correo", correo );
            }});
             String query = "select * from bo_m02_actualiza_instructor('"+nombre+"', '"+apellido+"', '"+fecha+"', '"+Character.toString(sexo)+"', '"+correo+"')";
            PreparedStatement st = conn.prepareStatement(query); 
            java.lang.reflect.Type type = new TypeToken<Progreso_Medida[]>(){}.getType();

                st.executeQuery();
            
            response.put("data", "Se actualizo el instructor");
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
