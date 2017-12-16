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
import Comun.Excepciones.ParameterNullException;
import java.sql.*;
import java.util.ArrayList;
import com.google.gson.Gson;
/**
 *
 * @author Miguel
 */
public class DaoUsuarioPostgre extends DaoPostgre implements IDaoUsuario{
    private Connection conn;
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Usuario> jsonArray;
    
    @Override     
    public String getUsuario( Usuario u){
        try{
            conn = getConexion();
            String query = "SELECT * FROM fo_m01_getusuario("+u.getId()+")";
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
            cerrarConexion(conn);
            return response;
        }
     }
    
    @Override
    public String IniciarSesion(Usuario u){
        
        try{
            conn = getConexion();
            String query = "SELECT * FROM fo_m01_iniciarsesion('"+u.getUsuario()+"','"+u.getPassword()+"')";
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
            cerrarConexion(conn);
            return response;
        }
        
    }
         
    @Override
    public String get_Usuariocorreo(Usuario u)
    {int x=0;
        try{
            conn = getConexion();
            String query = "SELECT * FROM fo_m01_getusuariocorreo('"+u.getCorreo()+"')";
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
                x=1;
            }
            if (x!=1)
                response = "0";
            else
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
            cerrarConexion(conn);
            return response;
        }
    }


    @Override
    public String Insertar(  Usuario u ){
        try {
            conn = getConexion();
            String query = "select * from fo_m01_inserta_usuario('"+u.getNombre()+"', '"+u.getApellido()+"', '"+u.getFecha_nac()+"', '"+u.getSexo()+"', '"+u.getCorreo()+"', '"+u.getUsuario()+"', '"+u.getPassword()+ "', "+u.getEstatura()+", '"+u.getTelefono()+"','"+u.isEntrenador()+"')";
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
            cerrarConexion(conn);
        }
    }
    
    @Override
    public String updateCodigo(Usuario u ){
        try {
            conn = getConexion();
            String query = "select * from fo_m01_update_codigo('"+u.getCorreo()+"','"+u.getCodigo()+"')";
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
            cerrarConexion(conn);
        }
    }
    
    @Override
    public String updatePassword( Usuario u)
    {
        try {
            conn = getConexion();
            String query = "select * from fo_m01_update_pass('"+u.getCorreo()+"','"+u.getPassword()+"')";
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
            cerrarConexion(conn);
        }
    }

    /**
     * Metodo que recibe como parametros los datos del usuario
     * para modificarlo.
     * @param u usuario
     * @return Devuelve un json con elemento llamado data, 
     * contiene el mensaje de la peticion
     */
    @Override
    public String modificaUsuario(Usuario u) {
        try {
            conn = getConexion();
            String query = "select * from fo_m01_modifica_usuario('"+u.getId()+"','"+u.getUsuario()+"','"+u.getPassword()+"','"+u.getNombre()+"','"+u.getApellido()+"','"+u.getSexo()+"','"+u.getTelefono()+"','"+u.getEstatura()+"','"+u.getCorreo()+"','"+u.isEntrenador()+"','"+u.getCodigo()+"')";
            PreparedStatement st = conn.prepareStatement(query); 
            st.executeQuery();           
            return("Se actualizo el usuario");
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
            cerrarConexion(conn);
        }
    }

    
/**
     * Funcion que recibe como parámetro el nombre y apellido del Usuario,
     * para consultarlo y saber sus datos.
    * @param u usuario 
     * @return Devuelve los datos del cliente en formato json
     */

   @Override
    public String getUsuarioNomApe( Usuario u){
        
        try{
            conn = getConexion();
            String query = "SELECT * FROM fo_m01_get_usuarioNA('"+u.getNombre()+"','"+u.getApellido()+"')";
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
            cerrarConexion(conn);
            return response;
        }
    }

    @Override
    public Entidad consultar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    

    @Override
    public ArrayList<Usuario> getListUsuario() {
        try{
            conn = getConexion();
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
            cerrarConexion(conn);
            return jsonArray;
        }
    }

    /**
     * Metodo que recibe como parametros el correo del Usuario
     * para eliminar su cuenta.
     * @param s string
     * @return Devuelve un json con elemento llamado data, 
     * contiene el mensaje de la peticion
     */
    @Override
    public String eliminaUsuario(String s) {
        try{
            conn = getConexion();
            String query = "SELECT fo_m01_elimina_usuario(?)";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, s);
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
            cerrarConexion(conn);
        }
    }
    
}
