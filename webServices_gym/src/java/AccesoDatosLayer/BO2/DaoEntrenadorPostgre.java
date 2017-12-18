/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.BO2;

import AccesoDatosLayer.Dao;
import AccesoDatosLayer.DaoPostgre;
import AccesoDatosLayer.IDao;
import Comun.Dominio.Entidad;
import Comun.Dominio.Entrenador;
import Comun.Excepciones.ParameterNullException;
import Comun.Util.ConfigurarLogger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que es utilizada para el manejo de la interaccion con la base de datos
 * en las tablas referentes al entrenador.
 * @author gilbert
 */
public class DaoEntrenadorPostgre extends DaoPostgre implements IDaoEntrenador{
    private Connection _conn = getInstancia();
    private ArrayList<Entrenador> jsonArray;
    ConfigurarLogger cl = new ConfigurarLogger();
    Logger logr = cl.getLogr();
    public DaoEntrenadorPostgre(){}
    /**
     * Metodo que es llamado cuando se desea consultar a un enrenador en particular
     * @param ent recibe un objeto de tipo entidad en el cual estan encapsulados
     * los datos necesarios para la consulta.
     * @return Devuelve un objeto de tipo entidad con los datos del entrenador a
     * consultar
     * @see Entidad
     */
    @Override
    public Entidad consultar(Entidad ent) {
        try{
            String query = "SELECT * FROM bo_m02_get_entrenadores( ? );";
            _conn = getConexion();
            Entrenador entrenador = ( Entrenador ) ent;
            jsonArray = new ArrayList<>();
            PreparedStatement st = _conn.prepareStatement(query);
            st.setString( 1, entrenador.getCorreo() );
            ResultSet rs = st.executeQuery();
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                jsonArray.add(new Entrenador());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("id"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("nombre"));
                jsonArray.get(jsonArray.size() - 1).setApellido(rs.getString("apellido"));
                Date dte;
                Date dte1=rs.getDate("fechanac");
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String formattedDate = formatter.format(dte1);
                dte  = formatter.parse(formattedDate);
                jsonArray.get(jsonArray.size() - 1).setFecha_nac(rs.getDate("fechanac"));
                jsonArray.get(jsonArray.size() - 1).setSexo(rs.getString("sexo"));
                jsonArray.get(jsonArray.size() - 1).setCorreo(rs.getString("correo"));
                jsonArray.get(jsonArray.size() - 1).setHistorial(rs.getString("historial"));           
                }
            logr.log(Level.WARNING, "CONSULTA CORREO CORRECTA");
            
        }
        catch(SQLException e) {
            logr.log(Level.WARNING, "ERROR, FALLO CON SQL.");
        }
        finally {
            cerrarConexion( _conn );
            return jsonArray.get(0);
        }
        
    }
    /**
     * Metodo que es llamado cuando se desea eliminar a un entrenador.
     * @param ent Recibe los datos pertinentes para realizar la busqueda del 
     * entrenador que se desea eliminar.
     * @return devuelve un objeto entidad con un mensaje que indica si fue 
     * realizada correctamente la accion.
     * @see Entidad
     */
    @Override
    public Entidad eliminar(Entidad ent) {
        try{
            Entrenador entrenador = ( Entrenador ) ent;
            _conn = getConexion();
            String query = "SELECT * from bo_m02_eliminar_entrenador(?)";
            PreparedStatement st = _conn.prepareStatement(query);
            st.setString( 1, entrenador.getCorreo() );
            ResultSet rs = st.executeQuery();
            ent.setMensaje( "Entrenador eliminado correctamente." );
            logr.log(Level.WARNING, "ELIMINADO EL ENTRENADOR " + entrenador.getCorreo() );
        }
        catch( SQLException e){
            Entrenador entrenador = ( Entrenador ) ent;
            ent.setMensaje( "Error de conexion, intente de nuevo." );
            logr.log(Level.WARNING, "ERROR AL ELIMINAR A: " + entrenador.getCorreo() );
            logr.log(Level.WARNING, "ERROR CON SQL" + e);
        }
        finally{
            cerrarConexion( _conn );
            return ent;
        }
    }
    /**
     * Metodo que es llamado cuando se desea actualizar a un entrenador.
     * @param ent recibe los datos del entrenador a modificar.
     * @return Devuelve un objeto Entidad con un mensaje que indica si se
     * realizo la accion.
     * @see Entidad
     */
    @Override
    public Entidad modificar(Entidad ent) {
        try{
            String query = "select * from bo_m02_actualizar_entrenador(?,?,?,?,?,?)";
            _conn = getConexion();
            Entrenador entrenador = ( Entrenador ) ent;
            PreparedStatement st = _conn.prepareStatement(query); 
            st.setString( 1, entrenador.getNombre() );
            st.setString( 2, entrenador.getApellido() );
            st.setString( 3, String.valueOf( entrenador.getFecha_nac() ));
            st.setString( 4, entrenador.getSexo() );
            st.setString( 5, entrenador.getCorreo() );
            st.setString( 6, entrenador.getHistorial() );
            st.executeQuery();
            ent.setMensaje( "Se realizo correctamente la actualizacion." );
            logr.log(Level.WARNING, "MODIFICADO EL ENTRENADOR " + entrenador.getNombre() );
        }
        catch( SQLException e ){
            Entrenador entrenador = ( Entrenador ) ent;
            logr.log(Level.WARNING, "ERROR CON SQL" + e);
            logr.log(Level.WARNING, "NO FUE MODIFICADO EL ENTRENADOR " + entrenador.getNombre() );
            ent.setMensaje( "Error con conexion, intente de nuevo." );
        }
        finally{
            cerrarConexion( _conn );
            return ent;
        }
    }
    /**
     * Metodo que es llamado cuando se desea insertar un nuevo entrenador.
     * @param ent Recibe un objeto Entidad con los datos encapsulados del entrenador
     * @return Devuelve un objeto Entidad con un mensaje que indica si la accion
     * fue realizada
     * @see Entidad
     */
    @Override
    public Entidad insertar(Entidad ent) {
        try{
            String query = "select * from bo_m02_insertar_entrenador(?,?,?,?,?,?)";
            _conn = getConexion();
            Entrenador entrenador = ( Entrenador ) ent;
            PreparedStatement st = _conn.prepareStatement(query); 
            st.setString( 1, entrenador.getNombre() );
            st.setString( 2, entrenador.getApellido() );
            st.setString( 3, String.valueOf( entrenador.getFecha_nac() ));
            st.setString( 4, entrenador.getSexo() );
            st.setString( 5, entrenador.getCorreo() );
            st.setString( 6, entrenador.getHistorial() );
            st.executeQuery();
            ent.setMensaje( "Se ha insertado correctamente." );
            logr.log(Level.WARNING, "INSERTADO EL ENTRENADOR " + entrenador.getNombre() );
        }
        catch(SQLException e) {
            Entrenador entrenador = ( Entrenador ) ent;
            logr.log(Level.WARNING, "ERROR CON SQL" + e);
            logr.log(Level.WARNING, "NO FUE INSERTADO EL ENTRENADOR " + entrenador.getNombre() );
            ent.setMensaje( "Error con la conexion, intente de nuevo." );
        }
        finally {
            cerrarConexion( _conn );
            return ent;
        }
    }
    /**
     * Metodo que es llamado cuando se desea obtener a todos los entrenadores.
     * @return Devuelve una lista de objetos Entrenador con todos los entrenadores.
     */
    @Override
    public ArrayList<Entrenador> consultarEntrenadores() {
        try{
            _conn = getConexion();
            String query = "SELECT ent_id, ent_nombre, ent_apellido, ent_fecha_nac, ent_sexo, ent_correo, ent_historial FROM entrenador;";
            jsonArray = new ArrayList<>();
            PreparedStatement st = _conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            
            //La variable donde se almacena el resultado de la consulta.
            while(rs.next()){
                jsonArray.add(new Entrenador());
                jsonArray.get(jsonArray.size() - 1).setId(rs.getInt("ENT_ID"));
                jsonArray.get(jsonArray.size() - 1).setNombre(rs.getString("ENT_NOMBRE"));
                jsonArray.get(jsonArray.size() - 1).setApellido(rs.getString("ENT_APELLIDO"));
                jsonArray.get(jsonArray.size() - 1).setFecha_nac(rs.getDate("ENT_FECHA_NAC"));
                jsonArray.get(jsonArray.size() - 1).setSexo((rs.getString("ENT_SEXO")));
                jsonArray.get(jsonArray.size() - 1).setCorreo(rs.getString("ENT_CORREO"));
                jsonArray.get(jsonArray.size() - 1).setHistorial(rs.getString("ENT_HISTORIAL"));
                          
            }
            logr.log(Level.WARNING, "CONSULTA REALIZADA EXITOSAMENTE.");
        }
        catch(SQLException e) {
            logr.log(Level.WARNING, "ERROR CON SQL" + e);
            logr.log(Level.WARNING, "CONSULTA REALIZADA SIN EXITO.");
            jsonArray.add( new Entrenador() );
            jsonArray.get(0).setMensaje( "Error con la conexion, intente de nuevo." );
        }
        finally {
            cerrarConexion( _conn );
            return jsonArray;
        }
    }
    
    
}
