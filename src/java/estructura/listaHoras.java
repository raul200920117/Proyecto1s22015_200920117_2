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
public class listaHoras {
    
    NodoHoras primero;
    NodoHoras ultimo;
    
    public listaHoras(){
        primero = null;
    }
    
    public void insertar(String hora, String estacion){
        
        NodoHoras nuevo = new NodoHoras(hora,estacion);
        
        if(primero != null){
            ultimo.setSig(nuevo);
            ultimo = nuevo;
        }else{
            primero = nuevo;
            ultimo = nuevo;
        }
    }
    
    public void recorrer(){
        NodoHoras aux;
        aux = primero;
        
        while (aux != null){
            //mostrar o graficar como sea
        }
    }
    
}
