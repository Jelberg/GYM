/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.FO3;

import AccesoDatosLayer.DaoPostgre;
import Comun.Dominio.Entidad;
import Comun.Dominio.Rutina;
import Comun.Excepciones.ParameterNullException;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Elberg
 */
public class DaoRutina extends DaoPostgre implements IDaoRutina {
    private Connection _conn;
    private String _resp;
    private ArrayList<Rutina> jsonArray;
    private Gson gson = new Gson();
    
    @Override
    public Entidad consultar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String consultaEjerciciosRealizados(int id) {
         try{
                _conn = getConexion();   
                String query = "Select * from FO_M03_get_ejerciciosRealizados('"+id+"')";
                this.jsonArray = new ArrayList<>();
                Statement st = _conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                
                ArrayList<String> listaEjercicios = new ArrayList<String>();
                
                while( rs.next() )
                {
                    listaEjercicios.add( rs.getString("nombre") );                
                }
                return gson.toJson( listaEjercicios );
            }
            catch( SQLException e )
            {
                return e.getMessage();
            }
            catch ( ParameterNullException e ) 
            {
            return e.getMessage();
        }
        finally 
        {
            
            
        } 
    }
    
}
