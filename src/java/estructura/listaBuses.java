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
public class listaBuses {
    
    public NodoBuses primero;
    
    public listaBuses(){
        primero = null;
    }
    
    public void insertar(int numero, String ruta, String horaInicio, String horaFinal){
        
        NodoBuses nuevo = new NodoBuses(numero, ruta, horaInicio, horaFinal);
        
        if(primero != null){
            NodoBuses aux = primero;
            while(aux != null){
                if(aux.getNum_bus() < numero && aux.getSig().getNum_bus() > numero ){
                    nuevo.setSig(aux.getSig());
                    nuevo.setAnt(aux);
                    aux.setSig(nuevo);
                    nuevo.getSig().setAnt(nuevo);
                }else if(aux.getNum_bus() > numero ){
                    primero.setAnt(nuevo);
                    nuevo.setSig(primero);
                    primero = nuevo;
                }else if(aux.getNum_bus() < numero && aux.getSig() == null ){
                    aux.setSig(nuevo);
                    nuevo.setAnt(aux);
                }else{
                    aux = aux.getSig();
                }
            }
            
        }else{
            primero = nuevo;
        }
        
    }
    
    public boolean borrar(int bus){
   
        NodoBuses aux = primero;
        while (aux != null) {
            if (aux.getNum_bus() == bus) {
                if (aux == primero && aux.getSig() == null) {
                    primero = null;
                } else if (aux == primero) {
                    aux.getSig().setAnt(null);
                    primero = aux.getSig();
                } else {
                    aux.getAnt().setSig(aux.getSig());
                    aux.getSig().setAnt(aux.getAnt());
                }
                
                return true;
            } else {
                aux = aux.getSig();
            }
        }
        
        return false;
    }
    
    
    public void mostrar(){
        NodoBuses aux;
        aux = primero;
        
        while(aux != null){
            
            if(aux.getSig() != null){
                
            }
            
            if(aux.getAnt() != null){
                
            }
            
            aux = aux.getSig();
        }
    }
}
