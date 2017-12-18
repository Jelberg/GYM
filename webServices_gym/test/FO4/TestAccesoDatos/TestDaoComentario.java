/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FO4.TestAccesoDatos;

import AccesoDatosLayer.FOM04Postgre.DaoComentario;
import Comun.Dominio.Entidad;
import Comun.Dominio.FabricaEntidad;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Elberg
 */
public class TestDaoComentario {
    private DaoComentario _pp = new DaoComentario();
    private Entidad en;
    
    @Test
    public void agregarComentarioTest(){
        en = FabricaEntidad.InstaciaInsertarComentario(1,"COMENTARIO DE PRUEBA");
        String _resp;
        _resp = _pp.insertar(en);
         assertEquals("Comentario Agregado",_resp);
    }
    
}
