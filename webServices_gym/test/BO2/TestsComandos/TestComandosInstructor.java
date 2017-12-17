package BO2.TestsComandos;

import AccesoDatosLayer.BO2.DaoInstructorPostgre;
import Comun.Dominio.Instructor;
import LogicaLayer.BO2.CmdActivarInstructor;
import LogicaLayer.BO2.CmdActualizarInstructor;
import LogicaLayer.BO2.CmdGetInstructorPorCorreo;
import LogicaLayer.BO2.CmdGetInstructores;
import LogicaLayer.BO2.CmdInactivarInstructor;
import LogicaLayer.Comando;
import LogicaLayer.FabricaComando;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author simon
 */
public class TestComandosInstructor {
    
    Comando _cmd;
    private ArrayList<Instructor> _lista = new ArrayList<>();
    private Instructor _instructor;
    private String _fechanacimiento = "12/12/1999";
    
    private DaoInstructorPostgre _DaoInstructor = new DaoInstructorPostgre();
    
    @Before
    public void PrepararPrueba(){
        try {
            SimpleDateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sourceFormat.parse(_fechanacimiento);
            _instructor = new Instructor("nombre", "apellido", date, "M", "a@gmail.com");
        } catch (ParseException ex) {
            Logger.getLogger(TestComandosInstructor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * INICIO DE PRUEBAS DE COMANDOS PARA GESTIONAR INSTRUCTORES
     */
    
    /**
     * Prueba comando para registrar instructor.
     */
    @Test
    public void TestCmdRegistrarInstructor(){
        _cmd = FabricaComando.CrearRegInstructor(_instructor);
        _cmd.ejecutar();
        
        CmdGetInstructorPorCorreo cmd = FabricaComando.instanciaInstructorPorCorreo("a@gmail.com");
        cmd.ejecutar();
        _lista =  cmd.getInstructor();
        
        _DaoInstructor.eliminar("a@gmail.com");
        
        assertEquals(1, _lista.size()); 
        
    }
    
    /**
     * Prueba de comando para actualizar un isntructor.
     */
    @Test
    public void TestCmdActualizarInstructor(){
        _cmd = FabricaComando.CrearRegInstructor(_instructor);
        _cmd.ejecutar();
        
        CmdActualizarInstructor cmd;
        cmd  = FabricaComando.instanciaActualizarInstructor("nombre1",
                _instructor.getApellido(), _fechanacimiento,
                _instructor.getSexo(), _instructor.getCorreo());
        cmd.ejecutar();
        
        CmdGetInstructorPorCorreo cmd2 = FabricaComando.
                instanciaInstructorPorCorreo("a@gmail.com");
        
        cmd2.ejecutar();
        _lista =  cmd2.getInstructor();
        
        _DaoInstructor.eliminar("a@gmail.com");
        
        assertEquals("nombre1", _lista.get(0).getNombre());
    }
    
    /**
     * Prueba de comando para obtener un instructor por correo.
     */
    @Test
    public void testCmdGetInstructorPorCorreo(){
        _cmd = FabricaComando.CrearRegInstructor(_instructor);
        _cmd.ejecutar();
        
        CmdGetInstructorPorCorreo cmd2 = FabricaComando.
                instanciaInstructorPorCorreo("a@gmail.com");
        
        cmd2.ejecutar();
        _lista =  cmd2.getInstructor();
        
        _DaoInstructor.eliminar("a@gmail.com");
        
        assertEquals(1, _lista.size());
    }
    
    /**
     * Prueba de comando para obtener todos los instrutores.
     */
    @Test
    public void testCmdGetInstructores(){
        
        CmdGetInstructores cmd = FabricaComando.instanciaGetInstructores();
        cmd.ejecutar();
        int TamañoInicial = cmd.getInstructores().size();
        
        _cmd = FabricaComando.CrearRegInstructor(_instructor);
        _cmd.ejecutar();
        
        cmd.ejecutar();
        int TamañoFinal = cmd.getInstructores().size();
        
        _DaoInstructor.eliminar("a@gmail.com");
        
        assertEquals(TamañoInicial+1, TamañoFinal);
    }
    
    /**
     * Prueba de comando para activar un instrutor.
     */
    @Test
    public void testCmdActivarInstructor(){
        
        _instructor.setActivo("no");
        _cmd = FabricaComando.CrearRegInstructor(_instructor);
        _cmd.ejecutar();
        
        CmdActivarInstructor cmd = FabricaComando.
                instanciaActivarInstructor("a@gmail.com");
        cmd.ejecutar();
        
        CmdGetInstructorPorCorreo cmd2 = FabricaComando.
                instanciaInstructorPorCorreo("a@gmail.com");
        
        cmd2.ejecutar();
        _lista =  cmd2.getInstructor();

        _DaoInstructor.eliminar("a@gmail.com");
        
        assertEquals("si", _lista.get(0).getActivo());
    }
    
    /**
     * Prueba de comando para activar un instrutor.
     */
    @Test
    public void testCmdInctivarInstructor(){
        
        _instructor.setActivo("si");
        _cmd = FabricaComando.CrearRegInstructor(_instructor);
        _cmd.ejecutar();
        
        CmdInactivarInstructor cmd = FabricaComando.
                instanciaInactivarInstructor("a@gmail.com");
                
        cmd.ejecutar();
        
        CmdGetInstructorPorCorreo cmd2 = FabricaComando.
                instanciaInstructorPorCorreo("a@gmail.com");
        
        cmd2.ejecutar();
        _lista =  cmd2.getInstructor();

        _DaoInstructor.eliminar("a@gmail.com");
        
        assertEquals("no", _lista.get(0).getActivo());
    }
    
}
