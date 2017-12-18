/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FO4;


import FO4.TestAccesoDatos.TestDaoMedida;
import FO4.TestAccesoDatos.TestDaoPeso;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 *
 * @author Elberg
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({ TestDaoPeso.class,
                      TestDaoMedida.class})

public class ComposicionTest {
}
