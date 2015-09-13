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
public class choferAVL {
    
    choferNodo raiz;
    int contadorNodos;
    
    public choferAVL() {
        this.raiz = null;
        this.contadorNodos = 0;
    }
    
    public void insertar(int id, String nom, String ape, String pas){
        
        choferNodo nuevo = new choferNodo(id,nom,ape,pas);
        
        if (raiz != null) {
            auxInsertar(nuevo, raiz);
        } else {
            raiz = nuevo;
        }
    }

    private void auxInsertar(choferNodo nuevo, choferNodo raiz) {
        
        
    }
    
    
    
}
