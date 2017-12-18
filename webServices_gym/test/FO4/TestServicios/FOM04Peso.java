/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FO4.TestServicios;

import Comun.Dominio.Entidad;
import Comun.Dominio.FabricaEntidad;
import ServiciosLayer.FOM04_Progreso_Peso;
import com.google.gson.Gson;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Elberg
 */
public class FOM04Peso {
    FOM04_Progreso_Peso _pp = new FOM04_Progreso_Peso();
    private Entidad en;
     Gson _gson = new Gson();
   
       
    @Test
    public void insertPesoTest(){ 
        String _resp  = _pp.insertaPeso(1,12);
        assertEquals(_gson.toJson("PESO AGREGADO"),_resp);
    }
    
    @Test
    public void actualizarPesoTest(){
        String _resp = _pp.actualizarPeso(1, 29);
        assertEquals("PESO ACTUALIZADO",_resp);
    }
    
    @Test
    public void eliminarPesoTest(){
        String _resp = _pp.eliminaPeso(1);
        assertEquals("PESO ELIMINADO",_resp);
    }
}
