/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FO4.TestDominio;

import Comun.Dominio.Progreso_Peso;
import java.sql.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elberg
 */
public class Progreso_PesoTest {
    
    public Progreso_PesoTest() {
    }

    @Test
    public void testGetPeso() {
       
        Progreso_Peso instance = new Progreso_Peso(1,20);
        int expResult = 20;
        int result = instance.getPeso();
        assertEquals(expResult, result);
       
    }

    @Test
    public void testSetPeso() {
     
        int _peso = 50;
        Progreso_Peso instance = new Progreso_Peso();
        instance.setPeso(_peso);
        assertEquals(50, instance.getPeso());
    }

    
}
