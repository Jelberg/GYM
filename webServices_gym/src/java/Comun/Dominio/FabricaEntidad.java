/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ds1718a.maven_serviciosweb.Comun.Dominio;

import java.sql.Date;

/**
 *
 * @author Elberg
 */
public class FabricaEntidad {
    
    // Inicia Fabricas de M04
    static public Entidad InstaciaProgresoPeso(int id, int peso, Date fechaP, String sobrenombre){
    return new Progreso_Peso(id, peso, fechaP,sobrenombre);
    }
    // Fin de M04        
    
}
