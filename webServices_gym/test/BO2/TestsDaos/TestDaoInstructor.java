package BO2.TestsDaos;

import AccesoDatosLayer.BO2.DaoInstructorPostgre;
import AccesoDatosLayer.Dao;
import Comun.Dominio.Instructor;
import Comun.Excepciones.ParameterNullException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author simon
 */
public class TestDaoInstructor {
    
    private Connection _conn;
    private DaoInstructorPostgre _DaoInstructor = new DaoInstructorPostgre();
    private ArrayList<Instructor> _lista = new ArrayList<>();
    private Instructor _instructor;
    private String _fechanacimiento = "12/12/1999";
            
    @Before
    public void PrepararPrueba(){
        try{
            //Conexion a la BDD para hacer las pruebas
            _conn = _DaoInstructor.getConexion();
            
            //Limpiando la lista de instructores
            _lista.clear();
            
            _DaoInstructor.eliminar("a@gmail.com");
            //Creando un instructor para las pruebas
            SimpleDateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sourceFormat.parse(_fechanacimiento);
            _instructor = new Instructor("nombre", "apellido", date, "M", "a@gmail.com");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * Prueba la busqueda exitosa de todos los instructores de la BDD
     */
    @Test
    public void TestGetInstructores(){
        _lista = _DaoInstructor.getInstructores();
        assertNotNull(_lista);
    }
    /**
     * Se comprueba el registro exitoso de un instructor.
     */
    @Test
    public void TestRegistrarInstructor(){
        _DaoInstructor.insertar(_instructor);
        _lista = _DaoInstructor.getInstructorPorCorreo("a@gmail.com");
        _DaoInstructor.eliminar("a@gmail.com");
        String correo = _lista.get(0).getCorreo();
        assertEquals("a@gmail.com", correo);
    }
    
    /**
     * Prueba que dos instructores no puedan tener el mismo correo.
     * El correo es UNIQUE en la BDD por lo que en DaoPostgre se
     * captura un SqlException.
     */
    @Test
    public void InstructorRepetido(){
        _DaoInstructor.insertar(_instructor);
        
        //Segundo instructor con el mismo correo. 
        _DaoInstructor.insertar(_instructor);
        
        _lista = _DaoInstructor.getInstructorPorCorreo("a@gmail.com");
        // Solo hay 1 con la direccion "a@gmail.com"
        assertEquals(1, _lista.size());
    }
    
    
}
