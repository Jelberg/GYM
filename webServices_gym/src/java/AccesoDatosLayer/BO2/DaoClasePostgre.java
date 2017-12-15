/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.BO2;

import AccesoDatosLayer.DaoPostgre;
import AccesoDatosLayer.Dao;
import AccesoDatosLayer.IDao;
import Comun.Dominio.Clase;
import Comun.Dominio.Entidad;
import Comun.Excepciones.ParameterNullException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author marvian
 */
public class DaoClasePostgre extends DaoPostgre implements IDaoClase {
    private Connection _conn;
    private ArrayList<Clase> jsonArray;
    public DaoClasePostgre() {}

    @Override
    public Entidad consultar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Clase> consultarClases() {
        try{
            
            String query = "SELECT cla_nombre, cla_descripcion FROM clase";
            jsonArray = new ArrayList<>();
            System.out.println (query);
            Statement st = _conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                jsonArray.add(new Clase());
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("cla_nombre"));
                jsonArray.get(jsonArray.size() - 1).setDescripcion(rs.getString("cla_descripcion"));
            }
            
        }
        catch(SQLException e) {
        }
        catch (ParameterNullException e) {
           
        }
        catch (Exception e) {
            
        }
        finally {
           Dao.closePostgreConnection( _conn );
            return jsonArray;
        }
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
}
