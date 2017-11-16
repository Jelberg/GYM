/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dominio.Clase;
import Dominio.ClasesParticipadas;
import Dominio.Critica;
import Dominio.Sql;
import Util.global;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Elberg
 */

@Path("/FOM05_ClasesSemana")
public class FOM05_ClasesSemana {
    private Connection _conn = Sql.getConInstance();
    private Gson _gson = new Gson();
    private String result;
    private ArrayList<Clase> jsonArray;
    private int _dia, _pasedia;
    Calendar calendar = Calendar.getInstance();
    
    @GET  
    @Produces("application/json")
    public String holaCriticas ()
    {
        return "CLASES SEMANA FO-M05";
    }
    
    /**
     * 
     * @param day dia de la semana
     * @return devuelve las clases del dia de la semana dependiendo de la fecha actual
     * @throws SQLException 
     */
    
    @GET
    
    @Path("/consultarClases")
    
    @Produces("application/json")
    
    public String consultarClases(@QueryParam("day") String day
                                  ) throws SQLException
    {
        try
        {
             Calendar fecha = new GregorianCalendar();
             int año = fecha.get(Calendar.YEAR);
             int mes = fecha.get(Calendar.MONTH);
             int dia = fecha.get(Calendar.DAY_OF_MONTH);
             String fechaActual = String.valueOf(dia)
                     +"/"+String.valueOf(mes)
                     +"/"+String.valueOf(año);
             Date parseFecha = Date.valueOf(fechaActual);
             //Dia de la semana que se paso
             _pasedia = global.numberDate(day);
             //Dia actual de la semana
             _dia = global.getDayOfTheWeek(Date.valueOf(fechaActual));
             int intermedioDias = _pasedia - _dia;
             if (intermedioDias > 0) //El dia a consultar esta en el futuro
             {
              	
                 calendar.setTime(parseFecha); // Configuramos la fecha que se recibe
                 calendar.add(Calendar.DAY_OF_YEAR, intermedioDias);             
             }
             else if (intermedioDias < 0)// el dia a consultar esta en el pasado
             {
             
                 calendar.setTime(parseFecha); // Configuramos la fecha que se recibe
                 calendar.add(Calendar.DAY_OF_YEAR, intermedioDias); 
             }
             else if (intermedioDias == 0) // El dia actual y el dia a consultar es el mismo
             {
             }
             
            //Statement st = _conn.createStatement();
            //ResultSet rs = st.executeQuery(query);  
            

             return String.valueOf(calendar.getTime()); 
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
        finally
        {
            Sql.bdClose(_conn);
        }
    } 
    
}
