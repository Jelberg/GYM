package LogicaLayer.BO2;

import AccesoDatosLayer.BO2.IDaoInstructor;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import LogicaLayer.Comando;

/**
 *
 * @author simon
 */
public class CmdActualizarInstructor extends Comando{
    String _nombre;
    String _apellido;
    String _fecha;
    String _sexo;
    String _correo;
    
    public CmdActualizarInstructor(String n, String a, String f, String s, String c){
        _nombre = n;
        _apellido = a;
        _fecha = f;
        _sexo = s;
        _correo = c;
    }

    @Override
    public void ejecutar() {
        FabricaDaoPostgre fab = (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1);
        IDaoInstructor dao = fab.getDaoInstructor();
        dao.actualizar(_nombre, _apellido, _fecha, _sexo, _correo);
    }
}
