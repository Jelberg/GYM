/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.Comentario;
import Dominio.Progreso_Medida;
import Dominio.Sql;
import Excepciones.ParameterNullException;
import Validaciones.ValidationWS;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author marvian
 */
public class FOM04_Comentario {
    
    private Connection conn = Sql.getConInstance();
    //Atributo que se utiliza para transformar a formado JSON las consultas.
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Comentario> jsonArray;
  
    
    
    @GET
    @Path("/getDatoPrueba")
    @Produces("application/json")
    public String getDatoPrueba(){
    
    Gson gson = new Gson();
    Comentario c= new Comentario(1,"hola");
    return gson.toJson(c);
    
    }

    /**
     * Funcion que recibe como parametro el id del progreso correspondiente a medidas
     * @param idProgreso del cual se quiere saber los comentarios
     * @return Devuelve los comentarios correspondientes a ese progreso de medidas
     */
    @GET
    @Path("/getComentarioM")
    @Produces("aplicacion/json")
    public String getComentarioProM(@QueryParam("idProgreso") int idProgreso){
    
        try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("idProgreso", idProgreso);
            }});

            String query = "SELECT * FROM fo_m04_get_comentariopromed(?)";
            jsonArray = new ArrayList<>();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, idProgreso);
            ResultSet rs = st.executeQuery();
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                jsonArray.add(new Comentario());
                jsonArray.get(jsonArray.size() - 1).setMensaje(rs.getString("mensaje"));
                jsonArray.get(jsonArray.size() - 1).setUsuarioProgreso(rs.getInt("usuarioprogreso"));
                jsonArray.get(jsonArray.size() - 1).setUsuarioComentario(rs.getInt("usuariocomentario"));
                          
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
     * Funcion que recibe como parametro el id del progreso correspondiente a peso
     * @param idProgreso del cual se quiere saber los comentarios
     * @return Devuelve los comentarios correspondientes a ese progreso de peso
     */
    @GET
    @Path("/getComentarioP")
    @Produces("aplicacion/json")
    public String getComentarioProP(@QueryParam("idUsuario") int idusuario,
                                    @QueryParam("idprogresop") int idprogresop,
                                    @QueryParam("idprogresom") int idprogresom){
    
        try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("idusurio", idusuario);
                put("idprogresop", idprogresop);
                put("idprogresom", idprogresom);
            }});

            String query = "SELECT * FROM fo_m04_get_comentario(?,?,?)";
            jsonArray = new ArrayList<>();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, idusuario);
            st.setInt(1, idprogresop);
            st.setInt(1, idprogresom);
            ResultSet rs = st.executeQuery();
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                jsonArray.add(new Comentario());
                jsonArray.get(jsonArray.size() - 1).setMensaje(rs.getString("mensaje"));                
                jsonArray.get(jsonArray.size() - 1).setUsuarioComentario(rs.getInt("usuariocomentario"));
                          
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
     * Funcion que permite ingresar comentarios a un progreso
     * @param jsonMedida 
     * @return Devuelve un json con elemento llamado data, el cual contiene el mensaje de la peticion
     */
    @POST
    @Path("/insertaComentario")
    @Produces("aplicacion/json")
    public String insertaComentario(@QueryParam("id_usuariocomentario") int id_usuariocomentario,
                                    @QueryParam("id_usuarioprogreso") int id_usuarioprogreso,
                                    @QueryParam("mensaje") String mensaje,
                                    @QueryParam("id_progresoM") int id_progresoM,
                                    @QueryParam("id_progresoP")int id_progresoP){

        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("id_usuariocomentario", id_usuariocomentario );
                put("id_usuarioprogreso", id_usuarioprogreso );
                put("mensaje", mensaje );
                put("id_progresom",id_progresoM);
                put("id_progresop", id_progresoP);
            }});

            String query = "select * from fo_m04_inserta_comentario(?, ?, ?, ?, ?)";
            PreparedStatement st = conn.prepareStatement(query);
            java.lang.reflect.Type type = new TypeToken<Progreso_Medida[]>(){}.getType();
                st.setInt(1, id_usuariocomentario);
                st.setInt(2, id_usuarioprogreso);
                st.setString(3, mensaje);
                st.setInt(4, id_progresoM);
                st.setInt(5, id_progresoP);
                
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
