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
public class NodoBuses {

    public NodoBuses(int num_bus, String ruta) {
        this.num_bus = num_bus;
        this.ruta = ruta;
        this.sig = null;
        this.ant = null;
        this.list = new listaHoras();
    }
    
    
    private int num_bus;
    private String ruta;
    private NodoBuses sig;
    private NodoBuses ant;
    public listaHoras list;

    /**
     * @return the num_bus
     */
    public int getNum_bus() {
        return num_bus;
    }

    /**
     * @param num_bus the num_bus to set
     */
    public void setNum_bus(int num_bus) {
        this.num_bus = num_bus;
    }

    /**
     * @return the ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * @return the sig
     */
    public NodoBuses getSig() {
        return sig;
    }

    /**
     * @param sig the sig to set
     */
    public void setSig(NodoBuses sig) {
        this.sig = sig;
    }

    /**
     * @return the ant
     */
    public NodoBuses getAnt() {
        return ant;
    }

    /**
     * @param ant the ant to set
     */
    public void setAnt(NodoBuses ant) {
        this.ant = ant;
    }
}
