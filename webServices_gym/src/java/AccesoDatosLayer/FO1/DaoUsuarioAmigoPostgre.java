/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.FO1;

import AccesoDatosLayer.DaoPostgre;
import Comun.Dominio.Usuario;
import Comun.Dominio.Usuario_Amigo;
import Comun.Excepciones.ParameterNullException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Miguel
 */
public class DaoUsuarioAmigoPostgre extends DaoPostgre implements IDaoUsuarioAmigo{        
    private Connection conn = super.getConInstance();
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
    @Override
    public String getUsuario_Amigo(int idUsuario){
        
        try{
            
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
            super.bdClose(conn);
            return response;
        }
    }
    
    /**
     * Funcion que es llamada cuando el usuario quiere agregar a un amigo.
     * @param idUsuario ID del Usuario.
     * @param idAmigo ID del Amigo.
     * @return Devuelve un json con mensaje del estatus de la peticion.
     */
    @Override
    public String insertaUsuario_Amigo( int idUsuario,
                                        int idAmigo){

        
        try {
            

            String query = "select * from fo_m01_inserta_usuario_amigo(?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            java.lang.reflect.Type type = new TypeToken<Usuario_Amigo[]>(){}.getType();
                st.setInt(1, idUsuario);
                st.setInt(2, idAmigo);
                st.executeQuery();
            
            return( "Se agregó el amigo");
        }
        catch (SQLException e){
            return( e.getMessage());
        }
        catch (ParameterNullException e) {
            return( e.getMessage());
        }
        catch (Exception e) {
            return( e.getMessage());
        }
        finally {
            super.bdClose(conn);
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
    @Override
    public String eliminaUsuario_Amigo(int idUsuario,
                                       int idAmigo){

        try{
            String query = "SELECT fo_m01_elimina_usuario_amigo(?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, idUsuario);
            ResultSet rs = st.executeQuery();
            return( "Se eliminó el amigo");
        }
        catch(SQLException e) {
            return(e.getMessage());
        }
        catch (ParameterNullException e) {
            return(e.getMessage());
        }
        catch (Exception e) {
            return(e.getMessage());
        }
        finally {
            super.bdClose(conn);
            
        }
    }
}
