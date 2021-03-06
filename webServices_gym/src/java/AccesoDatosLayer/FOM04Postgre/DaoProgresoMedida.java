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
import Comun.Util.ConfigurarLogger;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elberg
 */
public class DaoProgresoMedida extends DaoPostgre implements IDaoProgresoMedida{
    private Connection _conn;
    private String _resp;
    private Gson _gson = new Gson();
    private ArrayList<Progreso_Medida> _jsonArray;
    private Progreso_Medida _progresoMedida;
    private ArrayList<Progreso_Medida> _aux;
    ConfigurarLogger _cl;
    Logger _logger;
    
    public DaoProgresoMedida(){
        _cl = new ConfigurarLogger();
         _logger = _cl.getLogr();
    }
    
    /**
     * Metodo para consultar medidas en la base de datos
     * @param ent
     * @return 
     */
    @Override
    public Entidad consultar(Entidad ent) {
        _logger.log(Level.SEVERE, "Metodo aun no Funcional");
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Metodo para consulat medidas en la base de datos
     * @param id_usuario
     * @return 
     */
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
                _jsonArray.get(_jsonArray.size() - 1).setMedida
                                                        (rs.getInt("medida"));
                _jsonArray.get(_jsonArray.size() - 1).setTipo
                                                        (rs.getString("tipo"));
                _jsonArray.get(_jsonArray.size() - 1).setFechaM
                                                        (rs.getDate("fecha"));
            
            }
            _resp = _gson.toJson(_jsonArray);
            return _resp;
        }
        catch(SQLException e) {
            _logger.log(Level.SEVERE, "Error de Conexion con BD: {0}", 
                    e.getMessage());
            return null;
        }
        catch (ParameterNullException e) {
            _logger.log(Level.SEVERE, "Parametro Nulo: {0}", e.getMessage());
            return null;
        }
        finally {
            cerrarConexion( _conn );
        }
       
    }

    /**
     * Metodo para agregar medida en la base de datos
     * @param ent
     * @return 
     */
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
           _logger.log(Level.SEVERE, "Error de Conexion con BD: {0}", 
                   e.getMessage());
            return null;
        }
        catch (ParameterNullException e) {
            _logger.log(Level.SEVERE, "Parametro Nulo: {0}", e.getMessage());
            return null;
        }
        finally {
             cerrarConexion( _conn );
        }

    }

    /**
     * Metodo para actualizar medida en la base de datos
     * @param ent
     * @return 
     */
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
            _logger.log(Level.SEVERE, "Error de Conexion con BD: {0}",
                    e.getMessage());
            return null;
        }
        catch (ParameterNullException e) {
            _logger.log(Level.SEVERE, "Parametro Nulo: {0}", e.getMessage());
            return null;
        }
        finally {
            cerrarConexion(_conn);
        }
    }

    /**
     * Metodo para eliminar medida de la base de datos
     * @param ent
     * @return 
     */
    @Override
    public String eliminarMedida(Entidad ent) {
        try {
            _progresoMedida = (Progreso_Medida) ent;
            
            _conn = getConexion();
            
            String _query = "SELECT fo_m04_elimina_medidas("+
                    _progresoMedida.getId()+",'"+
                    _progresoMedida.getTipo()+"')";
            
            PreparedStatement _st = _conn.prepareStatement(_query);
            
            _st.executeQuery();
            
            return "Medida Eliminar";
        } catch (SQLException e){
            _logger.log(Level.SEVERE, "Error de Conexion con BD: {0}", 
                    e.getMessage());
            return null;
        }
        catch (ParameterNullException e) {
            _logger.log(Level.SEVERE, "Parametro Nulo: {0}", e.getMessage());
            return null;
        }
        finally {
            cerrarConexion(_conn);
        }
    }

    /**
     * Metodo para obtener Medidas Anuales de la base de datos
     * @param progreso_Medida
     * @param fechaini
     * @param fechafin
     * @return 
     */
    @Override
    public ArrayList<Progreso_Medida> getMedidasAnuales
        (Progreso_Medida progreso_Medida, String fechaini, String fechafin) {
        try {
            _conn = getConexion();
            
            String _query = "select * from m04_get_medidas_ano('"+
                            progreso_Medida.getSobrenombre()+"','"+fechaini
                            +"','"+fechafin+"')";
            
            PreparedStatement _st = _conn.prepareStatement(_query);
            
            ResultSet _rs;
            
            for(int i=1; i<=11; i++)
            {
                _rs = _st.executeQuery();
                _jsonArray.add(new Progreso_Medida());
                if(_rs.wasNull()){
                    _jsonArray.get(_jsonArray.size() - 1).setMedida(0);
                    _jsonArray.get(_jsonArray.size() - 1).setFechaM
                                                        (Date.valueOf(fechaini));
                }else{
                    while (_rs.next()) {
                        _jsonArray.get(_jsonArray.size() - 1).setMedida
                                                        (_rs.getInt("medida"));
                        _jsonArray.get(_jsonArray.size() - 1).setFechaM
                                                    (Date.valueOf(fechaini));
                    }
                }
            }
            return _jsonArray;
        } catch (SQLException e){
            _logger.log(Level.SEVERE, "Parametro Nulo: {0}", e.getMessage());
            return null;
        }
        catch (ParameterNullException e) {
            _logger.log(Level.SEVERE, "Parametro Nulo: {0}", e.getMessage());
            return null;
        }
        finally {
            cerrarConexion(_conn);
        }
    }
}
    

