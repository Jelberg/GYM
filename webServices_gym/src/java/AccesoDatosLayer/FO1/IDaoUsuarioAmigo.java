/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.FO1;

/**
 *
 * @author Miguel
 */
public interface IDaoUsuarioAmigo {
    public String insertaUsuario_Amigo( int idUsuario,
                                        int idAmigo);
     public String getUsuario_Amigo(int idUsuario);
     public String eliminaUsuario_Amigo(int idUsuario,
                                       int idAmigo);
}
