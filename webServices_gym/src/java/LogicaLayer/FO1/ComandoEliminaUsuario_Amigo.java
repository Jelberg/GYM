/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaLayer.FO1;

import AccesoDatosLayer.FO1.IDaoUsuarioAmigo;
import AccesoDatosLayer.FabricaAbstracta;
import AccesoDatosLayer.FabricaDaoPostgre;
import Comun.Dominio.Usuario_Amigo;
import LogicaLayer.Comando;

/**
 *
 * @author YESIMAR
 */
public class ComandoEliminaUsuario_Amigo extends Comando{
    Usuario_Amigo _s;
    private String resultado;

    public ComandoEliminaUsuario_Amigo(Usuario_Amigo _s) {
        this._s = _s;
    }

    public ComandoEliminaUsuario_Amigo(Usuario_Amigo _s, String resultado) {
        this._s = _s;
        this.resultado = resultado;
    }

    public Usuario_Amigo getS() {
        return _s;
    }

    public void setS(Usuario_Amigo _s) {
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
        IDaoUsuarioAmigo dao = fab.getDaoUsuarioAmigo();
        setResultado(dao.eliminaUsuario_Amigo(_s));
    }
    
}
