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
    
    public ArrayList<Comentario> getComentarios();
    public String insertar(Entidad comentario);
    public String eliminar(Comentario comentario);
    public String actualizar(Comentario comentario);
    
    /**
     * Firma de metodo para la consulta de los progresos
     * @param id
     * @return 
     */
    public String consultaProgresos(int id);
    
    
}