/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructura;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Raulk
 */
@WebService(serviceName = "prueba")
public class prueba {

    AVLgeneral arbol;
    int repeticiones;
    String ret;
    
    public prueba(){
       arbol = new AVLgeneral();
       repeticiones = 0;
       ret = "";
    }
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
         if (!txt.equals("")){
             arbol.insert(repeticiones, txt);
             repeticiones++; 
             return "insertado con exito en el arbol " + txt + " !";
         }else{
             return "ingrese un valor aceptado";
         }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "mostrar")
    public String mostrar() {
        //TODO write your implementation code here:
        NodoG aux;
        aux = arbol.raiz;
        ret = "";
        data(aux);
        return ret;
    }
    
    private void data(NodoG aux){
        if(aux.getIzquierda()!=null) data(aux.getIzquierda());
        
        ret += "nombre : " + aux.getNombre() + " numero : " + aux.getId_Estacion() + "<br>";
        
        if(aux.getDerecha() !=null)  data(aux.getDerecha());
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "borrarEstacionClave")
    public String borrarEstacionClave(@WebParam(name = "numeroEstacion") int numeroEstacion) {
        //metodo para borrar una estacion clave
        
        return null;
    }
}