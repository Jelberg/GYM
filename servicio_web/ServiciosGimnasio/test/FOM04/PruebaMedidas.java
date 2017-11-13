/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FOM04;
import Dominio.Sql;
import com.google.gson.Gson;
import java.sql.ResultSet;
import org.junit.*;
import static org.junit.Assert.*;
import Servicios.FOM04_Progreso_Medida;
import Dominio.Progreso_Medida;
import com.google.gson.reflect.TypeToken;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author gilbert
 */
public class PruebaMedidas {
    Sql _conn;
    ResultSet _rs;
    FOM04_Progreso_Medida _progresoMedida;
    Progreso_Medida _progresoComparar;
    ArrayList<Progreso_Medida> _arrayMedidas;
    
    @Before
    public void iniciarPruebas() {
        _conn = new Sql();
        String insertPersonaPrueba = "INSERT INTO USUARIO ( usu_id, usu_cedula, usu_nombre, "
                + "usu_apellido, usu_sexo, usu_fecha_nac ) VALUES (9999, 9999, "
                + "'Prueba', 'Prueba', 'M', '1990-12-12' )";
        String insertMedida = "INSERT INTO PROGRESO_MEDIDA (pm_id, pm_medida, pm_fecha, "
                + "fk_usuario, fk_medida) VALUES ( 9999, 69, '2012-10-12', 9999, 4 )";
        
        try {
            _rs = _conn.sql ( insertPersonaPrueba );
            
            _conn = new Sql();
            _rs = _conn.sql( insertMedida );
            

        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (Exception e){}
    }
    @After
    public void finalizarPruebas(){
        String query = "SELECT fo_m04_elimina_medidas(9999, '2012-12-10')";
        try {

            _rs = _conn.sql( query );
            _conn = new Sql();
            query = "DELETE FROM usuario where usu_id = 9999";
            _rs = _conn.sql( query );

        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (Exception e){}
        
    }
    @Test
    public void pruebaObtenerProgreso(){
        Gson gson = new Gson();
        _progresoMedida = new FOM04_Progreso_Medida();
        String respuesta = _progresoMedida.getProgresoM( 9999 );
        _arrayMedidas = new ArrayList<>();
        _arrayMedidas = gson.fromJson( respuesta, new TypeToken<List<Progreso_Medida>>(){}.getType());
        assertEquals( "Cuadricep", _arrayMedidas.get(0).getTipo() );

    }
    @Test
    public void pruebaInsertaMedida(){
        Gson gson = new Gson();
        String fecha = "2012-11-12";
        _progresoMedida = new FOM04_Progreso_Medida();
        String respuesta = _progresoMedida.insertaMedidas(9999, 67, 4, fecha);
        assertNotNull( respuesta );
    }
    @Test
    public void pruebaEliminaMedida(){
        Gson gson = new Gson();
        String fecha = "2012-10-12";
        _progresoMedida = new FOM04_Progreso_Medida();
        String respuesta = _progresoMedida.eliminaMedidas(fecha, 9999);
        assertNotNull( respuesta );
    }
}
