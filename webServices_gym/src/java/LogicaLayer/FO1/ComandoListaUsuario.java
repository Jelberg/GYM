/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FO1;

import AccesoDatosLayer.FO1.IDaoUsuario;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import Comun.Dominio.Usuario;
import LogicaLayer.Comando;
import java.util.ArrayList;

/**
 *
 * @author YESIMAR
 */
public class ComandoListaUsuario extends Comando{
    private Usuario _usuario;
    private String resultado;
    private ArrayList<Usuario> _listaUsuario;
    
    public ComandoListaUsuario(Usuario _usuario) {
        this._usuario = _usuario;
    }

    public ComandoListaUsuario() {
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

    public void setListaUsuario(ArrayList<Usuario> _listaUsuario) {
        this._listaUsuario = _listaUsuario;
    }
    
    public ArrayList<Usuario> getListUsuario(){
        return _listaUsuario;
    }
    
    @Override
    public void ejecutar() {
        FabricaDaoPostgre fab = (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1);
        IDaoUsuario dao = fab.getDaoUsuario();
        setListaUsuario(dao.getListUsuario());
    }
    
}
