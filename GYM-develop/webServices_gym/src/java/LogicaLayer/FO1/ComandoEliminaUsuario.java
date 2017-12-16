/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FO1;

import AccesoDatosLayer.FO1.IDaoUsuario;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import LogicaLayer.Comando;

/**
 *
 * @author YESIMAR
 */
public class ComandoEliminaUsuario extends Comando{
    private String _s;
    private String resultado;
    
    public ComandoEliminaUsuario(String _s) {
        this._s = _s;
    }

    public String getUsuario() {
        return _s;
    }

    public void setUsuario(String _s) {
        this._s = _s;
    }
    
    public String getResultado() {
        return resultado;
    }
    
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    @Override
    public void ejecutar() {
        FabricaDaoPostgre fab = (FabricaDaoPostgre)FabricaAbstracta.getFabrica(1);
        IDaoUsuario dao = fab.getDaoUsuario();
        setResultado(dao.eliminaUsuario(_s));
    }
    
}
