/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.FOM04Postgre;

import Comun.Dominio.Progreso_Medida;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public interface IDaoMedida {
    
    public ArrayList<Progreso_Medida> getMedidas(int idUsuario);
    public void insertar(Progreso_Medida progreso_Medida);
    public void eliminar(Progreso_Medida progreso_Medida);
    public void actualizar(Progreso_Medida progreso_Medida);
    public ArrayList<Progreso_Medida> getMedidasAnuales
        (Progreso_Medida sobrenombre,String fechaini, String fechafin);
    
}
