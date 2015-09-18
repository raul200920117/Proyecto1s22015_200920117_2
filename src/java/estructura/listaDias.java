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
public class listaDias {
    public NodoDias primero;
    public NodoDias ultimo;
    
    public listaDias(){
        primero = null;
        ultimo = null;
    }
    
    public void insertar(String dia){
        
        NodoDias nuevo = new NodoDias(dia);
        
        if(primero !=null){
            ultimo.setSig(nuevo);
            nuevo.setAnt(ultimo);
            ultimo = nuevo;
        }else{
            primero = nuevo;
            ultimo = nuevo;
        }
    }
    
    public boolean borrar(String dia){
        NodoDias aux;
        aux = primero;
        
        while(aux != null){
            if(aux.getDia().equals(dia)){
                if(aux == primero && aux == ultimo){
                    primero = null;
                    ultimo = null;
                }else if(aux == primero){
                    aux.getSig().setAnt(null);
                    primero = aux.getSig();
                }else if(aux == ultimo){
                    aux.getAnt().setSig(null);
                    ultimo = aux.getAnt();
                }else{
                    aux.getAnt().setSig(aux.getSig());
                    aux.getSig().setAnt(aux.getAnt());
                }
                return true;
            }
            
            aux = aux.getSig();
        }
         return false;
    }
    
    public void mostrar(){
        NodoDias aux;
        aux = primero;
        while(aux != null){
            if(aux.getSig() != null){
                
            }
            
            if(aux.getAnt() != null){
                
            }
            
            aux = aux.getSig();
        }
    }
    
    public NodoDias modificar(String dia){
        
        NodoDias aux;
        aux = primero;
        
        while(aux != null){
            if(aux.getDia().equals(dia)){
                return aux;
            }
            
           aux = aux.getSig();
        }
        return null;
    }
    
    
    
    
}
