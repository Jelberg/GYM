/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Dominio.Progreso_Peso;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author gilbert
 */
public class CompararProgreso {
 
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
