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
 *
 * @author gilbert
 */
public class ComandoConsultaEntrenadorCorreo extends Comando{
    private Entidad _entrenador;
    public ComandoConsultaEntrenadorCorreo( Entidad entrenador ){
        this._entrenador = entrenador;
    }

    public ComandoConsultaEntrenadorCorreo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Entidad getEntrenador(){
        return _entrenador;
    }
    @Override
    public void ejecutar() {
        FabricaAbstracta fab = FabricaAbstracta.getFabrica(1);
        DaoEntrenadorPostgre dao = fab.instanciaDaoEntrenador();
        _entrenador = dao.consultar( _entrenador );
    }
    
}
