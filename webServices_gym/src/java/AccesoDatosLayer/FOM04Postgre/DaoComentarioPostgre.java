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
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class DaoComentarioPostgre extends DaoPostgre implements IDaoComentario{
    
    private Connection _connection;
    private ArrayList<Comentario> _jsonArray;
    
    @Override
    public void insertar(Comentario comentario){
        try {
            _connection = Dao.getPostgreBdConnect();
            
            String  _query = "select * from fo_m04_inserta_progreso_compartido("
                +comentario.getIdUsuario()+",'"+comentario.getMensaje()+"')";
            
            PreparedStatement _st = _connection.prepareStatement(_query);
            
            _st.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        catch (ParameterNullException e){
            System.out.println(e.getMessage());
        }
        finally{
            Dao.closePostgreConnection(_connection);
        }
    }

    @Override
    public Entidad consultar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Comentario> getComentarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Comentario comentario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Comentario comentario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
