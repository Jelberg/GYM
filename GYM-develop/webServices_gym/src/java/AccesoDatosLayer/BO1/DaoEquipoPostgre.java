/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.BO1;
import AccesoDatosLayer.Dao;
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
    public DaoEquipoPostgre() {}
    
    @Override
    public Entidad consultar(Entidad ent) {
        return ent;
    }

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
    
    @Override
    public Entidad consultarEquipoPorId(int id) {
        try{
            _conn = super.getConexion();
            String query = "SELECT equ_id, equ_nombre FROM equipo WHERE equ_id = " + id + ";";
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

    @Override
    public Entidad eliminar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entidad agregar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entidad actualizar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
