/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.FO1;

import AccesoDatosLayer.Dao;
import AccesoDatosLayer.DaoPostgre;
import Comun.Dominio.Entidad;
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
    private Connection conn;
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Usuario> jsonArray2;
    private ArrayList<Usuario> jsonArray;

    @Override
    public Entidad consultar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Funcion que es llamada cuando el usuario quiere agregar a un amigo.
     * @param ua
     * @return Devuelve un json con mensaje del estatus de la peticion.
     */
    @Override
    public String insertaUsuario_Amigo(Usuario_Amigo ua) {
        try {
            conn = Dao.getPostgreBdConnect();
            String query = "select * from fo_m01_inserta_usuario_amigo('"+ua.getAmi_usuario()+"', '"+ua.getAmi_amigo()+"')";
            PreparedStatement st = conn.prepareStatement(query);
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
            Dao.closePostgreConnection(conn);
        }
    }

    /**
     * Funcion que recibe como parámetro el ID del Usuario,
     * para consultarlo y saber sus amigos.
     * @param ua
     * @return Devuelve los datos en formato json
     */
    @Override
    public String getUsuario_Amigo(Usuario_Amigo ua) {
        try{
            conn = Dao.getPostgreBdConnect();
            String query = "SELECT * FROM fo_m01_get_usuario_amigo("+ua.getAmi_usuario()+")";
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
            Dao.closePostgreConnection(conn);
            return response;
        }
    }

    /**
     * Metodo que recibe como parametros el ID del Usuario
     * para eliminar un amigo.
     * @param ua
     * @return Devuelve un json con elemento llamado data, 
     * contiene el mensaje de la peticion
     */
    @Override
    public String eliminaUsuario_Amigo(Usuario_Amigo ua) {
        try{
            conn = Dao.getPostgreBdConnect();
            String query = "SELECT fo_m01_elimina_usuario_amigo(?,?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, ua.getAmi_usuario());
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
            Dao.closePostgreConnection(conn);
            
        }
    }

    @Override
    public ArrayList<Usuario> getListUsuario_Amigo() {
        try{
            conn = Dao.getPostgreBdConnect();
            String query = "SELECT * FROM USUARIO";
            jsonArray = new ArrayList<>();
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                jsonArray.add(new Usuario());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("USU_ID"));
                jsonArray.get(jsonArray.size() - 1).setUsuario(rs.getString("USU_USUARIO"));
                jsonArray.get(jsonArray.size() - 1).setPassword(rs.getString("USU_PASSWORD"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("USU_NOMBRE"));
                jsonArray.get(jsonArray.size() - 1).setApellido(rs.getString("USU_APELLIDO"));
                jsonArray.get(jsonArray.size() - 1).setSexo(rs.getString("USU_SEXO"));
                jsonArray.get(jsonArray.size() - 1).setFecha_nac(rs.getDate("USU_FECHA_NAC"));
                jsonArray.get(jsonArray.size() - 1).setTelefono(rs.getString("USU_TELEFONO"));
                jsonArray.get(jsonArray.size() - 1).setEstatura(rs.getInt("USU_ESTATURA"));
//                jsonArray.get(jsonArray.size() - 1).setFoto(rs.getString("foto"));
                jsonArray.get(jsonArray.size() - 1).setCorreo(rs.getString("USU_CORREO"));
                jsonArray.get(jsonArray.size() - 1).setEntrenador(rs.getBoolean("USU_ENTRENADOR"));
                jsonArray.get(jsonArray.size() - 1).setCodigo(rs.getInt("USU_CODIGO"));
            }
        }
        catch(SQLException e) {
            
        }
        catch (ParameterNullException e) {
            response = e.getMessage();
        }
        catch (Exception e) {
            response = e.getMessage();
        }
        finally {
            Dao.closePostgreConnection( conn );
            return jsonArray;
        }
    }
}
