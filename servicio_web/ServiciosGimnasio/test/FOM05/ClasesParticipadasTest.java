
package FOM05;

import Dominio.ClasesParticipadas;
import java.sql.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elberg
 */
public class ClasesParticipadasTest {
    
    public ClasesParticipadasTest() {
    }

    @Test
    public void testGetIdHc() {
      
        ClasesParticipadas instance = new ClasesParticipadas();
        int expResult = 0;
        int result = instance.getIdHc();
        assertEquals(expResult, result);
       
    }

    @Test
    public void testSetIdHc() {
    
        int _idHc = 0;
        ClasesParticipadas instance = new ClasesParticipadas();
        instance.setIdHc(_idHc);
    
    }

    @Test
    public void testGetNombreIns() {
       
        ClasesParticipadas instance = new ClasesParticipadas();
        String expResult = "";
        String result = instance.getNombreIns();
        assertEquals(expResult, result);
      
    }

    @Test
    public void testSetNombreIns() {
     
        String _nombreIns = "";
        ClasesParticipadas instance = new ClasesParticipadas();
        instance.setNombreIns(_nombreIns);
        
    }

    @Test
    public void testGetApellidoIns() {
        
        ClasesParticipadas instance = new ClasesParticipadas();
        String expResult = "";
        String result = instance.getApellidoIns();
        assertEquals(expResult, result);
       
    }

    @Test
    public void testSetApellidoIns() {
       
        String _apellidoIns = "";
        ClasesParticipadas instance = new ClasesParticipadas();
        instance.setApellidoIns(_apellidoIns);
      
    }

    @Test
    public void testGetFecha() {
       
        ClasesParticipadas instance = new ClasesParticipadas();
        Date expResult = null;
        Date result = instance.getFecha();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetFecha() {
     
        Date _fecha = null;
        ClasesParticipadas instance = new ClasesParticipadas();
        instance.setFecha(_fecha);
        
    }

    @Test
    public void testGetNombreClase() {
       
        ClasesParticipadas instance = new ClasesParticipadas();
        String expResult = "";
        String result = instance.getNombreClase();
        assertEquals(expResult, result);
     
    }

    @Test
    public void testSetNombreClase() {
        
        String _nombreClase = "";
        ClasesParticipadas instance = new ClasesParticipadas();
        instance.setNombreClase(_nombreClase);
      
    }
    
}
