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
    busLista buses;//aca se agregan solo numeros de buses
    int repeticiones;
    String ret;
    
    public prueba(){
       general = new AVLgeneral();
       admin = new AVLadmin();
       clave = new AVLclave();
       chofer = new choferAVL();
       buses = new busLista();
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
    public int login(@WebParam(name = "nombre") String nombre, @WebParam(name = "pass") String pass, @WebParam(name = "tipo") String tipo) {
        //TODO write your implementation code here:
        //general.comprobar(, pass);
        
        
        if(tipo.equals("1") && (nombre.equals("admin") && pass.equals("1234"))){
           return 1;
        }else if(admin != null && admin.comprobar(nombre, pass)){
            return 1;
        }
        
        
        if(tipo.equals("2")){
            int num = Integer.parseInt(nombre);
            if(clave.comprobar(num, pass)) return 2;
            else  return 0;
        }
        
        if(tipo.equals("3")){
            int num = Integer.parseInt(nombre);
            if(general.comprobar(num, pass))  return 3;
            else return 0;
        }
        
        if(tipo.equals("4")){
            int num = Integer.parseInt(nombre);
            if(chofer.comprobar(num, pass))  return 4;
            else return 0;
        }
        
        return 0;
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
            admin.graficar();
            resultado = "administrador creado";
        }
            
        return resultado;
    }

    
     /**
     * Web service operation  para insertar una estacion clave
     */
    @WebMethod(operationName = "addEstacionClave")
    public String addEstacionClave(@WebParam(name = "id_estacion") String id_estacion, @WebParam(name = "nombre") String nombre, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        
        if(id_estacion.equals("0") || nombre.equals("0") || password.equals("0") ||
                id_estacion.equals("") || nombre.equals("") || password.equals("")){
            return "clave no insertada, no tiene el formato";
        }else{
            int num = Integer.parseInt(id_estacion);
            clave.insert(num, nombre, password);
            clave.graficar();
            return "clave insertada"; 
        }
      
    }
    
     /**
     * Web service operation para borrar una estacion clave
     */
    @WebMethod(operationName = "borrarEstacionClave")
    public String borrarEstacionClave(@WebParam(name = "numeroEstacion") int numeroEstacion) {
        //metodo para borrar una estacion clave
        clave.borrar(numeroEstacion);
        clave.graficar();
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
            general.graficar();
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
        if(id_estacion != 0){
            general.borrar(id_estacion);
            general.graficar();
            return "estacion borrada";
        }
        return "no se puede realizar el borrado";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "modificarEstClave")
    public String modificarEstClave(@WebParam(name = "id_estacion") int id_estacion, @WebParam(name = "nombre") String nombre, @WebParam(name = "pass") String pass) {
        //TODO write your implementation code here:
        if(id_estacion!=0){
            NodoC aux = clave.modificar(id_estacion); 
            if(aux != null) {
                aux.setNombre(nombre);
                aux.setPass(pass);
                clave.graficar();
                return "datos modificados en el nodo " + id_estacion;
            }else{
                return "el nodo no existe";
            }
        }
        
        return "ingrese un numero valido";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "modificarEstGeneral")
    public String modificarEstGeneral(@WebParam(name = "id_estacion") int id_estacion, @WebParam(name = "nombre") String nombre, @WebParam(name = "pass") String pass) {
        //TODO write your implementation code here:
        if(id_estacion!=0){
            NodoG aux = general.modificar(id_estacion); 
            if(aux != null) {
                aux.setNombre(nombre);
                aux.setPass(pass);
                general.graficar();
                return "datos modificados en el nodo " + id_estacion;
            }else{
                return "el nodo no existe";
            }
        }
        
        return "ingrese un numero valido";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "borrarAdmin")
    public String borrarAdmin(@WebParam(name = "correo") String correo) {
        //TODO write your implementation code here:
        if(correo.equals("0@0.com") || correo.equals("0@0.com") || correo.equals("") || correo.equals("")){
            return "apeguese al formato de entrada";
        }else{
            admin.borrar(correo);
            admin.graficar();
            return "borrado";
        }
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "modifAdmin")
    public String modifAdmin(@WebParam(name = "correo") String correo, @WebParam(name = "pass") String pass) {
        //TODO write your implementation code here:
        if(!(correo.equals("0") || correo.equals(""))){
            NodoAdmin aux = admin.modificar(correo);
            if(aux != null){
                aux.setPass(pass);
                admin.graficar();
                return "datos modificados";
            }else{
                return "el nodo no existe";
            }
            
        }
        return "ingrese un numero valido";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertaChofer")
    public String insertaChofer(@WebParam(name = "id_chofer") int id_chofer, @WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "pass") String pass) {
        //TODO write your implementation code here:
        if(id_chofer!=0 || !nombre.equals("0") || !apellido.equals("0") || !pass.equals("") ){
            chofer.insert(id_chofer, nombre, apellido, pass);
            chofer.graficar();
            return "chofer insertado";
        }else{
            return "apeguese a el estandar de entrada";
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "modifChofer")
    public String modifChofer(@WebParam(name = "id_chofer") int id_chofer, @WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "pass") String pass) {
        //TODO write your implementation code here:
        if(id_chofer != 0){
            Nodo aux = chofer.modificar(id_chofer); 
            if(aux != null) {
                aux.setNombre(nombre);
                aux.setPass(pass);
                chofer.graficar();
                return "datos modificados en el nodo " + id_chofer;
            }else{
                return "el nodo no existe";
            }
        }
        
        return "ingrese un numero valido";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "borraChofer")
    public String borraChofer(@WebParam(name = "id_chofer") int id_chofer) {
        //TODO write your implementation code here:
        if (id_chofer != 0 ) {
            chofer.borrar(id_chofer);
            chofer.graficar();
            return "borrado";
        }
        
        return "no borrado";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertaBus")
    public String insertaBus(@WebParam(name = "idBus") int idBus) {
        //TODO write your implementation code here:
        if(idBus!= 0){
            buses.insertar(idBus);
            buses.graficar();
            return "bus insertado";
        }
        return "no se puede insertar";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "borraBus")
    public String borraBus(@WebParam(name = "id_bus") int id_bus) {
        //TODO write your implementation code here:
        if(id_bus !=0){
            buses.graficar();
            return "borrado el bus: #" + id_bus;
        }
        return "no se pudo borrar";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "moverBusClave")
    public String moverBusClave(@WebParam(name = "id_bus") int id_bus, @WebParam(name = "personas") int personas, @WebParam(name = "entran_salen") boolean entran_salen, @WebParam(name = "hora") String hora, @WebParam(name = "estacion") String estacion) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "moverBusGral")
    public String moverBusGral(@WebParam(name = "id_bus") int id_bus, @WebParam(name = "personas") int personas, @WebParam(name = "entran_salen") boolean entran_salen, @WebParam(name = "estacion") String estacion) {
        //TODO write your implementation code here:
        String ret="";
        
        for(int i=0; i<10 ; i++){
            ret+= "<form name=\"imagenes\" action=\"imagenes.jsp\"  class=\"cajaFlotante\"> <br>";
            ret+="aca irian los movimientos <br>";
            ret+= "</form> <br>" ;
        }
        
        return ret;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "dibujarClave")
    public String dibujarClave() {
        //TODO write your implementation code here:
        String ret ="";
        return ret;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "dibujarGeneral")
    public String dibujarGeneral() {
        //TODO write your implementation code here:
        String ret = "";
        
        return ret;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cargaMasiva")
    public String cargaMasiva(@WebParam(name = "datos") String datos) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "imprimirGraficas")
    public String imprimirGraficas() {
       
        //TODO write your implementation code here:
        String manda="comiencan los datos <br>";
            manda += " estaciones clave <br>";
        if(clave != null){
            manda += clave.mostrar() + "<br>";
            
        }
        
        return manda;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "generales")
    public String generales() {
        //TODO write your implementation code here:
        String manda="";
            manda += " estaciones generales <br>";
        if(general != null){
            manda += general.mostrar() + "<br>";
        }
        
        return manda;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "choferess")
    public String choferess() {
        //TODO write your implementation code here:
       String manda=""; 
            manda += " avl choferes <br>";        
        if(chofer != null){
            manda += chofer.mostrar() +"<br>";
        }

        return manda;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "admins")
    public String admins() {
        //TODO write your implementation code here:
                
        String manda ="";
        
        if(admin != null){
            manda += " avl administrador <br>";
            manda += admin.mostrar() + "<br>";
        }
        return manda;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "buses")
    public String buses() {
        //TODO write your implementation code here:
        String manda ="lista de buses";
        if(buses !=null){
            manda += buses.mostrar() + "<br>";
        }
        return null;
    }

    
    


}
