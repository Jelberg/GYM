/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FOM04;

import AccesoDatosLayer.FabricaAbstracta;
import Comun.Dominio.Comentario;
import Comun.Dominio.Entidad;
import LogicaLayer.Comando;



/**
 *
 * @author Leonardo
 */
public class AgregarComentarioComando extends Comando {
    
    Comentario _comentario;
    
    public AgregarComentarioComando(Comentario comentario) {
        this._comentario = comentario;
    }
    
    @Override
    public void ejecutar() {
        
        FabricaAbstracta _fabrica = FabricaAbstracta.getFabrica(1);
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
