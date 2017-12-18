
package FOM05;

import Dominio.Critica;
import java.sql.Date;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Elberg
 */
public class CriticaTest {
    
    @Test
    public void testGetId() {
       
        Critica instance = new Critica();
        instance.setId(1);
        int result = instance.getId();
        assertEquals(1, result);
   
    }

    @Test
    public void testSetId() {
       
        int _id = 0;
        Critica instance = new Critica();
        instance.setId(_id);
        int result = instance.getId();
        assertEquals(0,result);
    }

    @Ignore
    @Test
    public void testGetFecha() {
       
        Critica instance = new Critica();
        instance.setFecha(Date.valueOf("12-12-12"));
        Date result = instance.getFecha();
        assertEquals(Date.valueOf("12-12-12"), result);
        
    }

    @Ignore
    @Test
    public void testSetFecha() {
        
        Date _fecha = Date.valueOf("12-12-12");
        Critica instance = new Critica();
        instance.setFecha(_fecha);
        Date result = instance.getFecha();
        assertEquals(_fecha, result);
     
    }

 
    @Test
    public void testGetComentario() {
    
        Critica instance = new Critica();
        instance.setComentario("HOLA");
        String result = instance.getComentario();
        assertEquals("HOLA", result);
 
    }

 
    @Test
    public void testSetComentario() {
       
        String _comentario = "hola";
        Critica instance = new Critica();
        instance.setComentario(_comentario);
        String result = instance.getComentario();
        assertEquals("hola", result);
    }

 
    @Test
    public void testGetValoracion() {
       
        Critica instance = new Critica();
        instance.setValoracion(3);
        int result = instance.getValoracion();
        assertEquals(3, result);
     
    }

    @Test
    public void testSetValoracion() {
        int _valoracion = 3;
        Critica instance = new Critica();
        instance.setValoracion(_valoracion);
        int result = instance.getValoracion();
        assertEquals(3, result);
    }

  
    @Test
    public void testGetReferenciaHc() {
        
        Critica instance = new Critica();
        instance.setReferenciaHc(0);
        int result = instance.getReferenciaHc();
        assertEquals(0, result);
      
    }

   
    @Test
    public void testSetReferenciaHc() {
      
        int _referenciaHc = 0;
        Critica instance = new Critica();
        instance.setReferenciaHc(_referenciaHc);
        assertEquals(_referenciaHc, instance.getReferenciaHc());
    }
    
}
