/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FO4;

import AccesoDatosLayer.FOM04Postgre.IDaoComentario;
import AccesoDatosLayer.FabricaAbstracta;
import Comun.Dominio.Comentario;
import LogicaLayer.Comando;



/**
 *
 * @author Leonardo
 */
public class AgregarComentarioComando extends Comando {
    
    private Comentario _comentario;
    private String _response;
    
    public AgregarComentarioComando(Comentario comentario){
        
        this._comentario = comentario;
        
    }
    
    public String obtenerRespuesta(){
        return _response;
    }
    
    @Override
    public void ejecutar() {
        FabricaAbstracta _fab = FabricaAbstracta.getFabrica(1);
        IDaoComentario _dao = _fab.getDaoComentario();
        _response = _dao.insertar(_comentario);
    }

}