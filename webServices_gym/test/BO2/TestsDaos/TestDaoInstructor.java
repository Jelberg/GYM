package BO2.TestsDaos;

import AccesoDatosLayer.BO2.DaoInstructorPostgre;
import AccesoDatosLayer.Dao;
import Comun.Dominio.Instructor;
import java.sql.Connection;
import java.util.ArrayList;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author simon
 */
public class TestDaoInstructor {
    
    private Connection _conn;
    DaoInstructorPostgre dip = new DaoInstructorPostgre();
    
    @Before
    public void PrepararPrueba(){
        try{
            _conn = Dao.getPostgreBdConnect();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Test
    public void TestGetInstructores(){
        ArrayList<Instructor> lista = dip.getInstructores();
        assertNotNull(lista);
    }
    
    
}
