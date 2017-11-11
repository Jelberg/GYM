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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
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
                + "usu_apellido, usu_sexo, usu_fecha_nac ) VALUES (9999, 9999, "
                + "'Prueba', 'Prueba', 'M', '10-10-1994' )";
        String insertPeso = "INSERT INTO PROGRESO_PESO (pp_id, pp_peso, pm_fecha, "
                + "fk_usuario) VALUES ( 9999, 69, '2017-10-10', 9999)";
       
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
        String respuesta = _progresoPeso.getProgresoP( 9999);
        _arrayPeso = new ArrayList<>();
        _arrayPeso = gson.fromJson( respuesta, new TypeToken<List<Progreso_Peso>>(){}.getType());
        assertEquals( 69 , _arrayPeso.get(0).getPeso() );
    }
}
