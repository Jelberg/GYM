/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author gilbert
 */
public class Usuario {
    private String _nombre;
    private String _apellido;
    private String _sexo;
    private String _fechaNacimiento;

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
     * @return the _apellido
     */
    public String getApellido() {
        return _apellido;
    }

    /**
     * @param _apellido the _apellido to set
     */
    public void setApellido(String _apellido) {
        this._apellido = _apellido;
    }

    /**
     * @return the _sexo
     */
    public String getSexo() {
        return _sexo;
    }

    /**
     * @param _sexo the _sexo to set
     */
    public void setSexo(String _sexo) {
        this._sexo = _sexo;
    }

    /**
     * @return the _fechaNacimiento
     */
    public String getFechaNacimiento() {
        return _fechaNacimiento;
    }

    /**
     * @param _fechaNacimiento the _fechaNacimiento to set
     */
    public void setFechaNacimiento(String _fechaNacimiento) {
        this._fechaNacimiento = _fechaNacimiento;
    }
}
