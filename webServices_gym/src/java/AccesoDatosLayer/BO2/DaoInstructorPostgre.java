package AccesoDatosLayer.BO2;

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
import java.util.logging.Level;
import java.util.logging.Logger;

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
            _conn = getConexion();
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
            System.out.println(e);
        }
        catch (ParameterNullException e) {
            System.out.println(e);
        }
        finally {
            cerrarConexion( _conn );
            return jsonArray;
        }

    }
    
    @Override
    public void insertar(Instructor i) {
        try {
            _conn = getConexion();
            
            // Adaptando la fecha de nacimiento al formato usado en la BDD
            int dia = i.getFecha_nac().getDate();
            int mes = i.getFecha_nac().getMonth()+1;
            int año = i.getFecha_nac().getYear() + 1900;
            String fecha = String.valueOf(dia)+"/"+String.valueOf(mes)+"/"+String.valueOf(año);
            
            String query = "select * from bo_m02_inserta_instructor('"+
                    i.getNombre()+"', '"+i.getApellido()+
                    "', '"+fecha+"', '"+i.getSexo()+
                    "', '"+i.getCorreo()+"')";
            
            PreparedStatement st = _conn.prepareStatement(query); 

            st.executeQuery();
            
        }
        catch (SQLException e){
            System.out.println("########## INSTRUCTOR REPETIDO");
            System.out.println(e.getMessage());
        }
        finally {
            cerrarConexion( _conn );
        }
    }

    @Override
    public ArrayList<Instructor> getInstructorPorCorreo(String correo) {
        try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("correo", correo);
            }});
            
            _conn = getConexion();
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
                jsonArray.get(jsonArray.size() - 1).setActivo(rs.getString("activo"));
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        catch (ParameterNullException e) {
            e.printStackTrace();
        }
        finally {
            cerrarConexion( _conn );
            return jsonArray;
        }
    }
    
    @Override
    public void actualizar(String nombre, String apellido, String fecha, String sexo, String correo) {
          Map<String, String> response = new HashMap<String, String>();
        
          _conn = getConexion();
          
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
            cerrarConexion(_conn);
        }
    }

    @Override
    public void eliminar(String correo) {
        try{
            _conn = getConexion(); 
            String query = "SELECT * from bo_m02_elimina_instructor('"+correo+"')";
            PreparedStatement st = _conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
        }
        catch(SQLException e) {
        }
        catch (ParameterNullException e) {
        }
        finally {
              cerrarConexion( _conn );
        }
    }
    
    @Override
    public Entidad consultar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void activar(String correo) {
        _conn = getConexion();
        String query = "select * from bo_m02_activa_instructor('"+correo+"')";
        PreparedStatement st; 
        try {
            st = _conn.prepareStatement(query);
            st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DaoInstructorPostgre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void inactivar(String correo) {
        _conn = getConexion();
        String query = "select * from bo_m02_inactiva_instructor('"+correo+"')";
        PreparedStatement st; 
        try {
            st = _conn.prepareStatement(query);
            st.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DaoInstructorPostgre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
