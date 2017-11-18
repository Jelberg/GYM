/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FOM03;
import Dominio.Sql;
import Servicios.FOM03_Rutina;
import java.sql.ResultSet;
import Dominio.Clase;
import Dominio.Rutina;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
/**
 *
 * @author MinervaMorales
 */
public class TestRutina {
     Sql _conn;
    ResultSet _rs;
    FOM03_Rutina _rutinas;
    Rutina _rutina;
    ArrayList<Rutina> _arrayRutina;
    
    @Before
    public void testRutina() {
        _conn = new Sql();
        String insertRutina = "insert into Rutina ( rut_nombre, rut_dia,fk_usuario) "
                + "values ('Prueba','Sabado', 1 )";
        
        try {
            _rs = _conn.sql ( insertRutina );  
            _conn = new Sql();
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (Exception e){}
    }
    
        
    //Insertar Rutina
    @Test
    public void testSetRutina(){
        Gson gson = new Gson();
        _rutinas = new FOM03_Rutina();
        String result = _rutinas.setRutina(1, "Pecho", "Viernes");
        assertNotNull( result );
    }
    
    //Modificar Rutina
    @Test
    public void testModificarRutina(){
        Gson gson = new Gson();
       _rutinas = new FOM03_Rutina();
        String result = _rutinas.modificarRutina(1, "Pecho", "Viernes","Pecho","Sabado");
        assertNotNull(result);
    }
    
    //Eliminar Rutina
    @Test
    public void testEliminarRutina(){
        Gson gson = new Gson();
        _rutinas = new FOM03_Rutina();
        String result = _rutinas.eliminarRutina(1,"Prueba", "Sabado");
        assertNotNull( result );
    }
    
    @After
    public void terminarPrueba(){
        String query = "Select  from FO_M03_eliminar_rutina(1,'Pecho','Viernes')";
        
        try {
            _rs = _conn.sql( query );
            _conn = new Sql();
            query = "DELETE FROM Rutina where rut_nombre= 'Pecho' and rut_dia='Viernes'";
            _rs = _conn.sql( query );
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (Exception e){}   
    }
}
