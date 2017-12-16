/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOM01;

import Dominio.Ejercicio;
import Dominio.Sql;
import Servicios.BOM01_Ejercicios;
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
 * @author Daniel Goncalves
 */
public class PruebaEjercicio {
     Sql _conn;
    ResultSet _rs;
    BOM01_Ejercicio _claseServicios;
    Ejercicio _Ejercicio;
    ArrayList<Ejercicio> _arrayEnt;
    
    @Before
    public void comenzarPrueba() {
        _conn = new Sql();
        String insertarEjercicio = "INSERT INTO EJERCICIO (EJE_ID, EJE_NOMBRE, EJE_GRUPO_MUSCULAR) "
                + "VALUES (9999,'Pullup','Biceps')";
        
        try {
            _rs = _conn.sql ( insertarEjercicio );  
            _conn = new Sql();
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (Exception e){}
    }
        
    @Test
    public void pruebaInsertarEjercicio(){
        Gson gson = new Gson();
        _claseServicios = new BOM01_Ejercicio();
        String respuesta;
         respuesta = _claseServicios.insertarEjercicio("Pullup","Biceps");
        assertNotNull( respuesta );
    }
    
    @Test
    public void pruebaModificarEjercicio(){
        Gson gson = new Gson();
        _claseServicios = new BOM01_Ejercicio();
        String respuesta;
         respuesta = _claseServicios.actualizaInstruct("Pullup","Biceps");
        assertNotNull( respuesta );
    }
    
 
    @Test
    public void pruebaEliminarEjercicio(){
        Gson gson = new Gson();
        _claseServicios = new BOM01_Ejercicio();
        String respuesta = _claseServicios.eliminarEjercicio("Pullup");
        assertNotNull( respuesta );
    }
    
    @After
    public void terminarPrueba(){
        String query = "SELECT bo_m01_eliminar_ejercicio('Pullup')";
        
        try {
            _rs = _conn.sql( query );
            _conn = new Sql();
            query = "DELETE FROM EJERCICIO where eje_nombre = 'Pullup'";
            _rs = _conn.sql( query );
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (Exception e){}   
    }
}
