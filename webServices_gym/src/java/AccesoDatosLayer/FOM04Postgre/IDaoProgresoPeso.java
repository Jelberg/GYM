/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosLayer.FOM04Postgre;

import AccesoDatosLayer.IDao;
import Comun.Dominio.Entidad;

/**
 *
 * @author Elberg
 */
public interface IDaoProgresoPeso extends IDao{
    public Entidad consultarProgresoPeso(int idusuario);
}
