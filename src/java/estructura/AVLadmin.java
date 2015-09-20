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
public class AVLadmin {
    NodoAdmin raiz;
    String graficar;
    String rel;
    
    public AVLadmin() {
        raiz = null;
        graficar = "";
        rel = "";
    }
    
 public boolean insert(String correo, String nombre) {
        if (raiz == null)
            raiz = new NodoAdmin(correo,nombre, null);
        else {
            NodoAdmin n = raiz;
            NodoAdmin padre;
            while (true) {
                if (n.getCorreo().equals(correo))
                    return false;
 
                padre = n;
 
                boolean goLeft = n.getCorreo().compareTo(correo) > 0;
                n = goLeft ? n.getIzquierda() : n.getDerecha();
 
                if (n == null) {
                    if (goLeft) {
                        padre.setIzquierda(new NodoAdmin(correo,nombre, padre));
                    } else {
                        padre.setDerecha(new NodoAdmin(correo,nombre, padre));
                    }
                    rebalancear(padre);
                    break;
                }
            }
        }
        return true;
    }
    
 public void borrar(String borrado) {
        if (raiz == null)
            return;
        NodoAdmin n = raiz;
        NodoAdmin padre = raiz;
        NodoAdmin borNodo = null;
        NodoAdmin hijo = raiz;
 
        while (hijo != null) {
            padre = n;
            n = hijo;
            hijo = borrado.compareTo(n.getCorreo()) >= 0 ? n.getDerecha() : n.getIzquierda();
            if (borrado.equals(n.getCorreo()))
                borNodo = n;
        }
 
        if (borNodo != null) {
            borNodo.setCorreo(n.getCorreo());
 
            hijo = n.getIzquierda() != null ? n.getIzquierda() : n.getDerecha();
 
            if (raiz.getCorreo().equals(borrado)) {
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
 
     private void rebalancear(NodoAdmin n) {
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
     
    private NodoAdmin rotDD(NodoAdmin aux) {
 
        NodoAdmin base = aux.getDerecha();
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
    
    private NodoAdmin rotII(NodoAdmin aux) {
 
        NodoAdmin base = aux.getIzquierda();
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
    
    private NodoAdmin rotID(NodoAdmin n) {
        n.setIzquierda(rotDD(n.getIzquierda()));
        return rotII(n);
    }
    
    private NodoAdmin rotDI(NodoAdmin n) {
        n.setDerecha(rotII(n.getDerecha()));
        return rotDD(n);
    }
    
    private int altura(NodoAdmin n) {
        if (n == null) {
            return -1;
        } else {
            return 1 + Math.max(altura(n.getIzquierda()), altura(n.getDerecha()));
        }
    }

    private void setBalance(NodoAdmin... nodos) {
        for (NodoAdmin n : nodos)
            n.setEq(altura(n.getDerecha()) - altura(n.getIzquierda()));
    }
    
    
       
    public void mostrar(){
        NodoAdmin aux;
        aux = raiz;
        auxMostrar(aux);
     }
    
    private void auxMostrar(NodoAdmin auxi) {
        
        System.out.println("act: " + auxi.getCorreo() );
  
        
        if(auxi.getIzquierda() != null){
            System.out.println("izq: " + auxi.getIzquierda().getCorreo());
            auxMostrar(auxi.getIzquierda());            
        }
        
        if(auxi.getDerecha() != null){
            System.out.println("der: " + auxi.getDerecha().getCorreo());
            auxMostrar(auxi.getDerecha());
        }
    }
    
    public NodoAdmin modificar(String id_nodo){
        NodoAdmin aux = raiz;
        while(aux != null){
            if(aux.getCorreo().compareTo(id_nodo) > 0){
                aux = aux.getIzquierda();
            }else if(aux.getCorreo().compareTo(id_nodo) < 0){
                aux = aux.getDerecha();
            }else{
                return aux;
            }
        }
        return null;
    }
    
    public void graficar(){
        
        auxGraph();
        
         try{
            //Abro stream, crea el fichero si no existe
            FileWriter fw = new FileWriter("C:\\Users\\Raulk\\Documents\\NetBeansProjects\\paginaJSP\\web\\images\\AVLadmin.dot");
            fw.write("digraph g { \n");
            
            fw.write(graficar + "\n");
            fw.write(rel + "\n");   
           
            fw.write("} \n");
            //Cierro el stream
            fw.close(); 
                //Abro el stream, el fichero debe existir
            FileReader fr=new FileReader("C:\\Users\\Raulk\\Documents\\NetBeansProjects\\paginaJSP\\web\\images\\AVLAdmin.dot");
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
            String fileInputPath = "C:\\Users\\Raulk\\Documents\\NetBeansProjects\\paginaJSP\\web\\images\\AVLadmin.dot";
            String fileOutputPath = "C:\\Users\\Raulk\\Documents\\NetBeansProjects\\paginaJSP\\web\\images\\AVLadmin.jpg";
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
        NodoAdmin aux;
        aux = raiz;
        graficar = "";
        rel = "";
        auxGraph2(aux);
    }
    
    private void auxGraph2(NodoAdmin aus){
        
        if(aus.getIzquierda() != null){
            auxGraph2(aus.getIzquierda());
        }
        
        graficar += "nod" + aus.getCorreo() + " [shape=record ,color=\"green\", label= \" { correo : " + aus.getCorreo()
                        + " |  contraseña: " + "" + aus.getPass() + " } | { equilibrio: " + aus.getEq() + " }  \"] ; \n";
        if(aus.getIzquierda()!=null) rel += "nod" + aus.getCorreo() + " -> nod" + aus.getIzquierda().getCorreo() + " [color = red] ; \n";
        
        if(aus.getDerecha()!=null) rel += "nod" + aus.getCorreo() + " -> nod" + aus.getDerecha().getCorreo() + " [color = red] ; \n";
        
        
        if(aus.getDerecha() != null){
            auxGraph2(aus.getDerecha());
        }
        
    }
    
    public boolean comprobar(String correo, String pass) {
        NodoAdmin aux;
        aux = raiz;
        while (aux != null) {
            if (aux.getCorreo().compareTo(correo) > 0) {
                aux = aux.getIzquierda();
            } else if (aux.getCorreo().compareTo(correo) < 0) {
                aux = aux.getDerecha();
            } else if ( aux.getPass().equals(pass)) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }
    

}
