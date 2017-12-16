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
import Comun.Util.CompararProgreso;
import Comun.Validaciones.ValidationWS;
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
public class DaoProgresoPeso extends DaoPostgre implements IDaoProgresoPeso{
    private Connection _conn;
    private ArrayList<Progreso_Peso> _jsonArray;
    private Entidad _progresoPeso;
    private ArrayList<Progreso_Peso> _aux;
    
    
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
     * Realiza la consulta a la bd y usa el stored procedure para el prgreso del peso
     * @param id_usuario
     * @return ArrayList del tipo progreso_peso 
     */
    @Override
    public ArrayList<Progreso_Peso> consultarProgresoPeso(int id_usuario) {
       try{
           _conn = Dao.getPostgreBdConnect();
            String query = "SELECT * FROM fo_m04_get_progresop(?)";
            _jsonArray = new ArrayList<>();
            PreparedStatement st = _conn.prepareStatement(query);
            st.setInt( 1 , id_usuario );
            ResultSet rs = st.executeQuery();
            
            while( rs.next() ){
                _jsonArray.add( new Progreso_Peso() );
                _jsonArray.get( _jsonArray.size() - 1 ).setPeso( rs.getInt( "peso" ) );
                _jsonArray.get( _jsonArray.size() - 1 ).setFechaP(rs.getDate( "fecha" ) );
                _jsonArray.get( _jsonArray.size() - 1 ).setId( rs.getInt( "id" ) );
            }
            
            _aux = CompararProgreso.compararProgresoPeso( _jsonArray );
            
        }
        catch ( SQLException e ) {
            
        }
        finally {
            Dao.closePostgreConnection(_conn);
            return _aux;
        } 
    }

    /**
     * Conexion a la base de datos para agregar peso al usuario
     * @return 
     */
    @Override
    public String agregarPeso(Entidad _pp) {
         Progreso_Peso pp = (Progreso_Peso) _pp;
        try {
           
                _conn = Dao.getPostgreBdConnect();
                String query = "select * from fo_m04_insert_progresop(?,?);";
                PreparedStatement st = _conn.prepareStatement( query );
                st.setInt( 1 , pp.getId() );
                st.setInt( 2 , pp.getPeso() );
                st.executeQuery();
                
                return "PESO AGREGADO";
            
        }
        catch (SQLException e){
            //response.put( "error", e.getMessage() );
            return null;
        }
        
        finally {
            Dao.closePostgreConnection(_conn);
            
        }
        
    }
 
}
