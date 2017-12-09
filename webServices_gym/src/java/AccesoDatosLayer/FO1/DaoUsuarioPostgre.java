/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.FO1;
import AccesoDatosLayer.DaoPostgre;
import Comun.Dominio.Usuario;
import Comun.Excepciones.ParameterNullException;
import java.sql.*;
import java.util.ArrayList;
import com.google.gson.Gson;
/**
 *
 * @author Miguel
 */
//public class DaoUsuarioPostgre extends DaoPostgre implements IDaoUsuario{
    /*private Connection conn = super.getConInstance();
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Usuario> jsonArray;
    
    @Override     
    public String Consultar( int id){
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
            super.bdClose(conn);
            return response;
        }
     }
         
    @Override
    public String get_Usuariocorreo( String correo)
    {
        try{
            String query = "SELECT * FROM fo_m01_getusuariocorreo('"+correo+"')";
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
            super.bdClose(conn);
            return response;
        }
    }


    @Override
    public String Insertar(  String nombre,
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
            super.bdClose(conn);
        }
    }
    
    @Override
    public String updateCodigo(String correo, int codigo ){
        try {
            Usuario usu= new Usuario();
            String query = "select * from fo_m01_update_codigo('"+correo+"','"+codigo+"')";
            PreparedStatement st = conn.prepareStatement(query); 
            st.executeQuery();           
            return("Se actualizo el codigo");
        }
        catch (SQLException e){
            return e.getMessage();           
        }
        catch (ParameterNullException e) {
         return e.getMessage();
        }
        catch (Exception e) {
         return e.getMessage();
        }
        finally {
            super.bdClose(conn);
        }
    }
    
    @Override
    public String updatePassword( String correo, String password)
    {
        try {
            Usuario usu= new Usuario();
            String query = "select * from fo_m01_update_pass('"+correo+"','"+password+"')";
            PreparedStatement st = conn.prepareStatement(query); 
            st.executeQuery();           
            return("Se actualizo la contrasena");
        }
        catch (SQLException e){
            return e.getMessage();           
        }
        catch (ParameterNullException e) {
         return e.getMessage();
        }
        catch (Exception e) {
         return e.getMessage();
        }
        finally {
            super.bdClose(conn);
        }
    }*/

    /**
     * Metodo que recibe como parametros los datos del usuario
     * para modificarlo.
     * @param id
     * @param usuario
     * @param password
     * @param nombre
     * @param apellido
     * @param sexo
     * @param fecha
     * @param telefono
     * @param estatura
     * @param correo
     * @param entrenador
     * @return Devuelve un json con elemento llamado data, 
     * contiene el mensaje de la peticion
     */
   /* @Override
    public String Modificar(        int id,
                                    String nombre,
                                    String apellido,
                                    String fecha,
                                    String sexo,
                                    String correo,
                                    String usuario,
                                    String password,
                                    int estatura,
                                    String telefono,
                                    boolean entrenador) {
        try {
            Usuario usu= new Usuario();
            String query = "select * from fo_m01_modifica_usuario('"+id+"','"+nombre+"','"+apellido+"','"+fecha+"','"+sexo+"','"+correo+"','"+usuario+"','"+password+"','"+estatura+"','"+telefono+"','"+entrenador+"')";
            PreparedStatement st = conn.prepareStatement(query); 
            st.executeQuery();           
            return("Se actualizo el usuario");
        }
        catch (SQLException e){
            return e.getMessage();           
        }
        catch (ParameterNullException e) {
         return e.getMessage();
        }
        catch (Exception e) {
         return e.getMessage();
        }
        finally {
            super.bdClose(conn);
        }
    }
*/
    
/**
     * Funcion que recibe como parámetro el nombre y apellido del Usuario,
     * para consultarlo y saber sus datos.
     * @param nombre del Usuario.
     * @return Devuelve los datos del cliente en formato json
     */

   /* @Override
    public String getUsuarioNomApe( String nombre, String apellido){
        
        try{
            String query = "SELECT * FROM fo_m01_get_usuarioNA('"+nombre+"','"+apellido+"')";
            jsonArray = new ArrayList<>();
            System.out.println (query);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                jsonArray.add(new Usuario());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("id"));
                jsonArray.get(jsonArray.size() - 1).setUsuario(rs.getString("usuario"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("nombre"));
                jsonArray.get(jsonArray.size() - 1).setApellido(rs.getString("apellido"));
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
            super.bdClose(conn);
            return response;
        }
    }
    
    */
    /**
     * Metodo que recibe como parametros el ID del Usuario
     * para eliminar su cuenta.
     * @param idUsuario ID del Usuario.
     * @return Devuelve un json con elemento llamado data, 
     * contiene el mensaje de la peticion
     */
   /* @Override
    public String Elimina( int idUsuario)
    {
        try{
            String query = "SELECT fo_m01_elimina_usuario(?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, idUsuario);
            ResultSet rs = st.executeQuery();
            return ("Se eliminó el usuario");
        }
        catch(SQLException e) {
            return ( e.getMessage());
        }
        catch (ParameterNullException e) {
            return ( e.getMessage());
        }
        catch (Exception e) {
            return ( e.getMessage());
        }
        finally {
            super.bdClose(conn);
        }
    }*/
    
//}
