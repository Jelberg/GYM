/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FO4;

import FO4.TestAccesoDatos.TestDaoPeso;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;


/**
 *
 * @author Elberg
 */
public class ComposicionTest extends TestCase{
    
    public ComposicionTest(String method){
        super(method);
    }
    
    // Se agregan las clases con los metodos 
   static public Test suite(){
       TestSuite suite = new TestSuite();
       suite.addTestSuite(TestDaoPeso.class);
       
       return (Test) suite; 
   }
}
