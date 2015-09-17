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
public class NodoAdmin {
    
    public NodoAdmin(String correo, String pass, NodoAdmin padre) {
        this.correo = correo;
        this.pass = pass;
        this.padre = padre;
        this.eq = 0;
        this.izquierda = null;
        this.derecha = null;
    }
    
    private String correo;
    private String pass;
    private int eq;
    private NodoAdmin padre;
    private NodoAdmin izquierda;
    private NodoAdmin derecha;

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
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
    public NodoAdmin getPadre() {
        return padre;
    }

    /**
     * @param padre the padre to set
     */
    public void setPadre(NodoAdmin padre) {
        this.padre = padre;
    }

    /**
     * @return the izquierda
     */
    public NodoAdmin getIzquierda() {
        return izquierda;
    }

    /**
     * @param izquierda the izquierda to set
     */
    public void setIzquierda(NodoAdmin izquierda) {
        this.izquierda = izquierda;
    }

    /**
     * @return the derecha
     */
    public NodoAdmin getDerecha() {
        return derecha;
    }

    /**
     * @param derecha the derecha to set
     */
    public void setDerecha(NodoAdmin derecha) {
        this.derecha = derecha;
    }
}
