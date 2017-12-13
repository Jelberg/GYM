/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.BO1;

import AccesoDatosLayer.Dao;
import AccesoDatosLayer.DaoPostgre;
import AccesoDatosLayer.IDao;
import Comun.Dominio.Entidad;
import Comun.Dominio.Ejercicio;
import Comun.Excepciones.ParameterNullException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel Goncalves
 */
public class DaoEjercicioPostgre extends DaoPostgre implements IDaoEjercicio{
    private Connection _conn;
    private ArrayList<Ejercicio> jsonArray;
    public DaoEjercicioPostgre() {}
    
    @Override
    public Entidad consultar(Entidad ent) {
        return ent;
    }

    @Override
    public Entidad eliminar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entidad modificar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entidad actualizar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Ejercicio> consultarEjercicios() {
        try{
            _conn = Dao.getPostgreBdConnect();
            String query = "SELECT eje_id, eje_nombre, eje_grupo_muscular FROM ejercicio;";
            jsonArray = new ArrayList<>();
            PreparedStatement st = _conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                jsonArray.add(new Ejercicio());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("EJE_ID"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("EJE_NOMBRE"));
                jsonArray.get(jsonArray.size() - 1).setGrupoMuscular(rs.getString("EJE_GRUPO_MUSCULAR"));                          
            }
            
        }
        catch(SQLException e) {
            
        }
        catch (ParameterNullException e) {
        }
        finally {
            Dao.closePostgreConnection( _conn );
            return jsonArray;
        }
    }
}
