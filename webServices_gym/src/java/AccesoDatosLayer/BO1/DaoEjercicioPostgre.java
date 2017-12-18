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
    public String response;
    public DaoEjercicioPostgre() {}
    
    @Override
    public Entidad consultar(Entidad ent) {
        return ent;
    }

    @Override
    public Entidad eliminar(Entidad ent) {
        Ejercicio _ent = (Ejercicio) ent;
        try{
            _conn = getConexion();
            String query = "SELECT bo_m01_eliminar_ejercicio(?)";
            PreparedStatement st = _conn.prepareStatement( query );
            st.setInt( 1 , _ent.getId());
            ResultSet rs = st.executeQuery();
            //response.put("Se ha eliminado un ejercicio");
            
        }
        catch ( SQLException e ) {
            return null;
        }
        catch ( ParameterNullException e ) {
            return null;
        }
        finally {
            cerrarConexion( _conn );
            return null;
        }
    
    }
    

    @Override
    public Entidad modificar(Entidad ent) {
       try {
            Ejercicio ejercicio = (Ejercicio) ent;
            _conn = getConexion();
            String query = "select * from fo_m04_act_progresop(?,?);";
            PreparedStatement st = _conn.prepareStatement( query );
            st.setInt( 1 , ejercicio.getId() );
            st.setString( 2 , ejercicio.getNombre() );
            st.setString(3, ejercicio.getGrupoMuscular());
            st.executeQuery();
        }
        catch (SQLException e){
            return null;
        }
        catch ( ParameterNullException e ) {
            return null;
        }
        finally {
            cerrarConexion( _conn );
            return null;
        }
    }

    @Override
    public ArrayList<Ejercicio> consultarEjercicios() {
        try{
            _conn = super.getConexion();
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
            super.cerrarConexion(_conn);
            return jsonArray;
        }
    }

    @Override
    public Entidad consultarID(int id) {
        try{
            _conn = super.getConexion();
            String query = "SELECT eje_id, eje_nombre, eje_grupo_muscular FROM ejercicio WHERE eje_id = " + id + ";";
            PreparedStatement st = _conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            //Verifico si ResultSet esta lleno
            if(rs.first())
            {
                super.cerrarConexion(_conn );
                return(new Ejercicio(rs.getInt("EJE_ID"),rs.getString("EJE_NOMBRE"),rs.getString("EJE_GRUPO_MUSCULAR")));                       
            }            
        }
        catch(SQLException e) {
            
        }
        catch (ParameterNullException e) {
        }
        finally {
            super.cerrarConexion(_conn );
            return null;
        }
    } 

    @Override
    public Entidad agregar(Entidad _ent) {
        Ejercicio ent = (Ejercicio) _ent; 
        try {
            _conn = super.getConexion();       
            
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
            super.cerrarConexion(_conn );
            return null;
        }
    
    }
}

    
