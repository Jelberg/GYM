/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FO4.ProgresoPeso;

import AccesoDatosLayer.FOM04Postgre.IDaoProgresoPeso;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import Comun.Dominio.Entidad;
import LogicaLayer.Comando;

/**
 *
 * @author Elberg
 */
public class ActualizarPesoComando extends Comando {
    private Entidad pp;
    private static String _respuesta;

    /**
     * Contructor Para actualizar Peso
     * @param pp 
     */
    public ActualizarPesoComando(Entidad pp) {
        this.pp = pp;
    }
 
    /**
     * Metodo estatico que retorna la respuesta de la actualizacion del peso
     * @return 
     */
    public static String getRespuestActulizaPeso(){
        return _respuesta;
    }
    
    @Override
    public void ejecutar() {
        FabricaDaoPostgre fab = (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1); 
        IDaoProgresoPeso dao = fab.getDaoProgresoPeso(); 
        _respuesta= dao.actualizarPeso(pp);
    }
      
}
