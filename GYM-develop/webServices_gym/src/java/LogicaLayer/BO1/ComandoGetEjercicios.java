/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.BO1;

import AccesoDatosLayer.BO1.IDaoEjercicio;
import AccesoDatosLayer.DaoPostgre;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import Comun.Dominio.Entidad;
import Comun.Dominio.Ejercicio;
import LogicaLayer.Comando;
import java.util.ArrayList;

/**
 *
 * @author Daniel Goncalves
 */
public class ComandoGetEjercicios extends Comando{
    private Entidad _ejercicio;
    private ArrayList<Ejercicio> _listaEjercicios;
    public ComandoGetEjercicios(Entidad ejercicio) {
        _ejercicio = ejercicio;
    }
    public ComandoGetEjercicios() {}
    public ArrayList<Ejercicio> getEjercicios(){
        return _listaEjercicios;
    }
    @Override
    public void ejecutar() {
        FabricaDaoPostgre fab = (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1);//POR QUE 1??
        IDaoEjercicio dao = fab.getDaoEjercicio();
        _listaEjercicios = dao.consultarEjercicios();
    }

}
