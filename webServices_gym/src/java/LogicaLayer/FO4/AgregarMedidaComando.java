/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FO4;

import Comun.Dominio.Entidad;
import Comun.Dominio.Progreso_Medida;
import LogicaLayer.Comando;

/**
 *
 * @author Elberg
 */
public class AgregarMedidaComando extends Comando {

    Progreso_Medida _progreso_medida;
    
    public AgregarMedidaComando (Progreso_Medida progreso_Medida){
        this._progreso_medida = progreso_Medida;
    }
    
    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}