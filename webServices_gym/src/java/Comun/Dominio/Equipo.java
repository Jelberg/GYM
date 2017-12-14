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
public class Equipo extends Entidad {

   private int _id;
   private String _nombre;
    
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
    
    public Equipo (int _id, String _nombre){
        this._id=_id;
        this._nombre=_nombre;
    }
    
    public Equipo (int _id){
        super(_id);
    }   
    
    public Equipo (){
        super();
    } 
}
