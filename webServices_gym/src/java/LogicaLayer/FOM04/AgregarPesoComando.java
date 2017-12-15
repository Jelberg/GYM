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
 * @author Elberg
 */
public class AgregarPesoComando extends Comando {

    
    int _idUsuario;
    int _peso;
    
    public AgregarPesoComando (int idUsuario, int peso){
        _idUsuario = idUsuario;
        _peso= peso;
    }
    
    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
