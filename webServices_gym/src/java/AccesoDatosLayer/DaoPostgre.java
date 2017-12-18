/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer;

import Comun.Dominio.Registro;
import Comun.Util.ConfigurarLogger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elberg
 */
public abstract class DaoPostgre extends Dao{
    private static Connection _conn = null;
    private static Connection _conInstance;
    ConfigurarLogger _cl = new ConfigurarLogger();
    Logger _logger = _cl.getLogr();
    
    /**
     * Metodo que es llamado para obtener la instancia de la conexion a la base
     * de datos
     * @return Devuelve la instancia de la conexion a la base de datos
     */
    @Override
    public Connection getInstancia(){
        _conInstance = getConexion();
        return _conInstance;
    }
    /**
     * Metodo que realiza la conexion a la base de datos
     * @return Devuelve un objeto con la conexion de la base de datos.
     */
    @Override 
    public Connection getConexion(){
        try
        {
            Class.forName( Registro.POSTGRE_BD_CLASS_FOR_NAME );
            _conn = DriverManager.getConnection( Registro.POSTGRE_BD_URL,
                    Registro.POSTGRE_BD_USER, Registro.POSTGRE_BD_PASSWORD );
        }
        catch (ClassNotFoundException e)
        {
            _logger.log(Level.SEVERE, 
                    "Clase con conexion a BD no encontrada: {0} ",
                    e.getMessage());
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            _logger.log(Level.SEVERE, "Error en al conexion a la BD: {0} ",
                    e.getMessage());
            e.printStackTrace();
        }
        return _conn;
    }
    /**
     * Metodo llamado para cerrar la conexion con la base de datos.
     * @param conn Recibe el objeto con la conexion a cerrar.
     */
    @Override
    public void cerrarConexion( Connection conn ){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
