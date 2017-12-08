/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author YESIMAR
 */
public class Usuario_Amigo {
    int ami_usuario;
    int ami_amigo;

    public Usuario_Amigo() {
    }

    public Usuario_Amigo(int ami_usuario, int ami_amigo) {
        this.ami_usuario = ami_usuario;
        this.ami_amigo = ami_amigo;
    }

    public int getAmi_usuario() {
        return ami_usuario;
    }

    public void setAmi_usuario(int ami_usuario) {
        this.ami_usuario = ami_usuario;
    }

    public int getAmi_amigo() {
        return ami_amigo;
    }

    public void setAmi_amigo(int ami_amigo) {
        this.ami_amigo = ami_amigo;
    }
    
}
