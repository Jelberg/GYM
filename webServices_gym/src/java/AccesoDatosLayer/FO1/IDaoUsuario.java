/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.FO1;
import Comun.Dominio.Usuario;


/**
 *
 * @author Jorge
 */
public interface IDaoUsuario {
    public String Modificar(Usuario u);
    public String Consultar(Usuario u);
    public String IniciarSesion(Usuario u);
    public String Insertar( Usuario u);
    public String get_Usuariocorreo(Usuario u);
    public String updatePassword(Usuario u);
    public String updateCodigo(Usuario u);
    public String getUsuarioNomApe(Usuario u);
    public String Elimina(Usuario u);
}
