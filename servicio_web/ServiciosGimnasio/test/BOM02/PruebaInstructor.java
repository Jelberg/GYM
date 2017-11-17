/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOM02;

import Dominio.Instructor;
import Dominio.Sql;
import Servicios.BOM02_Instruct;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
 * @author Laura
 */
public class PruebaInstructor {
     Sql _conn;
    ResultSet _rs;
    BOM02_Instruct _claseServicios;
    Instructor _Instructor;
    ArrayList<Instructor> _arrayInstruct;
    
    @Before
    public void comenzarPrueba() {
        _conn = new Sql();
        String insertaInstruct = "INSERT INTO INSTRUCTOR (ins_id, ins_nombre, ins_apellido, ins_fecha_nac, ins_sexo, ins_correo, ins_foto ) "
                + "VALUES (9999,'Laura','Quinones','14/09/1992','F','lvqp.93@gmail.com','Yoga',null )";
        
        try {
            _rs = _conn.sql ( insertaInstruct );  
            _conn = new Sql();
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (Exception e){}
    }
    
    @Test
    public void pruebaConsultaInstruct(){
        Gson gson = new Gson();
        _claseServicios = new BOM02_Instruct();
        String respuesta = _claseServicios.getInstructor("lvqp.93@gmail.com" );
        _arrayInstruct = new ArrayList<>();
        _arrayInstruct = gson.fromJson( respuesta, new TypeToken<List<Instructor>>(){}.getType());
        assertEquals( "lvqp.93@gmail.com" , _arrayInstruct.get(0) .getCorreo());
    }
    
    @Test
    public void pruebaInsertaInstruct(){
        Gson gson = new Gson();
        _claseServicios = new BOM02_Instruct();
        String respuesta;
         respuesta = _claseServicios.insertaInstruct("Laura","Quinones","14-09-1993","F","lvqp.93@gmail.com");
        assertNotNull( respuesta );
    }
    
    @Test
    public void pruebaModificaInstruct(){
        Gson gson = new Gson();
        _claseServicios = new BOM02_Instruct();
        String respuesta;
        respuesta = _claseServicios.actualizaInstruct("Laura","Quinones","14-09-1993","F","lvqp.93@gmail.com");
        assertNotNull( respuesta );
    }
    
 
    @Test
    public void pruebaEliminaInstruct(){
        Gson gson = new Gson();
        _claseServicios = new BOM02_Instruct();
        String respuesta;
         respuesta = _claseServicios.eliminaInstruct("lvqp.93@gmail.com");
        assertNotNull( respuesta );
    }
    
    @After
    public void terminarPrueba(){
        String query = "SELECT bo_m02_elimina_instrutor('lvqp.93@gmail.com')";
        
        try {
            _rs = _conn.sql( query );
            _conn = new Sql();
            query = "DELETE FROM INSTRUCTOR where ins_correo = 'lvqp.93@gmail.com'";
            _rs = _conn.sql( query );
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (Exception e){}   
    }
}
