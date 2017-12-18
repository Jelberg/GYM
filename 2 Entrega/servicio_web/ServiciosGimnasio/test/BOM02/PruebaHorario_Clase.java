/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOM02;

import Dominio.Horario_Clase;
import Dominio.Sql;
import Servicios.BOM02_Horario_Clase;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author YESIMAR
 */
public class PruebaHorario_Clase {
    Sql _conn;
    ResultSet _rs;
    BOM02_Horario_Clase _horario_ClaseServicios;
    Horario_Clase _horario_ClaseDominio;
    ArrayList<Horario_Clase> _arrayHorario_Clase;
    
    @Before
    public void comenzarPrueba() {
        _conn = new Sql();
        String insertHorario_Clase = "INSERT INTO HORARIO_CLASE ( hc_id, hc_fecha, hc_dia, hc_capacidad,"
                + "hc_hora_inicio, hc_hora_fin, hc_status, hc_duracion, fk_usuario, fk instructor, fk_clase ) "
                + "VALUES (9999,'11-11-2017', 'lunes', 9999, '12:00:00', '12:00:00', 'A', null, null, null, null)";
        
        try {
            _rs = _conn.sql ( insertHorario_Clase );  
            _conn = new Sql();
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (Exception e){}
    }
    
    //Prueba de Consulta
//    @Test
//    public void pruebaConsultaHorario_Clase(){
//        Gson gson = new Gson();
//        _horario_ClaseServicios = new BOM02_Horario_Clase();
//        String respuesta = _horario_ClaseServicios.getHorario_Clase( "Yoga" );
//        _arrayHorario_Clase = new ArrayList<>();
//        _arrayHorario_Clase = gson.fromJson( respuesta, new TypeToken<List<Horario_Clase>>(){}.getType());
//        assertEquals( "Yoga" , _arrayHorario_Clase.get(0).getNombreclase() );
//    }
    
    //Prueba de Inserción
    @Test
    public void pruebaInsertaHorario_Clase(){
        Gson gson = new Gson();
        String fecha = "2017-11-11";
        String tiempo ="12:00:00";
        _horario_ClaseServicios = new BOM02_Horario_Clase();
        String respuesta = _horario_ClaseServicios.insertaHorario_Clase( Date.valueOf(fecha) , "lunes",9999,Time.valueOf(tiempo),Time.valueOf(tiempo),'A',9999,9999,9999);
        assertNotNull( respuesta );
    }
    
    //Prueba de Modificación
    @Test
    public void pruebaModificaHorario_Clase(){
        Gson gson = new Gson();
        String fecha = "2017-11-11";
        String tiempo ="12:00:00";
        _horario_ClaseServicios = new BOM02_Horario_Clase();
        String respuesta = _horario_ClaseServicios.modificaHorario_Clase(9999,9999,Date.valueOf(fecha), "lunes",9999,Time.valueOf(tiempo),Time.valueOf(tiempo));
        assertNotNull( respuesta );
    }
    
    //Prueba de Eliminación
    @Test
    public void pruebaEliminaHorario_Clase(){
        Gson gson = new Gson();
        String fecha = "2017-11-11";
        String tiempo ="12:00:00";
        _horario_ClaseServicios = new BOM02_Horario_Clase();
        String respuesta = _horario_ClaseServicios.eliminaHorario_Clase( 9999,9999,Date.valueOf(fecha), "lunes",9999,Time.valueOf(tiempo),Time.valueOf(tiempo) );
        assertNotNull( respuesta );
    }
    
    @After
    public void terminarPrueba(){
        String query = "SELECT bo_m02_elimina_horario_clase(9999,9999,'11-11-2017','lunes',9999,'12:00:00','12:00:00')";
        
        try {
            _rs = _conn.sql( query );
            _conn = new Sql();
            query = "DELETE FROM HORARIO_CLASE where (fk_Clase=9999 and fk_Instructor=9999 and hc_fecha='11-11-2017' and hc_dia='lunes' and hc_capacidad=9999"
                    + "and hc_hora_inicio='12:00:00' and hc_hora_fin='12:00:00')";
            _rs = _conn.sql( query );
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (Exception e){}   
    }
    
}
