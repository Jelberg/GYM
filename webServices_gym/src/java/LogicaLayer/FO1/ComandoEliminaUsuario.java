/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FO1;

import Comun.Dominio.Usuario;
import LogicaLayer.Comando;

/**
 *
 * @author YESIMAR
 */
public class ComandoEliminaUsuario extends Comando{
    private Usuario _usuario;
    private String resultado;
    
    public ComandoEliminaUsuario(Usuario _usuario) {
        this._usuario = _usuario;
    }

    public Usuario getUsuario() {
        return _usuario;
    }

    public void setUsuario(Usuario _usuario) {
        this._usuario = _usuario;
    }
    
    public String getResultado() {
        return resultado;
    }
    
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    @Override
    public void ejecutar() {
        
    }
    
}
