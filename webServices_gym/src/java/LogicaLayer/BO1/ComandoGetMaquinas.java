/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.BO1;

import AccesoDatosLayer.BO1.IDaoMaquina;
import AccesoDatosLayer.DaoPostgre;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import Comun.Dominio.Entidad;
import Comun.Dominio.Maquina;
import LogicaLayer.Comando;
import java.util.ArrayList;

/**
 *
 * @author Daniel Goncalves
 */
public class ComandoGetMaquinas extends Comando{
    private Entidad _maquina;
    private ArrayList<Maquina> _listaMaquinas;
    public ComandoGetMaquinas(Entidad maquina) {
        _maquina = maquina;
    }
    public ComandoGetMaquinas() {}
    public ArrayList<Maquina> getMaquinas(){
        return _listaMaquinas;
    }
    @Override
    public void ejecutar() {
        FabricaDaoPostgre fab = (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1);//POR QUE 1??
        IDaoMaquina dao = fab.instanciaDaoMaquina();
        _listaMaquinas = dao.consultarMaquinas();
    }

}
