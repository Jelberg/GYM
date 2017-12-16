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

/**
 *
 * @author Elberg
 */
public class DaoProgresoPeso extends DaoPostgre implements IDaoProgresoPeso{
    private Connection _conn;
    private String response;
    private ArrayList<Progreso_Peso> jsonArray;
    private Entidad _progresoPeso;
    
    
    /**
     * Metodo Para acceder a la BD que consulta el progreso del peso
     * @param ent
     * @return 
     */
    @Override
    public Entidad consultar(Entidad ent) {
      
    }

    @Override
    public Entidad consultarProgresoPeso(int id_usuario) {
       try{
            
             
            String query = "SELECT * FROM fo_m04_get_progresop(?)";
            jsonArray = new ArrayList<>();
            PreparedStatement st = _conn.prepareStatement(query);
            st.setInt( 1 , id_usuario );
            ResultSet rs = st.executeQuery();
            
            while( rs.next() ){
                jsonArray.add( new Progreso_Peso() );
                jsonArray.get( jsonArray.size() - 1 ).setPeso( rs.getInt( "peso" ) );
                jsonArray.get( jsonArray.size() - 1 ).setFechaP(rs.getDate( "fecha" ) );
                jsonArray.get( jsonArray.size() - 1 ).setId( rs.getInt( "id" ) );
            }
            ArrayList<Progreso_Peso> aux;
            aux = CompararProgreso.compararProgresoPeso( jsonArray );
            
        }
        catch ( SQLException e ) {
            response = e.getMessage();
        }
        finally {
            Dao.closePostgreConnection(_conn);
        } 
    }
 
}
