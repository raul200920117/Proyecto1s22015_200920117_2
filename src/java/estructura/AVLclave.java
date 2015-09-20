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
public class AVLclave {
    NodoC raiz;
    String graficar;
    String rel;
    String ret;
    
    public AVLclave() {
        raiz = null;
        graficar = "";
        rel = "";
    }
    
 public boolean insert(int clave, String nombre, String pass) {
        if (raiz == null)
            raiz = new NodoC(clave,nombre,pass, null);
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
                        padre.setIzquierda(new NodoC(clave,nombre,pass, padre));
                    } else {
                        padre.setDerecha(new NodoC(clave,nombre,pass, padre));
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
    
    
       
    public String mostrar(){
        NodoC aux;
        aux = raiz;
        ret="";
        auxMostrar(aux);
        return ret;
     }
    
    private void auxMostrar(NodoC auxi) {
        
        System.out.println("act: " + auxi.getId_Estacion() );
  
        ret += "nodo : " + auxi.getId_Estacion()  + "<br>";
        if(auxi.getIzquierda() != null) ret += "izq: " + auxi.getIzquierda().getId_Estacion()  + "<br>";
        
        if(auxi.getDerecha() != null) ret +=  "der: " + auxi.getDerecha().getId_Estacion() + "<br>";
        
        
        if(auxi.getIzquierda() != null)   auxMostrar(auxi.getIzquierda());            
        
        
        if(auxi.getDerecha() != null)  auxMostrar(auxi.getDerecha());

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
    
    public void graficar(){
        
        auxGraph();
        
         try{
            //Abro stream, crea el fichero si no existe
            FileWriter fw = new FileWriter("C:\\Users\\Raulk\\Documents\\NetBeansProjects\\paginaJSP\\web\\images\\AVLclave.dot");
            fw.write("digraph g { \n");
            
            fw.write(graficar + "\n");
            fw.write(rel + "\n");   
           
            fw.write("} \n");
            //Cierro el stream
            fw.close(); 
                //Abro el stream, el fichero debe existir
            FileReader fr=new FileReader("C:\\Users\\Raulk\\Documents\\NetBeansProjects\\paginaJSP\\web\\images\\AVLclave.dot");
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
            String fileInputPath = "C:\\Users\\Raulk\\Documents\\NetBeansProjects\\paginaJSP\\web\\images\\AVLclave.dot";
            String fileOutputPath = "C:\\Users\\Raulk\\Documents\\NetBeansProjects\\paginaJSP\\web\\images\\AVLclave.jpg";
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
        NodoC aux;
        aux = raiz;
        graficar = "";
        rel = "";
        auxGraph2(aux);
    }
    
    private void auxGraph2(NodoC aus){
        
        if(aus.getIzquierda() != null){
            auxGraph2(aus.getIzquierda());
        }
        
        graficar += "nod" + aus.getId_Estacion() + " [shape=record ,color=\"green\", label= \" { Id estacion : " + aus.getId_Estacion()
                        + " |  personas : " + "" + aus.getPersonas_sist() + " } | { nombre: " + aus.getNombre() + "| equilibrio: " + aus.getEq() + " }  \"] ; \n";
        if(aus.getIzquierda()!=null) rel += "nod" + aus.getId_Estacion() + " -> nod" + aus.getIzquierda().getId_Estacion() + " [color = red] ; \n";
        
        if(aus.getDerecha()!=null) rel += "nod" + aus.getId_Estacion() + " -> nod" + aus.getDerecha().getId_Estacion() + " [color = red] ; \n";
        
        
        if(aus.getDerecha() != null){
            auxGraph2(aus.getDerecha());
        }
        
    }
    
    
    public boolean comprobar(int estacion, String pass){
        NodoC aux;
        aux = raiz;
        
        while(aux != null){
            if(aux.getId_Estacion() > estacion){
                aux = aux.getIzquierda();
            }else if(aux.getId_Estacion() < estacion){
                aux = aux.getDerecha();
            }else if(aux.getId_Estacion() == estacion && aux.getPass().equals(pass)){
                return true;
            }else{
                return false;
            }
        }
        
        return false;
    }
    
}
