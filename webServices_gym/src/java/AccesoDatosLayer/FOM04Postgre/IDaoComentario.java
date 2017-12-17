/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.FOM04Postgre;

import AccesoDatosLayer.IDao;
import Comun.Dominio.Comentario;
import Comun.Dominio.Entidad;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public interface IDaoComentario extends IDao {
    
    /**
     * Firma de metodo apra obterner comentarios
     * @return 
     */
    public ArrayList<Comentario> getComentarios();
<<<<<<< HEAD
    public String insertar(Entidad comentario);
=======
    /**
     * Firma de metodos para insertar comentario
     * @param comentario
     * @return 
     */
    public String insertar(Comentario comentario);
    /**
     * Firma de metodo para eliminar comentario
     * @param comentario
     * @return 
     */
>>>>>>> 56d17d0f837f8bcb3d214937cc9fa23f8bba85b7
    public String eliminar(Comentario comentario);
    /**
     * Firma de metodo para actualizar comentario
     * @param comentario
     * @return 
     */
    public String actualizar(Comentario comentario);
    /**
     * Firma de metodo para obtener una lista de los comentarios por idProgMedida
     * @param idUsuario
     * @param idProgMedida
     * @return 
     */
    public ArrayList<Comentario> getComentariosProgMedida(int idUsuario,int idProgMedida);
    
    /**
     * Firma de metodo para la consulta de los progresos
     * @param id
     * @return 
     */
    public String consultaProgresos(int id);
    
    
}