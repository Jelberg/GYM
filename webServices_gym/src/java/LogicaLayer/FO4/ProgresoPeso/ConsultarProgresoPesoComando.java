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
 * @author elberg
 */

public class ConsultarProgresoPesoComando extends Comando {
    private static String _respuesta;
    private  int _idUsuario;
    
    /**
     * Metodo estatico que devuelve la consulta del progreso del peso
     * @return 
     */
    public static String getResultadoConsultaProgresoPeso(){
        return _respuesta;
    }

    /**
     * Contructor del comando progreso peso 
     * @param pp 
     */
    public ConsultarProgresoPesoComando(int pp) {
        this._idUsuario=pp;
       }

    @Override
    public void ejecutar() {
        FabricaDaoPostgre fab = (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1);
        IDaoProgresoPeso dao = fab.getDaoProgresoPeso();
        _respuesta = dao.consultarProgresoPeso(_idUsuario);
    }
    
}
