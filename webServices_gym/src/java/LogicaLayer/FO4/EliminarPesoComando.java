/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FO4;

import AccesoDatosLayer.FOM04Postgre.IDaoProgresoPeso;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import LogicaLayer.Comando;

/**
 *
 * @author Elberg
 */
public class EliminarPesoComando extends Comando {
    private int _idUsuario;
    private static String _respuesta;

    /**
     * Constructor del comando para eliminar el peso 
     * @param _idUsuario 
     */
    public EliminarPesoComando(int _idUsuario) {
        this._idUsuario = _idUsuario;
    }
    
    /**
     * Metodo Estatico que devuelve la respuesta de la eliminacion del peso
     * @return 
     */
    public static String getRespuestaEliminarPeso(){
        return _respuesta;
    }

    @Override
    public void ejecutar() {
    FabricaDaoPostgre fab = (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1); 
    IDaoProgresoPeso dao = fab.getDaoProgresoPeso();
    _respuesta = dao.eliminarPeso(_idUsuario);}
    
}
