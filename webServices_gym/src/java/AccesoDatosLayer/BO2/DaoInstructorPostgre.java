package AccesoDatosLayer.BO2;

import AccesoDatosLayer.Dao;
import AccesoDatosLayer.DaoPostgre;
import Comun.Dominio.Entidad;
import Comun.Dominio.Instructor;
import Comun.Excepciones.ParameterNullException;
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
 * @author simon
 */
public class DaoInstructorPostgre extends DaoPostgre implements IDaoInstructor{

    private Connection _conn;
    private ArrayList<Instructor> jsonArray;
    
    public DaoInstructorPostgre() {}
    
    @Override
    public ArrayList<Instructor> getInstructores() {
         try{
            _conn = Dao.getPostgreBdConnect();
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
    public void insertar(Instructor i) {
        try {
            _conn = Dao.getPostgreBdConnect();       
            
            String query = "select * from bo_m02_inserta_instructor('"+
                    i.getNombre()+"', '"+i.getApellido()+
                    "', '"+i.getFecha_nac()+"', '"+i.getSexo()+
                    "', '"+i.getCorreo()+"')";
            
            PreparedStatement st = _conn.prepareStatement(query); 

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
        }
    }

    @Override
    public void eliminar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public ArrayList<Instructor> getInstructorPorCorreo(String correo) {
        try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("correo", correo);
            }});
            
            _conn = Dao.getPostgreBdConnect();
            String query = "SELECT * FROM bo_m02_get_instructor( ? );";
            jsonArray = new ArrayList<>();
            PreparedStatement st = _conn.prepareStatement(query);
            st.setString(1, correo);
            ResultSet rs = st.executeQuery();
            
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                jsonArray.add(new Instructor());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("id"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("nombre"));
                jsonArray.get(jsonArray.size() - 1).setApellido(rs.getString("apellido"));
                jsonArray.get(jsonArray.size() - 1).setFecha_nac(rs.getDate("fechanac"));
                jsonArray.get(jsonArray.size() - 1).setSexo((rs.getString("sexo")));
                jsonArray.get(jsonArray.size() - 1).setCorreo(rs.getString("correo"));
                          
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch (ParameterNullException e) {
            e.printStackTrace();
        }
        finally {
            Dao.closePostgreConnection( _conn );
            return jsonArray;
        }
    }

    @Override
    public Entidad consultar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(String nombre, String apellido, String fecha, String sexo, String correo) {
          Map<String, String> response = new HashMap<String, String>();
        
          _conn = Dao.getPostgreBdConnect();
          
          try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("nombre", nombre );
                put("apellido", apellido );
                put("fechanac", fecha);
                put("sexo", sexo );
                put("correo", correo );
            }});
             String query = "select * from bo_m02_actualiza_instructor('"+nombre+"', '"+apellido+"', '"+fecha+"', '"+sexo+"', '"+correo+"')";
            PreparedStatement st = _conn.prepareStatement(query); 

                st.executeQuery();
            
            response.put("data", "Se actualizo el instructor");
        }
        catch (SQLException e){
            response.put("error", e.getMessage());
        }
        catch (ParameterNullException e) {
            response.put("error", e.getMessage());
        }
        finally {
            Dao.closePostgreConnection( _conn );
        }
    }

    
}
