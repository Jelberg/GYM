/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.F03;

import AccesoDatosLayer.FO3.IDaoRutina;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import LogicaLayer.Comando;

/**
 *
 * @author Elberg
 */
public class ConsultarEjerciciosRealizadosComando extends Comando {
private int id;
private static String _resp;

    public ConsultarEjerciciosRealizadosComando(int id) {
        this.id = id;
    }

    public static String getResultado(){
        return _resp;
    }
    
    @Override
    public void ejecutar() {
        FabricaDaoPostgre fab = (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1); 
        IDaoRutina dao = fab.getDaoRutina();
        _resp = dao.consultaEjerciciosRealizados(id);
    }
    
}
