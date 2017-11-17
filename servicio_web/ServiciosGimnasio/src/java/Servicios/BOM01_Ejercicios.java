/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.Equipo;
import Dominio.Maquina;
import Dominio.Ejercicio_Maquina_Equipo;
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
 * @author Juan Zozaya
 */
@Path("Ejercicio")
public class BOM01_Ejercicios {

    private Connection conn = Sql.getConInstance();
    //Atributo que se utiliza para transformar a formado JSON las consultas.
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Equipo> jsonArray;
    private ArrayList<Maquina> jsonArray2;
    private ArrayList<Ejercicio_Maquina_Equipo> jsonArray3;

    @GET
    @Path("/getAll")
    @Produces("application/json")
    public String getAll() {
        try {
            String query = "SELECT * FROM bo_m01_getallexercices();";
            jsonArray3 = new ArrayList<>();
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            //La variable donde se almacena el resultado de la consulta.
            while (rs.next()) {
                jsonArray3.add(new Ejercicio_Maquina_Equipo());
                jsonArray3.get(jsonArray3.size() - 1).setId(rs.getInt("id"));
                jsonArray3.get(jsonArray3.size() - 1).setNombre(rs.getString("ejercicio"));
                jsonArray3.get(jsonArray3.size() - 1).setEquipamiento(rs.getString("equipamiento"));
                jsonArray3.get(jsonArray3.size() - 1).setGrupomuscular(rs.getString("grupo_muscular"));
            }
            response = gson.toJson(jsonArray);
        } catch (SQLException e) {
            response = e.getMessage();
        } catch (ParameterNullException e) {
            response = e.getMessage();
        } finally {
            Sql.bdClose(conn);
            return response;
        }

    }

    @POST
    @Path("/insertaEjercicioMaquina")
    @Produces("application/json")
    public String insertaEjercicioMaquina(@QueryParam("nombre") String nombre,
            @QueryParam("grupo") String grupo,
            @QueryParam("maquina") int maquina) {

        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>() {
                {
                    put("nombre", nombre);
                    put("grupo", grupo);
                    put("maquina", maquina);
                }
            });

            String query = "select * from bo_m01_insertar_ejercicio_maquina(?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            java.lang.reflect.Type type = new TypeToken<Ejercicio_Maquina_Equipo[]>() {
            }.getType();

            st.setString(1, nombre);
            st.setString(2, grupo);
            st.setInt(3, maquina);
            st.executeQuery();

            response.put("data", "Se insertó el ejercicio");
        } catch (SQLException e) {
            response.put("error", e.getMessage());
        } catch (ParameterNullException e) {
            response.put("error", e.getMessage());
        } finally {
            Sql.bdClose(conn);
            return gson.toJson(response);
        }

    }
    
    @POST
    @Path("/insertaEjercicioEquipo")
    @Produces("application/json")
    public String insertaEjercicioEquipo(@QueryParam("nombre") String nombre,
            @QueryParam("grupo") String grupo,
            @QueryParam("equipo") int equipo) {

        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>() {
                {
                    put("nombre", nombre);
                    put("grupo", grupo);
                    put("equipo", equipo);
                }
            });

            String query = "select * from bo_m01_insertar_ejercicio_equipo(?,?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            java.lang.reflect.Type type = new TypeToken<Ejercicio_Maquina_Equipo[]>() {
            }.getType();

            st.setString(1, nombre);
            st.setString(2, grupo);
            st.setInt(3, equipo);
            st.executeQuery();

            response.put("data", "Se insertó el ejercicio");
        } catch (SQLException e) {
            response.put("error", e.getMessage());
        } catch (ParameterNullException e) {
            response.put("error", e.getMessage());
        } finally {
            Sql.bdClose(conn);
            return gson.toJson(response);
        }

    }
}
