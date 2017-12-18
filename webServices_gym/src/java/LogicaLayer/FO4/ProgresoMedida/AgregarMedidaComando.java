/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FO4.ProgresoMedida;

import AccesoDatosLayer.FOM04Postgre.IDaoProgresoMedida;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import Comun.Dominio.Entidad;
import LogicaLayer.Comando;

/**
 *
 * @author Elberg
 */
public class AgregarMedidaComando extends Comando {
    private Entidad _pm;
    private static String _respuesta;

    /**
     * Constructor para agregar medida de comando
     * @param _pm 
     */
    public AgregarMedidaComando(Entidad _pm) {
        this._pm = _pm;
    }

    /**
     * Metodo estatico que guarda la respuesta de la consulta
     * @return 
     */
    public static String getRespuestaAgregarMedida(){
        return _respuesta;
    }
    @Override
    public void ejecutar() {
        FabricaDaoPostgre fab = 
                (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1); 
        IDaoProgresoMedida dao = fab.getDaoProgresoMedida();
        _respuesta = dao.agregarMedida(_pm);
    }

}
