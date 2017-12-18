
package FOM05;

import Dominio.ClasesParticipadas;
import java.sql.Date;
import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Elberg
 */
public class ClasesParticipadasTest {
    
   

    @Test
    public void testGetIdHc() {  
        ClasesParticipadas ins;
        ins = new ClasesParticipadas(2);
        assertEquals(2,ins.getIdHc());
       
    }

    @Test
    public void testSetIdHc() {
        ClasesParticipadas ins = new ClasesParticipadas();
        ins.setIdHc(2);
        int result = ins.getIdHc();
        assertEquals(2, result);
       
    }

    @Test
    public void testGetNombreIns() {
       
        ClasesParticipadas ins = new ClasesParticipadas("jessica");
        assertEquals("jessica", ins.getNombreIns());
      
    }

    @Test
    public void testSetNombreIns() {
     
        ClasesParticipadas ins = new ClasesParticipadas();
        ins.setNombreIns("jessica");
        String result = ins.getNombreIns();
        assertEquals("jessica", result);
    }

    @Test
    public void testGetApellidoIns() {
        
        ClasesParticipadas ins = new ClasesParticipadas();
        ins.setApellidoIns("elberg");
        String result = ins.getApellidoIns();
        assertEquals("elberg", result);
       
    }

    @Test
    public void testSetApellidoIns() {
       
        String _apellidoIns = "elberg";
        ClasesParticipadas ins = new ClasesParticipadas();
        ins.setApellidoIns(_apellidoIns);
        String result = ins.getApellidoIns();
        assertEquals(_apellidoIns, result);
      
    }

    @Ignore
    @Test
    public void testGetFecha() {
       
        ClasesParticipadas ins = new ClasesParticipadas(Date.valueOf("12-12-12"));
        assertEquals("12-12-12", ins.getFecha());
        
    }

    @Ignore
    @Test
    public void testSetFecha() {
     
        Date _fecha = Date.valueOf("12-12-12");
        ClasesParticipadas ins = new ClasesParticipadas();
        ins.setFecha(_fecha);
        Date result = ins.getFecha();
        assertEquals(_fecha, result);
        
    }

    @Test
    public void testGetNombreClase() {
       
        ClasesParticipadas ins = new ClasesParticipadas(1,"jessica","elberg",null,"yoga");
        assertEquals("yoga", ins.getNombreClase());
     
    }

    @Test
    public void testSetNombreClase() {
        
        ClasesParticipadas ins = new ClasesParticipadas();
        ins.setNombreClase("yoga");
        String result = ins.getNombreClase();
        assertEquals("yoga", result);
      
    }
    
}
