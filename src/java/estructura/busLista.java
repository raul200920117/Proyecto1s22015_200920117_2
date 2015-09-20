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
public class busLista {
    
    busNodo primero,ultimo;
    
    public busLista(){
        primero = null;
        ultimo = null;
    }
    
    public void insertar(int bus){
        busNodo nuevo = new busNodo(bus);
        
        if(primero == null){
            primero = nuevo;
            ultimo = nuevo;
        }else {
                       
            busNodo aux;
            aux = primero;
            if(bus < aux.getIdbus()){
                    nuevo.setSig(primero);
                    primero = nuevo;
            }else{
                ultimo.setSig(nuevo);
                ultimo = nuevo;
            }
        }
    }
    
    public void borrar(int id){
        busNodo aux = primero;
        busNodo padre = null;
        
        while(aux!=null){
            if(aux.getIdbus()==id){
                if(aux == primero && aux.getSig()!= null){
                    primero = primero.getSig();
                 
                }else if (aux == ultimo){
                    ultimo = padre;
                    padre.setSig(null);
              
                }else if (aux == primero && aux == ultimo){
                    ultimo = null;
                    primero = null;
                    aux = null;
                }else{
                    
                }
            }
                padre = aux;
                aux = aux.getSig();
     
        }
    }
    
    public void graficar(){
        
        busNodo aux;
        aux = primero;
        String rel = "";
        String der = "";
        
        while (aux != null) {
            
                rel += "nod" + aux.getIdbus() + " [shape=record ,color=\"cyan\", label= \" { id : " + aux.getIdbus() +  " }  \"] ; \n" ;             
               
                if(aux.getSig() != null){
                    der += "nod" +aux.getIdbus() + " -> nod" + aux.getSig().getIdbus() + " [ dir=both color = indigo: red] ;\n" ;
                }

            aux = aux.getSig();
        }
        
         try{
            //Abro stream, crea el fichero si no existe
            FileWriter fw = new FileWriter("C:\\Users\\Raulk\\Documents\\NetBeansProjects\\paginaJSP\\web\\images\\buslista.dot");
            fw.write("digraph g { \n");
          
            fw.write(rel + "\n");   
            fw.write(der + "\n");

            fw.write("} \n");
            //Cierro el stream
            fw.close(); 
                //Abro el stream, el fichero debe existir
            FileReader fr=new FileReader("C:\\Users\\Raulk\\Documents\\NetBeansProjects\\paginaJSP\\web\\images\\buslista.dot");
            //Leemos el fichero y lo mostramos por pantalla
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
            String fileInputPath = "C:\\Users\\Raulk\\Documents\\NetBeansProjects\\paginaJSP\\web\\images\\buslista.dot";
            String fileOutputPath = "C:\\Users\\Raulk\\Documents\\NetBeansProjects\\paginaJSP\\web\\images\\buslista.jpg";
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
}
