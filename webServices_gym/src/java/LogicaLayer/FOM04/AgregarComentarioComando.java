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
public class AgregarComentarioComando extends Comando {
    
    int _idUsuario;
    String _mensaje;
    
    public AgregarComentarioComando(int idUsuario, String mensaje) {
        _idUsuario = idUsuario;
        _mensaje = mensaje;
    }
    
    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
