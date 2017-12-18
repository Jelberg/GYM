/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author Luis L
 */
public class Progreso_rutina {
    private int _PR_ID;
    private String _PR_Progeso;
    private String _PR_Evaluacion;
    private int _rutina;
   // return _PR_ID identificador del progeso rutina
    public int getPR_ID() {
        return _PR_ID;
    }
    // param _PR_Id progreso rutina id to set
    public void setPR_ID(int _PR_ID) {
        this._PR_ID = _PR_ID;
    }
// return _PR_Progeso 
    public String getPR_Progeso() {
        return _PR_Progeso;
    }
// param _PR_Progreso _PR_progreso to set
    public void setPR_Progeso(String _PR_Progeso) {
        this._PR_Progeso = _PR_Progeso;
    }
// return _PR_Evaluacion
    public String getPR_Evaluacion() {
        return _PR_Evaluacion;
    }
// param _PR_Evaluacion _PR_Evaluacion to set
    public void setPR_Evaluacion(String _PR_Evaluacion) {
        this._PR_Evaluacion = _PR_Evaluacion;
    }
// return _rutina id de la rutina evaluada
    public int getRutina() {
        return _rutina;
    }
// param _rutina  _rutina to set
    public void setRutina(int _rutina) {
        this._rutina = _rutina;
    }
    
            
}
