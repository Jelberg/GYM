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
import javax.ws.rs.PUT;

/**
 *
 * @author Daniel Goncalves
 */
public class DaoEjercicioPostgre extends DaoPostgre implements IDaoEjercicio{
    private Connection _conn;
    private ArrayList<Ejercicio> jsonArray;
    public String response;
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

    @Override
    public Entidad consultarID(int id) {
        try{
            _conn = Dao.getPostgreBdConnect();
            String query = "SELECT eje_id, eje_nombre, eje_grupo_muscular FROM ejercicio WHERE eje_id = " + id + ";";
            PreparedStatement st = _conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            //Verifico si ResultSet esta lleno
            if(rs.first())
            {
                Dao.closePostgreConnection( _conn );
                return(new Ejercicio(rs.getInt("EJE_ID"),rs.getString("EQU_NOMBRE"),rs.getString("EJE_GRUPO_MUSCULAR")));                       
            }            
        }
        catch(SQLException e) {
            
        }
        catch (ParameterNullException e) {
        }
        finally {
            Dao.closePostgreConnection( _conn );
            return null;
        }
    } 

    @Override
    public Entidad agregar(Entidad _ent) {
        Ejercicio ent = (Ejercicio) _ent; 
        try {
            _conn = Dao.getPostgreBdConnect();       
            
            String query = "select * bo_m01_insertar_ejercicio(?,?,?);";
            PreparedStatement st = _conn.prepareStatement( query );
                st.setInt( 1 , ent.getId() );
                st.setString( 2 , ent.getNombre() );
                st.setString( 3 , ent.getGrupoMuscular() );
                st.executeQuery();    
            
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        catch (ParameterNullException e) {
            System.out.println(e.getMessage());
        }
        finally {
            Dao.closePostgreConnection( _conn );
            return null;
        }
    
    }
}

    
