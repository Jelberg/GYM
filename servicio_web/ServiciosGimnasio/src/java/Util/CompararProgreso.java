/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Dominio.Progreso_Peso;
import Dominio.Sql;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author gilbert
 */
public class CompararProgreso {
    /**
     * Metodo estatico que es llamado cuando se solicita el progreso del usuario,
     * se utiliza para organizar la misma.
     * @param progreso recibe una lista con todos los progreso del usuario
     * @return retorna la lista ordenada con todos los progreso del usuario 
     */
    public static ArrayList<Progreso_Peso> compararProgresoPeso ( ArrayList<Progreso_Peso> progreso ){
        int i = progreso.size();
        int j = 0;
        ArrayList<Progreso_Peso> aux = new ArrayList<Progreso_Peso>();
        Progreso_Peso auxObj;
        while ( i > j ){
            auxObj = new Progreso_Peso( progreso.get( i - 1 ).getId(),
                                        progreso.get( i - 1 ).getPeso(),
                                        progreso.get( i - 1 ).getFechaP(), null);
            aux.add(auxObj);
            i--;
        }
        return aux;
    }
}
