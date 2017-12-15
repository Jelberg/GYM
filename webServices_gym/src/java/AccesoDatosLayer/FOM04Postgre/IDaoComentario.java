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
    
    public ArrayList<Comentario> getComentariosProgMedida(int idUsuario, int idProgresoM);
    public void insertar(Comentario comentario);
    public void eliminar(Comentario comentario);
    public void actualizar(Comentario comentario);
    
}
