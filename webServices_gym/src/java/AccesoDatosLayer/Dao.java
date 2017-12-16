/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer;

import Comun.Dominio.Registro;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gilbert
 */
public abstract class Dao implements IDao{
    private static Connection _conn = null;
    private static Connection _conInstance;    
    
    /**
     * Metodo para devolver una unica instancia de la conexion (Singleton)
     * @return instancia de la conexion
     */
    public static Connection getConInstance(){

            _conInstance = getPostgreBdConnect();

        return _conInstance;
    }
    
    /**
     * Metodo que realiza la conexion con la base de datos
     * @return Conexion hecha a la base de datos
     * @throws ClassNotFoundException Si la clase no es encontrada
     * @throws SQLException Problemas con sql
     * @throws Exception
     * @see Connection
     * @see Statement
     */
    public static Connection getPostgreBdConnect()
    {

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

    /**
     * Metodo que cierra la conexion a la base de datos
     */
    public static void closePostgreConnection( Connection conn )
    {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
