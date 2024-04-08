/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;
/**
 *
 * @author Leonel LLancaqueo
 */
public class Pila {
    private static final int TAMANIO= 10;
    private Object []arr;
    private int tope;
    
    public Pila(){
        this.arr= new Object[TAMANIO];
        this.tope= -1;
    }
    public boolean apilar(Object elemento){
        /*ESTE METODO APILA EL ELEMENTO INGRESADO POR PARAMETRO EN EL TOPE DE LA PILA, SI LA PILA TIENE LUGAR Y EL ELEMENTO
        SE PUDO APILAR SE SUMA 1 AL ATRIBUTO TOPE Y EL METODO RETORNA TRUE, SI LA PILA ESTA LLENA Y NO SE PUDO APILAR EL 
        ELEMENTO EL METODO RETORNA FALSE*/
        boolean apilado= false;
        if(this.tope+1 < TAMANIO){
            this.tope++;
            this.arr[this.tope]= elemento;
            apilado= true;
        }
        return apilado;
    }
    public boolean desapilar(){
        /*ESTE METODO PERMITE QUITAR ELEMENTOS DE LA PILA, ELIMINA EL ELEMENTO QUE SE ENCUENTRA EN EL TOPE DE LA PILA
        CAMBIANDO SU VALOR A NULL Y RESTANDO 1 A EL VALOR DE EL ATRIBUTO TOPE. SI SE PUDO DESAPILAR EL METODO RETORNA
        TRUE, SI LA PILA ESTA VACIA Y NO SE PUDO DESAPILAR NADA EL METODO RETORNA FALSE*/
        boolean desapilado= false;
        if(this.tope != -1){
            arr[this.tope]= null;
            desapilado= true;
            this.tope--;
        }
        return desapilado;
    }
    public Object obtenerTope(){
        /*ESTE METODO RETORNA EL ELEMENTO QUE SE ENCUENTRA EN EL TOPE DE LA PILA, SI LA PILA ESTA VACIA SE RETORNA EL 
        VALOR NULL*/
        Object elemTope = null;
        if(this.tope != -1){
            elemTope = arr[this.tope];
        }
        return elemTope;
    }
    public boolean esVacia(){
        /*ESTE METODO VERIFICA SI LA PILA TIENE ELEMENTOS ALMACENADOS O ESTA VACIA, VERIFICANDO SI EN EL TOPE DE LA PILA
        SE ENCUENTRA ALGUN ELEMENTO ALMACENADO, SI LA PILA ESTA VACIA RETORNA TRUE EN CASO CONTRARIO FALSE */
        return this.tope == -1;
    }
    public void vaciar(){
        /*ESTE METODO PERMITE VACIAR TOTALMENTE LA PILA, ASIGNADOLE NULL A CADA ELEMENTO DE LA PILA DESDE EL TOPE HASTA 
        EL PRIMER ELEMENTO. POR ULTIMO CAMBIA EL VALOR DEL TOPE A -1*/
        int i;
        for(i= 0; i<= this.tope; i++){
            arr[i]= null;
        }
        this.tope= -1;
    }
    public Pila clone(){
        /*ESTE METODO PERMITE CLONAR Y RETORNAR LA ESTRUCTURA DE PILA, CREANDO UNA PILA NUEVA PERO MANTENIENDO LA REFERENCIA 
        HACIA LOS ELEMENTOS QUE CONTIENE DE LA ORIGNIAL.*/
        Pila p= new Pila();
        p.arr= this.arr.clone();
        p.tope= this.tope;
        return p;
    }    
    public String toString() {
        /*ESTE METODO PERMITE LISTAR LOS ELEMENTOS DE LA PILA ENTRE CORCHETES PONIENDO AL ELEMENTO TOPE DE LA PILA 
        AL PRINCIPIO DE LA LISTA. RETORNA UN STRING*/
        String estadoActual= "[";
        int i;
        for(i=0;i<=this.tope; i++){
            estadoActual+= this.arr[i].toString();
            if(i != this.tope){
                estadoActual+=" ";
            }
        }
        estadoActual+= "]";
        return estadoActual;
    }
    
}