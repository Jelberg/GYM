package BO2.TestsDaos;

import AccesoDatosLayer.BO2.DaoClasePostgre;
import Comun.Dominio.Clase;
import Comun.Dominio.Entidad;
import java.sql.Connection;
import java.util.ArrayList;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Marvian
 */
public class TestDaoClase {
    
    private Connection _conn;
    private DaoClasePostgre _DaoClase = new DaoClasePostgre();
    private ArrayList<Clase> _lista = new ArrayList<>();
    private Clase _clase;
    
    public TestDaoClase(){
        _clase = new Clase("prueba");
        _clase.setDescripcion("descripcion");
        _conn = _DaoClase.getConexion();
    }
    
    @After
    public void LimpiarBdd(){
        _DaoClase.eliminar(_clase);
        _clase.setNombre("prueba");
        _clase.setDescripcion("descripcion");
    }
    
    @Test
    public void TestConsultarClase(){
        
        _lista = _DaoClase.consultarClases();
        int TamañoInicial = _lista.size();
        
        _DaoClase.insertar(_clase);
        _lista.clear();
        _lista =  _DaoClase.consultarClases();
        int TamañoFinal = _lista.size();
        
        _DaoClase.eliminar(_clase);
        
        assertEquals(TamañoInicial+1, TamañoFinal);
    }
    
    @Test
    public void TestInsertarClase(){
        _DaoClase.insertar(_clase);
        _lista =  _DaoClase.consultarClases();
        
        _DaoClase.eliminar(_clase);

        String nombre = _lista.get(_lista.size()-1).getNombre();
        assertEquals(nombre, _clase.getNombre());
    }
    
    @Test
    public void TestEliminarClase(){
        
        _lista = _DaoClase.consultarClases();
        int TamañoInicial = _lista.size();
        
        _DaoClase.insertar(_clase);
        _lista.clear();
        _lista =  _DaoClase.consultarClases();
        int TamañoConClaseRegistrada = _lista.size();
        
        _DaoClase.eliminar(_clase);
        _lista.clear();
        _lista =  _DaoClase.consultarClases();
        int TamañoFinal = _lista.size();
        
        assertEquals(TamañoInicial+1, TamañoConClaseRegistrada);
        assertEquals(TamañoInicial, TamañoFinal);
        
    }
    
    @Test
    public void TestModificarClase(){
         _DaoClase.insertar(_clase);
         
         _clase.setDescripcion("descripcion2");
         Entidad ent = ( Entidad ) _clase;
         _DaoClase.modificar(ent);
         
         _lista =  _DaoClase.consultarClases();
         String DescripcionModificada = _lista.get(_lista.size()-1).getDescripcion();
         
         assertEquals(DescripcionModificada, "descripcion2");
         
    }
    
    @Test
    public void TestConsultarDescripcion(){
        _DaoClase.insertar(_clase);
        _lista =  _DaoClase.consultarClases();
        String Descripcion = _lista.get(_lista.size()-1).getDescripcion();
        assertEquals(_clase.getDescripcion(), Descripcion);
    }
            
    
    @Ignore
    @Test
    public void TestConsultarClaseEspecifica(){
        
        _DaoClase.insertar(_clase);
        Entidad ent = _DaoClase.consultar(_clase);
        Clase clase = ( Clase ) ent;
        
        _DaoClase.eliminar(_clase);
        
        assertEquals (clase.getNombre(), _clase.getNombre());
    }
}
