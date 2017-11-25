/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author gilbert
 */
public class Usuario extends Persona {
    private String password;
    private String usuario;
    private int estatura;

    public Usuario(String password, String usuario, int estatura) {
        this.password = password;
        this.usuario = usuario;
        this.estatura = estatura;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public Usuario() {
    }
    
    
}
