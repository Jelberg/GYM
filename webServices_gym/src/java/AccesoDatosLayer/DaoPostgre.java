/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer;

import java.sql.Connection;

/**
 *
 * @author Elberg
 */
public abstract class DaoPostgre extends Dao{
    
    // Conexion con la base de datos
    
    public Connection getConexion(){
        return Dao.getPostgreBdConnect();
    }
    
}
