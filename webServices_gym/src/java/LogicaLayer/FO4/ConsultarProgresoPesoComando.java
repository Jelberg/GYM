/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FO4;

import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import LogicaLayer.Comando;

/**
 *
 * @author elberg
 */

public class ConsultarProgresoPesoComando extends Comando {

    @Override
    public void ejecutar() {
        FabricaDaoPostgre fab = (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1);
    }
    
}
