/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BOM02;

import Dominio.Entrenador;
import Dominio.Sql;
import Servicios.BOM02_Entrenador;
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
public class PruebaEntrenador {
     Sql _conn;
    ResultSet _rs;
    BOM02_Entrenador _claseServicios;
    Entrenador _Entrenador;
    ArrayList<Entrenador> _arrayEnt;
    
    @Before
    public void comenzarPrueba() {
        _conn = new Sql();
        String insertarEntrenador = "INSERT INTO ENTRENADOR (ent_id, ent_nombre, ent_apellido, ent_fecha_nac, ent_sexo, ent_correo, ent_historial, ent_foto ) "
                + "VALUES (9999,'Emilio','Romero','02/10/1990','M','earp@gmail.com','Crossfit',null )";
        
        try {
            _rs = _conn.sql ( insertarEntrenador );  
            _conn = new Sql();
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (Exception e){}
    }
    
    @Test
    public void pruebaConsultarEntrenador(){
        Gson gson = new Gson();
        _claseServicios = new BOM02_Entrenador();
        String respuesta = _claseServicios.getEntrenador( "earp@gmail.com" );
        _arrayEnt = new ArrayList<>();
        _arrayEnt = gson.fromJson( respuesta, new TypeToken<List<Entrenador>>(){}.getType());
        assertEquals( "earp@gmail.com" , _arrayEnt.get(0).getCorreo());
    }
    
    @Test
    public void pruebaInsertarEntenador(){
        Gson gson = new Gson();
        _claseServicios = new BOM02_Entrenador();
        String respuesta;
         respuesta = _claseServicios.insertarEntrenador("Emilio","Romero","02-10-1990","M","earp@gmail.com","Crossfit");
        assertNotNull( respuesta );
    }
    
    @Test
    public void pruebaModificarEntrenador(){
        Gson gson = new Gson();
        _claseServicios = new BOM02_Entrenador();
        String respuesta;
         respuesta = _claseServicios.actualizaInstruct("Emilio","Romero","02-10-1990","M","earp@gmail.com","Crossfit");
        assertNotNull( respuesta );
    }
    
 
    @Test
    public void pruebaEliminarEntrenador(){
        Gson gson = new Gson();
        _claseServicios = new BOM02_Entrenador();
        String respuesta = _claseServicios.eliminarEntrenador("earp@gmail.com");
        assertNotNull( respuesta );
    }
    
    @After
    public void terminarPrueba(){
        String query = "SELECT bo_m02_eliminar_entrenador('earp@gmail.com')";
        
        try {
            _rs = _conn.sql( query );
            _conn = new Sql();
            query = "DELETE FROM ENTRENADOR where ent_correo = 'earp@gmail.com'";
            _rs = _conn.sql( query );
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        catch (Exception e){}   
    }
}
