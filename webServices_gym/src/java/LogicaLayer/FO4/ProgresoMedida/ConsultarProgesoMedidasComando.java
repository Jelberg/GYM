/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FO4.ProgresoMedida;

import AccesoDatosLayer.FOM04Postgre.IDaoProgresoMedida;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import LogicaLayer.Comando;



/**
 *
 * @author Leonardo
 */
public class ConsultarProgesoMedidasComando extends Comando {
    private int _id;
    private static String _resultado;

    /**
     * Constructor para la consulta de las medidas del usuario
     * @param _id 
     */
    public ConsultarProgesoMedidasComando(int _id) {
        this._id = _id;
    }
    
    /**
     * Metodo estatico que guarda la consulta en un string de la 
     * consulta de las medidas
     * @return 
     */
    public static String getResultadoConsultaMedidas(){
        return _resultado;
    }
    
    @Override
    public void ejecutar() {
        FabricaDaoPostgre fab = 
                (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1); 
        IDaoProgresoMedida dao = fab.getDaoProgresoMedida();
        _resultado = dao.consultarMedidas(_id);
    }

}
