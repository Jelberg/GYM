/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FO4;


import FO4.TestAccesoDatos.TestDaoComentario;
import FO4.TestAccesoDatos.TestDaoMedida;
import FO4.TestAccesoDatos.TestDaoPeso;
import FO4.TestsComandos.PruebaComandoActualizarMedida;
import FO4.TestsComandos.PruebaComandoActualizarPeso;
import FO4.TestsComandos.PruebaComandoAgregarMedida;
import FO4.TestsComandos.PruebaComandoAgregarPeso;
import FO4.TestsComandos.PruebaComandoEliminarMedida;
import FO4.TestsComandos.PruebaComandoEliminarPeso;
import FO4.TestsComandos.PruebaComandoInsertarComentario;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 *
 * @author Elberg
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({ TestDaoPeso.class,
                      TestDaoMedida.class,PruebaComandoActualizarMedida.class,
                      PruebaComandoActualizarPeso.class,
                      PruebaComandoAgregarMedida.class,
                      PruebaComandoAgregarPeso.class,
                      PruebaComandoEliminarMedida.class,
                      PruebaComandoEliminarPeso.class,
                      PruebaComandoInsertarComentario.class,
                      TestDaoMedida.class,
                      TestDaoComentario.class})

public class ComposicionTest {
}
