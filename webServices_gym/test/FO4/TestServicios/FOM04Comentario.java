/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FO4.TestServicios;

import Comun.Dominio.Entidad;
import ServiciosLayer.FOM04_Comentario;
import com.google.gson.Gson;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Elberg
 */
public class FOM04Comentario {
    FOM04_Comentario _c = new FOM04_Comentario();
    private Entidad en;
    Gson _gson = new Gson();
    
    @Test
    public void agregarComentarioTest(){
        String _resp = _c.insertaComentario(1,"COMENTARIO DE PRUEBA");
         assertEquals(_gson.toJson("Comentario Agregado"),_resp);
    }
}
