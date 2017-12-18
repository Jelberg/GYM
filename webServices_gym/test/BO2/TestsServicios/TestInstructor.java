package BO2.TestsServicios;

import AccesoDatosLayer.BO2.DaoInstructorPostgre;
import Comun.Dominio.Instructor;
import ServiciosLayer.BO2_Instructor;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import java.lang.String;

/**
 *
 * @author simon
 */
public class TestInstructor {
    
    BO2_Instructor _servicio = new BO2_Instructor();
    ArrayList<Instructor> _lista = new ArrayList<Instructor>();
    Gson _gson = new Gson();
    
    private DaoInstructorPostgre _DaoInstructor = new DaoInstructorPostgre();
    
    private Instructor _instructor;
    private String _fechanacimiento = "12/12/1999";
    
    
    public TestInstructor(){
        try {
            //Usuario que servirá para las pruebas.
            SimpleDateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sourceFormat.parse(_fechanacimiento);
            _instructor = new Instructor("nombre", "apellido", date, "M", "a@gmail.com");
        } catch (ParseException ex) {
            Logger.getLogger(TestInstructor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void getInstructores(){
        
        _lista = _gson.fromJson(_servicio.getListInstructor(), _lista.getClass());
        assertNotNull(_lista);
    }
    
    @Test
    public void insertarUsuario(){
        _lista = _gson.fromJson(_servicio.getListInstructor(), _lista.getClass());
        int sizeInicial = _lista.size();
        
        _servicio.RegistrarInstructor(_instructor.getNombre(),
                _instructor.getApellido(), _fechanacimiento,
                _instructor.getSexo(), _instructor.getCorreo());
        
        _lista = _gson.fromJson(_servicio.getListInstructor(), _lista.getClass());
        int sizeFinal = _lista.size();
        
        _DaoInstructor.eliminar(_instructor.getCorreo());
        
        assertEquals(sizeInicial+1, sizeFinal);
    }
    
    @Test
    public void getInstructorPorCorreo(){
        
        _servicio.RegistrarInstructor(_instructor.getNombre(),
                _instructor.getApellido(), _fechanacimiento,
                _instructor.getSexo(), _instructor.getCorreo());
        
        _lista = _gson.fromJson(_servicio.getInstructor(_instructor.getCorreo()),
                _lista.getClass());
        
        _DaoInstructor.eliminar(_instructor.getCorreo());
        
        assertEquals(1, _lista.size());
        
    }
    
    @Ignore
    @Test
    public void ActualizarInstructor(){
        
         _servicio.RegistrarInstructor(_instructor.getNombre(),
                _instructor.getApellido(), _fechanacimiento,
                _instructor.getSexo(), _instructor.getCorreo());
        
        _servicio.ActualizarInstructor("nombre1",
                _instructor.getApellido(), _fechanacimiento,
                _instructor.getSexo(), _instructor.getCorreo());
        
        _lista = _gson.fromJson(_servicio.getInstructor(_instructor.getCorreo()),
                _lista.getClass());
        
        _DaoInstructor.eliminar(_instructor.getCorreo());
        
        assertEquals(_lista.get(0).getNombre(), "nombre");
        
    }
    
    @Ignore
    @Test
    public void ActivarInstructor(){
        
       _servicio.RegistrarInstructor(_instructor.getNombre(),
                _instructor.getApellido(), _fechanacimiento,
                _instructor.getSexo(), _instructor.getCorreo()); 
       
       _servicio.InactivarInstructor(_instructor.getCorreo());
       _servicio.ActivarInstructor(_instructor.getCorreo());
       
       _lista = _gson.fromJson(_servicio.getInstructor(_instructor.getCorreo()),
                _lista.getClass());
       
       _DaoInstructor.eliminar(_instructor.getCorreo());
       
       assertEquals("si", _lista.get(0).getActivo());
        
    }
    
    @Ignore
    @Test
    public void InactivarInstructor(){
        
       _servicio.RegistrarInstructor(_instructor.getNombre(),
                _instructor.getApellido(), _fechanacimiento,
                _instructor.getSexo(), _instructor.getCorreo()); 
       
       _servicio.ActivarInstructor(_instructor.getCorreo());
       _servicio.InactivarInstructor(_instructor.getCorreo());
       
       _lista = _gson.fromJson(_servicio.getInstructor(_instructor.getCorreo()),
                _lista.getClass());
       
       _DaoInstructor.eliminar(_instructor.getCorreo());
       
       assertEquals("no", _lista.get(0).getActivo());
        
    }

}
