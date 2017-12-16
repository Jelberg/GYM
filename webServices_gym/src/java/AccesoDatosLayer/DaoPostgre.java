/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer;

import Comun.Dominio.Registro;
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
    
    @Override
    public Connection getInstancia(){
        _conInstance = getConexion();
        return _conInstance;
    }
    @Override 
    public Connection getConexion(){
        try
        {
            Class.forName( Registro.POSTGRE_BD_CLASS_FOR_NAME );
            _conn = DriverManager.getConnection( Registro.POSTGRE_BD_URL, Registro.POSTGRE_BD_USER, Registro.POSTGRE_BD_PASSWORD );
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return _conn;
    }
    @Override
    public void cerrarConexion( Connection conn ){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
