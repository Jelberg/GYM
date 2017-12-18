/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;
import java.awt.Image;
import java.io.Serializable;
/**
 *
 * @author Jorge
 */
public class Instructor extends Persona implements Serializable  {
    private Image foto;

 
    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }
    
    
}

