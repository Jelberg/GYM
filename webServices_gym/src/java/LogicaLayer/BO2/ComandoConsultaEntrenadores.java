/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.BO2;

import AccesoDatosLayer.BO2.IDaoEntrenador;
import AccesoDatosLayer.DaoPostgre;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import Comun.Dominio.Entidad;
import Comun.Dominio.Entrenador;
import LogicaLayer.Comando;
import java.util.ArrayList;

/**
 * A traves de esta clase se realizan los llamados para realizar la consulta
 * de todos los entrenadores.
 * @author gilbert
 */
public class ComandoConsultaEntrenadores extends Comando{
    private Entidad _entrenador;
    private ArrayList<Entrenador> _listaEntrenadores;
    public ComandoConsultaEntrenadores(Entidad entrenador) {
        _entrenador = entrenador;
    }
    public ComandoConsultaEntrenadores() {}
    /**
     * Metodo que es llamado para obtener la lista de los entrenadores obtenida
     * de a consulta.
     * @return Devuelve una lista con todos los entrenadores.
     */
    public ArrayList<Entrenador> getEntrenadores(){
        return _listaEntrenadores;
    }
    /**
     * Metodo que es llamado para realizar la accion, este llama a los objetos
     * necesarios para realizar la misma.
     */
    @Override
    public void ejecutar() {
        FabricaAbstracta fab = FabricaAbstracta.getFabrica(1);
        IDaoEntrenador dao = fab.instanciaDaoEntrenador();
        _listaEntrenadores = dao.consultarEntrenadores();
    }

}