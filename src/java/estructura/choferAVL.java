/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Raulk
 */
public class choferAVL {
    
    Nodo raiz;
    String graficar;
    String rel;
    
    public choferAVL() {
        raiz = null;
        graficar = "";
        rel = "";
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
    
     public void graficar(){
        
        auxGraph();
        
         try{
            //Abro stream, crea el fichero si no existe
            FileWriter fw = new FileWriter("C:\\Users\\Raulk\\Documents\\NetBeansProjects\\paginaJSP\\web\\images\\AVLchofer.dot");
            fw.write("digraph g { \n");
            
            fw.write(graficar + "\n");
            fw.write(rel + "\n");   
           
            fw.write("} \n");
            //Cierro el stream
            fw.close(); 
                //Abro el stream, el fichero debe existir
            FileReader fr=new FileReader("C:\\Users\\Raulk\\Documents\\NetBeansProjects\\paginaJSP\\web\\images\\AVLchofer.dot");
            //Leemos el fichero y lo mostramos por pantalla
            int valor=fr.read();
            while(valor!=-1){
                System.out.print((char)valor);
                valor=fr.read();
            }
            //Cerramos el stream
            fr.close();
            
            //llamamos graphviz
            graphviz();
            
        }catch(IOException e){
            System.out.println("Error E/S: "+e);
        }
    }
    
    private void graphviz(){
     
        try {

            String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
            String fileInputPath = "C:\\Users\\Raulk\\Documents\\NetBeansProjects\\paginaJSP\\web\\images\\AVLchofer.dot";
            String fileOutputPath = "C:\\Users\\Raulk\\Documents\\NetBeansProjects\\paginaJSP\\web\\images\\AVLchofer.jpg";
            //Users\\Raulk\\Documents\\NetBeansProjects\\practica1\\src\\imagenes\\lista.jpg
            String tParam = "-Tjpg";
            String tOParam = "-o";

            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;
            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
    }
    
    private void auxGraph(){
        Nodo aux;
        aux = raiz;
        graficar = "";
        rel = "";
        auxGraph2(aux);
    }
    
    private void auxGraph2(Nodo aus){
        
        if(aus.getIzquierda() != null){
            auxGraph2(aus.getIzquierda());
        }
        
        graficar += "nod" + aus.getNumero() + " [shape=record ,color=\"green\", label= \" { Id chofer : " + aus.getNumero()
                        + " |  nombre : " + "" + aus.getNombre() + " | apellido: "  + aus.getApellio() + " } | { contraseña: " + aus.getPass() + "| equilibrio: " + aus.getEq() + " }  \"] ; \n";
        if(aus.getIzquierda()!=null) rel += "nod" + aus.getNumero() + " -> nod" + aus.getIzquierda().getNumero() + " [color = red] ; \n";
        
        if(aus.getDerecha()!=null) rel += "nod" + aus.getNumero() + " -> nod" + aus.getDerecha().getNumero() + " [color = red] ; \n";
        
        
        if(aus.getDerecha() != null){
            auxGraph2(aus.getDerecha());
        }
        
    }
    
    public boolean comprobar(int clave , String pass){
        Nodo aux;
        aux = raiz;
        
        while(aux != null){
            if(aux.getNumero() > clave){
                aux = aux.getIzquierda();
            }else if (aux.getNumero() < clave){
                aux = aux.getDerecha();
            }else if(aux.getNumero() == clave){
                return true;
            }
            
        }
        
        return false;
    }
    
}
