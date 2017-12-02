/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;


import Dominio.Sql;
import Dominio.Usuario;
import Excepciones.ParameterNullException;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Miguel
 */
public class FOM01_Login_Conn {
    private Connection conn = Sql.getConInstance();
    //Atributo que se utiliza para transformar a formado JSON las consultas.
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Usuario> jsonArray;
    
    
    public String iniciarSesion( String usuario, String password){
        
        try{
            String query = "SELECT * FROM fo_m01_iniciarsesion('"+usuario+"','"+password+"')";
            jsonArray = new ArrayList<>();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                jsonArray.add(new Usuario());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("id"));
                jsonArray.get(jsonArray.size() - 1).setEntrenador(rs.getBoolean("entrenador"));
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
    
     public String get_Usuario( int id){
        
        try{
            String query = "SELECT * FROM fo_m01_getusuario("+id+")";
            jsonArray = new ArrayList<>();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                jsonArray.add(new Usuario());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("id"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("nombre"));
                jsonArray.get(jsonArray.size() - 1).setApellido(rs.getString("apellido"));
                jsonArray.get(jsonArray.size() - 1).setFecha_nac(rs.getDate("fechanac"));
                jsonArray.get(jsonArray.size() - 1).setSexo((rs.getString("sexo")));
                jsonArray.get(jsonArray.size() - 1).setCorreo(rs.getString("correo"));
                jsonArray.get(jsonArray.size() - 1).setUsuario(rs.getString("usuario"));
                jsonArray.get(jsonArray.size() - 1).setPassword(rs.getString("password"));
                jsonArray.get(jsonArray.size() - 1).setEstatura(rs.getInt("estatura"));
                jsonArray.get(jsonArray.size() - 1).setTelefono(rs.getString("telefono"));
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

     
    public String insertaUsu(  String nombre,
                                    String apellido,
                                    String fecha,
                                    String sexo,
                                    String correo,
                                    String usuario,
                                    String password,
                                    int estatura,
                                    String telefono,
                                    boolean entrenador
                                    ){
        Map<String, String> response = new HashMap<String, String>();
        try {
            
            String query = "select * from fo_m01_inserta_usuario('"+nombre+"', '"+apellido+"', '"+fecha+"', '"+sexo+"', '"+correo+"', '"+usuario+"', '"+password+ "', "+estatura+", '"+telefono+"','"+entrenador+"')";
            PreparedStatement st = conn.prepareStatement(query); 
            st.executeQuery();           
            return("Se inserto el usuario");
        }
        catch (SQLException e){
            if (e.getMessage().regionMatches(0, "ERROR: llave duplicada viola restricción de unicidad «usuario_usu_usuario_key»", 0, 78))
            return ("usuario duplicado");
                    else
                        if (e.getMessage().regionMatches(0, "ERROR: llave duplicada viola restricción de unicidad «usuario_usu_correo_key»", 0, 77))
                        return ("correo duplicado");
                        else return e.getMessage();
            
        }
        catch (ParameterNullException e) {
         return e.getMessage();
        }
        catch (Exception e) {
         return e.getMessage();
        }
        finally {
            Sql.bdClose(conn);
        }
    }
}