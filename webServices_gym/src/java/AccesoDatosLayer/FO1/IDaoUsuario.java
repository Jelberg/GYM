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
    public String Modificar(        int id,
                                    String nombre,
                                    String apellido,
                                    String fecha,
                                    String sexo,
                                    String correo,
                                    String usuario,
                                    String password,
                                    int estatura,
                                    String telefono,
                                    boolean entrenador);
    public String Consultar(int id);
    public String Insertar( Usuario u);
    public String get_Usuariocorreo( String correo);
    public String updatePassword( String correo, String password);
    public String updateCodigo(String correo, int codigo );
    public String getUsuarioNomApe( String nombre, String apellido);
    public String Elimina( int idUsuario);
}
