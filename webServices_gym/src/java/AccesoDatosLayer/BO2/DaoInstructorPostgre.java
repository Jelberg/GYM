package AccesoDatosLayer.BO2;

import Comun.Dominio.Instructor;
import Comun.Validaciones.ValidationWS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author simon
 */
public class DaoInstructorPostgre implements IDaoInstructor{

   // private Connection conn = Sql.getConInstance();
    
    @Override
    public void RegistrarInstructor(Instructor i) {
/*        Map<String, String> response = new HashMap<>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("nombre", i.getNombre() );
                put("apellido", i.getApellido() );
                put("fechanac", i.getFecha_nac());
                put("sexo", i.getSexo() );
                put("correo", i.getCorreo() );
            }});
            
            String query = "select * from bo_m02_inserta_instructor('"+i.getNombre()+"', '"+apellido+"', '"+fecha+"', '"+sexo+"', '"+correo+"')";
           // PreparedStatement st = conn.prepareStatement(query); 

                st.executeQuery();
            
            response.put("data", "Se inserto el instructor");
        }
        catch (SQLException e){
            response.put("error", e.getMessage());
        }
        catch (ParameterNullException e) {
            response.put("error", e.getMessage());
        }
        finally {
            Sql.bdClose(conn);
            return gson.toJson(response);
        }
*/
    }
    
}
