/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FO4;


import FO4.TestAccesoDatos.TestDaoComentario;
import FO4.TestAccesoDatos.TestDaoMedida;
import FO4.TestAccesoDatos.TestDaoPeso;
import FO4.TestDominio.Progreso_MedidaTest;
import FO4.TestDominio.Progreso_PesoTest;
import FO4.TestExcepciones.TestAgregarPesoExcepcion;

import FO4.TestServicios.FOM04Comentario;
import FO4.TestServicios.FOM04Medida;
import FO4.TestServicios.FOM04Peso;

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

@Suite.SuiteClasses(
    { TestDaoPeso.class,
    TestDaoMedida.class,
    TestDaoComentario.class,
    FOM04Comentario.class,
    FOM04Medida.class,
    TestDaoPeso.class,
    TestDaoMedida.class,
    PruebaComandoActualizarMedida.class,
    PruebaComandoActualizarPeso.class,
    PruebaComandoAgregarMedida.class,
    PruebaComandoAgregarPeso.class,
    PruebaComandoEliminarMedida.class,
    PruebaComandoEliminarPeso.class,
    PruebaComandoInsertarComentario.class,
    TestDaoMedida.class,
    TestDaoComentario.class,
    TestAgregarPesoExcepcion.class,
    Progreso_MedidaTest.class,
    FOM04Peso.class,
    Progreso_PesoTest.class})


public class ComposicionTest {
}
