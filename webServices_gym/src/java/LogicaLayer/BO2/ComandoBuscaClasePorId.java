/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.BO2;

import AccesoDatosLayer.BO2.IDaoClase;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import Comun.Dominio.Clase;
import Comun.Dominio.Entidad;
import java.util.ArrayList;

/**
 *
 * @author marvian
 */
public class ComandoBuscaClasePorId {
    
    private Entidad _clase;
    private ArrayList<Clase> _listaClase;
    /**
     * Constructor de clase con una Entidad que es recibida por quien lo llama.
     * @param clase Entidad que tiene los datos necesarios para realizar la 
     * accion.
     * @see Clase
     */
    public ComandoBuscaClasePorId(Entidad clase) {
        _clase = clase;
    }
    public ComandoBuscaClasePorId() {}
    public ArrayList<Clase> consultarBuscaClasePorId(){
        return _listaClase;
    }
    /**
     * Metodo que es llamado para ejecutar los llamados y asi realizar la accion
     * de consulta de clase.
     */
    public void ejecutar() {
        FabricaDaoPostgre fab = (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1);
        IDaoClase dao = fab.instanciaDaoClase();
        _listaClase = dao.consultarClases();}
    
    
}
