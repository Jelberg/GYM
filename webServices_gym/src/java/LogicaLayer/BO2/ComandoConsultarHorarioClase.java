/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.BO2;

import AccesoDatosLayer.BO2.IDaoHorarioClase;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import Comun.Dominio.Entidad;
import Comun.Dominio.HorarioClase;
import LogicaLayer.Comando;
import java.util.ArrayList;

/**
 *
 * @author marvian
 */
public class ComandoConsultarHorarioClase extends Comando {
    
    private Entidad _horarioClase;
    private ArrayList<HorarioClase> _listaHorarioClase;
    /**
     * Constructor de clase con una Entidad que es recibida por quien lo llama.
     * @param clase Entidad que tiene los datos necesarios para realizar la 
     * accion.
     * @see Clase
     */
    public ComandoConsultarHorarioClase(Entidad horarioclase) {
        _horarioClase= horarioclase;
    }
    public ComandoConsultarHorarioClase() {}
    public ArrayList<HorarioClase> consultarHorarioClase(){
        return _listaHorarioClase;
    }
    /**
     * Metodo que es llamado para ejecutar los llamados y asi realizar la accion
     * de consulta de clase.
     */
    @Override
    public void ejecutar() {
        FabricaDaoPostgre fab = (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1);
        IDaoHorarioClase dao = fab.instaciaDaoHorarioClase();
        _listaHorarioClase = dao.consultarHorarioClase();
    }
    
}
