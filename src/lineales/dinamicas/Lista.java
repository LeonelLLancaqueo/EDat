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
public class Lista {
    private Nodo cabecera;
    private int longitud;


    public Lista(){
        cabecera= null;
        longitud=0;
    }
    
    public void insertarPosterior(Object valor1, Object valor2){
        Nodo nodoAux= this.cabecera;
        Nodo nodo3= new Nodo(null);
        if(this.cabecera.getElemento().equals(valor2)){
            
        }
        while(nodoAux != null){
            if(nodoAux.getElemento().equals(valor2) && nodoAux != this.cabecera){//si el elemento en nodo aux es igual al valor buscado y ademas es el nodo cabecera 
                Nodo nodo1= new Nodo(valor2);//creamos un nodo nuevo 
                nodo1.setEnlace(nodoAux.getEnlace());
                nodoAux.setEnlace(nodo1);
            }else{
                Nodo nodo2= new Nodo(valor2);
                nodo2.setEnlace(nodoAux);
                nodo3.setElemento(valor2);
                nodo3.setEnlace(nodoAux.getEnlace());
                this.cabecera.setEnlace(nodo3);
                this.cabecera= nodo2;
                nodoAux= nodo3;
            }
        }
        
    }
    public void eliminarApariciones(Object x){
        /*METODO QUE ELIMINA LAS APARICIONES DEL OBJETO X PASADO POR PARAMETRO DE LA LISTA*/
        if(this.cabecera != null){
            while(this.cabecera.getElemento().equals(x)){
                this.cabecera=this.cabecera.getEnlace();
            }
            if(this.cabecera != null){
                Nodo nAux= this.cabecera;
                Nodo nAux2= this.cabecera.getEnlace();
                while(nAux2 != null){
                    if(nAux2.getElemento().equals(x)){
                        nAux2= nAux2.getEnlace();
                        nAux.setEnlace(nAux2);
                    }else{
                        nAux= nAux.getEnlace();
                        nAux2= nAux2.getEnlace();
                    }
                }
            }
        }
    }
    public void invertir(){
        if(this.cabecera != null){
            Nodo nAux= this.cabecera;
            Nodo nAux2= this.cabecera;
            while(nAux.getEnlace() != null){
                 Nodo n= new Nodo(nAux.getEnlace().getElemento());
                 n.setEnlace(nAux2);
                 nAux= nAux.getEnlace();
                 nAux2= n;
            }
            this.cabecera.setEnlace(null);
            this.cabecera= nAux2;
        }
        //{1 2 3 4 } {2 1 }
        //{4 3 2 1}
    }
    
    public boolean insertar(Object elemento, int pos){
        
        boolean insertado= true;
        if(pos < 1 || pos > this.longitud+1){
            insertado= false;
        }else{
            Nodo otroNodo= new Nodo(elemento);
            if(pos == 1){
                otroNodo.setEnlace(this.cabecera);
                this.cabecera= otroNodo;
            }else{
                Nodo nodoAux= this.cabecera; //tomamos la cabecera  para iterar sobre la lista
                int i= 1;
                int posLlegada= pos-1;
                while(i < posLlegada){ //llegamos hasta la posicion-1 de llegada
                    nodoAux= nodoAux.getEnlace(); //pasamos entre los nodos de la lista
                    i++;
                }
                
                otroNodo.setEnlace(nodoAux.getEnlace());
                nodoAux.setEnlace(otroNodo);
            }

            this.longitud++;
        }
        
        return insertado;
    }
    public boolean eliminar(int pos){
        boolean eliminado= false;
        if(pos > 0 && pos <= this.longitud){
            if(pos == 1){
                this.cabecera= this.cabecera.getEnlace();
            }else{
                Nodo nodoAux= this.cabecera;
                
                int i=1;
                while(i <= pos-1){
                    nodoAux= nodoAux.getEnlace();
                    i++;
                }
                if(pos == this.longitud){
                    nodoAux.setEnlace(null);
                }else{
                    nodoAux.setEnlace(nodoAux.getEnlace().getEnlace());
                }
            }
            eliminado = true;
            this.longitud--;
        }
        return eliminado;
    }
    public boolean esVacia(){
        return this.cabecera == null;
    }
    public void vaciar(){
        this.cabecera= null;
        this.longitud= 0;
    }
    public int longitud(){
        return this.longitud;
    }
    public Object recuperar(int pos){
        /*este metodo permite recuperar el elemento del nodo en una posicion ingresada por parametro de la estructura lista
          primero verifica si pos es valida sino lo es devuelve un elemento null.
          si pos es valida entonces se recorre la lista mediante un nodo auxiliar hasta la pos solicitada y se devuelve
          en una variable  tipo object el elemento que contiene el nodo en esa posicion
        */
        Object elementoRecuperado= null;
        if(pos > 0 && pos <= this.longitud){     
            Nodo nodoAux= this.cabecera ;
            int cont=1;
            while(cont < pos ){
                nodoAux= nodoAux.getEnlace();
                cont++;
            }
            elementoRecuperado= nodoAux.getElemento();
        }
        return elementoRecuperado;
    }

    public int localizar(Object buscado){     
        int posBuscado= -1;
        if(this.cabecera != null){        
            Nodo nodoAux= this.cabecera;
            boolean continuar= true;
            int cont=1;
            while(cont<=this.longitud && continuar){                    
                if(nodoAux.getElemento().equals(buscado)){
                    continuar= false;
                    posBuscado= cont;
                }else{
                    nodoAux= nodoAux.getEnlace();
                    cont++;
                }                
            }         
        }
   
        return posBuscado;
    }
    public Lista clone(){
        Lista unaLista= new Lista();
        if(this.cabecera != null){
            unaLista.cabecera= new Nodo(this.cabecera.getElemento());
            clonAux(this.cabecera.getEnlace(), unaLista.cabecera);
            unaLista.longitud= this.longitud;
        }
        return unaLista;
    }
    private void clonAux(Nodo n, Nodo nClon){
        /*METODO RECURSIVO QUE CREA RECORRE LISTA ORIGNAL Y CREA UN NODO NUEVO CON EL ELEMENTO DEL NODO ACTUAL Y LO ENLAZA A LA LISTA CLON*/
        if(n != null){
            nClon.setEnlace( new Nodo(n.getElemento()));
            clonAux(n.getEnlace(), nClon.getEnlace());
        }
    }
    
    
    public String toString(){
        Nodo nodoAux= this.cabecera;
        String toStringLista= "[";
        while(nodoAux != null){
            toStringLista+= nodoAux.getElemento();
            nodoAux= nodoAux.getEnlace();
            if(nodoAux != null){
                toStringLista+= ", ";
            }
        }
        toStringLista+= "]";
        return toStringLista;
    }
    public void intercalar(Lista lis){
        if(this.cabecera != null && !lis.esVacia()){
            intercalarAux(this.cabecera, lis, 1);
        }else{
            if(!lis.esVacia()){
                this.cabecera= new Nodo(lis.cabecera.getElemento());
                intercalarAux(this.cabecera, lis, 2);
                this.longitud= lis.longitud;
            }
        }
    }
    private void intercalarAux(Nodo n, Lista lis, int pos){
        int i= pos;
        while(i <= lis.longitud()){
            Nodo nA= new Nodo(lis.recuperar(i));
            nA.setEnlace(n.getEnlace());
            n.setEnlace(nA);
            if(nA.getEnlace() != null){
                n= nA.getEnlace();
            }else{
                n= nA;
            }
            i++;
        }
    }
    public void eliminarSiguiente(Object buscado){
        Nodo n= this.cabecera;
        while(n != null){
            if(n.getElemento().equals(buscado)){
                if(n.getEnlace()!= null && !(n.getEnlace().getElemento().equals(buscado))){
                    n.setEnlace(n.getEnlace().getEnlace());
                    this.longitud--;
                }
            }
            n=n.getEnlace();
        }
    }
}
