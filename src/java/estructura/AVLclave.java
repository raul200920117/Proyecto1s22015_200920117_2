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
public class AVLclave {
    NodoC raiz;
    
    public AVLclave() {
        raiz = null;
    }
    
 public boolean insert(int clave, String nombre) {
        if (raiz == null)
            raiz = new NodoC(clave,nombre, null);
        else {
            NodoC n = raiz;
            NodoC padre;
            while (true) {
                if (n.getId_Estacion()== clave)
                    return false;
 
                padre = n;
 
                boolean goLeft = n.getId_Estacion() > clave;
                n = goLeft ? n.getIzquierda() : n.getDerecha();
 
                if (n == null) {
                    if (goLeft) {
                        padre.setIzquierda(new NodoC(clave,nombre, padre));
                    } else {
                        padre.setDerecha(new NodoC(clave,nombre, padre));
                    }
                    rebalancear(padre);
                    break;
                }
            }
        }
        return true;
    }
    
 public void borrar(int borrado) {
        if (raiz == null)
            return;
        NodoC n = raiz;
        NodoC padre = raiz;
        NodoC borNodo = null;
        NodoC hijo = raiz;
 
        while (hijo != null) {
            padre = n;
            n = hijo;
            hijo = borrado >= n.getId_Estacion() ? n.getDerecha() : n.getIzquierda();
            if (borrado == n.getId_Estacion())
                borNodo = n;
        }
 
        if (borNodo != null) {
            borNodo.setId_Estacion(n.getId_Estacion());
 
            hijo = n.getIzquierda() != null ? n.getIzquierda() : n.getDerecha();
 
            if (raiz.getId_Estacion() == borrado) {
                raiz = hijo;
            } else {
                if (padre.getIzquierda() == n) {
                    padre.setIzquierda(hijo);
                } else {
                    padre.setDerecha(hijo);
                }
                rebalancear(padre);
            }
        }
    }
 
     private void rebalancear(NodoC n) {
        setBalance(n);
 
        if (n.getEq() == -2) {
            if (altura(n.getIzquierda().getIzquierda()) >= altura(n.getIzquierda().getDerecha()))
                n = rotII(n);
            else
                n = rotID(n);
 
        } else if (n.getEq() == 2) {
            if (altura(n.getDerecha().getDerecha()) >= altura(n.getDerecha().getIzquierda()))
                n = rotDD(n);
            else
                n = rotDI(n);
        }
 
        if (n.getPadre() != null) {
            rebalancear(n.getPadre());
        } else {
            raiz = n;
        }
    }
     
    private NodoC rotDD(NodoC aux) {
 
        NodoC base = aux.getDerecha();
        base.setPadre(aux.getPadre());
 
        aux.setDerecha(base.getIzquierda()); 
 
        if (aux.getDerecha() != null)
            aux.getDerecha().setPadre(aux);
 
        base.setIzquierda(aux);
        aux.setPadre(base);
 
        if (base.getPadre() != null) {
            if (base.getPadre().getDerecha() == aux) {
                base.getPadre().setDerecha(base);
            } else {
                base.getPadre().setIzquierda(base);
            }
        }
 
        setBalance(aux, base);
 
        return base;
    }
    
    private NodoC rotII(NodoC aux) {
 
        NodoC base = aux.getIzquierda();
        base.setPadre(aux.getPadre());
 
        aux.setIzquierda(base.getDerecha());
 
        if (aux.getIzquierda() != null)
            aux.getIzquierda().setPadre(aux);
 
        base.setDerecha(aux);
        aux.setPadre(base);
 
        if (base.getPadre() != null) {
            if (base.getPadre().getDerecha() == aux) {
                base.getPadre().setDerecha(base);
            } else {
                base.getPadre().setIzquierda(base);
            }
        }
 
        setBalance(aux, base);
 
        return base;
    }
    
    private NodoC rotID(NodoC n) {
        n.setIzquierda(rotDD(n.getIzquierda()));
        return rotII(n);
    }
    
    private NodoC rotDI(NodoC n) {
        n.setDerecha(rotII(n.getDerecha()));
        return rotDD(n);
    }
    
    private int altura(NodoC n) {
        if (n == null) {
            return -1;
        } else {
            return 1 + Math.max(altura(n.getIzquierda()), altura(n.getDerecha()));
        }
    }

    private void setBalance(NodoC... nodos) {
        for (NodoC n : nodos)
            n.setEq(altura(n.getDerecha()) - altura(n.getIzquierda()));
    }
    
    
       
    public void mostrar(){
        NodoC aux;
        aux = raiz;
        auxMostrar(aux);
     }
    
    private void auxMostrar(NodoC auxi) {
        
        System.out.println("act: " + auxi.getId_Estacion() );
  
        
        if(auxi.getIzquierda() != null){
            System.out.println("izq: " + auxi.getIzquierda().getId_Estacion());
            auxMostrar(auxi.getIzquierda());            
        }
        
        if(auxi.getDerecha() != null){
            System.out.println("der: " + auxi.getDerecha().getId_Estacion());
            auxMostrar(auxi.getDerecha());
        }
    }
    
    public NodoC modificar(int id_nodo){
        NodoC aux = raiz;
        while(aux != null){
            if(aux.getId_Estacion() > id_nodo){
                aux = aux.getIzquierda();
            }else if(aux.getId_Estacion() < id_nodo){
                aux = aux.getDerecha();
            }else{
                return aux;
            }
        }
        return null;
    }
}
