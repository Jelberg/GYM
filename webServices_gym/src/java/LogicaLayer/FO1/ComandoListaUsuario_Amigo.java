/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FO1;

import AccesoDatosLayer.FO1.IDaoUsuarioAmigo;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import Comun.Dominio.Usuario;
import Comun.Dominio.Usuario_Amigo;
import LogicaLayer.Comando;
import java.util.ArrayList;

/**
 *
 * @author YESIMAR
 */
public class ComandoListaUsuario_Amigo extends Comando {
    private Usuario_Amigo _usuarioa;
    private Usuario _usuario;
    private String resultado;
    private ArrayList<Usuario> _listaUsuario_Amigo;

    public ComandoListaUsuario_Amigo(Usuario _usuarioa) {
        this._usuario = _usuarioa;
    }

    public ComandoListaUsuario_Amigo() {
    }

    public Usuario_Amigo getUsuarioa() {
        return _usuarioa;
    }

    public void setUsuarioa(Usuario_Amigo _usuarioa) {
        this._usuarioa = _usuarioa;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public ArrayList<Usuario> getListUsuario_Amigo() {
        return _listaUsuario_Amigo;
    }

    public void setListUsuario_Amigo(ArrayList<Usuario> _listaUsuario_Amigo) {
        this._listaUsuario_Amigo = _listaUsuario_Amigo;
    }

    @Override
    public void ejecutar() {
        FabricaDaoPostgre fab = (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1);
        IDaoUsuarioAmigo dao = fab.getDaoUsuarioAmigo();
        setListUsuario_Amigo(dao.getListUsuario_Amigo(_usuario.getId()));
    }
  
}
