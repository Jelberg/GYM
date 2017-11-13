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
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Laura
 */
@Path("BOM02_Entrenador")
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
    public String getInstructor(@QueryParam("correo") String correo){
         try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("correo", correo);
            }});

            String query = "SELECT * FROM bo_m02_get_entrenador("+correo+");";
            jsonArray = new ArrayList<>();
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, correo);
            ResultSet rs = st.executeQuery();
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                jsonArray.add(new Entrenador());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("ENT_ID"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("ENT_NOMBRE"));
                jsonArray.get(jsonArray.size() - 1).setApellido(rs.getString("ENT_APELLIDO"));
                jsonArray.get(jsonArray.size() - 1).setFecha_nac(rs.getDate("ENT_FECHA_NAC"));
                jsonArray.get(jsonArray.size() - 1).setSexo(rs.getInt("ENT_SEXO"));
                jsonArray.get(jsonArray.size() - 1).setCorreo(rs.getString("ENT_CORREO"));
                jsonArray.get(jsonArray.size() - 1).setHistorial(rs.getString("ENT_HISTORIAL"));
                byte[] img = rs.getBytes("ENT_FOTO");
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                jsonArray.get(jsonArray.size() - 1).setFoto(im);
                          
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
     * PUT method for updating or creating an instance of BOM02_Entrenador
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
