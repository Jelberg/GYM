/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FO4.TestExcepciones;

import AccesoDatosLayer.FOM04Postgre.DaoProgresoPeso;
import Comun.Dominio.Entidad;
import Comun.Dominio.FabricaEntidad;
import Comun.Excepciones.FO4.AgregarPesoExcepcion;
import java.sql.SQLException;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Elberg
 */
public class TestAgregarPesoExcepcion {
    private DaoProgresoPeso _pp = new DaoProgresoPeso();
    private Entidad en;
    private AgregarPesoExcepcion _error;
    
    @Ignore
    @Test(expected=AgregarPesoExcepcion.class)
    public void agregarPesoExepcion() throws AgregarPesoExcepcion{
        en = FabricaEntidad.InstaciaProgresoPeso(99899, 12);
        _pp.agregarPeso(en);
        
    }    
}
