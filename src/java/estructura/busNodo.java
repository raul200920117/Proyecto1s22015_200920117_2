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
public class busNodo {

    public busNodo(int idbus) {
        this.idbus = idbus;
    }
    
    private int idbus;
    private busNodo sig;

    /**
     * @return the idbus
     */
    public int getIdbus() {
        return idbus;
    }

    /**
     * @param idbus the idbus to set
     */
    public void setIdbus(int idbus) {
        this.idbus = idbus;
    }

    /**
     * @return the sig
     */
    public busNodo getSig() {
        return sig;
    }

    /**
     * @param sig the sig to set
     */
    public void setSig(busNodo sig) {
        this.sig = sig;
    }
}
