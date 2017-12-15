/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FOM04;

import AccesoDatosLayer.FOM04Postgre.IDaoMedida;
import AccesoDatosLayer.FOM04Postgre.IDaoProgresoPeso;
import AccesoDatosLayer.FabricaAbstracta;
import Comun.Dominio.Progreso_Medida;
import LogicaLayer.Comando;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class ComandoObtenerMedidas extends Comando {

    int _idUsuario;
    ArrayList<Progreso_Medida> _listaMedidas;
    
    public ComandoObtenerMedidas(int idUsuario){
        this._idUsuario = idUsuario;
    }
    
    public ArrayList<Progreso_Medida> obtenerComentario(){
        return this._listaMedidas;
    }
    
    @Override
    public void ejecutar() {
        FabricaAbstracta _fab = FabricaAbstracta.getFabrica(1);
        IDaoMedida _dao = _fab.instanciaDaoProgresoMedida();
        this._listaMedidas = _dao.getMedidas(_idUsuario);
    }
    
}
