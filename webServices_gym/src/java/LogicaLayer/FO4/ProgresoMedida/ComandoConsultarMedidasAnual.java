/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FO4.ProgresoMedida;

import AccesoDatosLayer.FOM04Postgre.IDaoProgresoMedida;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import Comun.Dominio.Progreso_Medida;
import LogicaLayer.Comando;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class ComandoConsultarMedidasAnual extends Comando {

    Progreso_Medida _progreso_medida;
    String _fechainicio;
    String _fechafin;
    SimpleDateFormat _sdf;
    ArrayList<Progreso_Medida> _listaProgresoMedida;

    /**
     * Constructor Comando Consultar Medidas Anuales
     * @param _progreso_medida 
     */
    public ComandoConsultarMedidasAnual(Progreso_Medida _progreso_medida) {
        this._progreso_medida = _progreso_medida;
        _sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        LocalDate _fecha = LocalDate.now();
        _fecha = _fecha.with(TemporalAdjusters.firstDayOfMonth());
        
        Date _FechaIni = Date.valueOf(_fecha);
        Date _FechaFin = 
                Date.valueOf(_fecha.with(TemporalAdjusters.lastDayOfMonth()));
        
        _fecha = _fecha.minusMonths(1);
        _FechaIni = Date.valueOf(_fecha);
        _FechaFin = 
                Date.valueOf(_fecha.with(TemporalAdjusters.lastDayOfMonth()));
        
        _fechainicio = _sdf.format(_FechaIni);
        _fechafin = _sdf.format(_FechaFin);
    }
    
    /**
     * Obtener Medidas Anuales obtenidas por la base de datos
     * @return 
     */
    public ArrayList<Progreso_Medida> obtenerMedidasAnuales(){
        return _listaProgresoMedida;
    }
    

    @Override
    public void ejecutar() {
        FabricaDaoPostgre _fab = 
                (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1);
        IDaoProgresoMedida _dao = _fab.getDaoProgresoMedida();
        this._listaProgresoMedida = 
                _dao.getMedidasAnuales(_progreso_medida,_fechainicio,_fechafin);
    }
    
}