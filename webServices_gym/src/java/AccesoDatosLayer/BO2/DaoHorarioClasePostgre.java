/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.BO2;

import AccesoDatosLayer.DaoPostgre;
import Comun.Dominio.Clase;
import Comun.Dominio.Entidad;
import Comun.Dominio.HorarioClase;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author marvian
 */
public class DaoHorarioClasePostgre extends DaoPostgre implements IDaoHorarioClase {
    private Connection _conn;
    private ArrayList<Clase> jsonArray;
    
    public DaoHorarioClasePostgre() {}
       

    @Override
    public Entidad consultar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Clase> consultarClases() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entidad insertar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entidad modificar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entidad eliminar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<HorarioClase> consultarHorarioClase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
