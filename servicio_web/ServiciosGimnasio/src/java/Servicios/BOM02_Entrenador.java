/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.Entrenador;
import Dominio.Sql;
import Excepciones.ParameterNullException;
import Validaciones.ValidationWS;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author Laura
 */
@Path("/BOM02_Entrenador")
public class BOM02_Entrenador {
    
    private Connection conn = Sql.getConInstance();
    //Atributo que se utiliza para transformar a formato JSON las consultas
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Entrenador> jsonArray;
    
    /**
     * Funcion que recibe como parámetro el correo del entrenador
     * @param correo Correo del entrenador
     * @return Devuelve los datos del entrenador del gimnansio en formato json
     */
   @GET
    @Path("/getEntrenador")
    @Produces("application/json")
    public String getEntrenador(@QueryParam("correo") String correo){
         try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("correo", correo);
            }});

            String query = "SELECT * FROM bo_m02_get_entrenadores( ? );";
            jsonArray = new ArrayList<>();
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, correo);
            ResultSet rs = st.executeQuery();
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                jsonArray.add(new Entrenador());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("id"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("nombre"));
                jsonArray.get(jsonArray.size() - 1).setApellido(rs.getString("apellido"));
                jsonArray.get(jsonArray.size() - 1).setFecha_nac(rs.getDate("fechanac"));
                jsonArray.get(jsonArray.size() - 1).setSexo(rs.getString("sexo"));
                jsonArray.get(jsonArray.size() - 1).setCorreo(rs.getString("correo"));
                jsonArray.get(jsonArray.size() - 1).setHistorial(rs.getString("historial"));
                //byte[] img = rs.getBytes("ENT_FOTO");
                //ImageIcon image = new ImageIcon(img);
                //Image im = image.getImage();
                //jsonArray.get(jsonArray.size() - 1).setFoto(im);
                          
            }
            response = gson.toJson(jsonArray);
        }
        catch(SQLException | ParameterNullException e) {
            response = e.getMessage();
        }
        finally {
            Sql.bdClose(conn);
            return response;
        }
    
    }
     /**
     * @return Devuelve todos los datos del entrenador
     */
    @GET
    @Path("/getListEntrenador")
    @Produces("application/json")
    public String getListaEntrenador(){
         try{
            
            String query = "SELECT * FROM entrenador;";
            jsonArray = new ArrayList<>();
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                jsonArray.add(new Entrenador());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("ENT_ID"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("ENT_NOMBRE"));
                jsonArray.get(jsonArray.size() - 1).setApellido(rs.getString("ENT_APELLIDO"));
                jsonArray.get(jsonArray.size() - 1).setFecha_nac(rs.getDate("ENT_FECHA_NAC"));
                jsonArray.get(jsonArray.size() - 1).setSexo((rs.getString("ENT_SEXO")));
                jsonArray.get(jsonArray.size() - 1).setCorreo(rs.getString("ENT_CORREO"));
                 jsonArray.get(jsonArray.size() - 1).setCorreo(rs.getString("ENT_HISTORIAL"));
                /*byte[] img = rs.getBytes("ENT_FOTO");
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
     * Funcion que permite ingresar un entrenador
     * @param nombre
     * @param apellido
     * @param fecha_nac
     * @param sexo
     * @param correo
     * @param historial
     * @return Devuelve un json con elemento llamado data, el cual contiene el mensaje de la peticion
     */
  
    @POST
    @Path("/insertarEntrenador")
    @Produces("application/json")
    public String insertarEntrenador(@QueryParam("nombre") String nombre,
                                    @QueryParam("apellido") String apellido,
                                    @QueryParam("fechanac") String fecha,
                                    @QueryParam("sexo") char sexo,
                                    @QueryParam("correo") String correo,
                                    @QueryParam("historial") String historial
                                    ){
        
        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("nombre", nombre );
                put("apellido", apellido );
                put("fechanac", fecha);
                put("sexo", sexo );
                put("correo", correo );
                put("historial", historial );
            }});
            
            String query = "select * from bo_m02_insertar_entrenador('"+nombre+"', '"+apellido+"', '"+fecha+"', '"+Character.toString(sexo)+"', '"+correo+"', '"+historial+"')";
            PreparedStatement st = conn.prepareStatement(query); 

                st.executeQuery();
            
            response.put("respuesta", "Se inserto el entrenador");
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
     * Metodo que recibe como parametros el correo del entrenador
     * para eliminarlo.
     * @param correo correo del entrenador.
     * @return Devuelve un json con elemento llamado data que contiene el mensaje de la peticion
     */
   @DELETE
    @Path("/eliminarEntrenador")
    @Produces("application/json")
    public String eliminarEntrenador(@QueryParam("correo") String correo){

        Map<String, String> response = new HashMap<String, String>();
        try{

            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("correo", correo);
            }});
            
            String query = "SELECT * from bo_m02_eliminar_entrenador(?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, correo);
            ResultSet rs = st.executeQuery();
            response.put("respuesta", "Se elimino el entrenador");
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
     * Metodo que recibe como parametros el correo del entrenador
     * para modificarlo ademas de sus atributos a modificar.
     * @param nombre
     * @param apellido
     * @param fecha
     * @param sexo
     * @param correo 
     * @param historial
     * @return Devuelve un json con elemento llamado data, 
     * contiene el mensaje de la peticion
     */
    @POST
    @Path("/modificarEntrenador")
    @Produces("application/json")
    public String actualizaInstruct( @QueryParam("nombre") String nombre,
                                    @QueryParam("apellido") String apellido,
                                    @QueryParam("fechanac") String fecha,
                                    @QueryParam("sexo") char sexo,
                                    @QueryParam("correo") String correo,
                                    @QueryParam("historial") String historial ){
        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("nombre", nombre );
                put("apellido", apellido );
                put("fechanac", fecha);
                put("sexo", sexo );
                put("correo", correo );
                put("historial", historial );
            }});
             String query = "select * from bo_m02_actualizar_entrenador('"+nombre+"', '"+apellido+"', '"+fecha+"', '"+Character.toString(sexo)+"', '"+correo+"')";
            PreparedStatement st = conn.prepareStatement(query); 

                st.executeQuery();
            
            response.put("data", "Se actualizo el entrenador");
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
