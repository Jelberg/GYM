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

/**
 *
 * @author Miguel
 */
public class ComandoGetCorreo extends Comando{
    private Usuario _usuario;
    private String resultado;

    public String getResultado() {
        return resultado;
    }

    public ComandoGetCorreo(Usuario _usuario) {
        this._usuario = _usuario;
    }

    public Usuario getUsuario() {
        return _usuario;
    }

    public void setUsuario(Usuario _usuario) {
        this._usuario = _usuario;
    }
    

    @Override
    public void ejecutar() {
        FabricaDaoPostgre fab = (FabricaDaoPostgre)FabricaAbstracta.getFabrica(1);
        IDaoUsuario dao = fab.getDaoUsuario();
        setResultado(dao.get_Usuariocorreo(_usuario));
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
