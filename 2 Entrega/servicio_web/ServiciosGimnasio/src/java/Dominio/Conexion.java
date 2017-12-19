/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eavv1
 */
public class Conexion {
    
    public static void main(String[] args){
        String cadena = "jdbc:postgresql://localhost:5432/Gimnasio"; 
        String user ="postgres"; 
        String pass = "12345"; 

        try { Class.forName("org.postgresql.Driver"); 
            Connection conex = DriverManager.getConnection(cadena,user,pass); 
            java.sql.Statement st = conex.createStatement(); 
            String sql = "SELECT nom_usu, cla_usu FROM usuarios "; 
            ResultSet result = st.executeQuery(sql); 


            while(result.next()) { 
                String usuario = result.getString("nom_usu"); 
                String clave = result.getString("cla_usu"); 
                System.out.println("User: "+usuario + " Pass: " + clave); 
            } 

            result.close(); 
            st.close(); 
            conex.close(); 
        } 
        catch(Exception exc) { 
            System.out.println("Errorx:"+exc.getMessage()); 
        }
    }
} 
    

