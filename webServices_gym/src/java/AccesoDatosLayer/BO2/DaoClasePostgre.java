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
import Comun.Validaciones.ValidationWS;
import com.google.gson.reflect.TypeToken;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

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
     
      try{
            String query = "select * from bo_m02_inserta_clase(?,?)";
            _conn = getConexion();
            Clase clase = ( Clase ) ent;
            PreparedStatement st = _conn.prepareStatement(query);
            java.lang.reflect.Type type = new TypeToken<Clase[]>(){}.getType();
                st.setString(1, clase.getNombre());
                st.setString(2, clase.getDescripcion());
                st.executeQuery();
            
            ent.setMensaje("Se insertaron las clases.");
        }
        catch (SQLException e){
            ent.setMensaje( "Error con la conexion, intente de nuevo." );
        }
        catch (ParameterNullException e) {
            ent.setMensaje( "Error al ingresa valor, intente de nuevo." );
        }
        finally {
            cerrarConexion(_conn);
            return ent;
        }
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
        try {
                       
            String query = "select * from bo_m02_modifica_clase(?,?)";
            _conn = getConexion();
            Clase clase = ( Clase ) ent;
            PreparedStatement st = _conn.prepareStatement(query);
            java.lang.reflect.Type type = new TypeToken<Clase[]>(){}.getType();
            st.setString(1, clase.getNombre());
            st.setString(2, clase.getDescripcion());
            st.executeQuery();
            ent.setMensaje("Se modificó con éxito");
        }
        catch (SQLException e){
            ent.setMensaje( "Error, intente de nuevo" );
        }
        catch (ParameterNullException e) {
            ent.setMensaje( "Error, parametro vacio" );
        }
        catch (Exception e) {
            ent.setMensaje( "Error" );
        }
        finally {
            cerrarConexion( _conn );
            return ent;
        }
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
        
        try{
            String query = "SELECT bo_m02_elimina_clase(?)";
             _conn = getConexion();
            Clase clase = ( Clase ) ent;
            PreparedStatement st = _conn.prepareStatement(query);
            java.lang.reflect.Type type = new TypeToken<Clase[]>(){}.getType();
            st.setString(1, clase.getNombre());
            st.executeQuery();
            
            ent.setMensaje( "Se elimino correctamente la clase." );
        }
        catch(SQLException e) {
            ent.setMensaje( "Error intente de nuevo." );
        }
        catch (ParameterNullException e) {
            ent.setMensaje( "Parametro vacio." );
        }
        catch (Exception e) {
            ent.setMensaje( "Error." );
        }
        finally {
            cerrarConexion( _conn );
            return ent;
        }  
    }

    @Override
    public Entidad buscaPorId(Entidad ent) {
        try{
            
            String query = "SELECT * FROM bo_m02_get_clase_por_id(?)";
            _conn = getConexion();
            Clase clase = ( Clase ) ent;
            PreparedStatement st = _conn.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            java.lang.reflect.Type type = new TypeToken<Clase[]>(){}.getType();
            while(rs.next()){
                jsonArray.add(new Clase());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("cla_id"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("cla_nombre"));
                jsonArray.get(jsonArray.size() - 1).setDescripcion(rs.getString("cla_descripcion"));
            }
                ent.setMensaje( "Se busco correctamente la clase." );
        }
        catch(SQLException e) {
            ent.setMensaje( "Error intente de nuevo." );
        }
        catch (ParameterNullException e) {
            ent.setMensaje( "Parametro vacio." );
        }
        catch (Exception e) {
            ent.setMensaje( "Error." );
        }
        finally {
            cerrarConexion(_conn);
            return ent;
        }
    }

    @Override
    public Entidad buscaDescripcion(Entidad ent) {
        try{
            
            String query = "SELECT * FROM bo_m02_get_clase(?)";
             _conn = getConexion();
            Clase clase = ( Clase ) ent;
            PreparedStatement st = _conn.prepareStatement(query);
            java.lang.reflect.Type type = new TypeToken<Clase[]>(){}.getType();
            st.setString(1, clase.getNombre());
            st.executeQuery();
            
            ent.setMensaje( "Se busco correctamente la clase." );
        }
        catch(SQLException e) {
            ent.setMensaje( "Error intente de nuevo." );
        }
        catch (ParameterNullException e) {
            ent.setMensaje( "Parametro vacio." );
        }
        catch (Exception e) {
            ent.setMensaje( "Error." );
        }
        finally {
            cerrarConexion(_conn);
            return ent;
        }
    }
}
