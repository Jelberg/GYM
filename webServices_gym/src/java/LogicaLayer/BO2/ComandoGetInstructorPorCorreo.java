/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.BO2;

import AccesoDatosLayer.BO2.IDaoInstructor;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import Comun.Dominio.Instructor;
import LogicaLayer.Comando;
import java.util.ArrayList;

/**
 *
 * @author simon
 */
public class ComandoGetInstructorPorCorreo extends Comando {

    private String _correo;
    private ArrayList<Instructor> _instructor;
    
    public ComandoGetInstructorPorCorreo (String correo){
        _correo = correo;
    }

    public ArrayList<Instructor> getInstructor (){
        return _instructor;
    }
    
    @Override
    public void ejecutar() {
        FabricaDaoPostgre fab = (FabricaDaoPostgre) FabricaAbstracta.getFabrica(1);
        IDaoInstructor dao = fab.getDaoInstructor();
        _instructor = dao.getInstructorPorCorreo(_correo);
    }
    
}
