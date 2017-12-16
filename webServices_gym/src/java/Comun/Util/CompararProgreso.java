/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun.Util;

import Comun.Dominio.Progreso_Peso;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;




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
    
    
    /*public boolean comprobarInsercion( int idUsuario){
        ArrayList<Progreso_Peso> progresoPeso = new ArrayList<Progreso_Peso>();
        Gson gson = new Gson();
        String respuesta = getProgresoP( idUsuario );
        progresoPeso = gson.fromJson( respuesta, new TypeToken<List<Progreso_Peso>>(){}.getType());
        SimpleDateFormat sdft = new SimpleDateFormat( "yyyy-MM-dd" );
        java.util.Date fecha = new java.util.Date();
        String fechaActual = sdft.format( fecha );
        int tamanoArreglo = progresoPeso.size();
        java.util.Date ultimoProgreso = progresoPeso.get( tamanoArreglo - 1).getFechaP();
        if ( fechaActual.equals( String.valueOf( ultimoProgreso ) ) ){
            return true;
        }
        else{
            return false;
        }
    }
}
