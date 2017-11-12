/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FOM04;

import Dominio.Progreso_Peso;
import Dominio.Sql;
import Servicios.FOM04_Progreso_Peso;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author marvian
 */
public class PruebaPeso {
    
    Sql _conn;
    ResultSet _rs;
    FOM04_Progreso_Peso _progresoPeso;
    Progreso_Peso _progresoComparar;
    ArrayList<Progreso_Peso> _arrayPeso;
    
    @Before
    public void iniciarPruebas() {
        _conn = new Sql();
        String insertPersonaPrueba = "INSERT INTO USUARIO ( usu_id, usu_cedula, usu_nombre, "
                + "usu_apellido, usu_sexo, usu_fecha_nac ) VALUES (2222, 2222, "
                + "'Prueba', 'Prueba', 'M', '1994-10-10' )";
        String insertPeso = "INSERT INTO PROGRESO_PESO (pp_id, pp_peso, pm_fecha, "
                + "fk_usuario) VALUES ( 2222, 69, '2017-10-10', 2222)";
       
        try {
            _rs = _conn.sql ( insertPersonaPrueba );
            
            _conn = new Sql();
            _rs = _conn.sql( insertPeso);
            

        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (Exception e){}
    }
    
    @Test
    public void pruebaObtenerProgreso(){
        Gson gson = new Gson();
        _progresoPeso = new FOM04_Progreso_Peso();
        String respuesta = _progresoPeso.getProgresoP( 2222 );
        _arrayPeso = new ArrayList<>();
        _arrayPeso = gson.fromJson( respuesta, new TypeToken<List<Progreso_Peso>>(){}.getType());
        assertEquals( 69 , _arrayPeso.get(0).getPeso() );
    }
    
    @Test
    public void pruebaInsertaPeso(){
        Gson gson = new Gson();
        _progresoPeso = new FOM04_Progreso_Peso();
        String respuesta = _progresoPeso.insertaPeso( 2222, 67 );
        assertNotNull( respuesta );
    }
    
    @Test
    public void pruebaEliminaMedida(){
        Gson gson = new Gson();
        String fecha = "2012-10-12";
        _progresoPeso = new FOM04_Progreso_Peso();
        String respuesta = _progresoPeso.eliminaPeso(fecha, 2222 );
        assertNotNull( respuesta );
    }
    
    @After
    public void finalizarPruebas(){
        String query = "SELECT fo_m04_elimina_medidas(2222, '12-10-2012')";
        try {

            _rs = _conn.sql( query );
            _conn = new Sql();
            query = "DELETE FROM usuario where usu_id = 2222";
            _rs = _conn.sql( query );

        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (Exception e){}
        
    }
}

