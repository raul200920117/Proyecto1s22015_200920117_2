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
     * Web service operation aca es en donse se comprueba que tipo de usuario es el que se intenta loguear
     */
    @WebMethod(operationName = "login")
    public int login(@WebParam(name = "nombre") String nombre, @WebParam(name = "pass") String pass) {
        //TODO write your implementation code here:
        //general.comprobar(, pass);
        int num = Integer.parseInt(nombre);
        if(nombre.equals("admin") && pass.equals("1234")){
           return 1;
           
        }else if(admin.comprobar(nombre, pass)){
            return 1;
        }else if(clave.comprobar(num, pass)){
            return 2;
        }else if(general.comprobar(num, pass)){
            return 3;
        }else if(chofer.comprobar(num, pass)){
            return 4;
        }else{
            return 0;
        }
        
    
    }

    /**
     * Web service operation se añade un administrador a la lista
     */
    @WebMethod(operationName = "addAdmin")
    public String addAdmin(@WebParam(name = "correo") String correo, @WebParam(name = "password") String password) {
        String resultado;
        
        resultado = "El usuario no se pudo insertar";
        
        if(correo.equals("0@0.com") || correo.equals("0@0.com") || correo.equals("") || correo.equals("")){
            return resultado;
        }else{
            admin.insert(correo, password);
            resultado = "administrador creado";
        }
            
        return resultado;
    }

    
     /**
     * Web service operation  para insertar una estacion clave
     */
    @WebMethod(operationName = "addEstacionClave")
    public String addEstacionClave(@WebParam(name = "id_estacion") int id_estacion, @WebParam(name = "nombre") String nombre, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        return null;
    }
    
     /**
     * Web service operation para borrar una estacion clave
     */
    @WebMethod(operationName = "borrarEstacionClave")
    public String borrarEstacionClave(@WebParam(name = "numeroEstacion") int numeroEstacion) {
        //metodo para borrar una estacion clave
        clave.borrar(numeroEstacion);
        
        return "estacion borrada";
    }
    
    /**
     * Web service operation  se inserta una estacion general
     */
    @WebMethod(operationName = "addEstacionGeneral")
    public String addEstacionGeneral(@WebParam(name = "id_estacion") int id_estacion, @WebParam(name = "nombre") String nombre, @WebParam(name = "contrase\u00f1a") String contraseña) {
        
        if(!(id_estacion ==0 || nombre.equals("0") || contraseña.equals("0") ||
                nombre.equals("") || contraseña.equals(""))){
            
            general.insert(id_estacion, nombre, contraseña);
            return "nodo insertado correctamente";
            
        }else{
            return "no se inserto por que no cumple con el formato de entrada";
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "borrarEstacionGeneral")
    public String borrarEstacionGeneral(@WebParam(name = "id_estacion") int id_estacion) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "modificarEstClave")
    public String modificarEstClave(@WebParam(name = "id_estacion") int id_estacion, @WebParam(name = "nombre") String nombre, @WebParam(name = "pass") String pass) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "modificarEstGeneral")
    public String modificarEstGeneral(@WebParam(name = "id_estacion") int id_estacion, @WebParam(name = "nombre") String nombre, @WebParam(name = "pass") String pass) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "borrarAdmin")
    public String borrarAdmin(@WebParam(name = "correo") String correo) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "modifAdmin")
    public String modifAdmin(@WebParam(name = "correo") String correo, @WebParam(name = "pass") String pass) {
        //TODO write your implementation code here:
        return null;
    }



}
