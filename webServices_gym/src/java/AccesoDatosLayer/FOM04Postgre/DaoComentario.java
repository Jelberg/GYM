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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class DaoComentario extends DaoPostgre implements IDaoComentario{
    
    private Connection _connection;
    private ArrayList<Comentario> _jsonArray;
    
    /**
     * Metodo para insertar comentarios en la base de datos
     * @param comentario
     * @return 
     */
    @Override
    public String insertar(Comentario comentario){
        try {
            _connection = getConexion();
            
            String  _query = "select * from fo_m04_inserta_progreso_compartido("
                +comentario.getIdUsuario()+",'"+comentario.getMensaje()+"')";
            
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
    public Entidad consultar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}