/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.BO2;

import AccesoDatosLayer.BO2.DaoEntrenadorPostgre;
import AccesoDatosLayer.BO2.IDaoEntrenador;
import AccesoDatosLayer.FabricaAbstracta;
import Comun.Dominio.Entidad;
import Comun.Dominio.FabricaEntidad;
import LogicaLayer.Comando;

/**
 * Clase a traves de la cual se realiza el llamado para realizar la consulta
 * de un entrenador por correos
 * @author gilbert
 */
public class ComandoConsultaEntrenadorCorreo extends Comando{
    private Entidad _entrenador;
    /**
     * Constructor de clase con el objeto Entidad que se recibe.
     * @param entrenador Objeto Entidad que se recibe para realizar la accion
     * @see Entidad
     */
    public ComandoConsultaEntrenadorCorreo( Entidad entrenador ){
        this._entrenador = entrenador;
    }

    public ComandoConsultaEntrenadorCorreo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Metodo que es usado para devolver la consulta realizada.
     * @return Devuelve un objeto de tipo Entidad en el cual estan encapsulados
     * los datos de la consulta.
     */
    public Entidad getEntrenador(){
        return _entrenador;
    }
    /**
     * Metodo que es llamado para ejecutar la accion de la consulta a la base 
     * de datos.
     */
    @Override
    public void ejecutar() {
        FabricaAbstracta fab = FabricaAbstracta.getFabrica(1);
        DaoEntrenadorPostgre dao = fab.instanciaDaoEntrenador();
        _entrenador = dao.consultar( _entrenador );
    }
    
}
