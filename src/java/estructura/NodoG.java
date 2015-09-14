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
public class NodoG {
    
    public NodoG(int id_Estacion, String nombre, NodoG padre) {
        this.id_Estacion = id_Estacion;
        this.nombre = nombre;
        this.padre = padre;
        this.personas_sist = 0;
        this.padre = padre;
        this.izquierda = null;
        this.derecha = null;
    }
    
    
    private int id_Estacion;
    private String nombre;
    private int personas_sist;
    private int eq;
    private NodoG padre;
    private NodoG izquierda;
    private NodoG derecha;

    /**
     * @return the id_Estacion
     */
    public int getId_Estacion() {
        return id_Estacion;
    }

    /**
     * @param id_Estacion the id_Estacion to set
     */
    public void setId_Estacion(int id_Estacion) {
        this.id_Estacion = id_Estacion;
    }

    /**
     * @return the personas_sist
     */
    public int getPersonas_sist() {
        return personas_sist;
    }

    /**
     * @param personas_sist the personas_sist to set
     */
    public void setPersonas_sist(int personas_sist) {
        this.personas_sist = personas_sist;
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
    public NodoG getPadre() {
        return padre;
    }

    /**
     * @param padre the padre to set
     */
    public void setPadre(NodoG padre) {
        this.padre = padre;
    }

    /**
     * @return the izquierda
     */
    public NodoG getIzquierda() {
        return izquierda;
    }

    /**
     * @param izquierda the izquierda to set
     */
    public void setIzquierda(NodoG izquierda) {
        this.izquierda = izquierda;
    }

    /**
     * @return the derecha
     */
    public NodoG getDerecha() {
        return derecha;
    }

    /**
     * @param derecha the derecha to set
     */
    public void setDerecha(NodoG derecha) {
        this.derecha = derecha;
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
}
