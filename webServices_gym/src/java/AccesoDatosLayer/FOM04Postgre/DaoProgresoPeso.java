/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.FOM04Postgre;

import AccesoDatosLayer.DaoPostgre;
import Comun.Dominio.Entidad;
import Comun.Dominio.Progreso_Peso;
import Comun.Excepciones.FO4.AgregarPesoExcepcion;
import Comun.Excepciones.ParameterNullException;
import Comun.Util.CompararProgreso;
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
 * @author Elberg
 */
public class DaoProgresoPeso extends DaoPostgre implements IDaoProgresoPeso{
    private Connection _conn;
    private String _resp;
    private Gson _gson = new Gson();
    private ArrayList<Progreso_Peso> _jsonArray;
    private Entidad _progresoPeso;
    private ArrayList<Progreso_Peso> _aux;
    ConfigurarLogger _cl;
    Logger _logger;
    
    /**
     * Constructor de Dao Progreso Peso
     */
    public DaoProgresoPeso(){
        _cl = new ConfigurarLogger();
         _logger = _cl.getLogr();
    }
    
    /**
     * Metodo Para acceder a la BD que consulta el progreso del peso
     * @param ent
     * @return 
     */
    @Override
    public Entidad consultar(Entidad ent) {
        return null;
    }

    /**
     * Realiza la consulta a la bd y usa el stored procedure para el 
     * prgreso del peso
     * @param id_usuario
     * @return ArrayList del tipo progreso_peso 
     */
    @Override
    public String consultarProgresoPeso(int id_usuario) {
       try{
           _conn = getConexion();
            String query = "SELECT * FROM fo_m04_get_progresop(?)";
            _jsonArray = new ArrayList<>();
            PreparedStatement st = _conn.prepareStatement(query);
            st.setInt( 1 , id_usuario );
            ResultSet rs = st.executeQuery();
            
            while( rs.next() ){
                _jsonArray.add( new Progreso_Peso() );
                _jsonArray.get( _jsonArray.size() - 1 ).setPeso
                                                        ( rs.getInt( "peso" ) );
                _jsonArray.get( _jsonArray.size() - 1 ).setFechaP
                                                       (rs.getDate( "fecha" ) );
                _jsonArray.get( _jsonArray.size() - 1 ).setId
                                                        ( rs.getInt( "id" ) );
            }
            
            _aux = CompararProgreso.compararProgresoPeso( _jsonArray );
            _resp = _gson.toJson(_aux);
            return _resp;
        }
        catch ( SQLException e ) {
            _logger.log(Level.SEVERE, "Error con la conexion a BD: {0}", 
                    e.getMessage());
            return null;
        }
        finally {
            cerrarConexion( _conn );
        } 
    }

    /**
     * Conexion a la base de datos para agregar peso al usuario
     * @param _pp
     * @return 
     */
    @Override
    public String agregarPeso(Entidad _pp) {
         Progreso_Peso pp = (Progreso_Peso) _pp;
        try {
           
                _conn = getConexion();
                String query = "select * from fo_m04_insert_progresop(?,?);";
                PreparedStatement st = _conn.prepareStatement( query );
                st.setInt( 1 , pp.getId() );
                st.setInt( 2 , pp.getPeso() );
                st.executeQuery();
                
                return "PESO AGREGADO";
            
        }
        catch (SQLException e){
            //response.put( "error", e.getMessage() );
            _logger.log(Level.SEVERE, "Error con la conexion a BD: {0}",
                    e.getMessage());
            try {
                 AgregarPesoExcepcion _error = new AgregarPesoExcepcion(e,DaoProgresoPeso.class.getSimpleName(), e.getMessage());
                 throw _error;
             } catch (AgregarPesoExcepcion ex) {
                 Logger.getLogger(DaoProgresoPeso.class.getName()).log(Level.SEVERE, null, ex);
             }
            
        }
        catch(Exception e){
             try {
                 AgregarPesoExcepcion _error = new AgregarPesoExcepcion(e,DaoProgresoPeso.class.getSimpleName(), e.getMessage());
                 throw _error;
             } catch (AgregarPesoExcepcion ex) {
                 Logger.getLogger(DaoProgresoPeso.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
        finally {
            cerrarConexion( _conn );
            
        }
        return null;
    }

    /**
     * Metodo para eliminar el peso del usuario de la base de datos
     * @param id_usuario
     * @return 
     */
    @Override
    public String eliminarPeso(int id_usuario) {
        try{
            _conn = getConexion();
            String query = "SELECT fo_m04_elimina_progresop(?)";
            PreparedStatement st = _conn.prepareStatement( query );
            st.setInt( 1 , id_usuario);
            ResultSet rs = st.executeQuery();
            
            return "PESO ELIMINADO";
        }
        catch ( SQLException e ) {
            _logger.log(Level.SEVERE, "Error con la conexion a BD: {0}",
                    e.getMessage());
            return null;
        }
        catch ( ParameterNullException e ) {
            _logger.log(Level.SEVERE, "Parametro Nulo: {0}", e.getMessage());
            return null;
        }
        finally {
            cerrarConexion( _conn );
        }
    
    }

    /**
     * Metodo para actualizar peso en la base de datos
     * @param en
     * @return 
     */
    @Override
    public String actualizarPeso(Entidad en) {
        try {
            Progreso_Peso pp = (Progreso_Peso) en;
            _conn = getConexion();
            String query = "select * from fo_m04_act_progresop(?,?);";
            PreparedStatement st = _conn.prepareStatement( query );
            st.setInt( 1 , pp.getId() );
            st.setInt( 2 , pp.getPeso() );
            st.executeQuery();
            return "PESO ACTUALIZADO";
        }
        catch (SQLException e){
            _logger.log(Level.SEVERE, "Error con la conexion a BD: {0}",
                    e.getMessage());
            return null;
        }
        catch ( ParameterNullException e ) {
            _logger.log(Level.SEVERE, "Parametro Nulo: {0}", e.getMessage());
            return null;
        }
        finally {
            cerrarConexion( _conn );
        }
    
    }
 
}
