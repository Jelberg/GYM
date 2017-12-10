package AccesoDatosLayer.BO2;

import AccesoDatosLayer.Dao;
import AccesoDatosLayer.DaoPostgre;
import Comun.Dominio.Entidad;
import Comun.Dominio.Instructor;
import Comun.Excepciones.ParameterNullException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author simon
 */
public class DaoInstructorPostgre extends DaoPostgre implements IDaoInstructor{

    private Connection _conn;
    private ArrayList<Instructor> jsonArray;
    
    public DaoInstructorPostgre() {}
    
    @Override
    public ArrayList<Instructor> getInstructores() {
         try{
            
            String query = "SELECT * FROM instructor;";
            jsonArray = new ArrayList<>();
            PreparedStatement st = _conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                jsonArray.add(new Instructor());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("INS_ID"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("INS_NOMBRE"));
                jsonArray.get(jsonArray.size() - 1).setApellido(rs.getString("INS_APELLIDO"));
                jsonArray.get(jsonArray.size() - 1).setFecha_nac(rs.getDate("INS_FECHA_NAC"));
                jsonArray.get(jsonArray.size() - 1).setSexo((rs.getString("INS_SEXO")));
                jsonArray.get(jsonArray.size() - 1).setCorreo(rs.getString("INS_CORREO"));
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
    public Entidad consultar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
