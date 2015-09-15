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
public class NodoDias {

    public NodoDias(String dia) {
        this.dia = dia;
        this.ant = null;
        this.sig = null;
        this.lista = new listaBuses();
    }
    
    
    private String dia;
    private NodoDias sig;
    private NodoDias ant;
    public listaBuses lista;
    /**
     * @return the dia
     */
    public String getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

    /**
     * @return the sig
     */
    public NodoDias getSig() {
        return sig;
    }

    /**
     * @param sig the sig to set
     */
    public void setSig(NodoDias sig) {
        this.sig = sig;
    }

    /**
     * @return the ant
     */
    public NodoDias getAnt() {
        return ant;
    }

    /**
     * @param ant the ant to set
     */
    public void setAnt(NodoDias ant) {
        this.ant = ant;
    }
}
