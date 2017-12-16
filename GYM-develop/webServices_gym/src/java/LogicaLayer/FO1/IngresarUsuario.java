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
public class IngresarUsuario extends Comando{
    Usuario _usuario;
        
    public IngresarUsuario (Usuario usuario){
        _usuario = usuario;
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
        _usuario.setNombre(dao.Insertar(_usuario));
    }

    
}
