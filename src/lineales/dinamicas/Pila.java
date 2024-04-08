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
public class Pila {

    private Nodo tope;

    public Pila() 
    /*ESTE CONSTRUCTOR PERMITE CREAR UNA PILA DINAMICA VACIA. EL TOPE SE INICIALIZA CON UN NULL*/{
        this.tope = null;
    }

    public boolean apilar(Object elemento) {
        /*ESTE METODO PERMITE AGREGAR ELEMENETOS EN LA PILA, ILIMITADAMENTE, CREA UN NODO CON EL ELEMENTO A ALMACENAR Y
        UN ENLACE HACIA EL NODO TOPE DE LA PILA, A CONTINUACION SE ASIGNA LA REFERENCIA AL NODO COMO TOPE DE LA PILA. ESTE 
        NODO AGREGADO PASA A SER EL NUEVO TOPE DE LA PILA.*/
        Nodo nuevoNodo = new Nodo(elemento);
        nuevoNodo.setEnlace(this.tope);
        this.tope = nuevoNodo;
        return true;
    }

    public boolean desapilar() {
        /*ESTE METODO PERMITE QUITAR ELEMENTOS DE LA PILA. CAMBIA EL VALOR DEL ATRIBUTO TOPE DE LA PILA ASIGNANDOLE LA 
        REFERENCIA AL NODO QUE EL NODO TOPE TENIA, DE ESTA MANERA EL TOPE QUEDA REFERENCIADO A EL NODO ANTERIOR QUITANDO
        DE LA PILA LA REFERENCIA AL ULTIMO NODO QUE ALMACENABA.
        */
        boolean desapilado= false;
        if(this.tope != null){
            this.tope = this.tope.getEnlace();
            desapilado= true;
        }
        return desapilado;
    }

    public Object obtenerTope() {
        /*ESTE METODO PERMITE OBTENER EL ELEMENETO QUE ESTA ALMACENADO EN EL TOPE DE LA PILA. RETORNA EL ELEMENTO 
        QUE ESTE ALMACENADO EN EL NODO TOPE DE LA PILA, SI LA PILA ESTA VACIA RETORNA UN VALOR NULL*/
        Object valorRetornado = null;
        if(this.tope != null){
            valorRetornado= this.tope.getElemento();
        }
        return valorRetornado;
    }
    public void vaciar(){
        /*ESTE METODO PERMITE VACIAR LA PILA. AL ATRIBUTO TOPE DE LA PILA SE LE CAMBIA EL VALOR A NULL, DE ESTA MANERA
        LA PILA YA NO REFERENCIA A NINGUN NODO Y ESTOS DEJAN DE EXISITIR.*/
        this.tope=null;
    }
    public boolean esVacia() {
        /*ESTE METODO VERIFICA SI LA PILA ESTA VACIA. SI EL VALOR DEL ATRIBUTO TOPE ES IGUAL A NULL ENTONCES LA PILA ESTA VACIA Y SE RETORNA TRUE
        SI EL VALOR ES DIFERENTE  A NULL ENTONCES LA PILA ESTA REFERENCIANDO A UN NODO QUE CONTIENE UN ELEMENTO Y SE RETORNA FALSE*/
        return this.tope == null;
    }
    

        
    public Pila clone(){
        /*ESTE METODO PERMITE CLONAR LA PILA. SE CREA UN NUEVO OBJETO DE PILA DINAMICA Y TAMBIEN SE CREA UN NUEVO NODO 
        POR CADA NODO QUE TUVIESE LA PILA ORIGINAL. SE ENLAZAN LOS NODOS DE LA MISMA FORMA QUE LA PILA ORIGINAL, ESTOS
        NODOS QUEDAN REFERENCIANDO A LOS MISMOS OBJETOS QUE LA PILA ORIGINAL.*/
        
        Pila p= new Pila();
        if(this.tope!= null){
            p.tope= new Nodo(this.tope.getElemento());
            cloneAux(this.tope.getEnlace(), p.tope);
        }
        return p;
    }
    private void cloneAux(Nodo p1, Nodo p2){
        if(p1 != null){
            p2.setEnlace(new Nodo(p1.getElemento()));
            cloneAux(p1.getEnlace(), p2.getEnlace());
        }
    }

    public String toString() {
        /*ESTE METODO PERMITE OBTENER LOS VALORES DE LOS ELEMENTOS ALMACENADOS EN LA PILA, RECORRIENDO TODOS LOS NODOS
        QUE ESTEN ENLAZADOS EN LA PILA Y OBTENIENDO LOS ELEMENTOS QUE ALMACENAN.*/
        String salida="";
        Nodo aux=this.tope;
        while(aux != null){
            salida= aux.getElemento().toString() + salida;
            aux= aux.getEnlace();
            if(aux!= null){
                salida= "," + salida;
            }
        }
        salida= "["+salida+"]";
        return salida;
    }
    
}
