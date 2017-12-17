/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.FO3;

import AccesoDatosLayer.IDao;

/**
 *
 * @author Elberg
 */
public interface IDaoRutina extends IDao {
    public String consultaEjerciciosRealizados(int id);
}
