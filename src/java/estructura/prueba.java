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

    AVLgeneral general;
    AVLadmin admin;
    AVLclave clave;
    choferAVL chofer;
    listaBuses buses;
    int repeticiones;
    String ret;
    
    public prueba(){
       general = new AVLgeneral();
       admin = new AVLadmin();
       clave = new AVLclave();
       chofer = new choferAVL();
       buses = new listaBuses();
       repeticiones = 0;
       ret = "";
    }
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
         if (!(txt.equals("") || txt.equals("0"))){
             general.insert(repeticiones, txt, txt);
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
        aux = general.raiz;
        ret = "";
        data(aux);
        admin.graficar();
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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "login")
    public boolean login(@WebParam(name = "nombre") String nombre, @WebParam(name = "pass") String pass) {
        //TODO write your implementation code here:
        if(nombre.equals("admin") && pass.equals("1234")){
           return true;
        }else{
           return false; 
        }
    }
}
