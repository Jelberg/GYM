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
 *
 * @author gilbert
 */
public class ComandoGetEntrenadores extends Comando{
    private Entidad _entrenador;
    private ArrayList<Entrenador> _listaEntrenadores;
    public ComandoGetEntrenadores(Entidad entrenador) {
        _entrenador = entrenador;
    }
    public ComandoGetEntrenadores() {}
    public ArrayList<Entrenador> getEntrenadores(){
        return _listaEntrenadores;
    }
    @Override
    public void ejecutar() {
        FabricaDaoPostgre fab = (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1);
        IDaoEntrenador dao = fab.instanciaDaoEntrenador();
        _listaEntrenadores = dao.consultarEntrenadores();
    }

}
