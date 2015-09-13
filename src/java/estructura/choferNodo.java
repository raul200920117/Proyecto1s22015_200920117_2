/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

/**
 *
 * @author Raulk
 */
public class choferNodo {

    public choferNodo(int id, String nombre, String apellido, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.izquierda = null;
        this.derecha = null;
    }
    
    private int id;
    private String nombre;
    private String apellido;
    private String password;
    private int factorEquilibrio;
    private choferNodo derecha;
    private choferNodo izquierda;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the factorEquilibrio
     */
    public int getFactorEquilibrio() {
        return factorEquilibrio;
    }

    /**
     * @param factorEquilibrio the factorEquilibrio to set
     */
    public void setFactorEquilibrio(int factorEquilibrio) {
        this.factorEquilibrio = factorEquilibrio;
    }

    /**
     * @return the derecha
     */
    public choferNodo getDerecha() {
        return derecha;
    }

    /**
     * @param derecha the derecha to set
     */
    public void setDerecha(choferNodo derecha) {
        this.derecha = derecha;
    }

    /**
     * @return the izquierda
     */
    public choferNodo getIzquierda() {
        return izquierda;
    }

    /**
     * @param izquierda the izquierda to set
     */
    public void setIzquierda(choferNodo izquierda) {
        this.izquierda = izquierda;
    }
}
