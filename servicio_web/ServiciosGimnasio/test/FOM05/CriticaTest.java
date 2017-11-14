
package FOM05;

import Dominio.Critica;
import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elberg
 */
public class CriticaTest {
    
    @Test
    public void testGetId() {
       
        Critica instance = new Critica();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
   
    }

    @Test
    public void testSetId() {
       
        int _id = 0;
        Critica instance = new Critica();
        instance.setId(_id);
    }

    
    @Test
    public void testGetFecha() {
       
        Critica instance = new Critica();
        Date expResult = null;
        Date result = instance.getFecha();
        assertEquals(expResult, result);
        
    }

    
    @Test
    public void testSetFecha() {
        
        Date _fecha = null;
        Critica instance = new Critica();
        instance.setFecha(_fecha);
     
    }

 
    @Test
    public void testGetComentario() {
    
        Critica instance = new Critica();
        String expResult = "";
        String result = instance.getComentario();
        assertEquals(expResult, result);
 
    }

 
    @Test
    public void testSetComentario() {
       
        String _comentario = "";
        Critica instance = new Critica();
        instance.setComentario(_comentario);
   
    }

 
    @Test
    public void testGetValoracion() {
       
        Critica instance = new Critica();
        int expResult = 0;
        int result = instance.getValoracion();
        assertEquals(expResult, result);
     
    }

    @Test
    public void testSetValoracion() {
        System.out.println("setValoracion");
        int _valoracion = 0;
        Critica instance = new Critica();
        instance.setValoracion(_valoracion);
       
    }

  
    @Test
    public void testGetReferenciaHc() {
        
        Critica instance = new Critica();
        int expResult = 0;
        int result = instance.getReferenciaHc();
        assertEquals(expResult, result);
      
    }

   
    @Test
    public void testSetReferenciaHc() {
      
        int _referenciaHc = 0;
        Critica instance = new Critica();
        instance.setReferenciaHc(_referenciaHc);
      
    }
    
}
