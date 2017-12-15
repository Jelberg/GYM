/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun.Dominio;

import java.sql.Date;

/**
 *
 * @author Elberg
 */
public class FabricaEntidad {
    
    // Inicia Fabricas de M04
    static public Entidad InstaciaProgresoPeso(int id, int peso, Date fechaP, 
            String sobrenombre){
    return new Progreso_Peso(id, peso, fechaP,sobrenombre);
    }
    
    static public Entidad InstanciaProgresoMedida(int id, int medida, 
            String tipo, String fechaM, String sobreNombre){
        return new Progreso_Medida(id, medida, tipo, fechaM, sobreNombre);
    }
    
    static public Entidad InstanciaComentario(int id, String mensaje){
        return new Comentario(id, mensaje);
    }
    // Fin de M04        
    
}
