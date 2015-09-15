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
public class NodoHoras {
    
    public NodoHoras(String hora, String estacion) {
        this.hora = hora;
        this.estacion = estacion;
    }
    
    private String hora;
    private String estacion;
    private NodoHoras sig;

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * @return the estacion
     */
    public String getEstacion() {
        return estacion;
    }

    /**
     * @param estacion the estacion to set
     */
    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    /**
     * @return the sig
     */
    public NodoHoras getSig() {
        return sig;
    }

    /**
     * @param sig the sig to set
     */
    public void setSig(NodoHoras sig) {
        this.sig = sig;
    }
}
