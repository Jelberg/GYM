/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.FOM04Postgre;

import AccesoDatosLayer.DaoPostgre;
import Comun.Dominio.Entidad;
import Comun.Dominio.Progreso_Medida;
import Comun.Excepciones.ParameterNullException;
import Comun.Validaciones.ValidationWS;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Elberg
 */
public class DaoProgresoMedida extends DaoPostgre implements IDaoProgresoMedida{
    private Connection _conn;
    private String _resp;
    private Gson _gson = new Gson();
    private ArrayList<Progreso_Medida> _jsonArray;
    private Entidad _progresoMedida;
    private ArrayList<Progreso_Medida> _aux;
    
    @Override
    public Entidad consultar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String consultarMedidas(int id_usuario) {
        try{
            _conn = getConexion();
            String query = "SELECT * FROM fo_m04_get_progresom(?)";
            _jsonArray = new ArrayList<>();
            PreparedStatement st = _conn.prepareStatement(query);
            st.setInt(1, id_usuario);
            ResultSet rs = st.executeQuery();
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                _jsonArray.add(new Progreso_Medida());
                _jsonArray.get(_jsonArray.size() - 1).setMedida(rs.getInt("medida"));
                _jsonArray.get(_jsonArray.size() - 1).setTipo(rs.getString("tipo"));
                _jsonArray.get(_jsonArray.size() - 1).setFechaM(rs.getDate("fecha"));
            
            }
            _resp = _gson.toJson(_jsonArray);
            return _resp;
        }
        catch(SQLException e) {
            return null;
        }
        catch (ParameterNullException e) {
            return null;
        }
        finally {
            cerrarConexion( _conn );
        }
       
    }

    @Override
    public String agregarMedida(Entidad ent) {
    
        try {
            Progreso_Medida pm = (Progreso_Medida) ent;
            _conn = getConexion();
          
                String query = "select * from fo_m04_inserta_medidas(?, ?, ?)";
                PreparedStatement st = _conn.prepareStatement(query);
                st.setInt(1, pm.getId());
                st.setInt(2, pm.getMedida());
                st.setInt(3, pm.getIdtipo());
                
                st.executeQuery();
                
                return ("MEDIDA AGREGADA");
                
        }
        catch (SQLException e){
           
            return null;
        }
        catch (ParameterNullException e) {
            
            return null;
        }
        finally {
             cerrarConexion( _conn );
        }

    }

    @Override
    public String actualizarMedida(Entidad ent) {
         try {
             Progreso_Medida progreso_Medida = (Progreso_Medida) ent;
            _conn = getConexion();
            
            String _query = "select * from fo_m04_act_medida("+
                    progreso_Medida.getId()+",'"+
                    progreso_Medida.getTipo()+"',"+
                    progreso_Medida.getMedida()+")";
            
            PreparedStatement _st = _conn.prepareCall(_query);
            
            _st.executeQuery();
            
            return "Medida Cambiada";
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        catch (ParameterNullException e) {
            System.out.println(e.getMessage());
        }
        finally {
            cerrarConexion(_conn);
            return null;
        }
    }
    
}
