/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.FOM04Postgre;

import Comun.Dominio.Progreso_Peso;
import java.util.ArrayList;

/**
 *
 * @author Elberg
 */
public interface IDaoProgresoPeso{
    
    public ArrayList<Progreso_Peso> getPesos();
    public void insertar(Progreso_Peso progreso_Peso);
    public void eliminar(int idUsuario);
    public void actualizar(Progreso_Peso progreso_Peso);
    
}
