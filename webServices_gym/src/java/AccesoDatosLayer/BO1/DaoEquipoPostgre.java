/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.BO1;

import AccesoDatosLayer.DaoPostgre;
import Comun.Dominio.Entidad;
import Comun.Dominio.Equipo;
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
public class DaoEquipoPostgre extends DaoPostgre implements IDaoEquipo{
    
    private Connection _conn;
    private ArrayList<Equipo> jsonArray;
    
    /**
     * Builder
     */
    public DaoEquipoPostgre() {}
    
    /**
     * Override Consultar Entidad de IDAO
     * @param ent
     * @return Entidad
     */
    @Override
    public Entidad consultar(Entidad ent) {
        return ent;
    }
    /**
     * Devuelve listado de Equipos
     * @return lista Equipos
     */
    @Override
    public ArrayList<Equipo> consultarEquipos() {
        try{
            _conn = super.getConexion();
            String query = "SELECT id, nombre FROM bo_m01_getallequipments;";
            jsonArray = new ArrayList<>();
            PreparedStatement st = _conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                jsonArray.add(new Equipo());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("id"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("nombre"));                         
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
    
    /**
     * Consulta Equipo por ID
     * @param id ID de Equipo a buscar
     * @return Entidad Objeto Resultado
     */
    @Override
    public Entidad consultarEquipoPorId(int id) {
        try{
            _conn = super.getConexion();
            String query = "SELECT equ_id, equ_nombre FROM bo_m01_getequipo(" + id + ");";
            PreparedStatement st = _conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            //Verifico si ResultSet esta lleno
            if(rs.first())
            {
                super.cerrarConexion(_conn);
                return(new Equipo(rs.getInt("EQU_ID"),rs.getString("EQU_NOMBRE")));                       
            }            
        }
        catch(SQLException e) {
            
        }
        catch (ParameterNullException e) {
        }
        finally {
            super.cerrarConexion(_conn);
            return null;
        }
    } 

    /**
     * Eliminar Equipo
     * @param ent Entidad a eliminar
     * @return Entidad Eliminada
     */
    @Override
    public Entidad eliminar(Entidad ent) {
        try{
            _conn = getConexion(); 
            String query = "SELECT * from bo_m01_eliminar_equipo("+ent.getId()+");";
            PreparedStatement st = _conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            ent.setMensaje( "Se ha eliminado correctamente." );
        }
        catch(SQLException e) {
            ent.setMensaje( "Error al insertar, intente de nuevo." );
        }
        catch (ParameterNullException e) {
        }
        finally {
              cerrarConexion( _conn );
              return ent;
        }
    }

    /**
     * Agregar Equipo
     * @param ent Entidad a agregar
     * @return Entidad agregada
     */
    @Override
    public Entidad agregar(Entidad ent) {
        try{
            String query = "select * from bo_m01_agregar_equipo(" +
                            ent.getId() + "," +
                            ent.getMensaje() + ");";
            _conn = getConexion();
            PreparedStatement st = _conn.prepareStatement(query); 
            st.executeQuery();
            ent.setMensaje( "Se ha agregado correctamente." );
        }
        catch(SQLException e) {
            ent.setMensaje( "Error al insertar, intente de nuevo." );
        }
        finally {
            cerrarConexion( _conn );
            return ent;
        }
    }

    /**
     * Actualizar Equipo
     * @param ent Equipo a actualizar
     * @return Equipo actualizado
     */
    @Override
    public Entidad actualizar(Entidad ent) {        
        try{
          String query = "select * from bo_m01_actualizar_equipo(" +
                          ent.getId() + "," +
                          ent.getMensaje() + ");";
          _conn = getConexion();
          PreparedStatement st = _conn.prepareStatement(query); 
          st.executeQuery();
          ent.setMensaje( "Se ha actualizado correctamente." );
        }
        catch(SQLException e) {
            ent.setMensaje( "Error al actualizar, intente de nuevo." );
        }
        finally {
          cerrarConexion( _conn );
          return ent;
        }
    }
}
