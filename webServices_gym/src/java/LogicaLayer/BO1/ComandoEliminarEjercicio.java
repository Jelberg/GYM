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
 * @author Luis L
 */
public class ComandoEliminarEjercicio extends Comando {
    private Entidad _ejercicio;
    
    public ComandoEliminarEjercicio (Entidad ejercicio){
        this._ejercicio = _ejercicio;
    }
    
    @Override
    public void ejecutar (){
        FabricaDaoPostgre fab = (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1);
        IDaoEjercicio dao = fab.getDaoEjercicio();
        dao.eliminar(_ejercicio);
    }
    
}
