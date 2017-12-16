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
 * Clase en la cual se manejara el acceso a datos de las clases.
 * @author marvian
 */
public class DaoClasePostgre extends DaoPostgre implements IDaoClase {
    private Connection _conn;
    private ArrayList<Clase> jsonArray;
    public DaoClasePostgre() {}
    /**
     * Metodo que sera llamado cuando se desee consular las clases.
     * @param ent Recibe un objeto de tipo Entidad en el cual se encuentran encapsulados
     * los datos necesarios para consultar una clase.
     * @return Devuelve un objeto de tipo Entidad
     * @see Entidad
     */
    @Override
    public Entidad consultar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Metodo que sera llaado cuando se desee consultar todas las clases.
     * @return Devuelve una lista con todas las clases guardadas.
     * @see Clase
     */
    @Override
    public ArrayList<Clase> consultarClases() {
        try{
            _conn = getConexion();
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
           cerrarConexion( _conn );
            return jsonArray;
        }
    }
    /**
     * Metodo que sera llamado cuando se desee agregar una nueva clase.
     * @param ent REcibe un objeto de tipo Entidad en el cual se encuentran 
     * encapsulados los campos necesarios para agregar la clase.
     * @return Devuelve un mensaje encapsulado en un objeto Entidad en el cual
     * se indica el estado de la peticion.
     * @see Entidad
     */
    @Override
    public Entidad insertar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Metodo que sera llamado cuando se desee modificar una clase.
     * @param ent Recibe un objeto Entidad con los datos a modificar encapsulados.
     * @return Devuelve un mensaje encapsulado en un objeto Entidad en el cual
     * se indica el estado de la peticion.
     * @see Entidad
     */
    @Override
    public Entidad modificar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Metodo que sera llamado cuando se desee eliminar una clase.
     * @param ent Recibe un objeto Entidad en el que se encuentra la data
     * necesaria para elminar la clase,
     * @return Devuelve un mensaje encapsulado en un objeto Entidad en el cual
     * se indica el estado de la peticion.
     */
    @Override
    public Entidad eliminar(Entidad ent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
