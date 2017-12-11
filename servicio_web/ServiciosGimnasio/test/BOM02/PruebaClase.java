/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOM02;

import Dominio.Sql;
import Servicios.BOM02_Clase;
import java.sql.ResultSet;
import Dominio.Clase;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author YESIMAR
 */
public class PruebaClase {
    Sql _conn;
    ResultSet _rs;
    BOM02_Clase _claseServicios;
    Clase _claseDominio;
    ArrayList<Clase> _arrayClase;
    
    @Before
    public void comenzarPrueba() {
        _conn = new Sql();
        String insertClase = "INSERT INTO CLASE ( cla_id, cla_nombre, cla_descripcion ) "
                + "VALUES (9999,'Yoga', 'Clase de relajación y meditación' )";
        
        try {
            _rs = _conn.sql ( insertClase );  
            _conn = new Sql();
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (Exception e){}
    }
    
    //Prueba de Consulta
    @Test
    public void pruebaConsultaClase(){
        Gson gson = new Gson();
        _claseServicios = new BOM02_Clase();
        String respuesta = _claseServicios.getClase( "Yoga" );
        _arrayClase = new ArrayList<>();
        _arrayClase = gson.fromJson( respuesta, new TypeToken<List<Clase>>(){}.getType());
        assertEquals( "Yoga" , _arrayClase.get(0).getNombre() );
    }
    
    //Prueba de Inserción
    @Test
    public void pruebaInsertaClase(){
        Gson gson = new Gson();
        _claseServicios = new BOM02_Clase();
        String respuesta = _claseServicios.insertaClase( "Yoga", "Clase de relajación y meditación" );
        assertNotNull( respuesta );
    }
    
    //Prueba de Modificación
    @Test
    public void pruebaModificaClase(){
        Gson gson = new Gson();
        _claseServicios = new BOM02_Clase();
        String respuesta = _claseServicios.modificaClase("Yoga", "Clase de relajación y meditación");
        assertNotNull( respuesta );
    }
    
    //Prueba de Eliminación
    @Test
    public void pruebaEliminaClase(){
        Gson gson = new Gson();
        _claseServicios = new BOM02_Clase();
        String respuesta = _claseServicios.eliminaClase( "Yoga" );
        assertNotNull( respuesta );
    }
    
    @After
    public void terminarPrueba(){
        String query = "SELECT bo_m02_elimina_clase('Yoga')";
        
        try {
            _rs = _conn.sql( query );
            _conn = new Sql();
            query = "DELETE FROM CLASE where cla_nombre = 'Yoga'";
            _rs = _conn.sql( query );
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (Exception e){}   
    }
      
}
