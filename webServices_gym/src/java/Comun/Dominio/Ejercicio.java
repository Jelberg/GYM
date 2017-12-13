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
    private String _maquina;
    private String _equipo;

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

    public String getGrupomuscular() {
        return _grupomuscular;
    }

    /**
     * @param _grupomuscular the _grupomuscular to set
     */

    public void setGrupomuscular(String _grupomuscular) {
        this._grupomuscular = _grupomuscular;
    }

    /**
     * @return the _maquina
     */
    public String getMaquina() {
        return _maquina;
    }

    /**
     * @param _maquina the _maquina to set
     */

    public void setMaquina(String _maquina) {
        this._maquina = _maquina;
    }

    /**
     * @return the _equipo
     */

    public String getEquipo() {
        return _equipo;
    }

    /**
     * @param _equipo the _equipo to set
     */
    public void setEquipo(String _equipo) {
        this._equipo = _equipo;
    }
    
    public Ejercicio (int _id, String _nombre, String _grupomuscular, String _maquina, String _equipo){
        this._id=_id;
        this._nombre=_nombre;
        this._grupomuscular=_grupomuscular;
        this._maquina=_maquina;
        this._equipo=_maquina;
    }
    
    public Ejercicio (int _id){
        super (_id);
    }
    
    public Ejercicio (){
        super();
    }
}
