/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FO1;

import AccesoDatosLayer.FO1.IDaoUsuarioAmigo;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import Comun.Dominio.Usuario_Amigo;
import LogicaLayer.Comando;

/**
 *
 * @author YESIMAR
 */
public class ComandoInsertaUsuario_Amigo extends Comando {
    Usuario_Amigo _ua;

    public ComandoInsertaUsuario_Amigo(Usuario_Amigo _ua) {
        this._ua = _ua;
    }

    public Usuario_Amigo getUa() {
        return _ua;
    }

    public void setUa(Usuario_Amigo _ua) {
        this._ua = _ua;
    }

    @Override
    public void ejecutar() {
        FabricaDaoPostgre fab = (FabricaDaoPostgre)FabricaAbstracta.getFabrica(1);
        IDaoUsuarioAmigo dao = fab.getDaoUsuarioAmigo();
//        int foo = Integer.parseInt(dao.insertaUsuario_Amigo);
//        _ua.setAmi_usuario(dao.foo(_ua));
    }
}
