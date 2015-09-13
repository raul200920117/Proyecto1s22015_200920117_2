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
public class Nodo {
     public Nodo(int numero, String nombre, String apellio, String pass, Nodo padre) {
        this.numero = numero;
        this.nombre = nombre;
        this.apellio = apellio;
        this.pass = pass;
        this.eq = 0;
        this.padre = padre;
        this.izquierda = null;
        this.derecha = null;
    }
    
    private int numero;
    private String nombre;
    private String apellio;
    private String pass;
    private int eq;
    private Nodo padre;
    private Nodo izquierda;
    private Nodo derecha;

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
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
     * @return the izquierda
     */
    public Nodo getIzquierda() {
        return izquierda;
    }

    /**
     * @param izquierda the izquierda to set
     */
    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    /**
     * @return the derecha
     */
    public Nodo getDerecha() {
        return derecha;
    }

    /**
     * @param derecha the derecha to set
     */
    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    /**
     * @return the eq
     */
    public int getEq() {
        return eq;
    }

    /**
     * @param eq the eq to set
     */
    public void setEq(int eq) {
        this.eq = eq;
    }

    /**
     * @return the padre
     */
    public Nodo getPadre() {
        return padre;
    }

    /**
     * @param padre the padre to set
     */
    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    /**
     * @return the apellio
     */
    public String getApellio() {
        return apellio;
    }

    /**
     * @param apellio the apellio to set
     */
    public void setApellio(String apellio) {
        this.apellio = apellio;
    }

    /**
     * @return the contraseña
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setPass(String contraseña) {
        this.pass = contraseña;
    }


}
