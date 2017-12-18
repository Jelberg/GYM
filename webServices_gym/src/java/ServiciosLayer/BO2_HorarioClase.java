/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiciosLayer;

import Comun.Dominio.HorarioClase;
import Comun.Dominio.Entidad;
import Comun.Dominio.FabricaEntidad;
import Comun.Excepciones.ParameterNullException;
import Comun.Validaciones.ValidationWS;
import LogicaLayer.BO2.ComandoConsultarHorarioClase;
import LogicaLayer.BO2.ComandoEliminarHorarioClase;
import LogicaLayer.BO2.ComandoInsertarHorarioClase;
import LogicaLayer.BO2.ComandoModificarHorarioClase;
import LogicaLayer.FabricaComando;
import com.google.gson.Gson;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author marvian
 */
@Path("/BOM02_Horario_Clase")
public class BO2_HorarioClase {
    
    private Gson _gson = new Gson();
    private String _response;
    private ArrayList<HorarioClase> _listaHorarioClases;
    private Entidad _horarioClase;
    
    /**
     * @return Devuelve todos los datos de los horarios de clases
     */
    @GET
    @Path("/getListHorario_Clase")
    @Produces("application/json")
    public String getListaHorario_Clase(){
                    
        ComandoConsultarHorarioClase cmd = FabricaComando.instanciaCmdConsultarHorarioClase();
        cmd.ejecutar();
        _listaHorarioClases = cmd.consultarHorarioClase();
        _response = _gson.toJson( _listaHorarioClases);
        return _response;    
    }
    
    /**
     * Funcion que es llamada cuando el admin desea insertar un horario de una clase.
     * 
     * @param fecha Fecha de la clase (dd/mm/aaaa).
     * @param dia Día de la clase (lunes, martes, ... ).
     * @param capacidad Capacidad de alumnos en la clase.
     * @param hora_inicio Hora que inicia la clase.
     * @param hora_fin Hora que finaliza la clase.
     * @param status status de la clase A(Activa) I (Inactiva).
     * @param duracion duración de la clase (calculada con una función).
     * @param nombreclase Nombre de la clase.
     * @param instructor Día de la clase (lunes, martes, ... ).
     * @return Devuelve un json con mensaje del estatus de la peticion.
     */
    @POST
    @Path("/insertaHorario_Clase")
    @Produces("application/json")
    public String insertaHorario_Clase(@QueryParam("fecha") Date fecha,
                                 @QueryParam("dia") String dia,
                                 @QueryParam("capacidad") int capacidad,
                                 @QueryParam("hora_inicio") Time hora_inicio,
                                 @QueryParam("hora_fin") Time hora_fin,
                                 @QueryParam("status") String status,
                                 @QueryParam("duracion") int duracion,
                                 @QueryParam("nombreclase") int nombreclase,
                                 @QueryParam("instructor") int instructor){

        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("fecha", fecha );
                put("dia", dia );
                put("capacidad", capacidad );
                put("hora_inicio", hora_inicio );
                put("hora_fin", hora_fin );
                put("status", status );
                put("duracion", duracion );
                put("nombreclase", nombreclase );
                put("instructor", instructor );
            }});
                
            Entidad horarioClase = FabricaEntidad.instanciaConsultarHorarioClase(fecha, dia, capacidad,
                    hora_inicio,hora_fin,status,duracion,nombreclase,instructor);
            ComandoInsertarHorarioClase cmd = FabricaComando.instanciaCmdInsertaHorarioClase(horarioClase);
            cmd.ejecutar();
            horarioClase = cmd.getMensaje();
            response.put ( "data", horarioClase.getMensaje() );
            
            response.put("data", "Se insertó el horario");
        }
        catch (ParameterNullException e) {
            response.put("error", e.getMessage());
        }
        catch (Exception e) {
            response.put("error", e.getMessage());;
        }
        finally {
            
            return _gson.toJson(response);
        }
    }
    
    /**
     * Metodo que recibe como parametros los siguientes campos
     * para eliminar el horario de esa clase con ese instructor ese día y a esa hora.
     * @param nombreclase Nombre de la clase.
     * @param instructor Identificador del instructor.
     * @param fecha Fecha de la clase (dd/mm/aaaa).
     * @param dia Día de la clase (lunes, martes, ... ).
     * @param capacidad Capacidad de alumnos en la clase.
     * @param hora_inicio Hora que inicia la clase.
     * @param hora_fin Hora que finaliza la clase.
     * @return Devuelve un json con elemento llamado data, 
     * contiene el mensaje de la peticion
     */
    @DELETE
    @Path("/eliminaHorario_Clase")
    @Produces("application/json")
    public String eliminaHorario_Clase(@QueryParam("nombreclase") int nombreclase,
                                 @QueryParam("instructor") int instructor,
                                 @QueryParam("fecha") Date fecha,
                                 @QueryParam("dia") String dia,
                                 @QueryParam("capacidad") int capacidad,
                                 @QueryParam("hora_inicio") Time hora_inicio,
                                 @QueryParam("hora_fin") Time hora_fin){

        Map<String, String> response = new HashMap<String, String>();
        try{

            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("nombreclase", nombreclase);
                put("instructor", instructor);
                put("fecha", fecha );
                put("dia", dia );
                put("capacidad", capacidad );
                put("hora_inicio", hora_inicio );
                put("hora_fin", hora_fin );
            }});
            
            Entidad horarioClase = FabricaEntidad.instanciaEliminarHorarioClase(nombreclase,instructor,
                    fecha, dia, capacidad, hora_inicio,hora_fin);
            ComandoEliminarHorarioClase cmd = FabricaComando.instanciaCmdEliminarHorarioClase(horarioClase);
            cmd.ejecutar();
            horarioClase = cmd.getMensaje();
            response.put ( "data", horarioClase.getMensaje() );
                
            response.put("data", "Se elimino el horario");
        }
        
       
        catch (ParameterNullException e) {
            response.put("error", e.getMessage());
        }
        catch (Exception e) {
            response.put("error", e.getMessage());
        }
        finally {
            return _gson.toJson(response);
        }
    }
    
    /**
     * Funcion que modifica un horario.
     * @param nombreclase Nombre de la clase.
     * @param instructor Identificador del instructor.
     * @param fecha Fecha de la clase (dd/mm/aaaa).
     * @param dia Día de la clase (lunes, martes, ... ).
     * @param capacidad Capacidad de alumnos en la clase.
     * @param hora_inicio Hora que inicia la clase.
     * @param hora_fin Hora que finaliza la clase.
     * @return Devuelve un json con un mensaje al usuario sobre el estatus
     * de la petición.
     */
    @POST
    @Path("/modificaHorario_Clase")
    @Produces("application/json")
    public String modificaHorario_Clase( @QueryParam ( "nombreclase" ) int nombreclase,
                                 @QueryParam("instructor") int instructor,
                                 @QueryParam("fecha") Date fecha,
                                 @QueryParam("dia") String dia,
                                 @QueryParam("capacidad") int capacidad,
                                 @QueryParam("hora_inicio") Time hora_inicio,
                                 @QueryParam("hora_fin") Time hora_fin){
        Map<String, String> response = new HashMap<String, String>();
        try {
            ValidationWS.validarParametrosNotNull(new HashMap<String, Object>(){ {
                put("nombreclase", nombreclase);
                put("instructor", instructor);
                put("fecha", fecha );
                put("dia", dia );
                put("capacidad", capacidad );
                put("hora_inicio", hora_inicio );
                put("hora_fin", hora_fin );
            }});
            
            Entidad horarioClase = FabricaEntidad.instanciaModificarHorarioClase(nombreclase,instructor,
                    fecha, dia, capacidad, hora_inicio,hora_fin);
            ComandoModificarHorarioClase cmd = FabricaComando.instanciaCmdModificarHorarioClase(horarioClase);
            cmd.ejecutar();
            horarioClase = cmd.getMensaje();
            response.put ( "data", horarioClase.getMensaje() );
            
            response.put("data", "Se modificó con éxito");
        }
        catch (ParameterNullException e) {
            response.put("error", e.getMessage());
        }
        catch (Exception e) {
            response.put("error", e.getMessage());
        }
        finally {            
            return _gson.toJson(response);
        }
    } 
}
