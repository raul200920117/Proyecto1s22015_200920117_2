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
public class busLista {
    
    busNodo primero;
    
    public busLista(){
        primero = null;
    }
    
    public void insertar(int bus){
        busNodo nuevo = new busNodo(bus);
        
        if(primero == null){
            primero = nuevo;
        }else {
                       
            busNodo aux;
            aux = primero;
            
            while(aux!=null){
                if(aux.getIdbus() > bus){
                    nuevo.setSig(primero);
                    primero = nuevo;
                }else if(aux.getIdbus() < bus && aux.getSig().getIdbus() > bus){
                    nuevo.setSig(aux.getSig());
                    aux.setSig(nuevo);
                }else if(aux.getIdbus() < bus && aux.getSig() == null){
                    aux.setSig(nuevo);
                }
                
                aux = aux.getSig();
            }
        }
    }
}
