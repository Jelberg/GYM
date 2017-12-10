package ServiciosLayer;



import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
import ServiciosLayer.BOm02_Entrenador;

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
        h.add(FO1_Servicios.class);
        h.add(BOm02_Entrenador.class);


        return h;
    }
       
}
