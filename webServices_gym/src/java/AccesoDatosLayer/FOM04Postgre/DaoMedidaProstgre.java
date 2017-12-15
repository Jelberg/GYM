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
import java.sql.PreparedStatement;
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
    public ArrayList<Progreso_Medida> getMedidas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar(Progreso_Medida progreso_Medida) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Progreso_Medida progreso_Medida) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}
