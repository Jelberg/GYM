/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.FO1;

import Comun.Dominio.Usuario;
import Comun.Dominio.Usuario_Amigo;
import java.util.ArrayList;

/**
 *
 * @author Miguel
 */
public interface IDaoUsuarioAmigo {
    public String insertaUsuario_Amigo(Usuario_Amigo ua);
     public String getUsuario_Amigo(Usuario_Amigo ua);
     public String eliminaUsuario_Amigo(Usuario_Amigo ua);
     public ArrayList<Usuario> getListUsuario_Amigo();
}
