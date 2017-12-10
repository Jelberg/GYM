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
    
    
    public String ejecuta() {
        FabricaDaoPostgre fab = (FabricaDaoPostgre)FabricaAbstracta.getFabrica(1);
        IDaoUsuario dao = fab.getDaoUsuario();
        return dao.Insertar(_usuario);
        
    }

    @Override
    public void ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
