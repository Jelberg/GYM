/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FO4;


import FO4.TestAccesoDatos.TestDaoComentario;
import FO4.TestAccesoDatos.TestDaoMedida;
import FO4.TestAccesoDatos.TestDaoPeso;
import FO4.TestServicios.FOM04Comentario;
import FO4.TestServicios.FOM04Medida;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 *
 * @author Elberg
 */

@RunWith(Suite.class)
@Suite.SuiteClasses(
    { TestDaoPeso.class,
    TestDaoMedida.class,
    TestDaoComentario.class,
    FOM04Comentario.class,
    FOM04Medida.class
    })

public class ComposicionTest {
}
