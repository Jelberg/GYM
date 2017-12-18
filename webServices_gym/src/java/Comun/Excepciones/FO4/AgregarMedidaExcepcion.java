/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun.Excepciones.FO4;

/**
 *
 * @author Elberg
 */
public class AgregarMedidaExcepcion extends Exception {
    private int _code=5020;
    private String _clase;
    private String _especificacion;

    /**
     * Constructor par el error de agregar peso
     * @param _error
     * @param _clase
     * @param _especificacion 
     */
    public AgregarMedidaExcepcion(Exception _error, String _clase, String _especificacion) {
        super(_error);
        this._clase = _clase;
        this._especificacion = _especificacion;
    }

    /**
     * Metodo que devuelve la excepcion 
     * @return 
     */
    @Override
    public String toString() {
        return "AgregarMedidaExepcion{" + "_code=" + _code + ", _clase=" + _clase + ", _especificacion=" + _especificacion + '}';
    }
}
