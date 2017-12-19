/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comun.Dominio;

/**
 *
 * @author Luis L 
 */
public class Ejercicio extends Entidad {
    private int _id;
    private String _nombre;
    private String _grupomuscular;

    /**
     * @return the _id
     */
    public int getId() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void setId(int _id) {
        this._id = _id;
    }

    /**
     * @return the _nombre
     */

    public String getNombre() {
        return _nombre;
    }

    /**
     * @param _nombre the _nombre to set
     */

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    /**
     * @return the _grupomuscular
     */

    public String getGrupoMuscular() {
        return _grupomuscular;
    }

    /**
     * @param _grupomuscular the _grupomuscular to set
     */

    public void setGrupoMuscular(String _grupomuscular) {
        this._grupomuscular = _grupomuscular;
    }

    
    
    public Ejercicio (int _id, String _nombre, String _grupomuscular){
        this._id=_id;
        this._nombre=_nombre;
        this._grupomuscular=_grupomuscular;
    }
    
    public Ejercicio (int _id){
        super (_id);
    }
    
    public Ejercicio (){
        super();
    }
}
