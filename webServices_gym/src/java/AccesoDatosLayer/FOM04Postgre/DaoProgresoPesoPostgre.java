/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.FOM04Postgre;

import AccesoDatosLayer.Dao;
import AccesoDatosLayer.DaoPostgre;
import Comun.Dominio.Entidad;
import Comun.Dominio.Progreso_Peso;
import Comun.Excepciones.ParameterNullException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Elberg
 */
public class DaoProgresoPesoPostgre extends DaoPostgre implements IDaoProgresoPeso {
    
    private Connection _connection;
    private ArrayList<Progreso_Peso> jsonArray;
    
    @Override
    public void actualizar(Progreso_Peso progreso_Peso){
        try {
            _connection = Dao.getPostgreBdConnect();
            
            String _query = "select * from fo_m04_act_progresop("
                    +progreso_Peso.getIdUsuario()+","+progreso_Peso.getPeso()+")";
            
            PreparedStatement _st = _connection.prepareStatement(_query);
            _st.executeQuery();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        catch (ParameterNullException e) {
            System.out.println(e.getMessage());
        }
        finally {
            Dao.closePostgreConnection( _connection );
        }
    }

    @Override
    public Entidad consultar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Progreso_Peso> getPesos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar(Progreso_Peso progreso_Peso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int idUsuario) {
        try {
            _connection = Dao.getPostgreBdConnect();
            
            String _query = "SELECT fo_m04_elimina_progresop("+idUsuario+")";
            
            PreparedStatement _st = _connection.prepareStatement(_query);
            
            _st.executeQuery();
            
        } catch ( SQLException e ) {
            System.out.println(e.getMessage());
        }
        catch ( ParameterNullException e ) {
            System.out.println(e.getMessage());
        }
        finally {
            Dao.closePostgreConnection( _connection );
        }
    }
    
}
