/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FO4.TestDominio;

import Comun.Dominio.Progreso_Medida;
import java.sql.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elberg
 */
public class Progreso_MedidaTest {
    
    public Progreso_MedidaTest() {
    }

    @Test
    public void testGetIdtipo() {
        
        Progreso_Medida instance = new Progreso_Medida(1,11,1);
        int expResult = 1;
        int result = instance.getIdtipo();
        assertEquals(expResult, result);
       
    }

    @Test
    public void testSetIdtipo() {
      
        int _idtipo = 1;
        Progreso_Medida instance = new Progreso_Medida();
        instance.setIdtipo(_idtipo);
        assertEquals(1, instance.getIdtipo());
    }

    @Test
    public void testGetMedida() {
      
        Progreso_Medida instance = new Progreso_Medida(1,11,1);
        int expResult = 11;
        int result = instance.getMedida();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetMedida() {
       
        int _medida = 0;
        Progreso_Medida instance = new Progreso_Medida();
        instance.setMedida(_medida);
        assertEquals(0, instance.getIdtipo());
    }

    @Test
    public void testGetTipo() {
       
        Progreso_Medida instance = new Progreso_Medida(1,11,"Abdomen");
        String expResult = "Abdomen";
        String result = instance.getTipo();
        assertEquals(expResult, result);
     
    }

    @Test
    public void testSetTipo() {
        
        String _tipo = "Cuadricep";
        Progreso_Medida instance = new Progreso_Medida();
        instance.setTipo(_tipo);
        assertEquals("Cuadricep", instance.getTipo());
    }


    @Test
    public void testGetSobrenombre() {
      
        Progreso_Medida instance = new Progreso_Medida();
        String expResult = "MM";
        instance.setSobrenombre("MM");
        String result = instance.getSobrenombre();
        assertEquals(expResult, result);
     
    }

    @Test
    public void testSetSobrenombre() {
      
        String _sobrenombre = "SS";
        Progreso_Medida instance = new Progreso_Medida();
        instance.setSobrenombre(_sobrenombre);
        assertEquals("SS", instance.getSobrenombre());
    }
    
}
