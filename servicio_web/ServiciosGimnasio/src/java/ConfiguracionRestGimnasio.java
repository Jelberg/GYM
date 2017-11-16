
import Servicios.BOM02_Clase;
import Servicios.BOM02_Entrenador;
import Servicios.BOM02_Horario_Clase;
import Servicios.BOM02_Instruct;
import Servicios.FOM03_Rutina;
import Servicios.FOM05_Clase_Fecha;
import Servicios.FOM05_Critica;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gilbert
 */
@ApplicationPath("/")
public class ConfiguracionRestGimnasio extends Application{

    // Pila de ejecucion     
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(BOM02_Clase.class);
        h.add(BOM02_Entrenador.class);
        h.add(BOM02_Horario_Clase.class);
        h.add(BOM02_Instruct.class);
        h.add(FOM03_Rutina.class);
        h.add(FOM05_Critica.class);
        h.add(FOM05_Clase_Fecha.class);
        return h;
    }
       
}
