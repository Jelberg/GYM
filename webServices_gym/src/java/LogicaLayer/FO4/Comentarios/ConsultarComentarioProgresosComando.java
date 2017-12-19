/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FO4.Comentarios;

import AccesoDatosLayer.FOM04Postgre.IDaoComentario;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import LogicaLayer.Comando;

/**
 *
 * @author Elberg
 */
public class ConsultarComentarioProgresosComando extends Comando {
    private int _id;
    private static String _respuesta;

    /**
     * Constructor de la clase
     * @param _id 
     */
    public ConsultarComentarioProgresosComando(int _id) {
        this._id = _id;
    }
    
    /**
     * Metodo que mantendra la respuesta del resultado de los comentarios
     * @return 
     */
    public static String getResultadoComentarioProgresos(){
        return _respuesta;
    }


    @Override
    public void ejecutar() {
        FabricaDaoPostgre _fab = 
                (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1);
        IDaoComentario _dao = _fab.instanciaDaoComentario();
        _respuesta = _dao.consultaProgresos(_id);
    }
    
}
