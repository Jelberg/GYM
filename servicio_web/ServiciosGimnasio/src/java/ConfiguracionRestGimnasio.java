
import Servicios.BOM02_Clase;
import Servicios.BOM01_Equipamiento;
import Servicios.BOM01_Ejercicios;
import Servicios.BOM02_Entrenador;
import Servicios.BOM02_Horario_Clase;
import Servicios.BOM02_Instruct;
import Servicios.FOM03_Rutina;
import Servicios.FOM04_Comentario;

import Servicios.FOM05_Clase_Fecha;

import Servicios.FOM04_Progreso_Medida;
import Servicios.FOM04_Progreso_Peso;

import Servicios.FOM05_ClasesSemana;
import Servicios.FOM05_Critica;
import Servicios.FOM05_Reserva;
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
        h.add(BOM01_Equipamiento.class);
        h.add(BOM01_Ejercicios.class);
        h.add(BOM02_Clase.class);
        h.add(BOM02_Entrenador.class);
        h.add(BOM02_Horario_Clase.class);
        h.add(BOM02_Instruct.class);
        h.add(FOM03_Rutina.class);
        h.add(FOM05_Critica.class);
        h.add(FOM05_Clase_Fecha.class);
        h.add(FOM05_ClasesSemana.class);
        h.add(FOM05_Reserva.class);
        h.add(FOM04_Progreso_Medida.class);
        h.add(FOM04_Progreso_Peso.class);
        h.add(FOM04_Comentario.class);

        return h;
    }
       
}
