/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.FOM04Postgre;

import AccesoDatosLayer.DaoPostgre;
import Comun.Dominio.Comentario;
import Comun.Dominio.Entidad;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Leonardo
 */
public class DaoComentarioPostgre extends DaoPostgre implements IDaoComentario {
    
    private Connection _connection;
    
    public DaoComentarioPostgre(){
        
    }
    /*
    @Override
    public void insertar(Comentario comentario) {
        try{
            
            _connection = Dao.get
            
        }catch(SQLException e){
            
        }
    }*/

    @Override
    public void insertar(Comentario comentario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
