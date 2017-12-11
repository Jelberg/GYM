/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.FO1;

import Comun.Dominio.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public interface IDaoUsuario {
    public String IniciarSesion(Usuario u);
    public String Insertar( Usuario u);
    public String get_Usuariocorreo(Usuario u);
    public String updatePassword(Usuario u);
    public String updateCodigo(Usuario u);
    public String getUsuarioNomApe(Usuario u);
    public String eliminaUsuario(Usuario u);
    public String getUsuario(Usuario u);
    public String modificaUsuario(Usuario u);
    public ArrayList<Usuario> getListUsuario();
}
