/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FO1;

import AccesoDatosLayer.FO1.IDaoUsuario;
import AccesoDatosLayer.FabricaAbstracta;
import Comun.Dominio.Usuario;
import LogicaLayer.Comando;

/**
 *
 * @author Miguel
 */
public class IngresarUsuario extends Comando{
    Usuario usuario;
        
    public IngresarUsuario (Usuario usuario){
        this.usuario = usuario;
    }
    
    
    public String ejecuta() {
        FabricaAbstracta fab = FabricaAbstracta.getFabrica(1);
        IDaoUsuario dao = fab.getDaoUsuario();
        return dao.Insertar(usuario);
        
    }

    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
