/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author Leonel LLancaqueo
 */
public class Cola {
    private Nodo frente;
    private Nodo fin;
    
    public Cola(){
        this.frente= null;
        this.fin= null;
    }
    public boolean poner(Object elemento){
        /*ESTE METODO PERMITE AGREGAR A LA COLA OTRO ELEMENTO. ENLAZA AL NODO FRENTE CON UN NODO NUEVO INGRESADO POR
        PARAMETRO */
        Nodo otroNodo= new Nodo(elemento);
        if(this.frente == null){
            this.frente= otroNodo;           
        }else{ 
            this.fin.setEnlace(otroNodo);
        }
        this.fin= otroNodo;
        return true;
    }
    public boolean sacar(){
        /* ESTE METODO PERMITE SACAR ELEMENTOS DE LA COLA. VERIFICA PRIMERO SI LA PILA NO ESTA VACIA PARA PODER SACAR 
        EL NODO FRENTE, SI LA COLA TIENE AL MENOS UN ELEMENTO SE CAMBIA LA REFERENCIA DEL NODO FRENTE AL EL NODO SIGUIENTE
        POR ULTIMO SI EL NODO FRENTE QUEDA REFERENCIADO A UN NODO NULO ENTONCES EL NODO FIN TAMBIEN TIENE UNA REFERENCIA NULA*/
        boolean sacado= false;
        if(this.frente != null){
            this.frente= this.frente.getEnlace();
            if(this.frente == null){
                this.fin= null;
            }
            sacado= true;   
        }
        return sacado;
    }
    public Object obtenerFrente(){
        Object elementoFrente= null;
        if(this.frente != null){
            elementoFrente= this.frente.getElemento();
        }
        return elementoFrente;
    }
    public boolean esVacia(){
        /*ESTE METODO VERIFICA SI LA COLA ESTA VACIA. SI EL FRENTE Y EL FIN DE LA COLA TIENEN VALORES NULOS ENTONCES LA
        PILA ESTA VACIA Y SE RETORNA TRUE EN CASO CONTRARIO  SE RETORNA FALSE*/
        boolean esVacia;
        if(this.frente == null && this.fin == null){
            esVacia= true;
        }else{
            esVacia= false;
        }
        return esVacia;
    }
    public void vaciar(){
        this.frente=null;
        this.fin=null;
    }
        public Cola clone(){
            /*ESTE METODO PERMITE COPIAR LA ESTRUCTURA DE UNA COLA REFENCIANDO A LOS MISMOS OBEJTOS QUE LA COLA ORIGINAL
            PERO CREANDO Y RETORNANDO UNA ESTRUCTURA*/
            Cola otraColaDinamica= new Cola();
            if(!esVacia()){
                Nodo otroNodoFrente= new Nodo(this.frente.getElemento()); 
                Nodo nodoAux= this.frente.getEnlace();
                otraColaDinamica.frente= otroNodoFrente;
                otraColaDinamica.fin= otroNodoFrente;
                while(nodoAux != null){
                    Nodo otroNodo= new Nodo(nodoAux.getElemento());
                    otraColaDinamica.fin.setEnlace(otroNodo);
                    otraColaDinamica.fin= otroNodo;
                    nodoAux= nodoAux.getEnlace();
                }
            }else{
                otraColaDinamica.frente= null;
                otraColaDinamica.fin= null;
            }           
            return otraColaDinamica;
        }
        public String toString() {
        /*ESTE METODO PERMITE OBTENER LOS VALORES DE LOS ELEMENTOS ALMACENADOS EN LA COLA, RECORRIENDO TODOS LOS NODOS
        QUE ESTEN ENLAZADOS EN LA COLA Y OBTENIENDO LOS ELEMENTOS QUE ALMACENAN.*/
        String salida="";
        Nodo aux=this.frente;
        while(aux != null){
            salida=salida + aux.getElemento().toString();
            aux= aux.getEnlace();
            if(aux!= null ){
                salida+= ",";
            }
        }
        salida= "["+salida+"]";
        return salida;
    }
}
