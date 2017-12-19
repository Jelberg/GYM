/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FO4.ProgresoPeso;


import AccesoDatosLayer.FOM04Postgre.DaoProgresoPeso;
import AccesoDatosLayer.FOM04Postgre.IDaoProgresoPeso;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import Comun.Dominio.Entidad;
import Comun.Dominio.Progreso_Peso;
import LogicaLayer.Comando;

/**
 *
 * @author Elberg
 */
public class AgregarPesoComando extends Comando {
    private static String _resultado;
    private Entidad _pp;

    
    /**
     * Constructor de la clase para llenar datos del Peso
     * @param pp
     */
    public AgregarPesoComando(Entidad pp) {
        this._pp = pp;
    }
    
    /**
     * Metodo estatico que guarda el resultado de la consulta
     * @return 
     */
    public static String getResultado(){
        return _resultado;
    }
    

    @Override
    public void ejecutar() {
    FabricaDaoPostgre fab = (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1); 
    IDaoProgresoPeso dao = fab.getDaoProgresoPeso();
    _resultado = dao.agregarPeso(_pp);
    }

}
