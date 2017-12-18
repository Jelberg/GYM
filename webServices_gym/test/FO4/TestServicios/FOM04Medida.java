/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FO4.TestServicios;

import Comun.Dominio.Entidad;
import ServiciosLayer.FOM04_Progreso_Medida;
import com.google.gson.Gson;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Elberg
 */
public class FOM04Medida {
    private FOM04_Progreso_Medida _pm = new FOM04_Progreso_Medida();
    private Entidad en;
    Gson _gson = new Gson();
    
    
    @Test
    public void insertaMedidaTest(){
    String _resp = _pm.insertaMedidas(1, 22, 1);
    assertEquals(_gson.toJson("MEDIDA AGREGADA"),_resp);
    }
    
     @Test
    public void updateMedidaTest(){
        String _resp  = _pm.actualizarMedida(1, "Abdomen", 12); 
        assertEquals(_gson.toJson("Medida Cambiada"),_resp);
    }

    @Test
    public void deleteMediaTest(){
        String _resp  = _pm.eliminarMedida(1,"Abdomen"); 
        assertEquals(_gson.toJson("Medida Eliminar"),_resp);
    }
}
