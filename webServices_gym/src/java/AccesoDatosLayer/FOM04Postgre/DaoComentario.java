/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.FOM04Postgre;

import AccesoDatosLayer.DaoPostgre;
import Comun.Dominio.Comentario;
import Comun.Dominio.Entidad;
import Comun.Excepciones.ParameterNullException;
import Comun.Util.ConfigurarLogger;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonardo
 */
public class DaoComentario extends DaoPostgre implements IDaoComentario{
    
    private Connection _connection;
    private ArrayList<Comentario> _jsonArray;
    private Gson _gson = new Gson();
    private String _response;
    ConfigurarLogger _cl;
    Logger _logger;
    
    /**
     * Constructor DaoComentario
     */
    public DaoComentario(){
        _cl = new ConfigurarLogger();
        _logger = _cl.getLogr();
    }
    
    /**
     * Metodo para insertar comentarios en la BD
     * @param _comentario
     * @return 
     */
    @Override
    public String insertar(Entidad _comentario){
        try {
            Comentario comentario = (Comentario) _comentario;
            _connection = getConexion();
 
            String query = 
                    "select * from fo_m04_inserta_progreso_compartido(?, ?)";
            PreparedStatement st = _connection.prepareStatement(query);
                st.setInt(2, comentario.getIdU());
                st.setString(1, comentario.getMensajeC());
                st.executeQuery();
                
                return "Comentario Agregado";
           
        }
        catch (SQLException e){
            return null;
        }
        catch (ParameterNullException e) {
            return null;
        }
        finally {
           cerrarConexion(_connection);
        }

    
    }

    /**
     * Metodo para consultar comentarios de acuerdo a la medida
     * @return 
     */
    @Override
    public ArrayList<Comentario> getComentariosProgMedida
        (int idUsuario,int idProgMedida) {
        try {
            _connection = getConexion();
            
            String _query = "SELECT * FROM fo_m04_get_comentarioprom('"+
                            idUsuario+"',"+idProgMedida+")";
            
            PreparedStatement _st = _connection.prepareCall(_query);
            ResultSet _rs = _st.executeQuery();
            
            while(_rs.next()){
                _jsonArray.add(new Comentario());
                _jsonArray.get(_jsonArray.size()-1).setNombreUsuario
                                            (_rs.getString("nombreUsuario"));
                _jsonArray.get(_jsonArray.size()-1).setMensaje
                                                    (_rs.getString("mensaje"));
            }
            return _jsonArray;
        } catch(SQLException e) {
            _logger.log(Level.SEVERE, "Error en conexion a la BD: {0}",
                    e.getMessage());
            return null;
        }
        catch (ParameterNullException e) {
            _logger.log(Level.SEVERE, "Parametro Nulo: {0}",e.getMessage());
            return null;
        }
        finally {
            cerrarConexion(_connection);
            
        }
    }

    /**
     * Metodo para consultar Progresos en la BD
     * @param id
     * @return 
     */
    @Override
    public String consultaProgresos(int id) {
        try{
            _connection = getConexion();
            String query = "SELECT * FROM fo_m04_get_progresoscompartidos(?)";
            String query2 = 
                    "SELECT * FROM fo_m04_get_progresoscompartidosamigos(?)";
            _jsonArray = new ArrayList<>();
            
            PreparedStatement st = _connection.prepareStatement(query);
            st.setInt( 1 , id );
            ResultSet rs = st.executeQuery();
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                _jsonArray.add(new Comentario());
                _jsonArray.get(_jsonArray.size() - 1).setIdU
                                        (Integer.parseInt(rs.getString(1)));
                _jsonArray.get(_jsonArray.size() - 1).setMensaje
                                                    (rs.getString(2));                
                _jsonArray.get(_jsonArray.size() - 1).setNombreUsuario
                                                        (rs.getString(3));
                _jsonArray.get(_jsonArray.size() - 1).setFecha(rs.getString(4));
                          
            }
            
            st = _connection.prepareStatement(query2);
            st.setInt( 1 , id );
            rs = st.executeQuery();
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                _jsonArray.add(new Comentario());
                _jsonArray.get(_jsonArray.size() - 1).setId(Integer.parseInt
                                                        (rs.getString(1)));
                _jsonArray.get(_jsonArray.size() - 1).setMensaje
                                                        (rs.getString(2));                
                _jsonArray.get(_jsonArray.size() - 1).setNombreUsuario
                                                        (rs.getString(3));
                _jsonArray.get(_jsonArray.size() - 1).setFecha(rs.getString(4));
                          
            }
            
            _response = _gson.toJson(_jsonArray);
            return _response;
        }
        catch(SQLException e) {
            _logger.log(Level.SEVERE, "Error con la conexion a BD: {0}",
                    e.getMessage());
            _response = e.getMessage();
             return null;
        }
        catch (ParameterNullException e) {
            _logger.log(Level.SEVERE, "Parametro Nulo: {0}",e.getMessage());
            _response = e.getMessage();
            return null;
        }
        finally {
            cerrarConexion(_connection);
        }
    }

    /**
     * Metodo para consultar Comentarios en la base de datos
     * @param ent
     * @return 
     */
    @Override
    public Entidad consultar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

   

    
}