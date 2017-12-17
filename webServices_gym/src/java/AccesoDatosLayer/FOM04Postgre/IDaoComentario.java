/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.FOM04Postgre;

import Comun.Dominio.Comentario;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public interface IDaoComentario {
    
    public ArrayList<Comentario> getComentarios();
    public String insertar(Comentario comentario);
    public String eliminar(Comentario comentario);
    public String actualizar(Comentario comentario);
    
}