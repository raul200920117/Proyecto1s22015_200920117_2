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
    
     Nodo raiz;
    
    public choferAVL() {
        raiz = null;
    }
    
 public boolean insert(int clave , String nombre, String apellido, String pass) {
        if (raiz == null)
            raiz = new Nodo(clave, nombre, apellido, pass , null);
        else {
            Nodo n = raiz;
            Nodo padre;
            while (true) {
                if (n.getNumero() == clave)
                    return false;
 
                padre = n;
 
                boolean goLeft = n.getNumero() > clave;
                n = goLeft ? n.getIzquierda() : n.getDerecha();
 
                if (n == null) {
                    if (goLeft) {
                        padre.setIzquierda(new Nodo(clave, nombre, apellido, pass , padre));
                    } else {
                        padre.setDerecha(new Nodo(clave, nombre, apellido, pass , padre));
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
        Nodo n = raiz;
        Nodo padre = raiz;
        Nodo borNodo = null;
        Nodo hijo = raiz;
 
        while (hijo != null) {
            padre = n;
            n = hijo;
            hijo = borrado >= n.getNumero() ? n.getDerecha() : n.getIzquierda();
            if (borrado == n.getNumero())
                borNodo = n;
        }
 
        if (borNodo != null) {
            borNodo.setNumero(n.getNumero());
 
            hijo = n.getIzquierda() != null ? n.getIzquierda() : n.getDerecha();
 
            if (raiz.getNumero() == borrado) {
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
 
     private void rebalancear(Nodo n) {
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
     
    private Nodo rotDD(Nodo aux) {
 
        Nodo base = aux.getDerecha();
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
    
    private Nodo rotII(Nodo aux) {
 
        Nodo base = aux.getIzquierda();
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
    
    private Nodo rotID(Nodo n) {
        n.setIzquierda(rotDD(n.getIzquierda()));
        return rotII(n);
    }
    
    private Nodo rotDI(Nodo n) {
        n.setDerecha(rotII(n.getDerecha()));
        return rotDD(n);
    }
    
    private int altura(Nodo n) {
        if (n == null) {
            return -1;
        } else {
            return 1 + Math.max(altura(n.getIzquierda()), altura(n.getDerecha()));
        }
    }

    private void setBalance(Nodo... nodos) {
        for (Nodo n : nodos)
            n.setEq(altura(n.getDerecha()) - altura(n.getIzquierda()));
    }
    
       
    public void mostrar(){
        Nodo aux;
        aux = raiz;
        auxMostrar(aux);
     }
    
    private void auxMostrar(Nodo auxi) {
        
        System.out.println("act: " + auxi.getNumero() );
  
        
        if(auxi.getIzquierda() != null){
            System.out.println("izq: " + auxi.getIzquierda().getNumero());
            auxMostrar(auxi.getIzquierda());            
        }
        
        if(auxi.getDerecha() != null){
            System.out.println("der: " + auxi.getDerecha().getNumero());
            auxMostrar(auxi.getDerecha());
        }
        
    }
}
