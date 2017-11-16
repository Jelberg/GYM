/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Elberg
 */
public class global {
    
    /**
     * 
     * @param d Tipo de dato date
     * @return 1 = lunes, 2= martes, ...
     */
    public static int getDayOfTheWeek(Date d){
	GregorianCalendar cal = new GregorianCalendar();
	cal.setTime(d);
	return cal.get(Calendar.DAY_OF_WEEK);		
}
    
    /**
     * 
     * @param dia de la semana que se quiere saber la fecha
     * @return 
     */
    public static int numberDate(String dia)
    {
        if (dia.equals("LUNES"))
        {
            return 1;
        }
        else if (dia.equals("MARTES"))
        {
            return 2;
        }
        else if (dia.equals("MIERCOLES"))
        {
            return 3;
        }
        else if (dia.equals("JUEVES"))
        {
            return 4;
        }
        else if (dia.equals("VIERNES"))
        {
            return 5;
        }
        else if (dia.equals("SABADO"))
        {
            return 6;
        }
        return 0;
    }
    
}
