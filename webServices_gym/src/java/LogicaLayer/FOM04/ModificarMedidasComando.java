/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FOM04;

import Comun.Dominio.Entidad;
import LogicaLayer.Comando;



/**
 *
 * @author Leonardo
 */
public class ModificarMedidasComando extends Comando {
    
    int _idUsuario;
    int _medida;
    int _tipo_medida;
    
    public ModificarMedidasComando(int idUsuario, int medida, int tipo_medida){
        _idUsuario = idUsuario;
        _medida = medida;
        _tipo_medida = tipo_medida;
    }
    
    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
