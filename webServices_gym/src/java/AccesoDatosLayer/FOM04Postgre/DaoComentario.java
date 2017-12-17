/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.FOM04Postgre;

import AccesoDatosLayer.Dao;
import AccesoDatosLayer.DaoPostgre;
import Comun.Dominio.Comentario;
import Comun.Dominio.Entidad;
import Comun.Excepciones.ParameterNullException;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Leonardo
 */
public class DaoComentario extends DaoPostgre implements IDaoComentario{
    
    private Connection _connection;
    private ArrayList<Comentario> _jsonArray;
    private Gson _gson = new Gson();
    private String _response;
    
    @Override
    public String insertar(Entidad _comentario){
        try {
            Comentario comentario = (Comentario) _comentario;
            _connection = getConexion();
            
            String  _query = "select * from fo_m04_inserta_progreso_compartido("
                +comentario+",'"+comentario.getMensaje()+"')";
            
            PreparedStatement _st = _connection.prepareStatement(_query);
            
            _st.executeQuery();
            
            return "Comentario Agregado";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        catch (ParameterNullException e){
            System.out.println(e.getMessage());
        }
        finally{
            cerrarConexion(_connection);
            return null;
        }
    }

    /**
     * Metodo para consultar comentarios de acuerdo a la medida
     * @param ent
     * @return 
     */
    @Override
    public ArrayList<Comentario> getComentariosProgMedida(int idUsuario,int idProgMedida) {
        try {
            _connection = getConexion();
            
            String _query = "SELECT * FROM fo_m04_get_comentarioprom("+
                            idUsuario+","+idProgMedida+")";
            
            PreparedStatement _st = _connection.prepareCall(_query);
            ResultSet _rs = _st.executeQuery();
            
            while(_rs.next()){
                _jsonArray.add(new Comentario());
                _jsonArray.get(_jsonArray.size()-1).setNombreUsuario(_rs.getString("nombreUsuario"));
                _jsonArray.get(_jsonArray.size()-1).setMensaje(_rs.getString("mensaje"));
            }
            
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        catch (ParameterNullException e) {
            System.out.println(e.getMessage());
        }
        finally {
            cerrarConexion(_connection);
            return _jsonArray;
        }
    }

    @Override
    public ArrayList<Comentario> getComentarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminar(Comentario comentario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String actualizar(Comentario comentario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override

    public String consultaProgresos(int id) {
        try{
            _connection = getConexion();
            String query = "SELECT * FROM fo_m04_get_progresoscompartidos(?)";
            String query2 = "SELECT * FROM fo_m04_get_progresoscompartidosamigos(?)";
            _jsonArray = new ArrayList<>();
            
            PreparedStatement st = _connection.prepareStatement(query);
            st.setInt( 1 , id );
            ResultSet rs = st.executeQuery();
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                _jsonArray.add(new Comentario());
                _jsonArray.get(_jsonArray.size() - 1).setId(Integer.parseInt(rs.getString(1)));
                _jsonArray.get(_jsonArray.size() - 1).setMensaje(rs.getString(2));                
                _jsonArray.get(_jsonArray.size() - 1).setNombreUsuario(rs.getString(3));
                _jsonArray.get(_jsonArray.size() - 1).setFecha(rs.getString(4));
                          
            }
            
            st = _connection.prepareStatement(query2);
            st.setInt( 1 , id );
            rs = st.executeQuery();
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                _jsonArray.add(new Comentario());
                _jsonArray.get(_jsonArray.size() - 1).setId(Integer.parseInt(rs.getString(1)));
                _jsonArray.get(_jsonArray.size() - 1).setMensaje(rs.getString(2));                
                _jsonArray.get(_jsonArray.size() - 1).setNombreUsuario(rs.getString(3));
                _jsonArray.get(_jsonArray.size() - 1).setFecha(rs.getString(4));
                          
            }
            
            _response = _gson.toJson(_jsonArray);
            return _response;
        }
        catch(SQLException e) {
            _response = e.getMessage();
             return null;
        }
        catch (ParameterNullException e) {
            _response = e.getMessage();
            return null;
        }
        finally {
            cerrarConexion(_connection);
        }
    }

  

    public Entidad consultar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertar(Comentario comentario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}