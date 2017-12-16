/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.FOM04Postgre;

import AccesoDatosLayer.Dao;
import AccesoDatosLayer.DaoPostgre;
import Comun.Dominio.Entidad;
import Comun.Dominio.Progreso_Medida;
import Comun.Excepciones.ParameterNullException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class DaoMedidaProstgre extends DaoPostgre implements IDaoMedida {

    private Connection _connection;
    private ArrayList<Progreso_Medida> jsonArray;
    
    @Override
    public Entidad consultar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Progreso_Medida> getMedidas(int idUsuario) {
        try {
            _connection = Dao.getPostgreBdConnect();
            
            String _query = "SELECT * FROM fo_m04_get_progresom("+idUsuario+")";
            
            PreparedStatement _st = _connection.prepareCall(_query);
            ResultSet _rs = _st.executeQuery();
            
            while(_rs.next()){
                jsonArray.add(new Progreso_Medida());
                jsonArray.get(jsonArray.size()-1).setMedida(_rs.getInt("medida"));
                jsonArray.get(jsonArray.size()-1).setTipo(_rs.getString("tipo"));
                jsonArray.get(jsonArray.size()-1).setFechaM(_rs.getString("fecha"));
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        catch (ParameterNullException e) {
            System.out.println(e.getMessage());
        }
        finally {
            Dao.closePostgreConnection(_connection);
            return jsonArray;
        }
    }

    @Override
    public void insertar(Progreso_Medida progreso_Medida) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Progreso_Medida progreso_Medida) {
        try {
            _connection = Dao.getPostgreBdConnect();
            
            String _query = "SELECT fo_m04_elimina_medidas("+
                    progreso_Medida.getIdUsuario()+",'"+
                    progreso_Medida.getTipo()+"')";
            
            PreparedStatement _st = _connection.prepareStatement(_query);
            
            _st.executeQuery();
        } catch (SQLException e){
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
    public void actualizar(Progreso_Medida progreso_Medida) {
        try {
            _connection = Dao.getPostgreBdConnect();
            
            String _query = "select * from fo_m04_act_medida("+
                    progreso_Medida.getIdUsuario()+",'"+
                    progreso_Medida.getTipo()+"',"+
                    progreso_Medida.getMedida()+")";
            
            PreparedStatement _st = _connection.prepareCall(_query);
            
            _st.executeQuery();
        } catch (SQLException e){
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
    public ArrayList<Progreso_Medida> getMedidasAnuales(Progreso_Medida progreso_Medida, String fechaini, String fechafin) {
        try {
            _connection = Dao.getPostgreBdConnect();
            
            String _query = "select * from m04_get_medidas_ano('"+
                            progreso_Medida.getSobrenombre()+"','"+fechaini
                            +"','"+fechafin+"')";
            
            PreparedStatement _st = _connection.prepareStatement(_query);
            
            ResultSet _rs;
            
            for(int i=1; i<=11; i++)
            {
                _rs = _st.executeQuery();
                jsonArray.add(new Progreso_Medida());
                if(_rs.wasNull()){
                    jsonArray.get(jsonArray.size() - 1).setMedida(0);
                    jsonArray.get(jsonArray.size() - 1).setFechaM(fechaini);
                }else{
                    while (_rs.next()) {
                        jsonArray.get(jsonArray.size() - 1).setMedida(_rs.getInt("medida"));
                        jsonArray.get(jsonArray.size() - 1).setFechaM(fechaini);
                    }
                }
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        catch (ParameterNullException e) {
            System.out.println(e.getMessage());
        }
        finally {
            Dao.closePostgreConnection( _connection );
            return jsonArray;
        }
    }
    
}
