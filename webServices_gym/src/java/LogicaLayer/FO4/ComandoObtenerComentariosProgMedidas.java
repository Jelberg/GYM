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
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class ComandoObtenerComentariosProgMedidas extends Comando {

    int _idUsuario;
    int _idProgresoMedida;
    ArrayList<Comentario> _listaComentario;
    
    /**
     * Constrcutor de Comando Obterner Comentario por el idProgMedida
     * @param idUsuario
     * @param idProgMedida 
     */
    public ComandoObtenerComentariosProgMedidas(int idUsuario, int idProgMedida){
        this._idUsuario = idUsuario;
        this._idProgresoMedida = idProgMedida;
    }
    
    /**
     * Obtener Comentarios sacados de la BD
     * @return 
     */
    public ArrayList<Comentario> ObtenerComentarioProgMedidas(){
        return this._listaComentario;
    }
    
    @Override
    public void ejecutar() {
        FabricaAbstracta _fab = FabricaAbstracta.getFabrica(1);
        IDaoComentario _dao = _fab.getDaoComentario();
        this._listaComentario = _dao.getComentariosProgMedida(_idUsuario,_idProgresoMedida);
    }
    
}