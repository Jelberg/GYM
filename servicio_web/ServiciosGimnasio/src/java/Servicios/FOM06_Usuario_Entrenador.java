
package Servicios;
import Dominio.Reserva;
import Dominio.Sql;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import Validaciones.ValidationWS;
import Excepciones.ParameterNullException;
import com.google.gson.reflect.TypeToken;
import java.lang.ProcessBuilder.Redirect.Type;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Map;
import javax.ws.rs.DELETE;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;


/**
 *
 * @author Luis L
 */
@Path("/FOM06_Usuario_Entrenador")
public class FOM06_Usuario_Entrenador {
    private Connection conn = Sql.getConInstance();
    //Atributo que se utiliza para transformar a formado JSON las consultas.
    private Gson gson = new Gson();
    private String response;
    private ArrayList<Reserva> jsonArray;
    
    /**
     * 
     * @param id_usu
     * @param id_ent
     * @return 
     */
    @POST
    @Path("/insertaUsuario_Entrenador")
    @Produces("application/json")
    public String insertaUsu_Ent(@QueryParam("id") int id_usu,
                                  @QueryParam ("id_ent")int id_ent){
    
        try{
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("id", id_usu);
                put("id_ent", id_ent);
                
            }});

            String query = "SELECT * FROM fo_m06_agregar_reserva(?)";
            jsonArray = new ArrayList<>();
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1,id_usu);
            st.setInt(2,id_ent);
            st.executeQuery();
            
        }
        catch(SQLException e) {
            response = e.getMessage();
        }
        catch (ParameterNullException e) {
            response = e.getMessage();
        }
        finally {
            Sql.bdClose(conn);
            return response;
        }   
    }   
}